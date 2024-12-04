/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;
import Backend.ConnectHub;

/**
 *
 * @author cf
 */
  // Use the MainGUI.java instead
import javax.swing.*;
import java.util.List;

public class FriendsList extends JFrame {
    private JTextArea friendsArea;

    public FriendsList() {
        setTitle("Friends List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        friendsArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(friendsArea);

        ConnectHub fm = new ConnectHub();
        List<String> friends = fm.suggestFriends("someUserId"); // Replace with actual user ID
        friendsArea.setText(String.join("\n", friends));

        add(scrollPane);
    }

    public static void main(String[] args) {
        new FriendsList().setVisible(true);
    }
}

