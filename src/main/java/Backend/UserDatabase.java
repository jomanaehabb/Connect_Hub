/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.util.ArrayList;

public class UserDatabase {
    private ArrayList<User> users;
    private final String databaseFile = "users.json";

    public UserDatabase() {
        users = new ArrayList<>();
        loadDatabase();
    }

    private void loadDatabase() {
    File file = new File(databaseFile);
    if (file.exists()) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            // Check if the file contains an array or an object
            if (file.length() > 0) {
                // Try to load the array of users
                users = objectMapper.readValue(file, new TypeReference<ArrayList<User>>() {});
            } else {
                users = new ArrayList<>();
            }
        } catch (IOException e) {
            System.err.println("Failed to load users: " + e.getMessage());
            e.printStackTrace();
            users = new ArrayList<>();
        }
    }
}

    private void saveDatabase() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(databaseFile), users);
        } catch (IOException e) {
            System.err.println("Failed to save users: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        users.add(user);
        saveDatabase();
    }

    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public boolean authenticateUser(String email, String hashedPassword) {
        User user = getUserByEmail(email);
        return user != null && user.getHashedPassword().equals(hashedPassword);
    }

    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(user.getUserId())) {
                users.set(i, user);
                break;
            }
        }
        saveDatabase();
    }

    public void deleteUser(String userId) {
        users.removeIf(user -> user.getUserId().equals(userId));
        saveDatabase();
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }
    
    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
