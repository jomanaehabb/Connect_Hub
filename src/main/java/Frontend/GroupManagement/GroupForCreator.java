/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend.GroupManagement;
import Backend.Manager;
import Backend.GroupString;

/**
 *
 * @author carls
 */
public class GroupForCreator extends javax.swing.JFrame {

    /**
     * Creates new form GroupForCreator
     */
    private Manager a ;
    public GroupForCreator() {
        initComponents();
        
    }

    GroupForCreator(Manager a, GroupString groupString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupPhotoLabel = new javax.swing.JLabel();
        GroupNameField = new javax.swing.JTextField();
        GroupDescriptionField = new javax.swing.JTextField();
        DeleteGroupButton = new javax.swing.JButton();
        CreatePostButton = new javax.swing.JButton();
        GroupPostsPane = new javax.swing.JScrollPane();
        AdminsScrollPane = new javax.swing.JScrollPane();
        AdminsLabel = new javax.swing.JLabel();
        ManagePostsButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MembersLabel1 = new javax.swing.JLabel();
        EditNameButton = new javax.swing.JButton();
        SaveNameButton = new javax.swing.JButton();
        EditDescriptionButton = new javax.swing.JButton();
        SaveDescriptionButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GroupNameField.setEditable(false);

        GroupDescriptionField.setEditable(false);

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

        MembersLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MembersLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MembersLabel1.setText("Members");

        EditNameButton.setBackground(new java.awt.Color(102, 153, 255));
        EditNameButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditNameButton.setForeground(new java.awt.Color(255, 255, 255));
        EditNameButton.setText("Edit name");
        EditNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditNameButtonActionPerformed(evt);
            }
        });

        SaveNameButton.setBackground(new java.awt.Color(102, 153, 255));
        SaveNameButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SaveNameButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveNameButton.setText("Save");
        SaveNameButton.setFocusable(false);
        SaveNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveNameButtonActionPerformed(evt);
            }
        });

        EditDescriptionButton.setBackground(new java.awt.Color(102, 153, 255));
        EditDescriptionButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditDescriptionButton.setForeground(new java.awt.Color(255, 255, 255));
        EditDescriptionButton.setText("Edit Description");
        EditDescriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditDescriptionButtonActionPerformed(evt);
            }
        });

        SaveDescriptionButton.setBackground(new java.awt.Color(102, 153, 255));
        SaveDescriptionButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SaveDescriptionButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveDescriptionButton.setText("Save");
        SaveDescriptionButton.setFocusable(false);
        SaveDescriptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveDescriptionButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pending Members");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(GroupPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(AdminsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(MembersLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane2)
                                    .addComponent(AdminsScrollPane, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DeleteGroupButton)
                            .addComponent(CreatePostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ManagePostsButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(GroupNameField)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(EditNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SaveNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(GroupDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(EditDescriptionButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SaveDescriptionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(GroupPostsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(GroupPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(MembersLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaveNameButton)
                            .addComponent(EditNameButton)
                            .addComponent(GroupNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GroupDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditDescriptionButton)
                            .addComponent(SaveDescriptionButton))
                        .addGap(12, 12, 12)
                        .addComponent(ManagePostsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreatePostButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteGroupButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdminsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdminsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(GroupPostsPane))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteGroupButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_DeleteGroupButtonActionPerformed

    private void CreatePostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePostButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreatePostButtonActionPerformed

    private void EditNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditNameButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditNameButtonActionPerformed

    private void EditDescriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditDescriptionButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditDescriptionButtonActionPerformed

    private void ManagePostsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagePostsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManagePostsButtonActionPerformed

    private void SaveNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveNameButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveNameButtonActionPerformed

    private void SaveDescriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveDescriptionButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveDescriptionButtonActionPerformed

    /*
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GroupForCreator().setVisible(true);
            }
        });
    }
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminsLabel;
    private javax.swing.JScrollPane AdminsScrollPane;
    private javax.swing.JButton CreatePostButton;
    private javax.swing.JButton DeleteGroupButton;
    private javax.swing.JButton EditDescriptionButton;
    private javax.swing.JButton EditNameButton;
    private javax.swing.JTextField GroupDescriptionField;
    private javax.swing.JTextField GroupNameField;
    private javax.swing.JLabel GroupPhotoLabel;
    private javax.swing.JScrollPane GroupPostsPane;
    private javax.swing.JButton ManagePostsButton;
    private javax.swing.JLabel MembersLabel1;
    private javax.swing.JButton SaveDescriptionButton;
    private javax.swing.JButton SaveNameButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
