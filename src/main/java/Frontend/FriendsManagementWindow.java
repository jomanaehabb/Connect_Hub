/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

/**
 *
 * @author cf
 */


import Backend.ConnectHub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FriendsManagementWindow extends JFrame {
    private ConnectHub connectHub; 
    private String currentUsername; 

    public FriendsManagementWindow(String username) {
        this.currentUsername = username;
        this.connectHub = new ConnectHub(); 

        setTitle("Friends Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Create tabs for easy access to each part of the 
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add the three tabs (Friend Requests, Friends List, Suggested Friends)
        tabbedPane.addTab("Friend Requests", createFriendRequestsPanel());
        tabbedPane.addTab("Friends List", createFriendsListPanel());
        tabbedPane.addTab("Suggested Friends", createSuggestedFriendsPanel());

        add(tabbedPane);

        setVisible(true);
    }

    // Tab 1: Friend Requests
    public JPanel createFriendRequestsPanel() {
        // get the list of friend requests for the current user
        List<String[]> friendRequests = connectHub.getFriendRequests(currentUsername);

        // display the requests
        JPanel friendRequestsPanel = new JPanel();
        friendRequestsPanel.setLayout(new BoxLayout(friendRequestsPanel, BoxLayout.Y_AXIS));

        // get the requester username for the respond to request function
        for (String[] request : friendRequests) {
            if (request.length == 1) {  
                String requesterUsername = request[0];

                JLabel requesterLabel = new JLabel("Friend request from: " + requesterUsername);

                // Accept button
                JButton acceptButton = new JButton("Accept");
                acceptButton.addActionListener(e -> {
                    // Action for the Accept button
                    connectHub.respondToFriendRequest(requesterUsername, currentUsername, true);
                    refreshFriendRequestsPanel(friendRequestsPanel);  // Refresh panel after action (doesn't work)
                });

                // Decline button
                JButton declineButton = new JButton("Decline");
                declineButton.addActionListener(e -> {
                    // Action for the decline button
                    connectHub.respondToFriendRequest(requesterUsername, currentUsername, false);
                    refreshFriendRequestsPanel(friendRequestsPanel);  // Refresh panel after action(doesn't work)
                });

                
                JPanel requestPanel = new JPanel();
                requestPanel.add(requesterLabel);
                requestPanel.add(acceptButton);
                requestPanel.add(declineButton);

               
                friendRequestsPanel.add(requestPanel);
            } else {
                System.out.println("Invalid friend request: missing username");
            }
        }

        // Scroll panel incase of alot of requests
        JScrollPane scrollPane = new JScrollPane(friendRequestsPanel);
        scrollPane.setPreferredSize(new Dimension(400, 300));  

        
        this.add(scrollPane, BorderLayout.CENTER);  
        this.revalidate();  // Refresh the frame(not working)
        this.repaint();  // Repaint the frame to display updated content(not working)

        return friendRequestsPanel;  
    }

    // Tab 2: Friends List
    private JPanel createFriendsListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel header = new JLabel("Friends List for: " + currentUsername, JLabel.CENTER);
        panel.add(header, BorderLayout.NORTH);

        // Get a list of friends from the backend
        List<String> friends = connectHub.getFriendsList(currentUsername); // Assume this returns a list of usernames

        // Panel to display friends
        JPanel friendsPanel = new JPanel(new GridLayout(friends.size(), 1, 5, 5));
        for (String friend : friends) {
            JPanel friendRow = new JPanel(new FlowLayout(FlowLayout.LEFT));

            // Display the friend's username
            JLabel friendLabel = new JLabel(friend);
            friendRow.add(friendLabel);

            // Add Block button
            JButton blockButton = new JButton("Block");
            blockButton.addActionListener(e -> {
                connectHub.blockFriend(currentUsername, friend); // Call blockFriend in backend
                JOptionPane.showMessageDialog(this, friend + " has been blocked.");
            });
            friendRow.add(blockButton);

            // Add Remove button
            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(e -> {
                connectHub.removeFriend(currentUsername, friend); // Call removeFriend in backend
                JOptionPane.showMessageDialog(this, friend + " has been removed from your friends list.");
            });
            friendRow.add(removeButton);

            // Add the row to the panel
            friendsPanel.add(friendRow);
        }

        JScrollPane scrollPane = new JScrollPane(friendsPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }


    // Tab 3: Suggested Friends
    private JPanel createSuggestedFriendsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel header = new JLabel("Suggested Friends for: " + currentUsername, JLabel.CENTER);
        panel.add(header, BorderLayout.NORTH);

        // get a list of suggested friends from the backend
        List<String> suggestedFriends = connectHub.suggestFriends(currentUsername);

        JPanel suggestionsPanel = new JPanel(new GridLayout(suggestedFriends.size(), 1, 5, 5));
        for (String suggestion : suggestedFriends) {
            JPanel suggestionRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel suggestionLabel = new JLabel(suggestion);
            JButton addButton = new JButton("Add");

            // Action of Add button
            addButton.addActionListener(e -> {
                connectHub.sendFriendRequest(currentUsername, suggestion);
                JOptionPane.showMessageDialog(this, "Friend request sent to " + suggestion + "!");
                refreshSuggestedFriendsPanel(panel); // Refresh the panel after action(not working)
            });

            suggestionRow.add(suggestionLabel);
            suggestionRow.add(addButton);
            suggestionsPanel.add(suggestionRow);
        }

        JScrollPane scrollPane = new JScrollPane(suggestionsPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Refresh methods to reload data(not working)
    private void refreshFriendRequestsPanel(JPanel panel) {
        getContentPane().remove(panel);
        add(createFriendRequestsPanel());
        revalidate();
        repaint();
    }
    // not working
    private void refreshSuggestedFriendsPanel(JPanel panel) {
        getContentPane().remove(panel);
        add(createSuggestedFriendsPanel());
        revalidate();
        repaint();
    }

    /*public static void main(String[] args) {
        // Replace this with the actuall Login logic(for now use this simple login window)
        String username = JOptionPane.showInputDialog("Enter your username:");
        if (username != null && !username.isEmpty()) {
            new MainGUI(username);
        } else {
            System.out.println("Username is required!");
        }
    }
*/
}

