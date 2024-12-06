package Backend;

import java.time.LocalDateTime;

public abstract class Content{
    private static int counter = 1;
    private String contentID;
    String authorID;
    private InternalContent content;
    private LocalDateTime timeStamp;

    public Content(String authorID, InternalContent content, LocalDateTime timeStamp) {
        this.contentID = Integer.toString(counter); // automatically created the content ID at creation
        counter++;
        this.authorID = authorID;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public InternalContent getContent() {
        return content;
    }

    public void setContent(InternalContent content) {
        this.content = content;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
