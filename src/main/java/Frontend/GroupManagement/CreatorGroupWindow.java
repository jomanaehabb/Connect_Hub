/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend.GroupManagement;
import Backend.Manager;
import Backend.PostString;
import Backend.UserSearch;
import Backend.GroupString;
import Frontend.PostsAndStories;
import static Frontend.PostsAndStories.showCustomDialog;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL-G3
 */
public class CreatorGroupWindow extends javax.swing.JFrame {

    /**
     * Creates new form GroupForCreator
     */
    private GroupString gs;
    private Manager a ;
    public CreatorGroupWindow(Manager a, GroupString gs) {
        initComponents();
        this.a = a;
        this.gs = gs;
        postPanel.setLayout(new javax.swing.BoxLayout(postPanel, javax.swing.BoxLayout.Y_AXIS));
        String photo = gs.getPhoto();
        String groupName = gs.getName();
        GroupName.setText(groupName);
        String groupD = gs.getDescription();
        GroupDescriptionField.setText(groupD);
        ImageIcon imageIcon = new ImageIcon(photo);
            Image image = imageIcon.getImage().getScaledInstance(
                90, 
                90, 
                Image.SCALE_SMOOTH
            );
        GroupPhoto.setIcon(new ImageIcon(image));
        GroupPhoto.setText("");
        ArrayList<PostString> posts = a.getAllGroupPost(gs.getId());
        for(PostString p : posts){
            String text = p.getText();
            String postPhoto = p.getPhoto();
            String name = p.getAuthor();
            String date = p.getDate();
            if(postPhoto.equals("No file selected")){
                PostText ap =new PostText(text, name, date, a, p.getPostId(), gs.getId());
                postPanel.add(ap);
            }
            else{
                PostImage ap = new PostImage(photo, text, name, date, a, p.getPostId(), gs.getId());
                postPanel.add(ap);
            }
            
        }
          ArrayList<UserSearch> members = a.getAllUsersOfGroup(gs.getId());
        for(UserSearch u : members){
            String name= u.getUsernameString();
            String userPhoto = u.getPhotoString();
            String relation = u.getRelationString();
            String id = u.getIdString();
            CreatorMembersDisplay m = new CreatorMembersDisplay(a, name, userPhoto, id, gs.getId());
            membersPanel.add(m);
        }
        ArrayList<UserSearch> pendingMembers = a.getAllPendingRequestsOfGroup(gs.getId());
        for(UserSearch u : pendingMembers){
            String name= u.getUsernameString();
            String userPhoto = u.getPhotoString();
            String relation = u.getRelationString();
            String id = u.getIdString();
            PendingMembers pm = new PendingMembers(a, name, photo, id, gs.getId());
            pendingMPanel.add(pm);
    }  
        ArrayList<UserSearch> admins = a.getAllAdminsOfGroup(gs.getId());
            for(UserSearch u : admins){
            String name= u.getUsernameString();
            String userPhoto = u.getPhotoString();
            String relation = u.getRelationString();
            String id = u.getIdString();
            Admin admin = new Admin(a, name, photo, id, gs.getId());
            adminsPanel.add(admin);
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupPhoto = new javax.swing.JLabel();
        GroupName = new javax.swing.JTextField();
        GroupDescriptionField = new javax.swing.JTextField();
        DeleteGroupButton = new javax.swing.JButton();
        CreatePostButton = new javax.swing.JButton();
        GroupPostsPane = new javax.swing.JScrollPane();
        postPanel = new javax.swing.JPanel();
        AdminsScrollPane = new javax.swing.JScrollPane();
        adminsPanel = new javax.swing.JPanel();
        AdminsLabel = new javax.swing.JLabel();
        ManagePostsButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        membersPanel = new javax.swing.JPanel();
        MembersLabel1 = new javax.swing.JLabel();
        EditNameButton = new javax.swing.JButton();
        SaveName = new javax.swing.JButton();
        EditDescriptionButton = new javax.swing.JButton();
        SaveDescriptionButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pendingMPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        GroupPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GroupName.setEditable(false);
        GroupName.setFocusable(false);
        GroupName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupNameActionPerformed(evt);
            }
        });

        GroupDescriptionField.setEditable(false);
        GroupDescriptionField.setFocusable(false);
        GroupDescriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupDescriptionFieldActionPerformed(evt);
            }
        });

        DeleteGroupButton.setBackground(new java.awt.Color(102, 153, 255));
        DeleteGroupButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteGroupButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteGroupButton.setText("Delete Group");
        DeleteGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteGroupButtonActionPerformed(evt);
            }
        });

        CreatePostButton.setBackground(new java.awt.Color(102, 153, 255));
        CreatePostButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CreatePostButton.setForeground(new java.awt.Color(255, 255, 255));
        CreatePostButton.setText("Create post");
        CreatePostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePostButtonActionPerformed(evt);
            }
        });

        GroupPostsPane.setBackground(null);

        postPanel.setLayout(new javax.swing.BoxLayout(postPanel, javax.swing.BoxLayout.LINE_AXIS));
        GroupPostsPane.setViewportView(postPanel);

        AdminsScrollPane.setBackground(null);

        adminsPanel.setLayout(new javax.swing.BoxLayout(adminsPanel, javax.swing.BoxLayout.LINE_AXIS));
        AdminsScrollPane.setViewportView(adminsPanel);

        AdminsLabel.setBackground(null);
        AdminsLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AdminsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdminsLabel.setText("Admins");

        ManagePostsButton.setBackground(new java.awt.Color(102, 153, 255));
        ManagePostsButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ManagePostsButton.setForeground(new java.awt.Color(255, 255, 255));
        ManagePostsButton.setText("Manage posts");
        ManagePostsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManagePostsButtonActionPerformed(evt);
            }
        });

        membersPanel.setLayout(new javax.swing.BoxLayout(membersPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(membersPanel);

        MembersLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MembersLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MembersLabel1.setText("Members");

        EditNameButton.setBackground(new java.awt.Color(51, 153, 255));
        EditNameButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditNameButton.setForeground(new java.awt.Color(255, 255, 255));
        EditNameButton.setText("Edit name");
        EditNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditNameButtonActionPerformed(evt);
            }
        });

        SaveName.setBackground(new java.awt.Color(51, 153, 255));
        SaveName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SaveName.setForeground(new java.awt.Color(255, 255, 255));
        SaveName.setText("Save");
        SaveName.setEnabled(false);
        SaveName.setFocusable(false);
        SaveName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveNameActionPerformed(evt);
            }
        });

        EditDescriptionButton.setBackground(new java.awt.Color(51, 153, 255));
        EditDescriptionButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditDescriptionButton.setForeground(new java.awt.Color(255, 255, 255));
        EditDescriptionButton.setText("Edit Description");
        EditDescriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditDescriptionButtonActionPerformed(evt);
            }
        });

        SaveDescriptionButton.setBackground(new java.awt.Color(51, 153, 255));
        SaveDescriptionButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SaveDescriptionButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveDescriptionButton.setText("Save");
        SaveDescriptionButton.setEnabled(false);
        SaveDescriptionButton.setFocusable(false);
        SaveDescriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveDescriptionButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(null);

        pendingMPanel.setLayout(new javax.swing.BoxLayout(pendingMPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane2.setViewportView(pendingMPanel);

        jLabel1.setBackground(null);
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pending Members");

        refresh.setBackground(new java.awt.Color(102, 153, 255));
        refresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(MembersLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(AdminsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AdminsScrollPane))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GroupPostsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(206, 206, 206))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CreatePostButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteGroupButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ManagePostsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(GroupDescriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(GroupName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EditNameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EditDescriptionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SaveDescriptionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SaveName, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(GroupPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MembersLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refresh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AdminsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AdminsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(GroupPostsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DeleteGroupButton)
                            .addComponent(GroupPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CreatePostButton)
                                .addComponent(SaveName)
                                .addComponent(EditNameButton))
                            .addComponent(GroupName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ManagePostsButton)
                            .addComponent(GroupDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditDescriptionButton)
                            .addComponent(SaveDescriptionButton))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteGroupButtonActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(
            null,                       
            "Do you want to delete group",                    
            "Delete Group",                      
            JOptionPane.YES_NO_OPTION,  
            JOptionPane.QUESTION_MESSAGE  
        );
        if (response == JOptionPane.YES_OPTION) {
            a.deleteGroup(gs.getId());
            this.dispose();
        }
        
    }//GEN-LAST:event_DeleteGroupButtonActionPerformed

    private void CreatePostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePostButtonActionPerformed
        // TODO add your handling code here:
          PostsAndStories.Result result = showCustomDialog();
            
            if(result.userText.equals("")){
                JOptionPane.showMessageDialog(null, "Text can't be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else {
                a.createGroupPost(gs.getId(), result.imagePath, result.userText);
               
            }
    }//GEN-LAST:event_CreatePostButtonActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        
        postPanel.removeAll();
        pendingMPanel.removeAll();
        membersPanel.removeAll();
        adminsPanel.removeAll();
        ArrayList<PostString>posts = a.getAllGroupPost(gs.getId());
        for(PostString p : posts){
            String text = p.getText();
            String postPhoto = p.getPhoto();
            String name = p.getAuthor();
            String date = p.getDate();
            if(postPhoto.equals("No file selected")){
                PostText pt = new PostText(text, name, date);
                postPanel.add(pt);
            }
            else{
                PostImage pi = new PostImage(text, postPhoto, name, date);
                postPanel.add(pi);
            }
        }
            postPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
            postPanel.revalidate();
            postPanel.repaint();
         ArrayList<UserSearch> members = a.getAllUsersOfGroup(gs.getId());
        for(UserSearch u : members){
            String name= u.getUsernameString();
            String userPhoto = u.getPhotoString();
            String relation = u.getRelationString();
            String id = u.getIdString();
            AdminMembersDisplay m = new AdminMembersDisplay(a, name, userPhoto, id, gs.getId());
            membersPanel.add(m);
        }
        membersPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
            membersPanel.revalidate();
            membersPanel.repaint();
               ArrayList<UserSearch> pendingMembers = a.getAllPendingRequestsOfGroup(gs.getId());
        for(UserSearch u : pendingMembers){
            String name= u.getUsernameString();
            String userPhoto = u.getPhotoString();
            String relation = u.getRelationString();
            String id = u.getIdString();
            PendingMembers pm = new PendingMembers(a, name, userPhoto, id, gs.getId());
            pendingMPanel.add(pm);
    }
        pendingMPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
            pendingMPanel.revalidate();
            pendingMPanel.repaint();
        ArrayList<UserSearch> admins = a.getAllAdminsOfGroup(gs.getId());
        for(UserSearch u : admins){
        String name= u.getUsernameString();
        String userPhoto = u.getPhotoString();
        String relation = u.getRelationString();
        String id = u.getIdString();
        Admin admin = new Admin(a, name, userPhoto, id, gs.getId());
        adminsPanel.add(admin);
    }
         adminsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
            adminsPanel.revalidate();
            adminsPanel.repaint();
    }//GEN-LAST:event_refreshActionPerformed

    private void EditNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditNameButtonActionPerformed
        // TODO add your handling code here:
        SaveName.setEnabled(true);
        GroupName.setFocusable(true);
        GroupName.setEditable(true);
    }//GEN-LAST:event_EditNameButtonActionPerformed

    private void SaveNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveNameActionPerformed
        // TODO add your handling code here:
        String name = GroupName.getText();
        GroupName.setFocusable(false);
        SaveName.setEnabled(false);
        a.changeGroupName(name, gs.getId());
    }//GEN-LAST:event_SaveNameActionPerformed

    private void EditDescriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditDescriptionButtonActionPerformed
        // TODO add your handling code here:
        SaveDescriptionButton.setEnabled(true);
        GroupDescriptionField.setFocusable(true);
        GroupDescriptionField.setEditable(true);
    }//GEN-LAST:event_EditDescriptionButtonActionPerformed

    private void SaveDescriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveDescriptionButtonActionPerformed
        // TODO add your handling code here:
        String description = GroupDescriptionField.getText();
        SaveDescriptionButton.setEnabled(false);
        GroupDescriptionField.setFocusable(false);
        a.changeGroupDescription(description, gs.getId());
    }//GEN-LAST:event_SaveDescriptionButtonActionPerformed

    private void ManagePostsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagePostsButtonActionPerformed
        // TODO add your handling code here:
        ManageGroupPosts m = new ManageGroupPosts(a, gs.getId());
        m.setVisible(true);
    }//GEN-LAST:event_ManagePostsButtonActionPerformed

    private void GroupNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GroupNameActionPerformed

    private void GroupDescriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupDescriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GroupDescriptionFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminsLabel;
    private javax.swing.JScrollPane AdminsScrollPane;
    private javax.swing.JButton CreatePostButton;
    private javax.swing.JButton DeleteGroupButton;
    private javax.swing.JButton EditDescriptionButton;
    private javax.swing.JButton EditNameButton;
    private javax.swing.JTextField GroupDescriptionField;
    private javax.swing.JTextField GroupName;
    private javax.swing.JLabel GroupPhoto;
    private javax.swing.JScrollPane GroupPostsPane;
    private javax.swing.JButton ManagePostsButton;
    private javax.swing.JLabel MembersLabel1;
    private javax.swing.JButton SaveDescriptionButton;
    private javax.swing.JButton SaveName;
    private javax.swing.JPanel adminsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel membersPanel;
    private javax.swing.JPanel pendingMPanel;
    private javax.swing.JPanel postPanel;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables
}
