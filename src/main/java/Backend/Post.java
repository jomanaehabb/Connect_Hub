package Backend;

import java.time.LocalDateTime;

public class Post extends Content {
    private static int id;

    public Post(String photo, String contentID, String authorID, String text, LocalDateTime timePosted) {
        super(photo, contentID, authorID, text, timePosted);
    }

    public Post(String photo, String authorID, String text) { // optional photo
        /* null should be sent from the front end */
        super(photo, "P-" + id++, authorID, text, LocalDateTime.now());
    }

    public Post(String photo, String contentID, String authorID, String text) { // optional photo
        /* null should be sent from the front end */
        super(photo, contentID, authorID, text, LocalDateTime.now());
    }

    public static void setId(int id) {
        Post.id = id;
    }

    // Getter for contentID
    @Override
    public String getContentID() {
        return super.getContentID();
    }

    // Getter for authorID
    @Override
    public String getAuthorID() {
        return super.getAuthorID();
    }

    // Getter for text
    @Override
    public String getText() {
        return super.getText();
    }

    // Getter for photo
    @Override
    public String getPhoto() {
        return super.getPhoto();
    }

    // Getter for timePosted
    @Override
    public LocalDateTime getTimePosted() {
        return super.getTimePosted();
    }
    
    public String getOwnerId() {
        return getAuthorID(); // Alias for the author's ID
    }
}
