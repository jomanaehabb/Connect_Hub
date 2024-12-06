/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 * The Friendship class represents the relationship between two users. It
 * contains the usernames of two users involved in a friendship and the status
 * of their friendship. The status can indicate various stages like "Pending",
 * "Accepted", or "Blocked".
 */
public class Friendship {

    // Usernames of the two users involved in the friendship
    private String user1Username;
    private String user2Username;

    // The status of the friendship (e.g., Pending, Accepted, Blocked)
    private String status;

    // Getter and Setter methods for user1Username
    public void setUser1Username(String user1Username) {
        this.user1Username = user1Username;
    }

    public String getUser1Username() {
        return user1Username;
    }

    // Getter and Setter methods for user2Username
    public void setUser2Username(String user2Username) {
        this.user2Username = user2Username;
    }

    public String getUser2Username() {
        return user2Username;
    }

    // Getter and Setter methods for status
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    // End of Getters and Setters
}
