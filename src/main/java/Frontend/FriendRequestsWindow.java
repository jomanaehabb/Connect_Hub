/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

/**
 *
 * @author cf
 */
 // Alternative to the GUI but this time instead of tabs we use separate panels for each page(we may use it)
 // Use the MainGUI.java instead


import Backend.ConnectHub;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FriendRequests extends JPanel {
    public FriendRequests(String currentUsername, ConnectHub connectHub) {
        // Main panel for friend requests
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Get friend requests from the backend
        List<String[]> friendRequests = connectHub.getFriendRequests(currentUsername);

        for (String[] request : friendRequests) {
            if (request.length == 1) {
                String requesterUsername = request[0];
                JLabel requesterLabel = new JLabel("Friend request from: " + requesterUsername);

                // Accept button
                JButton acceptButton = new JButton("Accept");
                acceptButton.addActionListener(e -> {
                    connectHub.respondToFriendRequest(requesterUsername, currentUsername, true);
                    JOptionPane.showMessageDialog(this, "You accepted the friend request from " + requesterUsername);
                });

                // Decline button
                JButton declineButton = new JButton("Decline");
                declineButton.addActionListener(e -> {
                    connectHub.respondToFriendRequest(requesterUsername, currentUsername, false);
                    JOptionPane.showMessageDialog(this, "You declined the friend request from " + requesterUsername);
                });

                // Add components to a sub-panel
                JPanel requestPanel = new JPanel();
                requestPanel.add(requesterLabel);
                requestPanel.add(acceptButton);
                requestPanel.add(declineButton);

                // Add the sub-panel to the content panel
                contentPanel.add(requestPanel);
            }
        }

        // Wrap the content panel with a JScrollPane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        // Add the scroll pane to the FriendRequestsWindow panel
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }
}
