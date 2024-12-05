package Backend;

public class ProfileManager extends Manager {

    public boolean updateBio(String email, String newBio) {
        User user = users.get(email);
        if (user != null) {
            user.setBio(newBio);
            saveUsers();
            return true;
        } else return false;
    }

    public void updateProfilePhoto(String email, String photoPath) {
        User user = users.get(email);
        if (user != null) {
            user.setProfilePhotoPath(photoPath);
            saveUsers();
        }
    }

    public void updateCoverPhoto(String email, String coverPhotoPath) {
        User user = users.get(email);
        if (user != null) {
            user.setCoverPhotoPath(coverPhotoPath);
            saveUsers();
        }
    }

    public void createPost(String email, String content, String imagePath) {
        User user = users.get(email);
        if (user != null) {
            Post newPost = new Post(content, imagePath);
            user.getPosts().add(newPost);
            saveUsers();
        }
    }
}

