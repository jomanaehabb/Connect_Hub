package Backend;

import java.awt.Image;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ContentManager {
    private ArrayList<Content> contents;

    public ContentManager(){
        this.contents = new ArrayList<>();
    }

    public Post createPost(String userID, String text, Image image){
        InternalContent content = new InternalContent(text, image);
        Post post = new Post(userID, content, LocalDateTime.now());
        return post;
    }

    public Story createStory(String userID, String text, Image image){
        InternalContent content = new InternalContent(text, image);
        Story story = new Story(userID, content, LocalDateTime.now());
        return story;
    }

    public Content findContent(String contentID){
        for(int i=0;i<contents.size();i++){
            if(contents.get(i).getContentID().equals(contentID)){
                return contents.get(i);
            }
        }
        return null;
    }

    public ArrayList<Content> allContent(){
        return contents;
    }

    public ArrayList<Content> userContent(String userID){
        ArrayList<Content> userContent = new ArrayList<>();
        for(int i=0;i<contents.size();i++){
            if(contents.get(i).getAuthorID().equals(userID)){
                userContent.add(contents.get(i));
            }
        }
        if(!userContent.isEmpty()){
            return userContent;
        }
        return null;
    }
}
