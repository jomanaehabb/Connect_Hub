/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public class UserSearch {

    //read all users from the database
    public List<User> readAllUsers() {
        try {
            UserDatabase userDatabase = UserDatabase.getInstance();
            List<User> users = userDatabase.getAllUsers();
            if (users != null) {
                System.out.println("Users loaded from database: " + users.size());
            } else {
                System.out.println("No users found in the database.");
            }
            return users;
        } catch (Exception e) {
            System.err.println("Error reading users: " + e.getMessage());
            return null;
        }
    }


    //search for the user inside the userslist
    public User searchFriend(String targetUsername) {
    try {
        List<User> allUsers = readAllUsers();
        if (allUsers != null) {
            for (User user : allUsers) {
                System.out.println("Comparing: " + user.getUsername() + " with " + targetUsername);
                if (user.getUsername().equalsIgnoreCase(targetUsername)) {
                    System.out.println("User found: " + user.getUsername());
                    return user;
                }
            }
        } else {
            System.out.println("User list is empty.");
        }
    } catch (Exception e) {
        System.err.println("Error searching for user: " + e.getMessage());
    }
    System.out.println("No user found with username: " + targetUsername);
    return null;
}


    //if user exist in the database you can send a friend request
    public void sendFriendRequest(String currentUsername, String targetUsername) {
        try {
            // Check if a friendship or request already exists
            FriendshipDatabase data = FriendshipDatabase.readJSONFile();
            List<Friendship> friendships = data.getFriendships();

            for (Friendship friendship : friendships) {
                if ((friendship.getUser1Username().equals(currentUsername) && friendship.getUser2Username().equals(targetUsername)) ||
                    (friendship.getUser1Username().equals(targetUsername) && friendship.getUser2Username().equals(currentUsername))) {
                    System.out.println("You are already friends or a request is pending with: " + targetUsername);
                    return;
                }
            }

            // Create a new friendship and add it to the .JSON file
            Friendship newFriendship = new Friendship();
            newFriendship.setUser1Username(currentUsername);
            newFriendship.setUser2Username(targetUsername);
            newFriendship.setStatus("Pending");
            friendships.add(newFriendship);

            // Save the updated friendships list
            data.setFriendships(friendships);
            FriendshipDatabase.editJSONFile(data);

            System.out.println("Friend request sent successfully to: " + targetUsername);
        } catch (Exception e) {
            System.err.println("Error sending friend request: " + e.getMessage());
        }
    }
}