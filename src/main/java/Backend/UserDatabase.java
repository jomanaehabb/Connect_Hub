package Backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.*;
import java.util.ArrayList;

public class UserDatabase {
    private static UserDatabase instance;
    private ArrayList<User> users;  // List to hold the user objects
    private final String databaseFile = "users.json";  // Path to the file that stores user data

    // Constructor: Initializes the list of users and loads the database from the file
    private UserDatabase() {
        users = new ArrayList<>();
        loadDatabase();
    }
    
    public static UserDatabase getInstance(){
         if(instance == null){
             synchronized (UserDatabase.class){
                if(instance == null){
                    instance = new UserDatabase();
                }
            }
        }
        return instance;
    }

    // Loads the user data from the JSON file into the 'users' list
    private void loadDatabase() {
        File file = new File(databaseFile);
        
        // Check if the file exists and contains data
        if (file.exists()) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());  // Register the JavaTime module for date serialization
                objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);  // Disable writing dates as timestamps
                
                // Check if the file contains data and try to deserialize it into a list of users
                if (file.length() > 0) {
                    users = objectMapper.readValue(file, new TypeReference<ArrayList<User>>() {});
                } else {
                    users = new ArrayList<>();
                }
            } catch (IOException e) {
                // Print an error message and set an empty list in case of failure
                System.err.println("Failed to load users: " + e.getMessage());
                e.printStackTrace();
                users = new ArrayList<>();
            }
        }
    }

    // Saves the 'users' list into the JSON file
    private void saveDatabase() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());  // Register the JavaTime module for date serialization
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);  // Disable writing dates as timestamps
            // Write the users list to the file with pretty-print formatting
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(databaseFile), users);
        } catch (IOException e) {
            // Print an error message if saving the file fails
            System.err.println("Failed to save users: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Adds a new user to the 'users' list and saves the database
    public void addUser(User user) {
        users.add(user);
        saveDatabase();
    }

    // Retrieves a user by their email address
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;  // Return the user if found
            }
        }
        return null;  // Return null if no user matches the email
    }

    // Authenticates a user by comparing their email and hashed password
    public boolean authenticateUser(String email, String hashedPassword) {
        User user = getUserByEmail(email);
        return user != null && user.getHashedPassword().equals(hashedPassword);  // Return true if authentication is successful
    }

    // Updates an existing user's details in the database
    public void updateUser(User user) {
        // Find the user with the matching userId and update their details
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(user.getUserId())) {
                users.set(i, user);  // Replace the old user with the updated user
                break;
            }
        }
        saveDatabase();  // Save the changes to the database
    }

    // Deletes a user from the database using their userId
    public void deleteUser(String userId) {
        // Remove the user from the list by matching their userId
        users.removeIf(user -> user.getUserId().equals(userId));
        saveDatabase();  // Save the changes to the database
    }

    // Retrieves all users from the database
    public ArrayList<User> getAllUsers() {
        return users;  // Return the list of all users
    }

    // Retrieves a user by their username
    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;  // Return the user if found
            }
        }
        return null;  // Return null if no user matches the username
    }
    
    public String getUserNameByID(String userID){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUserId().equals(userID)){
                return users.get(i).getUsername();
            }
        }
        return null;
    }
}