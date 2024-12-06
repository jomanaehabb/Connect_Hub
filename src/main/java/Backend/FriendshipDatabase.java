/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The FriendshipDatabase class is responsible for managing the friendships data
 * and performing operations like creating, editing, and reading the
 * "friendships.json" file. It handles storing and retrieving friendship
 * relationships between users, where each friendship has a status (e.g.,
 * Pending, Accepted).
 */
public class FriendshipDatabase {

    // List to store all friendships
    private List<Friendship> friendships;

    // Getter and Setter methods for the friendships list
    public void setFriendships(List<Friendship> friendships) {
        this.friendships = friendships;
    }

    public List<Friendship> getFriendships() {
        return friendships;
    }

    /**
     * Creates a new "friendships.json" file with a default friendship structure
     * if it doesn't already exist.
     */
    public static void createJSONFile() {
        try {
            // Default JSON content structure for the friendships file
            String jsonContent = """
                             {
                               "friendships": [
                                 {
                                   "user1Username": "john123",
                                   "user2Username": "jane456",
                                   "status": "Pending"
                                 }
                               ]
                             }"""; // File structure template used

            // Write the default JSON content to the file
            try (FileWriter file = new FileWriter("friendships.json")) {
                file.write(jsonContent);
                file.flush();
            }
            System.out.println("Friendships JSON file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Edits (rewrites) the "friendships.json" file with the updated friendships
     * list from the provided FriendshipDatabase object.
     */
    public static void editJSONFile(FriendshipDatabase data) {
        try (FileWriter fileWriter = new FileWriter("friendships.json")) {
            // StringBuilder to build the new JSON content
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{\n  \"friendships\": [\n");

            // Loop through the friendships list and add each friendship to the JSON structure
            for (int i = 0; i < data.getFriendships().size(); i++) {
                Friendship friendship = data.getFriendships().get(i);
                jsonBuilder.append("    {\n")
                        .append("      \"user1Username\": \"").append(friendship.getUser1Username()).append("\",\n")
                        .append("      \"user2Username\": \"").append(friendship.getUser2Username()).append("\",\n")
                        .append("      \"status\": \"").append(friendship.getStatus()).append("\"\n")
                        .append("    }");
                if (i < data.getFriendships().size() - 1) {
                    jsonBuilder.append(",");
                }
                jsonBuilder.append("\n");
            }
            jsonBuilder.append("  ]\n}");
            fileWriter.write(jsonBuilder.toString());
            fileWriter.flush();
            System.out.println("Friendships JSON file updated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the "friendships.json" file and returns a FriendshipDatabase object
     * containing all the friendships stored in the file.
     *
     * @return a FriendshipDatabase object with the loaded friendships
     */
    public static FriendshipDatabase readJSONFile() {
        FriendshipDatabase data = new FriendshipDatabase();
        try {
            // Read the entire file content
            BufferedReader reader = new BufferedReader(new FileReader("friendships.json"));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();

            // Parse the JSON content into a list of Friendship objects
            String jsonContent = jsonBuilder.toString();
            List<Friendship> friendships = new ArrayList<>();
            if (jsonContent.contains("\"friendships\": [")) {
                int startIndex = jsonContent.indexOf("\"friendships\": [") + 15;
                int endIndex = jsonContent.lastIndexOf("]");
                String friendsArray = jsonContent.substring(startIndex, endIndex).trim();

                // Split the JSON array of friendships into individual objects
                for (String friend : friendsArray.split("},")) {
                    String fullFriend = friend + (friend.endsWith("}") ? "" : "}");
                    Friendship friendship = new Friendship();

                    // Extract fields from the JSON string and set them to the Friendship object
                    String user1Username = fullFriend.split("\"user1Username\": \"")[1].split("\"")[0];
                    String user2Username = fullFriend.split("\"user2Username\": \"")[1].split("\"")[0];
                    String status = fullFriend.split("\"status\": \"")[1].split("\"")[0];

                    friendship.setUser1Username(user1Username);
                    friendship.setUser2Username(user2Username);
                    friendship.setStatus(status);

                    friendships.add(friendship);
                }
            }
            data.setFriendships(friendships);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
