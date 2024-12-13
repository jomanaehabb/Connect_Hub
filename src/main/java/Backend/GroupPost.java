package Backend;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class GroupPost{
    
    private static int groupPostCounter;
    private String groupPostId;
    private String groupId;
    private String groupAuthorId;
    private String groupPostText;
    private String groupPostImagePath;
    private LocalDateTime groupPostDate;
    
    private static void setGroupPostCounter() {
        groupPostCounter = CounterDatabase.loadGroupCounterFromFile("GroupPostCounter.txt");
    }
    
    private String groupPostIdGenerator() {
        return String.valueOf(groupPostCounter);
    }
    
    private void countGroupPost() {
        groupPostCounter++;
    }

    public String getGroupPostId() {
        return groupPostId;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupAuthorId() {
        return groupAuthorId;
    }

    public void setGroupPostText(String groupPostText) {
        this.groupPostText = groupPostText;
    }
    
    public String getGroupPostText() {
        return groupPostText;
    }

    public void setGroupPostImagePath(String groupPostImagePath) {
        this.groupPostImagePath = groupPostImagePath;
    }
    
    public String getGroupPostImagePath() {
        return groupPostImagePath;
    }

    public void setGroupPostDate(LocalDateTime groupPostDate) {
        this.groupPostDate = groupPostDate;
    }
    
    public LocalDateTime getGroupPostDate() {
        return groupPostDate;
    }

    public static GroupPost fromJson(JSONObject j) {
        GroupPost groupPost = new GroupPost();
        groupPost.groupPostId = j.getString("GroupPostID");
        groupPost.groupId = j.getString("GroupID");
        groupPost.groupAuthorId = j.getString("GroupAuthorID");
        if(j.getString("GroupPostText").equals("NULL"))
            groupPost.groupPostText = null;
        else
            groupPost.groupPostText = j.getString("GroupPostText");
        if(j.getString("GroupPostImagePath").equals("NULL"))
            groupPost.groupPostImagePath = null;
        else
            groupPost.groupPostImagePath = j.getString("GroupPostImagePath");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        groupPost.groupPostDate = LocalDateTime.parse(j.getString("GroupPostDate"), formatter);
        return groupPost;
    }
    
    public JSONObject toJson() {
        JSONObject j = new JSONObject();
        j.put("GroupPostID", this.groupPostId);
        j.put("GroupID", this.groupId);
        j.put("GroupAuthorID", this.groupAuthorId);
        if(this.groupPostText != null)
            j.put("GroupPostText", this.groupPostText);
        else
            j.put("GroupPostText", "NULL");
        if(this.getGroupPostImagePath() != null)
            j.put("GroupPostImagePath", this.groupPostImagePath);
        else
            j.put("GroupPostImagePath", "NULL");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        j.put("GroupPostDate", this.getGroupPostDate().format(formatter));
        return j;
    }
    
    public void createGroupPost(String groupId, String groupAuthorId, String groupPostText, String groupPostImagePath, LocalDateTime groupPostDate) {
        setGroupPostCounter();
        this.groupPostId = this.groupPostIdGenerator();
        this.groupId = groupId;
        this.groupAuthorId = groupAuthorId;
        this.groupPostText = groupPostText;
        this.groupPostImagePath = groupPostImagePath;
        this.groupPostDate = groupPostDate;
        GroupPostDatabase groupPostDatabase = new GroupPostDatabase();
        groupPostDatabase.addGroupPostToFile(this);
        CounterDatabase.saveGroupCounterToFile(groupPostCounter,"GroupPostCounter.txt");
        JOptionPane.showMessageDialog(null, "GroupPost has been successfully added.");
        this.countGroupPost();
    }
    
    public static void deleteGroupPost(String groupPostId) {
        GroupPostDatabase groupPostDatabase = new GroupPostDatabase();
        groupPostDatabase.removeGroupPostFromGroupPostsFile(groupPostId);
    }
}
