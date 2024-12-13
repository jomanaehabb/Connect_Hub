package Backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class GroupMembershipRequest {
    
    public static void saveToGroupRequestsFile (String groupId, String userId) {
        JSONObject j = new JSONObject();
        j.put("GroupID", groupId);
        j.put("UserID", userId);
        try {
            File groupRequests = new File("GroupRequests.json");
            if (!groupRequests.exists())
                groupRequests.createNewFile();
            FileWriter file = new FileWriter(groupRequests,true);
            file.write(j.toString(2));
            file.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading GroupRequests file.");
        }
    }
}
