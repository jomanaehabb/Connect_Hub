/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */

public class NotificationHandler {
    private static final String USERS_FILE_PATH = "path/to/users.json";

    // Load users from the JSON file
    public ArrayList<User> loadUsers() {
        try (FileReader reader = new FileReader(USERS_FILE_PATH)) {
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            return new Gson().fromJson(reader, userListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Save users back to the JSON file
    private void saveUsers(ArrayList<User> users) {
        try (FileWriter writer = new FileWriter(USERS_FILE_PATH)) {
            new Gson().toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a notification to a specific user
    public void addNotification(String userId, Notification notification) {
        ArrayList<User> users = loadUsers();

        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                user.getNotifications().add(notification);
                break;
            }
        }

        saveUsers(users);
    }
}

