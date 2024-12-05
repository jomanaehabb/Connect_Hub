/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Frontend;



import Backend.ConnectHub;
import javax.swing.*;

public class FriendsManagement extends JFrame {
    private ConnectHub connectHub;
    private String currentUsername;

    public FriendsManagement(String username) {
        this.currentUsername = username;
        this.connectHub = new ConnectHub();

        setTitle("Friends Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Create the tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add each "window" to the tabs
        tabbedPane.addTab("Friend Requests", new FriendRequests(currentUsername, connectHub));
        tabbedPane.addTab("Friends List", new FriendsList(currentUsername, connectHub));
        tabbedPane.addTab("Suggested Friends", new SuggestFriends(currentUsername, connectHub));

        add(tabbedPane);

        setVisible(true);
    }

    
}

