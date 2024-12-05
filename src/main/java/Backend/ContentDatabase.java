
package Backend;

import java.awt.Image;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContentDatabase {
    private List<Post> posts;
    private final List<Story> stories;

    public ContentDatabase() {
        this.posts = new ArrayList<>();
        this.stories = new ArrayList<>();
    }

    public Post createPost(String userID, String text, Image image) {
        Post post = new Post(text, LocalDateTime.now(), null, userID);
        posts.add(post);
        return post;
    }

    public Story createStory(String userID, String text, Image image) {
        Story story = new Story(text, LocalDateTime.now(), null, userID);
        stories.add(story);
        return story;
    }

    public void deletePost(String postID) {
        posts.remove(findPost(postID));
    }

    public void deleteStory(String storyID) {
        stories.remove(findStory(storyID));
    }

    public Content findPost(String postID) {
        for (Post post : posts) {
            if (post.getContentID().equals(postID)) {
                return post;
            }
        }
        return null; // Consider handling not-found cases explicitly
    }

    public Content findStory(String storyID) {
        for (Story story : stories) {
            if (story.getContentID().equals(storyID)) {
                return story;
            }
        }
        return null;
    }

    public List<Post> allPosts() {
        return posts;
    }

    public List<Story> allStories() {
        return stories;
    }

    public List<Post> userFriendPosts(String userID) {
        ArrayList<Post> friendsPostList = new ArrayList<>();
        ConnectHub cH = new ConnectHub();
        Set<String> friendsSet = new HashSet<>(cH.getFriendsList(userID));

        for (Post post : posts) {
            if (friendsSet.contains(post.getAuthorID())) {
                friendsPostList.add(post);
            }
        }
        return friendsPostList;
    }

    public List<Story> userFriendStories(String userID) {
        ArrayList<Story> friendsStoryList = new ArrayList<>();
        ConnectHub cH = new ConnectHub();
        Set<String> friendsSet = new HashSet<>(cH.getFriendsList(userID));

        for (Story story : stories) {
            if (friendsSet.contains(story.getAuthorID())) {
                friendsStoryList.add(story);
            }
        }
        return friendsStoryList;
    }

    public List<Content> userPosts(String userID) {
        ArrayList<Content> userContent = new ArrayList<>();
        for (Post post : posts) {
            if (post.getAuthorID().equals(userID)) {
                userContent.add(post);
            }
        }
        return userContent;
    }

    public List<Content> userStories(String userID) {
        ArrayList<Content> userContent = new ArrayList<>();
        for (Story story : stories) {
            if (story.getAuthorID().equals(userID)) {
                userContent.add(story);
            }
        }
        return userContent;
    }
}