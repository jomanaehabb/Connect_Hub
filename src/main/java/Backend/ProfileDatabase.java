package Backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The ProfileDatabase class manages the storage and retrieval of user profile data.
 * It uses JSON file storage for saving and loading profile information.
 */
public class ProfileDatabase {
    private static ProfileDatabase instance;
    private static final String PROFILE_DB = "profiles.json";  // Path to the JSON file storing profile data
    private Map<String, Profile> profiles = new HashMap<>();   // A map to store profiles by userId
    private final ObjectMapper objectMapper = new ObjectMapper();  // Jackson ObjectMapper for JSON serialization and deserialization

    /**
     * Constructor to initialize ProfileDatabase and load existing data.
     */
    private ProfileDatabase() {
        loadDatabase();
    }
    
    public static ProfileDatabase getInstance(){
        if(instance == null){
             synchronized (ProfileDatabase.class){
                if(instance == null){
                    instance = new ProfileDatabase();
                }
            }
        }
        return instance;
    }

    /**
     * Retrieves the profile of a user by their userId.
     * If no profile is found for the given userId, a default empty profile is returned.
     * 
     * @param userId the user ID whose profile is to be retrieved
     * @return the Profile object for the given userId, or an empty Profile if not found
     */
    public Profile getProfile(String userId) {
        return profiles.getOrDefault(userId, new Profile("", "", ""));
    }

    /**
     * Saves or updates the profile of a user in the database.
     * The profile is associated with the provided userId and saved to the JSON file.
     * 
     * @param userId the user ID whose profile is to be saved or updated
     * @param profile the Profile object to be saved
     */
    public void saveProfile(String userId, Profile profile) {
        profiles.put(userId, profile);  // Add or update the profile in the map
        saveDatabase();  // Save the updated profiles map to the JSON file
    }

    /**
     * Loads the profile database from the JSON file.
     * If the file exists, the profiles are read into the profiles map.
     * If the file does not exist or an error occurs, an empty map is used.
     */
    private void loadDatabase() {
        File file = new File(PROFILE_DB);
        if (file.exists()) {  // Check if the file exists before attempting to load
            try {
                // Deserialize the JSON file into a Map of userId to Profile objects
                profiles = objectMapper.readValue(file, new TypeReference<Map<String, Profile>>() {});
            } catch (IOException e) {
                System.err.println("Failed to load profile database: " + e.getMessage());
            }
        }
    }

    /**
     * Saves the profiles map to the JSON file.
     * The file is serialized into a pretty-printed JSON format.
     */
    private void saveDatabase() {
        try {
            // Serialize the profiles map to the JSON file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(PROFILE_DB), profiles);
        } catch (IOException e) {
            System.err.println("Failed to save profile database: " + e.getMessage());
        }
    }
}
