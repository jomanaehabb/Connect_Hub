package Backend;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class ContentFileReader {
    
    public ArrayList<Story> readStoriesFile(ContentDatabase cD){
            ArrayList<Story> stories = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new java.io.FileReader("stories.json"));
                StringBuilder jsonBuilder = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
                reader.close();

                String jsonContent = jsonBuilder.toString();
                // Parse stories.json manually
                if (jsonContent.contains("[") && jsonContent.contains("]")) {
                    String storiesArray = jsonContent.substring(
                            jsonContent.indexOf("[") + 1,
                            jsonContent.lastIndexOf("]")
                    ).trim();

                    for (String story : storiesArray.split("},")) {
                        String fullStory = story + (story.endsWith("}") ? "" : "}");
                        String text = fullStory.split("\"text\": \"")[1].split("\"")[0];
                        String imagePath = fullStory.split("\"imagePath\": \"")[1].split("\"")[0];
                        String authorID = fullStory.split("\"authorID\":\"")[1].split("\"")[0];
                        String date = fullStory.split("\"date\":\"")[1].split("\"")[0];
                        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        LocalDateTime timeStamp = LocalDateTime.parse(date, formatter);
                        InternalContent content = new InternalContent(text, imagePath);
                        Story storyInstance = new Story(authorID, content, timeStamp);
                        stories.add(storyInstance);
                    }
                }
            } catch (IOException e) {
            }
            return stories;
    }
    
    public ArrayList<Post> readPostsFile(ContentDatabase cD){
            ArrayList<Post> posts = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new java.io.FileReader("posts.json"));
                StringBuilder jsonBuilder = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
                reader.close();

                String jsonContent = jsonBuilder.toString();
                // Parse posts.json manually
                if (jsonContent.contains("[") && jsonContent.contains("]")) {
                    String postsArray = jsonContent.substring(
                            jsonContent.indexOf("[") + 1,
                            jsonContent.lastIndexOf("]")
                    ).trim();

                    for (String post : postsArray.split("},")) {
                        String fullPost = post + (post.endsWith("}") ? "" : "}");
                        String text = fullPost.split("\"text\": \"")[1].split("\"")[0];
                        String imagePath = fullPost.split("\"imagePath\": \"")[1].split("\"")[0];
                        String authorID = fullPost.split("\"authorID\":\"")[1].split("\"")[0];
                        String date = fullPost.split("\"date\":\"")[1].split("\"")[0];
                        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        LocalDateTime timeStamp = LocalDateTime.parse(date, formatter);
                        InternalContent content = new InternalContent(text, imagePath);
                        Post postInstance = new Post(authorID, content, timeStamp);
                        posts.add(postInstance);
                    }
                }
            } catch (IOException e) {
            }
            return posts;
    }
}
