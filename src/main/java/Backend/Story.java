package Backend;

import java.time.LocalDateTime;

public class Story extends Content{
    private LocalDateTime endTime;

    public Story(String authorID, LocalDateTime timeStamp, InternalContent content, String userID) {
        super(authorID, content, timeStamp);
        endTime = timeStamp.plusDays(1);
    }



    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

}
