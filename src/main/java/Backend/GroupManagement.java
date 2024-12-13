package Backend;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class GroupManagement {
    
    private static int groupCounter;
    private String groupId;
    private String groupCreatorId;
    private String groupName;
    private String groupDescription;
    private String groupImagePath;
    private LocalDateTime groupDate;

    private static void setGroupCounter() {
        groupCounter = CounterDatabase.loadGroupCounterFromFile("GroupCounter.txt");
    }
    
    private String groupIdGenerator() {
        return String.valueOf(groupCounter);
    }
    
    private void countGroup() {
        groupCounter++;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    public String getGroupId() {
        return groupId;
    }

    public void setGroupCreatorId(String groupCreatorId) {
        this.groupCreatorId = groupCreatorId;
    }

    public String getGroupCreatorId() {
        return groupCreatorId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public String getGroupName() {
        return groupName;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupImagePath(String groupImagePath) {
        this.groupImagePath = groupImagePath;
    }

    public String getGroupImagePath() {
        return groupImagePath;
    }

    public void setGroupDate(LocalDateTime groupDate) {
        this.groupDate = groupDate;
    }

    public LocalDateTime getGroupDate() {
        return groupDate;
    }
    
    public static GroupManagement fromJson(JSONObject j) {
        GroupManagement group = new GroupManagement();
        group.setGroupId(j.getString("GroupID"));
        group.setGroupCreatorId(j.getString("GroupCreatorID"));
        group.setGroupName(j.getString("GroupName"));
        if(j.getString("GroupDescription").equals("NULL"))
            group.setGroupDescription(null);
        else
            group.setGroupDescription(j.getString("GroupDescription"));
        if(j.getString("GroupImagePath").equals("NULL"))
            group.setGroupImagePath(null);
        else
            group.setGroupImagePath(j.getString("GroupImagePath"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        group.setGroupDate(LocalDateTime.parse(j.getString("GroupDate"), formatter));
        return group;
    }
    
    public JSONObject toJson() {
        JSONObject j = new JSONObject();
        j.put("GroupID", this.getGroupId());
        j.put("GroupCreatorID", this.getGroupCreatorId());
        j.put("GroupName", this.getGroupName());
        if(this.getGroupDescription() != null)
            j.put("GroupDescription", this.getGroupDescription());
        else
            j.put("GroupDescription", "NULL");
        if(this.getGroupImagePath() != null)
            j.put("GroupImagePath", this.getGroupImagePath());
        else
            j.put("GroupImagePath", "NULL");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        j.put("GroupDate", this.getGroupDate().format(formatter));
        return j;
    }

    public void createGroup(String groupCreatorId, String groupName, String groupDiscription, String groupImagePath, LocalDateTime groupDate) {
        setGroupCounter();
        this.groupId = this.groupIdGenerator();
        this.groupName = groupName;
        this.groupCreatorId = groupCreatorId;
        this.groupDescription = groupDiscription;
        this.groupImagePath = groupImagePath;
        this.groupDate = groupDate;
        GroupCreator groupCreator = new GroupCreator(groupCreatorId);
        GroupMemberDatabase groupMemberDatabase = new GroupMemberDatabase();
        groupMemberDatabase.addAdmin(groupId, groupCreator);
        GroupDatabase groupDatabase = new GroupDatabase();
        groupDatabase.addGroupToFile(this);
        CounterDatabase.saveGroupCounterToFile(groupCounter,"GroupCounter.txt");
        JOptionPane.showMessageDialog(null, "Group has been successfully added.");
        this.countGroup();
    }

    public static void deleteGroup(String groupId) {
        GroupDatabase groupDatabase = new GroupDatabase();
        groupDatabase.removeGroupFromGroupsFile(groupId);
        GroupMemberDatabase groupMemberDatabase = new GroupMemberDatabase();
        groupMemberDatabase.removeGroupFromGroupMembersFile(groupId);
        GroupPostDatabase groupPostDatabase = new GroupPostDatabase();
        if(groupPostDatabase.checkGroupHasPost(groupId))
            GroupPost.deleteGroupPost(groupId);
        GroupMembershipRequest.deleteGroupRequests(groupId);
        JOptionPane.showMessageDialog(null, "Group has been successfully deleted.");
    }
}
