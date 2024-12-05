package Backend;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private String userId;
    private String email;
    private String username;
    private String hashedPassword;
    private LocalDate dateOfBirth;
    private String status; // Online or Offline
    private String profilePhotoPath;
    private String coverPhotoPath;
    private String bio;
    

    public User(String userId, String email, String username, String hashedPassword, LocalDate dateOfBirth) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.dateOfBirth = dateOfBirth;
        this.status = "offline"; // Default to offline
        this.profilePhotoPath = null; // No photo by default
        this.coverPhotoPath = null;
        this.bio = "";
    }

    // Getters and setters for all attributes

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public String getCoverPhotoPath() {
        return coverPhotoPath;
    }

    public String getBio() {
        return bio;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }

    public void setCoverPhotoPath(String coverPhotoPath) {
        this.coverPhotoPath = coverPhotoPath;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    

}