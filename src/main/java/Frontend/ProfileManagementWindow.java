package Frontend;

import Backend.ProfileManager;
import Backend.User;
import Backend.UserAccountManager;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ProfileManagementWindow extends javax.swing.JFrame {
    private User currentUser;
    private UserAccountManager userManager;
    private ProfileManager profileManager;

    public ProfileManagementWindow(String email) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Managing profile");
        userManager = new UserAccountManager();
        profileManager = new ProfileManager();
        this.currentUser = userManager.getUserByEmail(email);
        
        if (currentUser != null) {
            displayUserInfo();
        } else {
            JOptionPane.showMessageDialog(this, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void displayUserInfo() {
        usernameLabel.setText("Username: " + currentUser.getUsername());
        emailLabel.setText("Email: " + currentUser.getEmail());
        bioTextArea.setText(currentUser.getBio());
        bioTextArea.setText(currentUser.getBio());
        loadImage(profilePhotoLabel, currentUser.getProfilePhotoPath());
        loadImage(coverPhotoLabel, currentUser.getCoverPhotoPath());
    }
    
    private void updateUserInfo() {
    String newBio = bioTextArea.getText();
    if (profileManager.updateBio(currentUser.getEmail(), newBio)) {
        currentUser.setBio(newBio); // Update current user's bio in memory
        displayUserInfo();
        JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Failed to update bio. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    private String selectImageFile(String dialogTitle) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(dialogTitle);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    
    private void changeProfilePhoto() {
        String imagePath = selectImageFile("Select Profile Photo");
        if (imagePath != null) {
            profileManager.updateProfilePhoto(currentUser.getEmail(), imagePath);
            loadImage(profilePhotoLabel, imagePath);
            JOptionPane.showMessageDialog(this, "Profile photo updated successfully!");
        }
    }

    private void changeCoverPhoto() {
        String imagePath = selectImageFile("Select Cover Photo");
        if (imagePath != null) {
            profileManager.updateCoverPhoto(currentUser.getEmail(), imagePath);
            loadImage(coverPhotoLabel, imagePath);
            JOptionPane.showMessageDialog(this, "Cover photo updated successfully!");
        }
    }
    private void loadImage(JLabel label, String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image image = imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(image));
        } else {
            label.setIcon(null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        profilePhotoButton = new javax.swing.JButton();
        coverPhotoButton = new javax.swing.JButton();
        profilePhotoLabel = new javax.swing.JLabel();
        coverPhotoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bioTextArea = new javax.swing.JTextArea();
        usernameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        saveBioButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        viewNewsFeed = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 700));

        profilePhotoButton.setText("Change profile photo");
        profilePhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilePhotoButtonActionPerformed(evt);
            }
        });

        coverPhotoButton.setText("Change cover photo");
        coverPhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coverPhotoButtonActionPerformed(evt);
            }
        });

        profilePhotoLabel.setForeground(new java.awt.Color(255, 255, 255));
        profilePhotoLabel.setText("Profile Photo");

        coverPhotoLabel.setForeground(new java.awt.Color(255, 255, 255));
        coverPhotoLabel.setText("Cover Photo");

        bioTextArea.setColumns(20);
        bioTextArea.setRows(5);
        jScrollPane1.setViewportView(bioTextArea);

        usernameLabel.setBackground(new java.awt.Color(0, 0, 0));
        usernameLabel.setText("Username");

        emailLabel.setText("Email");

        saveBioButton.setText("Save Bio");
        saveBioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBioButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        viewNewsFeed.setText("View News Feed");
        viewNewsFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewNewsFeedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(logoutButton)
                        .addGap(174, 174, 174)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(viewNewsFeed)
                        .addGap(224, 224, 224)
                        .addComponent(saveBioButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profilePhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(profilePhotoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(coverPhotoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addComponent(coverPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coverPhotoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(profilePhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coverPhotoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profilePhotoButton)
                .addGap(9, 9, 9)
                .addComponent(usernameLabel)
                .addGap(13, 13, 13)
                .addComponent(emailLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBioButton)
                    .addComponent(viewNewsFeed))
                .addGap(155, 155, 155))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profilePhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilePhotoButtonActionPerformed
        changeProfilePhoto();
    }//GEN-LAST:event_profilePhotoButtonActionPerformed

    private void coverPhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coverPhotoButtonActionPerformed
        changeCoverPhoto();
    }//GEN-LAST:event_coverPhotoButtonActionPerformed

    private void saveBioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBioButtonActionPerformed
        updateUserInfo();
    }//GEN-LAST:event_saveBioButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        currentUser.setStatus("offline");
        JOptionPane.showMessageDialog(this, "You have been logged out.", "Logout", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void viewNewsFeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewNewsFeedActionPerformed
        // TODO add your handling code here:
        NewsFeedWindow newsFeedWindow = new NewsFeedWindow(currentUser.getEmail());
        newsFeedWindow.setVisible(true);
        newsFeedWindow.pack();
        newsFeedWindow.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_viewNewsFeedActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bioTextArea;
    private javax.swing.JButton coverPhotoButton;
    private javax.swing.JLabel coverPhotoLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton profilePhotoButton;
    private javax.swing.JLabel profilePhotoLabel;
    private javax.swing.JButton saveBioButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JButton viewNewsFeed;
    // End of variables declaration//GEN-END:variables
}
