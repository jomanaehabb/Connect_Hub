package Frontend;

import Backend.ProfileManager;
import Backend.User;
import Backend.UserAccountManager;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import Backend.User;
import javax.swing.JOptionPane;

public class SettingsWindow extends javax.swing.JFrame {
        private User currentUser;
    private UserAccountManager userManager;
    private ProfileManager profileManager;

    public SettingsWindow(String email) {
        initComponents();
        setLocationRelativeTo(null);
        userManager = new UserAccountManager();
        profileManager = new ProfileManager();
        this.currentUser = userManager.getUserByEmail(email);
        
        setTitle("Settings");
                if (currentUser == null) {
                    JOptionPane.showMessageDialog(this, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
                }

        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileButton = new javax.swing.JButton();
        friendsButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        addFriendButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        profileButton.setText("Profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        friendsButton.setText("Friends");
        friendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        addFriendButton.setText("Add Friend");
        addFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addFriendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(friendsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(profileButton)
                .addGap(38, 38, 38)
                .addComponent(friendsButton)
                .addGap(45, 45, 45)
                .addComponent(addFriendButton)
                .addGap(29, 29, 29)
                .addComponent(logoutButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed

    }//GEN-LAST:event_logoutButtonActionPerformed

    private void addFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendButtonActionPerformed
        AddFriendWindow addFriend = new AddFriendWindow();
        addFriend.setVisible(true);
    }//GEN-LAST:event_addFriendButtonActionPerformed

    private void friendsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsButtonActionPerformed

            FriendsManagementWindow friendsManagementPanel = new FriendsManagementWindow("123");
            // Embed the panel in a JFrame for testing
            JFrame frame = new JFrame("Friends Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.add(friendsManagementPanel);
            frame.setVisible(true);
    }//GEN-LAST:event_friendsButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        // TODO add your handling code here:
        ProfileManagementWindow profileManagementWindow = new ProfileManagementWindow(currentUser.getEmail());
        profileManagementWindow.setVisible(true);
        profileManagementWindow.pack();
        profileManagementWindow.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_profileButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFriendButton;
    private javax.swing.JButton friendsButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton profileButton;
    // End of variables declaration//GEN-END:variables
}
