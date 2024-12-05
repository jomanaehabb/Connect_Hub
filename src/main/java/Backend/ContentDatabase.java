package Backend;

import java.awt.Image;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContentDatabase {
    private ArrayList<Post> posts;
    private ArrayList<Story> stories;

    public ContentDatabase(){
        ContentFileReader fR = new ContentFileReader();
        this.posts = fR.readPostsFile(this);
        this.stories = fR.readStoriesFile(this);
    }

    public Post createPost(String userID, String text, Image image){
        InternalContent content = new InternalContent(text, image);
        Post post = new Post(userID, content, LocalDateTime.now());
        posts.add(post);
        return post;
    }

    public Story createStory(String userID, String text, Image image){
        InternalContent content = new InternalContent(text, image);
        Story story = new Story(userID, content, LocalDateTime.now());
        stories.add(story);
        return story;
    }
    
    public void deletePost(String postID){
        posts.remove(findPost(postID));
    }
    
    public void deleteStory(String storyID){
        stories.remove(findStory(storyID));
    }

    public Post findPost(String postID){
        for(int i=0;i<posts.size();i++){
            if(posts.get(i).getContentID().equals(postID)){
                return posts.get(i);
            }
        }
        return null;
    }
    
    public Story findStory(String storyID){
        for(int i=0;i<stories.size();i++){
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
        ConnectHub cH = new ConnectHub();
        List<String> friendsList = cH.getFriendsList(userID);
        for(int i=0;i<posts.size();i++){
            for(int j=0;j<friendsList.size();j++){
                if(posts.get(i).getAuthorID().equals(friendsList.get(j))){
                    friendsPostList.add(posts.get(i));
                }
            }
        }
        if(!friendsPostList.isEmpty()){
            return friendsPostList;
        }
        return null;
    }
    
     public ArrayList<Story> userFriendStories(String userID){
        ArrayList<Story> friendsStoryList = new ArrayList<>();
        ConnectHub cH = new ConnectHub();
        List<String> friendsList = cH.getFriendsList(userID);
        for(int i=0;i<stories.size();i++){
            for(int j=0;j<friendsList.size();j++){
                if(stories.get(i).getAuthorID().equals(friendsList.get(j))){
                    friendsStoryList.add(stories.get(i));
                }
            }
        }
        if(!friendsStoryList.isEmpty()){
            return friendsStoryList;
        }
        return null;
    }

    public ArrayList<Content> userPosts(String userID){
        ArrayList<Content> userContent = new ArrayList<>();
        for(int i=0;i<posts.size();i++){
            if(posts.get(i).getAuthorID().equals(userID)){
                userContent.add(posts.get(i));
            }
        }
        if(!userContent.isEmpty()){
            return userContent;
        }
        return null;
    }
    
    public ArrayList<Content> userStories(String userID){
        ArrayList<Content> userContent = new ArrayList<>();
        for(int i=0;i<stories.size();i++){
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
        fS.savePostsToFile(posts);
        fS.saveStoriesToFile(stories);
    }
}
