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

public class GroupMemberDatabase {
    
    private static Map<String, ArrayList<GroupAdmin>> adminsMap = new HashMap<>();
    private static Map<String, ArrayList<GroupUser>> usersMap = new HashMap<>();
    
    public void addAdmin(String groupId, GroupAdmin groupAdminId) {
        adminsMap.computeIfAbsent(groupId, k -> new ArrayList<>()).add(groupAdminId);
        saveToGroupMembersFile();
    }
    
    public static ArrayList<GroupAdmin> getAdmins(String groupId) {
        return adminsMap.getOrDefault(groupId, new ArrayList<>());
    }
    
    public void addUser(String groupId, GroupUser groupUserId) {
        usersMap.computeIfAbsent(groupId, k -> new ArrayList<>()).add(groupUserId);
        saveToGroupMembersFile();
    }
    
    public static ArrayList<GroupUser> getUsers(String groupId) {
        return usersMap.getOrDefault(groupId, new ArrayList<>());
    }
    
    public void removeGroupFromGroupMembersFile(String groupId) {
        if (adminsMap.containsKey(groupId)) {
            adminsMap.remove(groupId);
            saveToGroupMembersFile();
        }    
        else
            JOptionPane.showMessageDialog(null, "Group or admin not found.");
        if (usersMap.containsKey(groupId)) {
            usersMap.remove(groupId);
            saveToGroupMembersFile();
        }    
        else if(!usersMap.isEmpty())
            JOptionPane.showMessageDialog(null, "Group or user not found.");
    }
    
    public void removeUserFromGroupMembersFile(String groupId, String groupUserId) {
        if (usersMap.containsKey(groupId)) {
            ArrayList<GroupUser> groupUsers = usersMap.get(groupId);
            boolean userFound = false;
            if (groupUsers != null) {
                for (int i = 0; i < groupUsers.size(); i++) {
                    if (groupUsers.get(i).getGroupUserId().equals(groupUserId)) {
                        groupUsers.remove(i);
                        userFound = true;
                        break;
                }
            }
        }
        if (userFound) {
            saveToGroupMembersFile();
            JOptionPane.showMessageDialog(null, "User with ID: " +groupUserId+ " has been removed successfully.");
        } 
        else {
            JOptionPane.showMessageDialog(null, "User with ID" +groupUserId+ "not found in the specified group.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Group not found.");
    }
}

    public void loadFromGroupMembersFile() {
        try {
            adminsMap.clear();
            usersMap.clear();
            String json = new String(Files.readAllBytes(Paths.get("GroupMembers.json")));
            JSONObject j = new JSONObject(json);
            for (String groupId : j.keySet()) {
                JSONObject jg = j.getJSONObject(groupId);
                JSONArray adminsArray = jg.getJSONArray("AdminID");
                ArrayList<GroupAdmin> groupAdmins = new ArrayList<>();
                for (int i = 0; i < adminsArray.length(); i++) {
                    JSONObject ja = adminsArray.getJSONObject(i);
                    GroupAdmin groupAdmin = GroupAdmin.fromJson(ja);
                    groupAdmins.add(groupAdmin);
                }
                adminsMap.put(groupId, groupAdmins);
                JSONArray usersArray = jg.getJSONArray("UserID");
                ArrayList<GroupUser> groupUsers = new ArrayList<>();
                for (int i = 0; i < usersArray.length(); i++) {
                    JSONObject ju = usersArray.getJSONObject(i);
                    GroupUser groupUser = GroupUser.fromJson(ju);
                    groupUsers.add(groupUser);
                }
                usersMap.put(groupId, groupUsers);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "GroupMembers file not found.");
        }
    }
    
    public void saveToGroupMembersFile() {
        JSONObject j = new JSONObject();
        for (String groupId : adminsMap.keySet()) {
            JSONObject jg = new JSONObject();
            JSONArray adminsArray = new JSONArray();
            if (adminsMap.containsKey(groupId)) {
                for (GroupAdmin groupAdmin : adminsMap.get(groupId)) {
                    adminsArray.put(groupAdmin.toJson());
                }
            }
            jg.put("AdminID", adminsArray);
            JSONArray usersArray = new JSONArray();
            if (usersMap.containsKey(groupId)) {
                for (GroupUser groupUser : usersMap.get(groupId)) {
                    usersArray.put(groupUser.toJson());
                }
            }
            jg.put("UserID", usersArray);
            j.put(groupId, jg);
        }
        try {
            File groupMembers = new File("GroupMembers.json");
            if (!groupMembers.exists())
                groupMembers.createNewFile();
            FileWriter file = new FileWriter(groupMembers);
            file.write(j.toString(2));
            file.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading GroupMembers file.");
        }
    }
}
