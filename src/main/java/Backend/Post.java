package Backend;

import java.time.LocalDateTime;

public class Post extends Content {
    private String postContent; // Renamed to avoid conflict with Content class
    private LocalDateTime postTimestamp; // Renamed for clarity
    private String imagePath;

    // Corrected constructor
    public Post(String postContent, LocalDateTime postTimestamp, String imagePath, String authorID) {
        super(authorID, null, postTimestamp); // Assuming InternalContent is null for now
        this.postContent = postContent;
        this.postTimestamp = postTimestamp;
        this.imagePath = imagePath;
    }

    // Default constructor
    public Post() {
        super(null, null, null); // Placeholder values for superclass constructor
        this.postContent = "";
        this.postTimestamp = LocalDateTime.now();
        this.imagePath = "";
    }


    public LocalDateTime getTimestamp() {
        return postTimestamp;
    }

    public String getImagePath() {
        return imagePath;
    }
}