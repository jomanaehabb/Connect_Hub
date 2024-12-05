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
 *
 * @author cf
 */
// Class to manage the friendships data and the .json file to store it
public class FriendshipData{
    private List<Friendship> friendships;

    // Getters and Setters
    public void setFriendships(List<Friendship> friendships) {
        this.friendships = friendships;
    }

    public List<Friendship> getFriendships() {
        return friendships;
    }
    
    // Function to create the .json file if not created
    public static void createJSONFile() {
        try {
            // Create the JSON content manually
            String jsonContent = """
                             {
                               "friendships": [
                                 {
                                   "user1Username": "john123",
                                   "user2Username": "jane456",
                                   "status": "Pending"
                                 }
                               ]
                             }""";// File structure used

            try (FileWriter file = new FileWriter("friendships.json")) {
                file.write(jsonContent);
                file.flush();
            }

            System.out.println("Friendships JSON file created successfully!");
        } catch (IOException e) {
        }
    }
    
    // Function to edit(rewrite) the .json file
    public static void editJSONFile(FriendshipData data) {
        try (FileWriter fileWriter = new FileWriter("friendships.json")) {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{\n  \"friendships\": [\n");

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
        }
    }

    // Function to read the .json file
    public static FriendshipData readJSONFile() {
        FriendshipData data = new FriendshipData();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("friendships.json"));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();

            String jsonContent = jsonBuilder.toString();

            List<Friendship> friendships = new ArrayList<>();
            if (jsonContent.contains("\"friendships\": [")) {
                int startIndex = jsonContent.indexOf("\"friendships\": [") + 15;
                int endIndex = jsonContent.lastIndexOf("]");
                String friendsArray = jsonContent.substring(startIndex, endIndex).trim();

                // Split objects in the array
                for (String friend : friendsArray.split("},")) {
                    String fullFriend = friend + (friend.endsWith("}") ? "" : "}");
                    Friendship friendship = new Friendship();

                    // Extract fields from the JSON string
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
        }
        return data;
    }
}

