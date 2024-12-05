/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static final String DATABASE_FILE = "users.json";
    private Map<String, User> users = new HashMap<>();
//    private final ObjectMapper objectMapper = new ObjectMapper();

    public UserDatabase() {
       // loadDatabase();
    }

    public void saveUser(User user) {
        users.put(user.getEmail(), user);
        saveDatabase();
    }

    public User getUser(String email) {
        return users.get(email);
    }

//    private void loadDatabase() {
//        File file = new File(DATABASE_FILE);
//        if (file.exists()) {
//            try {
//                users = objectMapper.readValue(file, new TypeReference<Map<String, User>>() {});
//            } catch (IOException e) {
//                System.err.println("Failed to load user database: " + e.getMessage());
//            }
//        }
//    }

    private void saveDatabase() {
//        try {
//            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(DATABASE_FILE), users);
//        } catch (IOException e) {
//            System.err.println("Failed to save user database: " + e.getMessage());
//        }
    }
}