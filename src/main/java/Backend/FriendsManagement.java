package Backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*public class ConnectHub {
    public List<String> getFriendsList(String usedID){
        List<String> list = null;
        return list;
    }
}
*/
public class FriendsManagement {
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
            // Save the updated friendships to friendships.json
            data.setFriendships(friendships);
            FriendshipData.editJSONFile(data);
            System.out.println("Friendship JSON updated successfully!");

            // If accepted, update the users.json file
            if (accept) {
                // Read the users.json file
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

                File usersFile = new File("users.json");

                // Read the users as a Map (email is the key)
                Map<String, User> users = objectMapper.readValue(usersFile, new TypeReference<Map<String, User>>() {});

                // Find users by their usernames
                User currentUser = null;
                User requester = null;

                for (User user : users.values()) {
                    if (user.getUsername().equals(currentUsername)) {
                        currentUser = user;
                    }
                    if (user.getUsername().equals(requesterUsername)) {
                        requester = user;
                    }
                }

                if (currentUser != null && requester != null) {
                    // Update their friends lists
                    if (!currentUser.getFriends().contains(requester.getUsername())) {
                        currentUser.getFriends().add(requester.getUsername());
                    }
                    if (!requester.getFriends().contains(currentUser.getUsername())) {
                        requester.getFriends().add(currentUser.getUsername());
                    }

                    // Write the updated users back to users.json
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(usersFile, users);
                    System.out.println("Users JSON updated successfully!");
                } else {
                    System.err.println("One or both users not found in users.json.");
                }
            }
        } else {
            System.out.println("No pending friend request found for the given usernames.");
        }
    } catch (Exception e) {
        System.err.println("Error responding to friend request: " + e.getMessage());
        e.printStackTrace();
    }
}




    //Function to block a friend
    public void blockFriend(String user1Username, String user2Username) {
    try {
        // Step 1: Read current friendships from friendships.json
        FriendshipData data = FriendshipData.readJSONFile();
        List<Friendship> friendships = data.getFriendships();

        // Mark the friendship status as "Blocked"
        boolean isBlocked = false;
        for (Friendship friendship : friendships) {
            if (friendship.getUser1Username().equals(user1Username) && friendship.getUser2Username().equals(user2Username)) {
                friendship.setStatus("Blocked");
                isBlocked = true;
                break;
            }
        }

        // Save the updated friendships back to friendships.json
        if (isBlocked) {
            data.setFriendships(friendships);
            FriendshipData.editJSONFile(data);
            System.out.println("Friendship status updated to 'Blocked' in friendships.json.");
        } else {
            System.out.println("No friendship found between " + user1Username + " and " + user2Username + ".");
            return;
        }

        // Step 2: Remove the users from each other's friend list in users.json
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        File usersFile = new File("users.json");

        // Read users.json as a Map (email as key)
        Map<String, User> users = objectMapper.readValue(usersFile, new TypeReference<Map<String, User>>() {});

        // Find both users by their usernames
        for (User user : users.values()) {
            if (user.getUsername().equals(user1Username)) {
                user.getFriends().remove(user2Username); // Remove user2 from user1's friends list
            }
            if (user.getUsername().equals(user2Username)) {
                user.getFriends().remove(user1Username); // Remove user1 from user2's friends list
            }
        }

        // Write the updated users back to users.json
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(usersFile, users);

        System.out.println("Blocked friend removed from friends list in users.json.");
    } catch (Exception e) {
        System.err.println("Error blocking friend: " + e.getMessage());
        e.printStackTrace();
    }
}

    //Function to remove a friend
    public void removeFriend(String user1Username, String user2Username) {
    try {
        // Step 1: Read current friendships from friendships.json
        FriendshipData data = FriendshipData.readJSONFile();
        List<Friendship> friendships = data.getFriendships();

        // Remove the friendship between user1Username and user2Username
        boolean isRemoved = friendships.removeIf(friendship
                -> (friendship.getUser1Username().equals(user1Username) && friendship.getUser2Username().equals(user2Username))
                || (friendship.getUser1Username().equals(user2Username) && friendship.getUser2Username().equals(user1Username))
        );

        // Save the updated friendships list back to friendships.json
        if (isRemoved) {
            data.setFriendships(friendships);
            FriendshipData.editJSONFile(data);
            System.out.println("Friendship removed successfully in friendships.json.");

            // Step 2: Read users.json and update the friends array
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            File usersFile = new File("users.json");

            // Read the users as a Map (email is the key)
            Map<String, User> users = objectMapper.readValue(usersFile, new TypeReference<Map<String, User>>() {});

            // Find both users by their usernames
            User user1 = null;
            User user2 = null;

            for (User user : users.values()) {
                if (user.getUsername().equals(user1Username)) {
                    user1 = user;
                }
                if (user.getUsername().equals(user2Username)) {
                    user2 = user;
                }
            }

            if (user1 != null && user2 != null) {
                // Remove each other's username from their friends list
                user1.getFriends().remove(user2.getUsername());
                user2.getFriends().remove(user1.getUsername());

                // Save the updated users back to users.json
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(usersFile, users);
                System.out.println("Users JSON updated successfully: Friendship removed.");
            } else {
                System.err.println("One or both users not found in users.json.");
            }
        } else {
            System.out.println("No friendship found between " + user1Username + " and " + user2Username + ".");
        }
    } catch (Exception e) {
        System.err.println("Error removing friendship: " + e.getMessage());
        e.printStackTrace();
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

