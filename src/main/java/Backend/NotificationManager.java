/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Lenovo
 */
import java.util.ArrayList;
import java.util.HashMap;

public class NotificationManager {
    private HashMap<String, ArrayList<Notification>> userNotifications; // User ID to notifications

    public NotificationManager() {
        userNotifications = new HashMap<>();
    }

    // Add a new notification for a user
    public void addNotification(String userId, Notification notification) {
        userNotifications.computeIfAbsent(userId, k -> new ArrayList<>()).add(notification);
    }

    // Get all notifications for a user
    public ArrayList<Notification> getNotifications(String userId) {
        return userNotifications.getOrDefault(userId, new ArrayList<>());
    }

    // Clear all notifications for a user
    public void clearNotifications(String userId) {
        if (userNotifications.containsKey(userId)) {
            userNotifications.get(userId).clear();
        }
    }
}

