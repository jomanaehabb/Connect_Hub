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


import Backend.ConnectHub;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FriendsList extends JPanel {
    private ConnectHub connectHub; 
    private String currentUsername;
    public FriendsList(String currentUsername, ConnectHub connectHub) {
        this.currentUsername = currentUsername;
        this.connectHub = new ConnectHub();
        setLayout(new BorderLayout());
        
        

        JLabel header = new JLabel("Friends List for: " + currentUsername, JLabel.CENTER);
        add(header, BorderLayout.NORTH);

        // Get the list of friends from the backend
        List<String> friends = connectHub.getFriendsList(currentUsername);

        JPanel friendsPanel = new JPanel(new GridLayout(friends.size(), 1, 5, 5));

        for (String friend : friends) {
            JPanel friendRow = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JLabel friendLabel = new JLabel(friend);
            JButton blockButton = new JButton("Block");
            JButton removeButton = new JButton("Remove");

            blockButton.addActionListener(e -> {
                connectHub.blockFriend(currentUsername, friend);
                JOptionPane.showMessageDialog(this, friend + " has been blocked.");
            });

            removeButton.addActionListener(e -> {
                connectHub.removeFriend(currentUsername, friend);
                JOptionPane.showMessageDialog(this, friend + " has been removed from your friends list.");
            });

            friendRow.add(friendLabel);
            friendRow.add(blockButton);
            friendRow.add(removeButton);
            friendsPanel.add(friendRow);
        }

        JScrollPane scrollPane = new JScrollPane(friendsPanel);
        add(scrollPane, BorderLayout.CENTER);
        
        setVisible(true);
        setSize(600, 400);
        
    }
}


