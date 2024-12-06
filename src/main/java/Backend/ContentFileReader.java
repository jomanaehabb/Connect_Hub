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
    public void saveStoriesToFile(ArrayList<Story> stories){
        try (FileWriter fileWriter = new FileWriter("stories.json")) {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{\n  \"stories\": [\n");
            for (int i = 0; i < stories.size(); i++) {
                Story story = stories.get(i);
                jsonBuilder.append("    {\n")
                        .append("      \"text\": \"").append(story.getContent().getText()).append("\",\n")
                        .append("      \"image\": \"").append(story.getContent().getImage().toString()).append("\",\n")
                        .append("      \"authorID\": \"").append(story.getAuthorID()).append("\",\n")
                        .append("      \"date\": \"").append(story.getTimeStamp().toString()).append("\"\n")
                        .append("    }");
                if (i < stories.size() - 1) {
                    jsonBuilder.append(",");
                }
                jsonBuilder.append("\n");
            }
            jsonBuilder.append("  ]\n}");
            fileWriter.write(jsonBuilder.toString());
            fileWriter.flush();
            System.out.println("Stories JSON file updated successfully!");
        } catch (IOException e) {
            System.err.println("Error saving stories to file: " + e.getMessage());
        }
    }
    // Save Posts to posts.json
    public void savePostsToFile(ArrayList<Post> posts){
        try (FileWriter fileWriter = new FileWriter("posts.json")) {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{\n  \"posts\": [\n");
            for (int i = 0; i < posts.size(); i++) {
                Post post = posts.get(i);
                jsonBuilder.append("    {\n")
                        .append("      \"text\": \"").append(post.getContent().getText()).append("\",\n")
                        .append("      \"image\": \"").append(post.getContent().getImage().toString()).append("\",\n")
                        .append("      \"authorID\": \"").append(post.getAuthorID()).append("\",\n")
                        .append("      \"date\": \"").append(post.getTimeStamp().toString()).append("\"\n")
                        .append("    }");
                if (i < posts.size() - 1) {
                    jsonBuilder.append(",");
                }
                jsonBuilder.append("\n");
            }
            jsonBuilder.append("  ]\n}");
            fileWriter.write(jsonBuilder.toString());
            fileWriter.flush();
            System.out.println("Posts JSON file updated successfully!");
        } catch (IOException e) {
            System.err.println("Error saving posts to file: " + e.getMessage());
        }
    }
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
                        String imageString = fullStory.split("\"image\": \"")[1].split("\"")[0];
                        String authorID = fullStory.split("\"authorID\":\"")[1].split("\"")[0];
                        String date = fullStory.split("\"date\":\"")[1].split("\"")[0];
                        ImageIcon icon = new ImageIcon(imageString);
                        Image image = icon.getImage(); //making an icon to turn the string to an image
                        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        LocalDateTime timeStamp = LocalDateTime.parse(date, formatter);
                        InternalContent content = new InternalContent(text, image);
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
                        String imageString = fullPost.split("\"image\": \"")[1].split("\"")[0];
                        String authorID = fullPost.split("\"authorID\":\"")[1].split("\"")[0];
                        String date = fullPost.split("\"date\":\"")[1].split("\"")[0];
                        ImageIcon icon = new ImageIcon(imageString);
                        Image image = icon.getImage(); //making an icon to turn the string to an image
                        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        LocalDateTime timeStamp = LocalDateTime.parse(date, formatter);
                        InternalContent content = new InternalContent(text, image);
                        Post postInstance = new Post(authorID, content, timeStamp);
                        posts.add(postInstance);
                    }
                }
            } catch (IOException e) {
            }
            return posts;
    }
}
