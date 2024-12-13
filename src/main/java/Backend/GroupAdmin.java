package Backend;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class GroupAdmin extends GroupUser{
    
    public GroupAdmin(String userId) {
        super(userId);
    }

    public static GroupAdmin fromJson(JSONObject j) {
        return new GroupAdmin(j.getString("AdminID"));
    }
    
    @Override
    public JSONObject toJson() {
        JSONObject j = new JSONObject();
        j.put("AdminID", super.getGroupUserId());
        return j;
    }
    
    public void approveUserGroupRequest(String groupId, String userId) {
        GroupMembershipRequest.approveGroupRequest(groupId, userId);
    }
    
    public void declineUserGroupRequest(String groupId, String userId) {
        GroupMembershipRequest.declineGroupRequest(groupId, userId);
    }
    
    public void editGroupPost(String groupPostId, String groupPostText, String groupPostImagePath, LocalDateTime groupPostDate) {
        GroupPostDatabase groupPostDatabase = new GroupPostDatabase();
        groupPostDatabase.editGroupPostFromGroupPostsFile(groupPostId, groupPostText, groupPostImagePath, groupPostDate);
    }
    
    public void deleteGroupPost(String groupPostId) {
        GroupPost.deleteGroupPost(groupPostId);
    }
     
    public void removeGroupMember(String groupId, String groupUserId) {
        if (groupId == null || groupUserId == null) {
            JOptionPane.showMessageDialog(null, "Invalid groupID or userID.");
            return;
        }
        if(GroupMemberDatabase.groupUserFound(groupId, groupUserId)) {
            GroupMemberDatabase groupMemberDatabase = new GroupMemberDatabase();
            groupMemberDatabase.removeUserFromGroupMembersFile(groupId, groupUserId);
        }
        else
            JOptionPane.showMessageDialog(null, "User with ID: " +groupUserId+ " is not in this group.");
    }
    
    @Override
    public void leaveGroup(String groupId) {
        if (groupId == null || this.getGroupUserId() == null) {
            JOptionPane.showMessageDialog(null, "Invalid groupID or userID.");
            return;
        }
        if(GroupMemberDatabase.groupAdminFound(groupId, this.getGroupUserId())) {
            GroupMemberDatabase groupMemberDatabase = new GroupMemberDatabase();
            groupMemberDatabase.removeAdminFromGroupMembersFile(groupId, this.getGroupUserId());
        }
        else
            JOptionPane.showMessageDialog(null, "You are not in this group.");
    }
}
