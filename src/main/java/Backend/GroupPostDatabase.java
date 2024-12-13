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

public class GroupPostDatabase {
    
    private static ArrayList<GroupPost> groupPosts = new ArrayList<> ();

    public static ArrayList<GroupPost> getGroupPosts() {
        return groupPosts;
    }
        
    public void addGroupPostToFile(GroupPost groupPost) {
        groupPosts.add(groupPost);
        saveToGroupPostsFile();
    }
    
    public void removeGroupPostFromGroupPostsFile(String groupPostId) {
        loadFromGroupPostsFile();
        if(!groupPosts.isEmpty()) {
            int flag = 0;
            for(int i = 0; i < groupPosts.size(); i++) {
                if(groupPosts.get(i).getGroupPostId().equals(groupPostId)) {
                    groupPosts.remove(i);
                    flag = 1;
                }  
            }
            if(flag == 0) {
                JOptionPane.showMessageDialog(null, "GroupPost not found");
            }
            else if(flag == 1)
                saveToGroupPostsFile();    
        }
        else 
            JOptionPane.showMessageDialog(null, "GroupPost not found");
    }
    
    public ArrayList<GroupPost> getGroupPosts(String groupId) {
        loadFromGroupPostsFile();
        if(!groupPosts.isEmpty()) {
            int flag = 0;
            ArrayList<GroupPost> posts = new ArrayList<>();
            for(int i = 0; i < groupPosts.size(); i++) {
                if(groupPosts.get(i).getGroupId().equals(groupId)) {
                    posts.add(groupPosts.get(i));
                    flag = 1;
                }
            }
            if(flag == 0)
                return null;
            else
                return posts;
        }
        else
            return null;
    }
    
    public ArrayList<GroupPost> getGroupAuthorPosts(String groupAuthorId) {
        loadFromGroupPostsFile();
        if(!groupPosts.isEmpty()) {
            int flag = 0;
            ArrayList<GroupPost> posts = new ArrayList<>();
            for(int i = 0; i < groupPosts.size(); i++) {
                if(groupPosts.get(i).getGroupAuthorId().equals(groupAuthorId)) {
                    posts.add(groupPosts.get(i));
                    flag = 1;
                }
            }
            if(flag == 0)
                return null;
            else
                return posts;
        }
        else
            return null;
    }
    
    public boolean checkGroupHasPost(String groupId) {
        loadFromGroupPostsFile();
        if(groupPosts.isEmpty())
            return false;
        else {
            for(int i = 0; i < groupPosts.size(); i++) {
                if(groupId.equals(groupPosts.get(i).getGroupId()))
                    return true;
            }
            return false;
        }
    }

    public void loadFromGroupPostsFile() {
        try {
            groupPosts.clear();
            String json = new String(Files.readAllBytes(Paths.get("GroupPosts.json")));
            JSONArray postsArray = new JSONArray(json);
            for (int i = 0; i < postsArray.length(); i++) {
                JSONObject j = postsArray.getJSONObject(i);
                GroupPost groupPost = GroupPost.fromJson(j);
                groupPosts.add(groupPost);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "GroupPosts file not found.");
        }
    }
    
    public void saveToGroupPostsFile() {
        JSONArray postsArray = new JSONArray();
        for(int i = 0; i < groupPosts.size(); i++)
            postsArray.put(groupPosts.get(i).toJson());
        try {
            File groupPosts = new File("GroupPosts.json");
            if (!groupPosts.exists())
                groupPosts.createNewFile();
            FileWriter file = new FileWriter(groupPosts);
            file.write(postsArray.toString(2));
            file.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading GroupPosts file.");
        }
    }
}
