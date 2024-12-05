package Frontend;

import Backend.ConnectHub;

  // Use the MainGUI.java instead
import javax.swing.*;
import java.util.List;

public class FriendsListWindow extends JFrame {
    private JTextArea friendsArea;

    public FriendsListWindow() {
        setTitle("Friends List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        friendsArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(friendsArea);

        ConnectHub fm = new ConnectHub();
        List<String> friends = fm.suggestFriends("someUserId"); // Replace with actual user ID
        friendsArea.setText(String.join("\n", friends));

        add(scrollPane);
    }
}
