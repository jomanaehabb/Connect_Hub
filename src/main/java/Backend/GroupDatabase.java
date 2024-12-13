package Backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

public class GroupDatabase {
    
    private static ArrayList<GroupManagement> groups = new ArrayList<> ();

    public static ArrayList<GroupManagement> getGroups() {
        return groups;
    }
        
    public void addGroupToFile(GroupManagement group) {
        groups.add(group);
        saveToGroupsFile();
    }
    
    public void removeGroupFromGroupsFile(String groupId) {
        int index = searchGroups(groupId);
        if(index > -1) {
            groups.remove(index);
            saveToGroupsFile();
        }
        else if (index == -1)
            JOptionPane.showMessageDialog(null, "Group not found.");
    }
    
    public int searchGroups(String groupId) {
        loadFromGroupsFile();
        if(!groups.isEmpty()) {
            for(int i = 0; i < groups.size(); i++)
                if(groupId.equals(groups.get(i).getGroupId()))
                    return i;
        }
        return -1;
    }

    public void loadFromGroupsFile() {
        try {
            groups.clear();
            String json = new String(Files.readAllBytes(Paths.get("Groups.json")));
            JSONArray groupsArray = new JSONArray(json);
            for (int i = 0; i < groupsArray.length(); i++) {
                JSONObject j = groupsArray.getJSONObject(i);
                GroupManagement group = GroupManagement.fromJson(j);
                groups.add(group);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Groups file not found.");
        }
    }

    private void saveToGroupsFile () {
        JSONArray groupsArray = new JSONArray();
        for(int i = 0; i < groups.size(); i++)
            groupsArray.put(groups.get(i).toJson());
        try {
            File groups = new File("Groups.json");
            if (!groups.exists())
                groups.createNewFile();
            FileWriter file = new FileWriter(groups);
            file.write(groupsArray.toString(2));
            file.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading Groups file.");
        }
    }
}
