/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//This handles the Friends Managements
package Backend;

import java.io.BufferedReader;
import java.util.List;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author cf
 */
public class ConnectHub {
    
    /*    
    public List<String> getFriendsList(String usedID){
        List<String> list = null;
        return list;
    }
*/
    //Function to send request
   
    public void sendFriendRequest(String user1Id, String user2Id) {

        // Read current friendships to check if there is existing friend request
        FriendshipData data = FriendshipData.readJSONFile();
        List<Friendship> friendships = data.getFriendships();

        for (Friendship friendship : friendships) {
            if ((friendship.getUser1Username().equals(user1Id) && friendship.getUser2Username().equals(user2Id))
                    || (friendship.getUser1Username().equals(user2Id) && friendship.getUser2Username().equals(user1Id))) {
                System.out.println("A friend request or friendship already exists.");
                return; // If already friends ,Exit the function
            }
        }
        try {
            // Create a new friendship and add it to the .JSON file
            Friendship newFriendship = new Friendship();
            newFriendship.setUser1Username(user1Id);
            newFriendship.setUser2Username(user2Id);
            newFriendship.setStatus("Pending");
            friendships.add(newFriendship);

            // Edit and Save the updated friendships.json file
            data.setFriendships(friendships);
            FriendshipData.editJSONFile(data);

            System.out.println("Friend request sent successfully!");
        } catch (Exception e) {
        }
    }
   

    // Function to handle responses (Accept/decline)
    public void respondToFriendRequest(String requesterUsername, String currentUsername, boolean accept) {
        try {
            // Read current friendships
            FriendshipData data = FriendshipData.readJSONFile();
            List<Friendship> friendships = data.getFriendships();

            boolean isUpdated = false;

            // Find and respond to the friend request
            for (Friendship friendship : friendships) {
                if (friendship.getUser1Username().equals(requesterUsername) && friendship.getUser2Username().equals(currentUsername)
                        && "Pending".equals(friendship.getStatus())) {

                    if (accept) {
                        friendship.setStatus("Accepted"); // Update status if accepted
                    } else {
                        friendship.setStatus("Declined"); // Update status if declined
                    }
                    isUpdated = true;
                    break; // Exit loop after processing
                }
            }

            if (isUpdated) {
                // Save the updated friendships to the .JSON file
                data.setFriendships(friendships);
                FriendshipData.editJSONFile(data); 
                System.out.println("Friend request responded successfully!");
            } else {
                System.out.println("No pending friend request found for the given IDs.");
            }
        } catch (Exception e) {
        }
    }



    //Function to block a friend
    public void blockFriend(String user1Id,String user2Id){
         try {
        // Read current friendships from the json file
        FriendshipData data = FriendshipData.readJSONFile();
        List<Friendship> friendships = data.getFriendships();

        // Find and block the friend
        for (Friendship friendship : friendships) {
            if (friendship.getUser1Username().equals(user1Id) && friendship.getUser2Username().equals(user2Id)) {
                friendship.setStatus("Blocked");
                break;
            }
        }

        // Save the updated friendships to the .json file
        data.setFriendships(friendships);
        FriendshipData.editJSONFile(data);

        System.out.println("Friend blocked successfully!");
    } catch (Exception e) {
    }
    }
    //Function to remove a friend
    public void removeFriend(String user1Id, String user2Id) {
        try {
            // Read current friendships from the JSON file
            FriendshipData data = FriendshipData.readJSONFile();
            List<Friendship> friendships = data.getFriendships();

            // Remove the friendship between user1Id and user2Id
            friendships.removeIf(friendship
                    -> (friendship.getUser1Username().equals(user1Id) && friendship.getUser2Username().equals(user2Id))
                    || (friendship.getUser1Username().equals(user2Id) && friendship.getUser2Username().equals(user1Id))
            );

            // Save the updated friendships list back to the JSON file
            data.setFriendships(friendships);
            FriendshipData.editJSONFile(data); 

            System.out.println("Friendship removed successfully between " + user1Id + " and " + user2Id);
        } catch (Exception e) {
            // Print exception for debugging
            
        }
    }

    
    public List<String> suggestFriends(String userId) {
    List<String> suggestions = new ArrayList<>();
    try {
        // Read current friendships
        FriendshipData data = FriendshipData.readJSONFile();
        List<Friendship> friendships = data.getFriendships();

        // Collect IDs of current friends and pending requests
        Set<String> currentFriends = new HashSet<>();
        for (Friendship friendship : friendships) {
            if (friendship.getUser1Username().equals(userId)) {
                if (!"Blocked".equals(friendship.getStatus())) {
                    currentFriends.add(friendship.getUser2Username());
                }
            } else if (friendship.getUser2Username().equals(userId)) {
                if (!"Blocked".equals(friendship.getStatus())) {
                    currentFriends.add(friendship.getUser1Username());
                }
            }
        }

        // Use a Set to store suggestions to avoid duplicates
        Set<String> uniqueSuggestions = new HashSet<>();

        // Generate suggestions
        for (Friendship friendship : friendships) {
            if (!currentFriends.contains(friendship.getUser1Username()) && !friendship.getUser1Username().equals(userId)) {
                uniqueSuggestions.add(friendship.getUser1Username());
            }
            if (!currentFriends.contains(friendship.getUser2Username()) && !friendship.getUser2Username().equals(userId)) {
                uniqueSuggestions.add(friendship.getUser2Username());
            }
        }

        // Convert the set back to a list
        suggestions = new ArrayList<>(uniqueSuggestions);

    } catch (Exception e) {
        // Print any exception for debugging
        
    }

    return suggestions;


    
//    List<String> suggestions = new ArrayList<>();
//        FriendshipData data = FriendshipData.readJSONFile();
//        List<Friendship> friendships = data.getFriendships();
//
//        // Collect IDs of current friends and pending requests
//        Set<String> currentFriends = new HashSet<>();
//        for (Friendship friendship : friendships) {
//            if (friendship.getUser1Id().equals(userId) || friendship.getUser2Id().equals(userId)) {
//                if (!"Blocked".equals(friendship.getStatus())) {
//                    currentFriends.add(friendship.getUser1Id());
//                    currentFriends.add(friendship.getUser2Id());
//                }
//            }
//        }
//
//        // Fetch all users from users.json
//        List<String> allUsers = UserActivity.getAllUsers();
//        for (String user : allUsers) {
//            if (!currentFriends.contains(user) && !user.equals(userId)) {
//                suggestions.add(user);
//            }
//        }
//
//        return suggestions;
    }

