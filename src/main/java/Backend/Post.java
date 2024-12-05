package Backend;

import java.time.LocalDateTime;

public class Post extends Content{
    private String content;
    private LocalDateTime timestamp;
    private String imagePath;

    public Post(String content, InternalContent imagePath, LocalDateTime now) {
        this.content = content;
        this.imagePath = imagePath;
        this.timestamp = LocalDateTime.now();
    }

    public Post() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getContent() { return content; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getImagePath() { return imagePath; }
}

