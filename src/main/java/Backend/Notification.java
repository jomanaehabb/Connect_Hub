/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Backend;

/**
 *
 * @author DELL-G3
 */

public class Notification {
    private String name;
    private String userId;
    private String profilePhoto;
    private String message;  // The message field to store the notification message
    private static int num = 0;
    private String Id;

    Notification(String group_Photo_Changed, String photoPath) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Notification(String new_post_added_to_group, String userName, Post post) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Notification(String new_post_need_to_be_Approved, String userName, Post post, String groupId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public static int getNum() {
        return num;
    }

    public Notification(String name, String userId, String profilePhoto, String message) {
        this.name = name;
        this.userId = userId;
        this.profilePhoto = profilePhoto;
        this.message = message;  // Store the message in the object
        num++;
        this.Id = "n" + num;
    }

    public String getId() {
        return Id;
    }

    public String getMessage() {
        return message;  // Get the message for displaying in the GUI
    }

    // Other getters and setters
}
