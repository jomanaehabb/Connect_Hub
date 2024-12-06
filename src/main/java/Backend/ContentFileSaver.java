package Backend;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ContentFileSaver {
    public void saveStoriesToFile(ArrayList<Story> stories){
        try (FileWriter fileWriter = new FileWriter("stories.json")) {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{\n  \"stories\": [\n");

            for (int i = 0; i < stories.size(); i++) {
                Story story = stories.get(i);

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
}
