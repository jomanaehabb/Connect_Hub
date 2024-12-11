package Backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContentFileSaver {
    public void saveStoriesToUsersFile(ArrayList<Story> stories) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.json"));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();

            String jsonContent = jsonBuilder.toString();
            JSONObject usersJson = new JSONObject(jsonContent);

            // Clear existing stories and add the new ones to the respective users
            for (Story story : stories) {
                String authorID = story.getAuthorID();
                for (String email : usersJson.keySet()) {
                    JSONObject userObject = usersJson.getJSONObject(email);

                    if (userObject.getString("userId").equals(authorID)) {
                        JSONArray storiesArray = userObject.has("stories") ? userObject.getJSONArray("stories") : new JSONArray();

                        JSONObject storyJson = new JSONObject();
                        storyJson.put("text", story.getContent().getText());
                        storyJson.put("imagePath", story.getContent().getImagePath() == null ? "null" : story.getContent().getImagePath());

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        storyJson.put("date", story.getTimeStamp().format(formatter));

                        storyJson.put("authorID", story.getAuthorID());
                        storiesArray.put(storyJson);

                        userObject.put("stories", storiesArray);
                        break;
                    }
                }
            }

            // Write back to the file
            FileWriter fileWriter = new FileWriter("users.json");
            fileWriter.write(usersJson.toString(4)); // Pretty print with indentation
            fileWriter.flush();
            fileWriter.close();

            System.out.println("Stories saved to users.json successfully!");
        } catch (IOException | JSONException e) {
            System.err.println("Error saving stories to users file: " + e.getMessage());
        }
    }

    
    public void savePostsToUsersFile(ArrayList<Post> posts) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.json"));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();

            String jsonContent = jsonBuilder.toString();
            JSONObject usersJson = new JSONObject(jsonContent);

            // Clear existing stories and add the new ones to the respective users
            for (Post post : posts) {
                String authorID = post.getAuthorID();
                for (String email : usersJson.keySet()) {
                    JSONObject userObject = usersJson.getJSONObject(email);

                    if (userObject.getString("userId").equals(authorID)) {
                        JSONArray postsArray = userObject.has("stories") ? userObject.getJSONArray("stories") : new JSONArray();

                        JSONObject postJson = new JSONObject();
                        postJson.put("text", post.getContent().getText());
                        postJson.put("imagePath", post.getContent().getImagePath() == null ? "null" : post.getContent().getImagePath());

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        postJson.put("date", post.getTimeStamp().format(formatter));

                        postJson.put("authorID", post.getAuthorID());
                        postsArray.put(postJson);

                        userObject.put("posts", postsArray);
                        break;
                    }
                }
            }

            // Write back to the file
            FileWriter fileWriter = new FileWriter("users.json");
            fileWriter.write(usersJson.toString(4)); // Pretty print with indentation
            fileWriter.flush();
            fileWriter.close();

            System.out.println("Posts saved to users.json successfully!");
        } catch (IOException | JSONException e) {
            System.err.println("Error saving posts to users file: " + e.getMessage());
        }
    }
}
