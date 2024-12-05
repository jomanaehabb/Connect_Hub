package Backend;

import Backend.User;
import java.io.IOException;
import java.util.List;


public class ProfileManager {
private final ProfileDatabase database;
    private final UserDatabase userDatabase;

    public ProfileManager() throws IOException {
        this.database = new ProfileDatabase();
        this.userDatabase = new UserDatabase(); // Initialize UserDatabase
    }

    public void updateProfile(String userId, String bio, String profilePhotoPath, String coverPhotoPath) throws IOException {
        Profile profile = database.getProfile(userId);
        profile.setBio(bio);
        profile.setProfilePhotoPath(profilePhotoPath);
        profile.setCoverPhotoPath(coverPhotoPath);
        database.saveProfile(userId, profile);
        System.out.println("Profile updated successfully!");
    }

    public List<String> getUserFriends(String email) {
        User user = userDatabase.getUser(email); // Access UserDatabase
        return (user != null) ? user.getFriends() : null;
    }
}
