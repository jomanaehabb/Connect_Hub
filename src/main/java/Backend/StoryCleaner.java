
package Backend;

import java.time.LocalDateTime;

public class StoryCleaner implements Runnable {
    private ContentDatabase contentDatabase;

    public StoryCleaner(){
        contentDatabase = ContentDatabase.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            try {
                    for(int i=0;i<contentDatabase.allStories().size();i++){
                        if (contentDatabase.allStories().get(i).getEndTime().isAfter(LocalDateTime.now())) {
                            contentDatabase.deleteStory(contentDatabase.allStories().get(i));
                        }
                    }
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                System.out.println("Cleaner thread interrupted");
                break;
            }
        }
    }
}