    public static void main(String[] args) {
        
    }
    
    public List<String> getPendingFriendRequests(String userId) {
        List<String> pendingRequests = new ArrayList<>();//create a newlist containing the pending requests
        try {
            FriendshipData data = FriendshipData.readJSONFile();
            List<Friendship> friendships = data.getFriendships();

            for (Friendship friendship : friendships) {
                if (friendship.getUser2Username().equals(userId) && "Pending".equals(friendship.getStatus())) {
                    pendingRequests.add(friendship.getUser1Username());
                }
            }
        } catch (Exception e) {
            
        }
        return pendingRequests;
    }

    // Function to accept friend requests(not used)
    public void acceptFriendRequest(String user1Username, String user2Username) {
        respondToFriendRequest(user1Username, user2Username, true);
    }


    //Function to get FriendRequests
    public List<String[]> getFriendRequests(String currentUsername) {
        List<String[]> friendRequests = new ArrayList<>();
        try {
            // Read the friendships data from JSON
            FriendshipData data = FriendshipData.readJSONFile();
            List<Friendship> friendships = data.getFriendships();

            // Loop through the friendships to find pending requests for the given user
            for (Friendship friendship : friendships) {
                if ("Pending".equals(friendship.getStatus())) { // Check only pending friendships
                    if (friendship.getUser2Username().equals(currentUsername)) {
                        // Get username of users
                        String requesterUsername = friendship.getUser1Username();
                        friendRequests.add(new String[]{requesterUsername});
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching friend requests: " + e.getMessage());
        }
        return friendRequests;
    }

    
    
    public List<String> getFriendsList(String username) {
        List<String> friendsList = new ArrayList<>();
        try {
            // Read the friendships data from JSON
            FriendshipData data = FriendshipData.readJSONFile();
            List<Friendship> friendships = data.getFriendships();

            // Loop through the friendships to find friends for the given username
            for (Friendship friendship : friendships) {
                if ("Accepted".equals(friendship.getStatus())) { // Check only accepted friendships
                    if (friendship.getUser1Username().equals(username)) {
                        friendsList.add(friendship.getUser2Username());
                    } else if (friendship.getUser2Username().equals(username)) {
                        friendsList.add(friendship.getUser1Username());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching friends list: " + e.getMessage());
        }
        return friendsList;
    }
}
// Class that manage the Friendships
class Friendship {
    private String user1Username;
    private String user2Username;
    private String status;

    // Getters and Setters
    public void setUser1Username(String user1Username) {
        this.user1Username = user1Username;
    }

    public void setUser2Username(String user2Username) {
        this.user2Username = user2Username;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser1Username() {
        return user1Username;
    }

    public String getUser2Username() {
        return user2Username;
    }

    public String getStatus() {
        return status;
    }
    // end of Getters and Setters
}

// Class to manage the friendships data and the .json file to store it
class FriendshipData{
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

