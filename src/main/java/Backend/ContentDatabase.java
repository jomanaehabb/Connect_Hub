package Backend;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContentDatabase {
    private static ContentDatabase instance;
    private ArrayList<Post> posts;
    private ArrayList<Story> stories;
    private UserDatabase userDatabase;

    private ContentDatabase(){
        userDatabase = UserDatabase.getInstance();
        ContentFileReader fR = new ContentFileReader(); // automatically reads file upon creation
        this.posts = fR.readPostsFromUsersFile(instance);
        this.stories = fR.readStoriesFromUsersFile(instance);
        storyChecker();
    }
    
    private static void storyChecker(){
        Thread storyChecker = new Thread();
        storyChecker.start();
    }
    
    public static ContentDatabase getInstance(){
        if(instance == null){
             synchronized (ContentDatabase.class){
                if(instance == null){
                    instance = new ContentDatabase();
                }
            }
        }
        return instance;
    }

    public Post createPost(String userID, String text, String imagePath){
        InternalContent content = new InternalContent(text, imagePath);
        Post post = new Post(userID, content, LocalDateTime.now());
        posts.add(post);
        saveToFiles();
        return post;
    }

    public Story createStory(String userID, String text, String imagePath){
        InternalContent content = new InternalContent(text, imagePath);
        Story story = new Story(userID, content, LocalDateTime.now());
        stories.add(story);
        saveToFiles();
        return story;
    }

    public void deletePost(String postID){
        posts.remove(findPost(postID));
        saveToFiles();
    }

    public void deleteStory(String storyID){
        stories.remove(findStory(storyID));
        saveToFiles();
    }

    public void deletePost(Post post){
        posts.remove(post);
        saveToFiles();
    }

    public void deleteStory(Story story){
        stories.remove(story);
        saveToFiles();
    }

    public Post findPost(String postID){
        for(int i=0;i<posts.size();i++){ // loop method for looking for a post
            if(posts.get(i).getContentID().equals(postID)){
                return posts.get(i);
            }
        }
        return null;
    }
    
    public Story findStory(String storyID){
        for(int i=0;i<stories.size();i++){ // loop method for looking for a story
            if(stories.get(i).getContentID().equals(storyID)){
                return stories.get(i);
            }
        }
        return null;
    }

    public ArrayList<Post> allPosts(){
        return posts;
    }
    
    public ArrayList<Story> allStories(){
        return stories;
    }
    
    public ArrayList<Post> userFriendPosts(String userID){
        ArrayList<Post> friendsPostList = new ArrayList<>();
        FriendsManagement cH = new FriendsManagement();
        List<String> friendsList = cH.getFriendsList(userID);
        for(int i=0;i<posts.size();i++){ // looping through each post and each friend ID
            for(int j=0;j<friendsList.size();j++){
                if(posts.get(i).getAuthorID().equals(friendsList.get(j))){
                    friendsPostList.add(posts.get(i));
                }
            }
        }
        if(!friendsPostList.isEmpty()){ // checks if empty before returning
            return friendsPostList;
        }
        return null;
    }
    
     public ArrayList<Story> userFriendStories(String userID){
        ArrayList<Story> friendsStoryList = new ArrayList<>();
        FriendsManagement cH = new FriendsManagement();
        List<String> friendsList = cH.getFriendsList(userID);
        for(int i=0;i<stories.size();i++){ // looping through each post and each friend ID
            for(int j=0;j<friendsList.size();j++){
                if(stories.get(i).getAuthorID().equals(friendsList.get(j))){
                    friendsStoryList.add(stories.get(i));
                }
            }
        }
        if(!friendsStoryList.isEmpty()){ // checks if empty before returning
            return friendsStoryList;
        }
        return null;
    }

    public ArrayList<Post> userPosts(String userID){
        ArrayList<Post> userContent = new ArrayList<>();
        for(int i=0;i<posts.size();i++){ // making a new arrayList with looping through each post
            if(posts.get(i).getAuthorID().equals(userID)){
                userContent.add(posts.get(i));
            }
        }
        if(!userContent.isEmpty()){ // checks if empty before returning
            return userContent;
        }
        return null;
    }
    
    public ArrayList<Story> userStories(String userID){
        ArrayList<Story> userContent = new ArrayList<>();
        for(int i=0;i<stories.size();i++){ // making a new arrayList with looping through each story
            if(stories.get(i).getAuthorID().equals(userID)){
                userContent.add(stories.get(i));
            }
        }
        if(!userContent.isEmpty()){
            return userContent;
        }
        return null;
    }
    
    public void saveToFiles(){
        ContentFileSaver fS = new ContentFileSaver();
        fS.saveStoriesToUsersFile(stories);
        fS.savePostsToUsersFile(posts);
    }
}
