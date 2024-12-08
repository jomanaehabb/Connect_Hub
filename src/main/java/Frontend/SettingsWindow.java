package Frontend;

import Backend.ProfileManager;
import Backend.UserAccountManager;
import javax.swing.JFrame;
import Backend.User;
import javax.swing.JOptionPane;

public class SettingsWindow extends javax.swing.JFrame {
    private User currentUser;
    private UserAccountManager userManager;
    private ProfileManager profileManager;

    public SettingsWindow(String email) {
        initComponents();
        setLocationRelativeTo(null);
        userManager = UserAccountManager.getInstance();
        profileManager = new ProfileManager();
        this.currentUser = userManager.getUserByEmail(email);
        
        setTitle("Settings");
                if (currentUser == null) {
                    JOptionPane.showMessageDialog(this, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
                }

        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        profileButton = new javax.swing.JButton();
        friendsButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        addFriendButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        profileButton.setBackground(new java.awt.Color(102, 153, 255));
        profileButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        profileButton.setForeground(new java.awt.Color(255, 255, 255));
        profileButton.setText("Profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        friendsButton.setBackground(new java.awt.Color(102, 153, 255));
        friendsButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        friendsButton.setForeground(new java.awt.Color(255, 255, 255));
        friendsButton.setText("Friends");
        friendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(102, 153, 255));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        addFriendButton.setBackground(new java.awt.Color(102, 153, 255));
        addFriendButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addFriendButton.setForeground(new java.awt.Color(255, 255, 255));
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
                    .addComponent(addFriendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(friendsButton)
                .addGap(18, 18, 18)
                .addComponent(addFriendButton)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        currentUser.setStatus("offline");
        JOptionPane.showMessageDialog(this, "You have been logged out.", "Logout", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();

    }                                            

    private void addFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        AddFriendWindow addFriend = new AddFriendWindow();
        addFriend.setVisible(true);
    }                                               

    private void friendsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              

            String username=currentUser.getUsername();
            FriendsManagementWindow friendsManagementPanel = new FriendsManagementWindow(username);
            // Embed the panel in a JFrame for testing
            JFrame frame = new JFrame("Friends Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.add(friendsManagementPanel);
            frame.setVisible(true);
    }                                             

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        ProfileManagementWindow profileManagementWindow = new ProfileManagementWindow(currentUser.getEmail());
        profileManagementWindow.setVisible(true);
        profileManagementWindow.pack();
        profileManagementWindow.setLocationRelativeTo(null); 
        this.dispose();
    }                                             

    // Variables declaration - do not modify                     
    private javax.swing.JButton addFriendButton;
    private javax.swing.JButton friendsButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton profileButton;
    // End of variables declaration                   
}
