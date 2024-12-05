package Frontend;

import Backend.ConnectHub1;

  // Use the MainGUI.java instead
import javax.swing.*;
import java.util.List;

public class FriendsList extends JFrame {
    private JTextArea friendsArea;

    public FriendsList() {
        setTitle("Friends List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        friendsArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(friendsArea);

        ConnectHub1 fm = new ConnectHub1();
        List<String> friends = fm.suggestFriends("someUserId"); // Replace with actual user ID
        friendsArea.setText(String.join("\n", friends));

        add(scrollPane);
    }
}
