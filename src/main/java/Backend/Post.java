package Backend;

import java.time.LocalDateTime;

/**
 * The Post class represents a post in the system.
 * It extends the Content class and adds functionality specific to a post.
 */
public class Post extends Content {

    /**
     * Constructor to create a new Post instance.
     * 
     * @param authorID the ID of the user who authored the post
     * @param content the content (text and image) of the post
     * @param timeStamp the date and time when the post was created
     */
    public Post(String authorID, InternalContent content, LocalDateTime timeStamp) {
        // Calls the constructor of the superclass Content to initialize the post
        super(authorID, content, timeStamp);
    }
}
