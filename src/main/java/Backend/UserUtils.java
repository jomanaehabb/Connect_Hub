/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author cf
 */

// this part is reponsible for taking data from the users.json file and editing it into friendships.json
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class UserUtils {
    private static Map<String, String> emailToUsernameMap = null;

    // Load the mapping from users.json
    public static void loadUserMappings() {
        if (emailToUsernameMap == null) {
            emailToUsernameMap = new HashMap<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader("users.json"));
                StringBuilder jsonBuilder = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
                reader.close();

                String jsonContent = jsonBuilder.toString();
                // Parse users.json manually
                if (jsonContent.contains("[") && jsonContent.contains("]")) {
                    String usersArray = jsonContent.substring(
                            jsonContent.indexOf("[") + 1,
                            jsonContent.lastIndexOf("]")
                    ).trim();

                    for (String user : usersArray.split("},")) {
                        String fullUser = user + (user.endsWith("}") ? "" : "}");
                        String email = fullUser.split("\"email\": \"")[1].split("\"")[0];
                        String username = fullUser.split("\"username\": \"")[1].split("\"")[0];
                        emailToUsernameMap.put(email, username);
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    // Get username by email
    public static String getUsernameByEmail(String email) {
        if (emailToUsernameMap == null) {
            loadUserMappings();
        }
        return emailToUsernameMap.getOrDefault(email, "Unknown");
    }

    // Check if username exists
    public static boolean usernameExists(String username) {
        if (emailToUsernameMap == null) {
            loadUserMappings();
        }
        return emailToUsernameMap.containsValue(username);
    }
}
