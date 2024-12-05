package main.java.Backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class FileReader {
    public ArrayList<Story> readStoriesFile(){
            try {
                BufferedReader reader = new BufferedReader(new java.io.FileReader("users.json"));
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
}
