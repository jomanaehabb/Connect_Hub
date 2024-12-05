/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author cf
 */
// Class that manage the Friendships
public class Friendship {
    private String user1Username;
    private String user2Username;
    private String status;

    // Getters and Setters
    public void setUser1Username(String user1Username) {
        this.user1Username = user1Username;
    }

    public void setUser2Username(String user2Username) {
        this.user2Username = user2Username;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser1Username() {
        return user1Username;
    }

    public String getUser2Username() {
        return user2Username;
    }

    public String getStatus() {
        return status;
    }
    // end of Getters and Setters
}
