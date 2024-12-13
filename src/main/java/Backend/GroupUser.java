package Backend;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class GroupUser {
    
    private String groupUserId;

    public GroupUser(String userId) {
        this.groupUserId = userId;
    } 

    public String getGroupUserId() {
        return groupUserId;
    }

    public static GroupUser fromJson(JSONObject j) {
        return new GroupUser(j.getString("UserID"));
    }
    
    public JSONObject toJson() {
        JSONObject j = new JSONObject();
        j.put("UserID", this.getGroupUserId());
        return j;
    }
    
    public void addGroupPost(String groupId, String groupPostText, String groupPostImagePath, LocalDateTime groupPostDate) {
        GroupPost groupPost = new GroupPost();
        groupPost.createGroupPost(groupId, this.getGroupUserId(), groupPostText, groupPostImagePath, groupPostDate);
    }
    
//    public void joinGroup(String groupId) {
//        if(!GroupMemberDatabase.groupUserFound(groupId, this.getGroupUserId()))
//            GroupMembershipRequest.saveToGroupRequestsFile(groupId, this.groupUserId);
//        else
//            JOptionPane.showMessageDialog(null, "You already joined this group.");
//    }
    
    public void leaveGroup(String groupId) {
        if (groupId == null || this.getGroupUserId() == null) {
            JOptionPane.showMessageDialog(null, "Invalid groupID or userID.");
            return;
        }
        if(GroupMemberDatabase.groupUserFound(groupId, this.getGroupUserId())) {
            GroupMemberDatabase groupMemberDatabase = new GroupMemberDatabase();
            groupMemberDatabase.removeUserFromGroupMembersFile(groupId, this.getGroupUserId());
        }
        else
            JOptionPane.showMessageDialog(null, "You are not in this group.");
    }
}
