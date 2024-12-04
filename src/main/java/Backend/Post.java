package main.java.Backend;

import java.time.LocalDateTime;

public class Post extends Content{

    public Post(String authorID, InternalContent content, LocalDateTime timeStamp) {
        super(authorID, content, timeStamp);

    }
}
