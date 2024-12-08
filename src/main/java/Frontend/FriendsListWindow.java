/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;

import Backend.FriendsManagement;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class FriendsListWindow extends JPanel {
    private FriendsManagement connectHub; 
    private String currentUsername; 
    private JPanel friendsPanel; // Panel for dynamically adding friend rows


    public FriendsListWindow(String username, FriendsManagement connectHub) {
        this.connectHub = connectHub;
        this.currentUsername = username; // Store the passed username

        // Initialize components
        initComponents();

        // Create the dynamic panel for friends and link it to the scroll pane
        friendsPanel = new JPanel();
        friendsPanel.setLayout(new GridLayout(0, 1, 5, 5)); // Rows with spacing
        jScrollPane1.setViewportView(friendsPanel); // Attach to scroll pane

        // Call init with the provided username and connectHub
        init(username, connectHub);
    }

    /**
     * Custom method to dynamically update UI with the username and ConnectHub instance.
     * 
     * @param username The username of the logged-in user
     * @param connectHub The backend connection for retrieving the friends list
     */
    public void init(String username, FriendsManagement connectHub) {
        // Update the current username and backend connection
        this.currentUsername = username;
        this.connectHub = connectHub;

        // Update the header with the username
        jLabel2.setText("Friends List for: " + username);

        // Load and display the friends list dynamically
        loadFriendsList();
    }

    /**
     * Dynamically loads the friends list and refreshes the UI.
     */
    private void loadFriendsList() {
        // Clear all existing rows from the panel
        friendsPanel.removeAll();

        // Fetch the friends list from the backend
        List<String> friends = connectHub.getFriendsList(currentUsername);

        for (String friend : friends) {
            JPanel friendRow = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Row layout

            // Friend name
            JLabel friendLabel = new JLabel(friend);

            // Block button
            JButton blockButton = new JButton("Block");
            blockButton.addActionListener(e -> {
                connectHub.blockFriend(currentUsername, friend);
                JOptionPane.showMessageDialog(this, friend + " has been blocked.");
                loadFriendsList(); // Refresh the list after blocking
            });

            // Remove button
            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(e -> {
                connectHub.removeFriend(currentUsername, friend);
                JOptionPane.showMessageDialog(this, friend + " has been removed from your friends list.");
                loadFriendsList(); // Refresh the list after removal
            });

            // Add components to the row
            friendRow.add(friendLabel);
            friendRow.add(blockButton);
            friendRow.add(removeButton);

            // Add the row to the friendsPanel
            friendsPanel.add(friendRow);
        }

        // Notify the layout manager of changes to the panel
        friendsPanel.revalidate();
        friendsPanel.repaint();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("[username]");

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Remove");

        jButton2.setBackground(new java.awt.Color(102, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Block");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Friends for : [username]");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
