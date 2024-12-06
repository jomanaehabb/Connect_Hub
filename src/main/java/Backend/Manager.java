package Backend;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * The Manager class provides a base class for managing users and user data in a JSON file.
 * It handles loading users from a file, saving users back to the file, and hashing passwords.
 */
public abstract class Manager {

    // Map to store users, with user ID as the key
    protected Map<String, User> users = new HashMap<>();

    // Constant for the file where user data is stored
    private static final String DATABASE_FILE = "users.json";

    /**
     * Constructor that loads the users from the JSON file when the Manager is initialized.
     */
    public Manager() {
        loadUsers();
    }

    /**
     * Loads users from the JSON file into the 'users' map.
     * If the file exists, it reads the content using Jackson's ObjectMapper and maps it to a map of users.
     */
    public void loadUsers() {
        File file = new File(DATABASE_FILE);
        if (file.exists()) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule()); // Register the JavaTime module for handling dates
                objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Disable writing dates as timestamps
                users = objectMapper.readValue(file, new TypeReference<Map<String, User>>() {}); // Deserialize JSON into 'users' map
            } catch (IOException e) {
                System.err.println("Failed to load users: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Saves the current users map to the JSON file.
     * The data is serialized to JSON using Jackson's ObjectMapper with pretty printing enabled.
     */
    public void saveUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule()); // Register JavaTime module for date handling
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Disable timestamp serialization for dates
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(DATABASE_FILE), users); // Serialize and write to file
        } catch (IOException e) {
            System.err.println("Failed to save users: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Hashes the given password using SHA-256.
     * 
     * @param password the password to hash
     * @return the hashed password as a hexadecimal string
     */
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // Get SHA-256 MessageDigest instance
            byte[] hash = md.digest(password.getBytes()); // Hash the password
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b)); // Convert byte to hex and append
            }
            return hexString.toString(); // Return the hashed password as hex string
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e); // Throw runtime exception if hashing algorithm is not found
        }
    }
}
