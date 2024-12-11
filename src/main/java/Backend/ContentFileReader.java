package Backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContentFileReader {

    // Method to read stories from a file
    public ArrayList<Story> readStoriesFromUsersFile(ContentDatabase cD) {
        ArrayList<Story> stories = new ArrayList<>();
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

            for (String email : usersJson.keySet()) {
                JSONObject userObject = usersJson.getJSONObject(email);

                if (userObject.has("stories")) {
                    JSONArray storiesArray = userObject.getJSONArray("stories");

                    for (int i = 0; i < storiesArray.length(); i++) {
                        JSONObject storyObject = storiesArray.getJSONObject(i);

                        try {
                            String text = storyObject.getString("text");
                            String imagePath = storyObject.getString("imagePath");
                            String authorID = storyObject.getString("authorID");
                            String date = storyObject.getString("date");

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                            LocalDateTime timeStamp = LocalDateTime.parse(date, formatter);

                            InternalContent content = new InternalContent(text, imagePath);
                            Story storyInstance = new Story(authorID, content, timeStamp);
                            stories.add(storyInstance);
                        } catch (JSONException | DateTimeParseException e) {
                            System.err.println("Error parsing story data for user " + email + ": " + e.getMessage());
                        }
                    }
                }
            }
        } catch (IOException | JSONException e) {
            System.err.println("Error reading users file: " + e.getMessage());
        }

        return stories;
    }

    // Method to read posts from a file
    public ArrayList<Post> readPostsFromUsersFile(ContentDatabase cD) {
        ArrayList<Post> posts = new ArrayList<>();
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

            for (String email : usersJson.keySet()) {
                JSONObject userObject = usersJson.getJSONObject(email);

                if (userObject.has("posts")) {
                    JSONArray postsArray = userObject.getJSONArray("posts");

                    for (int i = 0; i < postsArray.length(); i++) {
                        JSONObject storyObject = postsArray.getJSONObject(i);

                        try {
                            String text = storyObject.getString("text");
                            String imagePath = storyObject.getString("imagePath");
                            String authorID = storyObject.getString("authorID");
                            String date = storyObject.getString("date");

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                            LocalDateTime timeStamp = LocalDateTime.parse(date, formatter);

                            InternalContent content = new InternalContent(text, imagePath);
                            Post postInstance = new Post(authorID, content, timeStamp);
                            posts.add(postInstance);
                        } catch (JSONException | DateTimeParseException e) {
                            System.err.println("Error parsing story data for user " + email + ": " + e.getMessage());
                        }
                    }
                }
            }
        } catch (IOException | JSONException e) {
            System.err.println("Error reading users file: " + e.getMessage());
        }

        return posts;
    }
}