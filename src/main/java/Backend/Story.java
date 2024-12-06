package Backend;
import java.time.LocalDateTime;

public class Story extends Content {
    private LocalDateTime endTime;  // End time for the story, automatically set to 24 hours after the timestamp

    /**
     * Constructor to create a new Story instance.
     * 
     * @param authorID the ID of the author of the story
     * @param content the content of the story (text, image, etc.)
     * @param timeStamp the timestamp when the story is created
     */
    public Story(String authorID, InternalContent content, LocalDateTime timeStamp) {
        super(authorID, content, timeStamp);  // Call the constructor of the superclass (Content)
        endTime = timeStamp.plusDays(1);  // Set the end time of the story to 24 hours after the timestamp
    }

    /**
     * Gets the end time of the story.
     * 
     * @return the end time of the story
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of the story.
     * 
     * @param endTime the end time to set for the story
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}