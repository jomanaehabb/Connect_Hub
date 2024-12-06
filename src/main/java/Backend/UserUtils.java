package Backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class UserUtils {
    private static Map<String, String> emailToUsernameMap = null;  // Mapping of email to username for quick lookup

    // Load the mapping of email to username from the users.json file
    public static void loadUserMappings() {
        if (emailToUsernameMap == null) {
            emailToUsernameMap = new HashMap<>();
            try {
                // Read the entire users.json file into a string
                BufferedReader reader = new BufferedReader(new FileReader("users.json"));
                StringBuilder jsonBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
                reader.close();

                // Parse the JSON content manually
                String jsonContent = jsonBuilder.toString();
                
                // Check if the file contains an array of users
                if (jsonContent.contains("[") && jsonContent.contains("]")) {
                    String usersArray = jsonContent.substring(
                            jsonContent.indexOf("[") + 1,
                            jsonContent.lastIndexOf("]")
                    ).trim();
                    
                    // For each user in the array, extract their email and username, and store them in the map
                    for (String user : usersArray.split("},")) {
                        String fullUser = user + (user.endsWith("}") ? "" : "}");
                        String email = fullUser.split("\"email\": \"")[1].split("\"")[0];
                        String username = fullUser.split("\"username\": \"")[1].split("\"")[0];
                        emailToUsernameMap.put(email, username);
                    }
                }
            } catch (IOException e) {
                // Handle potential IO exceptions when reading the file
                System.err.println("Failed to load user mappings: " + e.getMessage());
            }
        }
    }

    // Get the username associated with the given email
    public static String getUsernameByEmail(String email) {
        // Load mappings if not already loaded
        if (emailToUsernameMap == null) {
            loadUserMappings();
        }
        // Return the username for the given email, or "Unknown" if the email does not exist
        return emailToUsernameMap.getOrDefault(email, "Unknown");
    }

    // Check if a given username exists in the mapping
    public static boolean usernameExists(String username) {
        // Load mappings if not already loaded
        if (emailToUsernameMap == null) {
            loadUserMappings();
        }
        // Return true if the username exists, otherwise false
        return emailToUsernameMap.containsValue(username);
    }
}