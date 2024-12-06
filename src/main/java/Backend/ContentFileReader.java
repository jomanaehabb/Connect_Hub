package Backend;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class ContentFileReader {

    // Method to read stories from a file
    public ArrayList<Story> readStoriesFile(ContentDatabase cD) {
        ArrayList<Story> stories = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("stories.json"));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();

            String jsonContent = jsonBuilder.toString();
            // Check if the content has a valid JSON structure for stories
            if (jsonContent.contains("[") && jsonContent.contains("]")) {
                String storiesArray = jsonContent.substring(
                        jsonContent.indexOf("[") + 1,
                        jsonContent.lastIndexOf("]")
                ).trim();

                // Ensure the array is not empty
                if (!storiesArray.isEmpty()) {
                    for (String story : storiesArray.split("},\n?")) { // Account for new lines
                        String fullStory = story + (story.endsWith("}") ? "" : "}");
                        try {
                            String text = fullStory.split("\"text\": \"")[1].split("\"")[0];
                            String imagePath = fullStory.split("\"imagePath\": \"")[1].split("\"")[0];
                            String authorID = fullStory.split("\"authorID\":\"")[1].split("\"")[0];
                            String date = fullStory.split("\"date\":\"")[1].split("\"")[0];
                            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                            LocalDateTime timeStamp = LocalDateTime.parse(date, formatter);
                            InternalContent content = new InternalContent(text, imagePath);
                            Story storyInstance = new Story(authorID, content, timeStamp);
                            stories.add(storyInstance);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.err.println("Error parsing story data: " + fullStory);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading stories file: " + e.getMessage());
        }
        return stories;
    }

    // Method to read posts from a file
    public ArrayList<Post> readPostsFile(ContentDatabase cD) {
        ArrayList<Post> posts = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("posts.json"));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();

            String jsonContent = jsonBuilder.toString();
            // Check if the content has a valid JSON structure for posts
            if (jsonContent.contains("[") && jsonContent.contains("]")) {
                String postsArray = jsonContent.substring(
                        jsonContent.indexOf("[") + 1,
                        jsonContent.lastIndexOf("]")
                ).trim();

                // Ensure the array is not empty
                if (!postsArray.isEmpty()) {
                    for (String post : postsArray.split("},\n?")) { // Account for new lines
                        String fullPost = post + (post.endsWith("}") ? "" : "}");
                        try {
                            String text = fullPost.split("\"text\": \"")[1].split("\"")[0];
                            String imagePath = fullPost.split("\"imagePath\": \"")[1].split("\"")[0];
                            String authorID = fullPost.split("\"authorID\":\"")[1].split("\"")[0];
                            String date = fullPost.split("\"date\":\"")[1].split("\"")[0];
                            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                            LocalDateTime timeStamp = LocalDateTime.parse(date, formatter);
                            InternalContent content = new InternalContent(text, imagePath);
                            Post postInstance = new Post(authorID, content, timeStamp);
                            posts.add(postInstance);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.err.println("Error parsing post data: " + fullPost);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading posts file: " + e.getMessage());
        }
        return posts;
    }
}