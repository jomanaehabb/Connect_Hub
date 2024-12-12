package Backend;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L; // Serializable version UID for object serialization
    private String userId;
    private String email;
    private String username;
    private String hashedPassword; // Storing hashed password for security
    private String status;
    private String bio;
    private String profilePhotoPath;
    private String coverPhotoPath;
    private LocalDate dateOfBirth;
    private List<Post> posts;
    private List<Story> stories;
    private List<String> friends;

    /**
     * Constructor to create a new User instance.
     * 
     * @param userId the unique ID of the user
     * @param email the user's email address
     * @param username the user's chosen username
     * @param hashedPassword the user's hashed password
     * @param dateOfBirth the user's date of birth
     */
    @JsonCreator
    public User(
        @JsonProperty("userId") String userId,
        @JsonProperty("email") String email,
        @JsonProperty("username") String username,
        @JsonProperty("hashedPassword") String hashedPassword,
        @JsonProperty("dateOfBirth") LocalDate dateOfBirth
    ) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword; // Assigning the hashed password
        this.dateOfBirth = dateOfBirth;
        this.status = "Offline"; // Default status when the user is created
        this.bio = "";
        this.profilePhotoPath = "";
        this.coverPhotoPath = "";
        this.posts = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    // Getter and setter methods
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getHashedPassword() {
        return hashedPassword;
    }
    
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public String getBio() {
        return bio;
    }
    
    public void setBio(String bio) {
        this.bio = bio;
    }
    
    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }
    
    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }
    
    public String getCoverPhotoPath() {
        return coverPhotoPath;
    }
    
    public void setCoverPhotoPath(String coverPhotoPath) {
        this.coverPhotoPath = coverPhotoPath;
    }
    
    public List<Post> getPosts() {
        return posts;
    }
    
    public List<String> getFriends() {
        return friends;
    }

    // Helper method for hashing passwords (simple hash code for now)
    public static String hashPassword(String password) {
        // Use a more secure hashing library like BCrypt or SHA-256 in production
        return Integer.toHexString(password.hashCode());  // Basic hash code (not secure for production)
    }

    // Setter for friends list
    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<Story> getStories() {
        return stories;
    }

    @Override
    public String toString() {
        return username;  // Return the username when the object is printed
    }
}