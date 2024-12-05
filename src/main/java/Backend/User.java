package Backend;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L; // Serializable version UID
    private String userId;
    private String email;
    private String username;
    private String hashedPassword; // Changed to hashedPassword
    private String status;
    private String bio;
    private String profilePhotoPath;
    private String coverPhotoPath;
    private LocalDate dateOfBirth;
    private List<Post> posts;
    private List<String> friends;

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
        this.hashedPassword = hashedPassword; // Assign hashed password
        this.dateOfBirth = dateOfBirth;
        this.status = "Offline";
        this.bio = "";
        this.profilePhotoPath = "";
        this.coverPhotoPath = "";
        this.posts = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

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

    // Add a helper method for hashing passwords
    public static String hashPassword(String password) {
        // Use a real hashing library like BCrypt or SHA-256 for production
        return Integer.toHexString(password.hashCode());
    }
}
