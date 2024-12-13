package Backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

public class GroupMembershipRequest {
    
    private static Map<String, ArrayList<String>> requestsMap = new HashMap<>();
    
    public void addGroupRequest(String groupId, String userId) {
        if(!hasGroupRequestWithSpecificUser(groupId,userId)) {
            requestsMap.computeIfAbsent(groupId, k -> new ArrayList<>()).add(userId);
            saveToGroupRequestsFile();
            JOptionPane.showMessageDialog(null, "GroupRequest has been sent.");
        }
        else
            JOptionPane.showMessageDialog(null, "GroupRequest already exists.");
    }
    
    public static ArrayList<String> getGroupRequests(String groupId) {
        return requestsMap.getOrDefault(groupId, new ArrayList<>());
    }
    
    public static boolean hasGroupRequestWithSpecificUser(String groupId, String userId) {
        for (Map.Entry<String, ArrayList<String>> entry : requestsMap.entrySet()) {
            if (entry.getKey().equals(groupId)) {
                ArrayList<String> groupRequests = entry.getValue();
                for (int i = 0; i < groupRequests.size(); i++) {
                    String id = groupRequests.get(i);
                    if (id.equals(userId)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static void deleteGroupRequests(String groupId) {
        if (requestsMap.containsKey(groupId)) {
            requestsMap.remove(groupId);
            saveToGroupRequestsFile();
        }    
    }
    
    public static void approveGroupRequest(String groupId, String userId) {
        loadFromGroupRequestsFile();
        if(!requestsMap.isEmpty() && requestsMap.containsKey(groupId)) {
            ArrayList<String> groupRequests = requestsMap.get(groupId);
            for (int i = 0; i < groupRequests.size(); i++) {
                if (groupRequests.get(i).equals(userId)) {
                groupRequests.remove(i);
                GroupUser groupUser = new GroupUser(userId);
                GroupMemberDatabase groupMemberDatabase = new GroupMemberDatabase();
                groupMemberDatabase.addUser(groupId, groupUser);
                saveToGroupRequestsFile();
                JOptionPane.showMessageDialog(null, "GroupRequest for user with ID: " +userId+ " has been approved.");
                return;
                }   
            }
        }
        JOptionPane.showMessageDialog(null, "Error approving GroupRequest.");
    }
    
    public static void declineGroupRequest(String groupId, String userId) {
        loadFromGroupRequestsFile();
        if(!requestsMap.isEmpty() && requestsMap.containsKey(groupId)) {
            ArrayList<String> groupRequests = requestsMap.get(groupId);
            for (int i = 0; i < groupRequests.size(); i++) {
                if (groupRequests.get(i).equals(userId)) {
                groupRequests.remove(i);
                saveToGroupRequestsFile();
                JOptionPane.showMessageDialog(null, "GroupRequest for user with ID: " +userId+ " has been declined.");
                return;
                }   
            }
        }
        JOptionPane.showMessageDialog(null, "Error declining GroupRequest.");
    }
    
    public static void loadFromGroupRequestsFile() {
        try {
            requestsMap.clear();
            String json = new String(Files.readAllBytes(Paths.get("GroupRequests.json")));
            JSONArray requestsArray = new JSONArray(json);
            for (int i = 0; i < requestsArray.length(); i++) {
                JSONObject j = requestsArray.getJSONObject(i);
                String groupId = j.getString("GroupID");
                String userId = j.getString("UserID");
                requestsMap.computeIfAbsent(groupId, k -> new ArrayList<>()).add(userId);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "GroupRequests file not found.");
        }
    }
    
    public static void saveToGroupRequestsFile() {
        JSONArray requestsArray = new JSONArray();
        for (Map.Entry<String, ArrayList<String>> entry : requestsMap.entrySet()) {
            String groupId = entry.getKey();
            ArrayList<String> userIds = entry.getValue();
            for (int i = 0; i < userIds.size(); i++) {
                String userId = userIds.get(i);
                JSONObject j = new JSONObject();
                j.put("GroupID", groupId);
                j.put("UserID", userId);
                requestsArray.put(j);
            }
        }
        try {
        File groupRequests = new File("GroupRequests.json");
        if (!groupRequests.exists())
                groupRequests.createNewFile();
        FileWriter file = new FileWriter(groupRequests);
        file.write(requestsArray.toString(2));
        file.close();
        } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error loading GroupRequests file.");
        }
    }
}
