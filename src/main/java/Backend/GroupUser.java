package Backend;

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
}
