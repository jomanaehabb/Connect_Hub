/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.Manager;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
// m7tagen nzbt lma yt2fl wlma n8yr el profile manager
//check current password
public class ProfileDetails extends javax.swing.JFrame {

    /**
     * Creates new form ProfileManagement
     */
    private String profilePath = ""; 
    private String coverPath = ""; 
    private Manager a;
    public ProfileDetails(Manager a) {
        initComponents();
        this.a = a;
        //making the bio text field not editable after pressing the button & editing it
        String profilePath = a.getProfilePhoto();
        ImageIcon imageIcon = new ImageIcon(profilePath);
            Image image = imageIcon.getImage().getScaledInstance(
                170, 
                170, 
                Image.SCALE_SMOOTH
            );
            profilePhoto.setIcon(new ImageIcon(image));
            profilePhoto.setText(""); 
        String coverPath = a.getCoverPhoto();
        ImageIcon imageIconC = new ImageIcon(coverPath);
        Image imageC = imageIconC.getImage().getScaledInstance(
                460, 
                220, 
                Image.SCALE_SMOOTH
            );
            coverPhoto.setIcon(new ImageIcon(imageC));
            coverPhoto.setText(""); 
            
        bioText.addFocusListener(new java.awt.event.FocusListener() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            
                bioText.setEditable(false);
                // put bio in the text field from appManager
            
        }
    });
       
      bioText.setText(a.getBio());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profilePhoto = new javax.swing.JLabel();
        coverPhoto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bioText = new javax.swing.JTextField();
        editBio_btn = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        currPass = new javax.swing.JLabel();
        changePassword_btn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        newPasswordPanel = new javax.swing.JPanel();
        newPass = new javax.swing.JLabel();
        reEnterPass = new javax.swing.JLabel();
        checkNewPass = new javax.swing.JPasswordField();
        confirmPassword_btn = new javax.swing.JButton();
        newPasword = new javax.swing.JPasswordField();
        saveBio = new javax.swing.JButton();
        user_post_story = new javax.swing.JButton();
        CreateGroupButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        profilePhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        coverPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Change Profile Photo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Change Cover Photo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Bio");

        bioText.setEditable(false);
        bioText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bioTextActionPerformed(evt);
            }
        });

        editBio_btn.setText("Edit Bio");
        editBio_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBio_btnActionPerformed(evt);
            }
        });

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        currPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        currPass.setText("Enter Current Password");

        changePassword_btn.setText("Change Password");
        changePassword_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassword_btnActionPerformed(evt);
            }
        });

        newPass.setText("New Password");
        newPass.setEnabled(false);

        reEnterPass.setText("ReEnter Password");
        reEnterPass.setEnabled(false);

        checkNewPass.setEnabled(false);

        confirmPassword_btn.setText("Confirm Password");
        confirmPassword_btn.setEnabled(false);
        confirmPassword_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPassword_btnActionPerformed(evt);
            }
        });

        newPasword.setEnabled(false);
        newPasword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPaswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newPasswordPanelLayout = new javax.swing.GroupLayout(newPasswordPanel);
        newPasswordPanel.setLayout(newPasswordPanelLayout);
        newPasswordPanelLayout.setHorizontalGroup(
            newPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newPasswordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newPasswordPanelLayout.createSequentialGroup()
                        .addGroup(newPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(newPasswordPanelLayout.createSequentialGroup()
                                .addComponent(reEnterPass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkNewPass))
                            .addGroup(newPasswordPanelLayout.createSequentialGroup()
                                .addComponent(newPass)
                                .addGap(30, 30, 30)
                                .addComponent(newPasword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newPasswordPanelLayout.createSequentialGroup()
                        .addComponent(confirmPassword_btn)
                        .addGap(17, 17, 17))))
        );
        newPasswordPanelLayout.setVerticalGroup(
            newPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newPasswordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPass)
                    .addComponent(newPasword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reEnterPass)
                    .addComponent(checkNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(confirmPassword_btn)
                .addContainerGap())
        );

        saveBio.setText("Save");
        saveBio.setEnabled(false);
        saveBio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBioActionPerformed(evt);
            }
        });

        user_post_story.setText("Show my posts and stories");
        user_post_story.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_post_storyActionPerformed(evt);
            }
        });

        CreateGroupButton.setBackground(new java.awt.Color(0, 153, 255));
        CreateGroupButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CreateGroupButton.setForeground(new java.awt.Color(255, 255, 255));
        CreateGroupButton.setText("Create Group");
        CreateGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateGroupButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(coverPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editBio_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveBio))
                            .addComponent(bioText))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(currPass)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changePassword_btn)
                                .addGap(97, 97, 97)))
                        .addComponent(newPasswordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(118, 118, 118)))
                .addContainerGap())
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(user_post_story)
                .addGap(36, 36, 36)
                .addComponent(CreateGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(coverPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton1)))))
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(currPass))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saveBio)
                                    .addComponent(editBio_btn)
                                    .addComponent(changePassword_btn)))))
                    .addComponent(newPasswordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_post_story)
                    .addComponent(CreateGroupButton))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".png");
            }

            @Override
            public String getDescription() {
                return "PNG Images (*.png)";
            }
        });
        
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
             profilePath = selectedFile.getAbsolutePath();
             if(profilePath.endsWith(".png")){
            ImageIcon imageIcon = new ImageIcon(profilePath);
            Image image = imageIcon.getImage().getScaledInstance(
                profilePhoto.getWidth(), 
                profilePhoto.getHeight(), 
                Image.SCALE_SMOOTH
            );
            profilePhoto.setIcon(new ImageIcon(image));
            profilePhoto.setText(""); 
            
           JOptionPane.showMessageDialog(this, "photo uploaded successfully");
             }
             else{
             JOptionPane.showMessageDialog(null, "Selected file is not png image", "Warning", JOptionPane.WARNING_MESSAGE);
             }
        } else {
        JOptionPane.showMessageDialog(null, "No image selected", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
        a.changeProfilePhoto(profilePath);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".png");
            }

            @Override
            public String getDescription() {
                return "PNG Images (*.png)";
            }
        });
        
        // Show the file chooser dialog
        int result = fileChooser.showOpenDialog(null);
        
        // Check if the user selected a file
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            coverPath = selectedFile.getAbsolutePath();
            if(coverPath.endsWith(".png")){
           ImageIcon imageIcon = new ImageIcon(coverPath);
            Image image = imageIcon.getImage().getScaledInstance(
                460, 
                220, 
                Image.SCALE_SMOOTH
            );
            coverPhoto.setIcon(new ImageIcon(image));
            coverPhoto.setText("");
            
           JOptionPane.showMessageDialog(this, "photo uploaded successfully");
            }
            else{
              JOptionPane.showMessageDialog(null, "Selected file is not png image", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
        JOptionPane.showMessageDialog(null, "No image selected", "Warning", JOptionPane.WARNING_MESSAGE);
        }
       
        a.changeCoverPhoto(coverPath);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bioTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bioTextActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bioTextActionPerformed

    
    
    private void editBio_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBio_btnActionPerformed
        // TODO add your handling code here:
        
        
        bioText.setEditable(true);
        bioText.setFocusable(true);
        saveBio.setEnabled(true);
        
        
    }//GEN-LAST:event_editBio_btnActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void changePassword_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassword_btnActionPerformed
        // TODO add your handling code here:
        //We need to check if the password is true or not
        //If Password is true
        
        if(a.checkPassword(passwordField.getText())){
            newPass.setEnabled(true);
            reEnterPass.setEnabled(true);
            newPasword.setEnabled(true);
            checkNewPass.setEnabled(true);
            confirmPassword_btn.setEnabled(true);
            currPass.setEnabled(false);
            passwordField.setEnabled(false);
            changePassword_btn.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Wrong Password", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_changePassword_btnActionPerformed

    private void newPaswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPaswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPaswordActionPerformed

    private void confirmPassword_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPassword_btnActionPerformed
        // TODO add your handling code here:
        String newPassword = new String(newPasword.getPassword());
        
        String confirmPassword =new String(checkNewPass.getPassword()) ;
        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Password fields cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!newPassword.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    newPass.setEnabled(false);
    reEnterPass.setEnabled(false);
    newPasword.setEnabled(false);
    checkNewPass.setEnabled(false);
    confirmPassword_btn.setEnabled(false);
    currPass.setEnabled(true);
    passwordField.setEnabled(true);
    changePassword_btn.setEnabled(true);
    // Save the new password
    
    a.changePassword(newPasword.getText());  // n4of get text dy lw fy tareka tanya
    JOptionPane.showMessageDialog(this, "Password changed successfully!");
    passwordField.setText(newPassword);
    newPasword.setText("");
    checkNewPass.setText("");
    }//GEN-LAST:event_confirmPassword_btnActionPerformed

    private void saveBioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBioActionPerformed
        // TODO add your handling code here:
        //Save in user bio
        
        bioText.setFocusable(false);
        saveBio.setEnabled(false);
        a.changeBio(bioText.getText());
        JOptionPane.showMessageDialog(ProfileDetails.this, "Bio saved successfully!");
    }//GEN-LAST:event_saveBioActionPerformed

    private void user_post_storyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_post_storyActionPerformed
        // TODO add your handling code here:
         JFrame frame = new JFrame("My Posts and Stories");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close on exit
    frame.setSize(800, 600); // Set the frame size
    frame.add(new MyPosts_Stories(a)); // Add your panel
    frame.setVisible(true); // Make the frame visible
        //new window for displaying user's post and stories
    }//GEN-LAST:event_user_post_storyActionPerformed

    private void CreateGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateGroupButtonActionPerformed
        // TODO add your handling code here:
        CreateGroup createGroup = new CreateGroup(a);
        createGroup.setVisible(true);
    }//GEN-LAST:event_CreateGroupButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProfileDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new ProfileDetails(a).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateGroupButton;
    private javax.swing.JTextField bioText;
    private javax.swing.JButton changePassword_btn;
    private javax.swing.JPasswordField checkNewPass;
    private javax.swing.JButton confirmPassword_btn;
    private javax.swing.JLabel coverPhoto;
    private javax.swing.JLabel currPass;
    private javax.swing.JButton editBio_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel newPass;
    private javax.swing.JPanel newPasswordPanel;
    private javax.swing.JPasswordField newPasword;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel profilePhoto;
    private javax.swing.JLabel reEnterPass;
    private javax.swing.JButton saveBio;
    private javax.swing.JButton user_post_story;
    // End of variables declaration//GEN-END:variables
}
