package Backend;

import java.time.LocalDateTime;
import org.json.JSONObject;

public class GroupUser {
    
    protected String groupUserId;

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
    
    public void joinGroup(String groupId) {
        GroupMembershipRequest.saveToGroupRequestsFile(groupId, this.groupUserId);
    }
    
    public void leaveGroup(String groupId) {
        GroupMemberDatabase groupMemberDatabase = new GroupMemberDatabase();
        groupMemberDatabase.removeUserFromGroupMembersFile(groupId, this.getGroupUserId());
    }
}
