/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;

import Backend.ProfileManager;
import Backend.User;
import Backend.UserAccountManager;
import Backend.UserSearch;

/**
 *
 * @author Lenovo
 */
public class UserSearchWindow extends javax.swing.JPanel {
    
    private User currentUser;
    private UserAccountManager userManager;

    /**
     * Creates new form UserSearchWindow
     */
    public UserSearchWindow(String email) {
        userManager = UserAccountManager.getInstance();
        this.currentUser = userManager.getUserByEmail(email);

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaResults = new javax.swing.JTextArea();
        addFriend = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(102, 153, 255));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtAreaResults.setColumns(20);
        txtAreaResults.setRows(5);
        jScrollPane1.setViewportView(txtAreaResults);

        addFriend.setBackground(new java.awt.Color(102, 153, 255));
        addFriend.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addFriend.setForeground(new java.awt.Color(255, 255, 255));
        addFriend.setText("Add Friend");
        addFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(addFriend)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(addFriend))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private boolean userFound = false; // Flag to track if a valid user is found during search

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String targetUsername = txtUsername.getText().trim();

    if (targetUsername.isEmpty()) {
        txtAreaResults.setText("Please enter a username to search.");
        addFriend.setEnabled(false); // Disable Add Friend button if input is empty
        userFound = false;
        return;
    }

    // Create a UserSearch instance and search for the user
    UserSearch userSearch = new UserSearch();
    User foundUser = userSearch.searchFriend(targetUsername);

    if (foundUser != null) {
        txtAreaResults.setText("User found:\n"
                + "Username: " + foundUser.getUsername() + "\n"
                + "Email: " + foundUser.getEmail());
        addFriend.setEnabled(true); // Enable Add Friend button if user is found
        userFound = true; // Update flag
    } else {
        txtAreaResults.setText("No user found with username: " + targetUsername);
        addFriend.setEnabled(false); // Disable Add Friend button if no user is found
        userFound = false;
    }
    }//GEN-LAST:event_searchButtonActionPerformed

    
    private void addFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendActionPerformed
        // TODO add your handling code here:
        // Ensure a user was found before proceeding
    if (!userFound) {
        txtAreaResults.setText("Please search for a valid user before sending a friend request.");
        return;
    }

    String targetUsername = txtUsername.getText().trim();

    if (targetUsername.isEmpty()) {
        txtAreaResults.setText("Please search for a user before sending a friend request.");
        return;
    }

    // Create a UserSearch instance and send the friend request
    UserSearch userSearch = new UserSearch();
    String currentUsername = currentUser.getUsername(); // Replace with the actual logged-in username

    userSearch.sendFriendRequest(currentUsername, targetUsername);

    txtAreaResults.setText("Friend request sent to: " + targetUsername);
    addFriend.setEnabled(false); // Disable Add Friend button after request is sent
    userFound = false; // Reset flag
    }//GEN-LAST:event_addFriendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFriend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextArea txtAreaResults;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}