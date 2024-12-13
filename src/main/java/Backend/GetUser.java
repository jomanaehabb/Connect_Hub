/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author DELL-G3
 */



public class GetUser {
    private String userId;
    private String userName;
    private String profilePhoto;
    private String bio;


    public GetUser(String userId, String userName, String profilePhoto, String bio) {
        this.userId = userId;
        this.userName = userName;
        this.profilePhoto = profilePhoto;
        this.bio = bio;  
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public String getBio() {
        return bio;
    }
    
    
    
    
}
