package Backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// This file only used to update online/offline status (you can ignore it if you have a better approach)
public class UserActivity {
    public static void updateUserStatus(String userId, boolean isLoggedIn) {
        try {
            // Read the JSON file
            BufferedReader reader = new BufferedReader(new FileReader("activity.json"));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();

            // Parse the JSON content
            String jsonContent = jsonBuilder.toString();
            List<String> users = new ArrayList<>();
            if (jsonContent.contains("\"users\": [")) {
                int startIndex = jsonContent.indexOf("\"users\": [") + 9;
                int endIndex = jsonContent.lastIndexOf("]");
                String usersArray = jsonContent.substring(startIndex, endIndex).trim();

                // Split objects in the array
                for (String user : usersArray.split("},")) {
                    users.add(user + (user.endsWith("}") ? "" : "}"));
                }
            }

            // Update the user's status
            for (int i = 0; i < users.size(); i++) {
                String user = users.get(i);
                if (user.contains("\"userId\": \"" + userId + "\"")) {
                    String updatedUser = user.replaceFirst("\"status\": \"(Online|Offline)\"",
                            "\"status\": \"" + (isLoggedIn ? "Online" : "Offline") + "\"");
                    users.set(i, updatedUser);
                    break;
                }
            }

            // Rebuild the JSON content
            StringBuilder updatedJSON = new StringBuilder("{\n  \"users\": [\n");
            for (int i = 0; i < users.size(); i++) {
                updatedJSON.append(users.get(i));
                if (i < users.size() - 1) {
                    updatedJSON.append(",\n");
                }
            }
            updatedJSON.append("\n  ]\n}");

            // Write the updated JSON back to the file
            FileWriter file = new FileWriter("activity.json");
            file.write(updatedJSON.toString());
            file.flush();
            file.close();

            System.out.println("User status updated to " + (isLoggedIn ? "Online" : "Offline") + " for userId: " + userId);

        } catch (IOException e) {
        }
    }
}
