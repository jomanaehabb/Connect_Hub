package Backend;

public class ProfileManager extends Manager {

    /**
     * Updates the bio of the user associated with the given email.
     * If the user is found, the bio is updated and the changes are saved.
     * 
     * @param email the email of the user whose bio is to be updated
     * @param newBio the new bio text to set for the user
     * @return true if the bio was successfully updated, false if the user is not found
     */
    public boolean updateBio(String email, String newBio) {
        User user = users.get(email);  // Retrieve the user based on email
        if (user != null) {
            user.setBio(newBio);  // Set the new bio for the user
            saveUsers();  // Save the updated users list to the database
            return true;  // Bio update successful
        } else {
            return false;  // User not found
        }
    }

    /**
     * Updates the profile photo of the user associated with the given email.
     * If the user is found, the profile photo path is updated and the changes are saved.
     * 
     * @param email the email of the user whose profile photo is to be updated
     * @param photoPath the new profile photo path to set for the user
     */
    public void updateProfilePhoto(String email, String photoPath) {
        User user = users.get(email);  // Retrieve the user based on email
        if (user != null) {
            user.setProfilePhotoPath(photoPath);  // Set the new profile photo path
            saveUsers();  // Save the updated users list to the database
        }
    }

    /**
     * Updates the cover photo of the user associated with the given email.
     * If the user is found, the cover photo path is updated and the changes are saved.
     * 
     * @param email the email of the user whose cover photo is to be updated
     * @param coverPhotoPath the new cover photo path to set for the user
     */
    public void updateCoverPhoto(String email, String coverPhotoPath) {
        User user = users.get(email);  // Retrieve the user based on email
        if (user != null) {
            user.setCoverPhotoPath(coverPhotoPath);  // Set the new cover photo path
            saveUsers();  // Save the updated users list to the database
        }
    }

    /**
     * Changes the password of the user associated with the given email.
     * The current password is validated before updating to the new password.
     * If the current password matches, the new password is hashed and updated.
     * 
     * @param email the email of the user whose password is to be changed
     * @param currentPassword the current password to validate
     * @param newPassword the new password to set for the user
     * @return true if the password was successfully changed, false if the current password is incorrect
     */
    public boolean changePassword(String email, String currentPassword, String newPassword) {
        User user = users.get(email);  // Retrieve the user based on email
        if (user != null) {
            // Validate the current password by comparing hashed values
            if (user.getHashedPassword().equals(User.hashPassword(currentPassword))) {
                // Update the password with the new one, ensuring it is hashed
                user.setHashedPassword(User.hashPassword(newPassword));
                saveUsers();  // Save the updated users list to the database
                return true;  // Password successfully changed
            }
        }
        return false;  // Invalid current password or user not found
    }

    // Example commented-out method for creating a post (not implemented here)
    /* 
    public void createPost(String email, String content, String imagePath) {
        User user = users.get(email);  // Retrieve the user based on email
        if (user != null) {
            Post newPost = new Post(content, imagePath);  // Create a new Post object
            user.getPosts().add(newPost);  // Add the new post to the user's posts list
            saveUsers();  // Save the updated users list to the database
        }
    }
    */
}
