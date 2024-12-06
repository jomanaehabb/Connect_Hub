package Backend;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ContentFileSaver {
    public void saveStoriesToFile(ArrayList<Story> stories){
        try (FileWriter fileWriter = new FileWriter("stories.json")) {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{\n  \"stories\": [\n");

            for (int i = 0; i < stories.size(); i++) {
                Story story = stories.get(i);
                if(story.getContent().getImagePath() == null){
                    story.getContent().setImagePath("null");
                }

                jsonBuilder.append("    {\n")
                        .append("      \"text\": \"").append(story.getContent().getText()).append("\",\n")
                        .append("      \"imagePath\": \"").append(story.getContent().getImagePath()).append("\",\n")
                        .append("      \"authorID\": \"").append(story.getAuthorID()).append("\"\n")
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
        }
    }
    
    public void savePostsToFile(ArrayList<Post> posts){
        try (FileWriter fileWriter = new FileWriter("posts.json")) {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{\n  \"posts\": [\n");

            for (int i = 0; i < posts.size(); i++) {
                Post post = posts.get(i);
                if(post.getContent().getImagePath() == null){
                    post.getContent().setImagePath("null");
                }
                jsonBuilder.append("    {\n")
                        .append("      \"text\": \"").append(post.getContent().getText()).append("\",\n")
                        .append("      \"imagePath\": \"").append(post.getContent().getImagePath()).append("\",\n")
                        .append("      \"authorID\": \"").append(post.getAuthorID()).append("\"\n")
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
        }
    }
    
    public void savePostsToUserFile(String email, ArrayList<Post> posts) {
        try {
            // read the existing users.json file
            FileReader fileReader = new FileReader("users.json");
            StringBuilder jsonBuilder = new StringBuilder();
            int i;
            while ((i = fileReader.read()) != -1) {
                jsonBuilder.append((char) i);
            }
            fileReader.close();

            JSONObject usersJson = new JSONObject(jsonBuilder.toString());

            // find the user by email
            if (!usersJson.has(email)) {
                System.out.println("Error: User with email " + email + " not found.");
                return;
            }

            // get the user's posts array
            JSONObject userObject = usersJson.getJSONObject(email);
            JSONArray postsArray = userObject.getJSONArray("posts");

            // add new posts to the array
            for (Post post : posts) {
                JSONObject postJson = new JSONObject();
                postJson.put("text", post.getContent().getText());
                postJson.put("imagePath", post.getContent().getImagePath() == null ? "null" : post.getContent().getImagePath());
                postJson.put("authorID", post.getAuthorID());
                postJson.put("date", post.getTimeStamp().toString());
                postsArray.put(postJson);
            }

            // update the user's posts in the JSON
            userObject.put("posts", postsArray);
            usersJson.put(email, userObject);

            // write the updated JSON to the file
            try (FileWriter fileWriter = new FileWriter("users.json")) {
                fileWriter.write(usersJson.toString(4)); // indentation for readability
                fileWriter.flush();
            }

            System.out.println("Posts added successfully to user: " + email);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
