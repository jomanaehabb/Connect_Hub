package Backend;

import org.json.JSONObject;

public class GroupAdmin extends GroupUser{
    
    public GroupAdmin(String userId) {
        super(userId);
    }

    @Override
    public String toString() {
        return "GroupAdmin{name='" + super.getGroupUserId() + "'}";
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
}
