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

public class ProfileDatabase {
    private static final String PROFILE_DB = "profiles.json";
    private Map<String, Profile> profiles = new HashMap<>();
 //   private final ObjectMapper objectMapper = new ObjectMapper();

    public ProfileDatabase() {
 //       loadDatabase();
    }

    public Profile getProfile(String userId) {
        return profiles.getOrDefault(userId, new Profile("", "", ""));
    }

    public void saveProfile(String userId, Profile profile) {
        profiles.put(userId, profile);
 //       saveDatabase();
    }

//    private void loadDatabase() {
//        File file = new File(PROFILE_DB);
//        if (file.exists()) {
//            try {
//                profiles = objectMapper.readValue(file, new TypeReference<Map<String, Profile>>() {});
//            } catch (IOException e) {
//                System.err.println("Failed to load profile database: " + e.getMessage());
//            }
//        }
//    }

//    private void saveDatabase() {
//        try {
//            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(PROFILE_DB), profiles);
//        } catch (IOException e) {
//            System.err.println("Failed to save profile database: " + e.getMessage());
//        }
//    }
}