/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;
import Backend.Manager;

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

        DeleteGroupButton.setBackground(new java.awt.Color(51, 153, 255));
        DeleteGroupButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteGroupButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteGroupButton.setText("Delete Group");
        DeleteGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteGroupButtonActionPerformed(evt);
            }
        });

        CreatePostButton.setBackground(new java.awt.Color(51, 153, 255));
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

        ManagePostsButton.setBackground(new java.awt.Color(51, 153, 255));
        ManagePostsButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ManagePostsButton.setForeground(new java.awt.Color(255, 255, 255));
        ManagePostsButton.setText("Manage posts");

        MembersLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MembersLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MembersLabel1.setText("Members");

        EditNameButton.setBackground(new java.awt.Color(51, 153, 255));
        EditNameButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditNameButton.setForeground(new java.awt.Color(255, 255, 255));
        EditNameButton.setText("Edit name");

        SaveNameButton.setBackground(new java.awt.Color(51, 153, 255));
        SaveNameButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SaveNameButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveNameButton.setText("Save");
        SaveNameButton.setFocusable(false);

        EditDescriptionButton.setBackground(new java.awt.Color(51, 153, 255));
        EditDescriptionButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditDescriptionButton.setForeground(new java.awt.Color(255, 255, 255));
        EditDescriptionButton.setText("Edit Description");

        SaveDescriptionButton.setBackground(new java.awt.Color(51, 153, 255));
        SaveDescriptionButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SaveDescriptionButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveDescriptionButton.setText("Save");
        SaveDescriptionButton.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pending Members");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(GroupPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GroupNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(GroupDescriptionField))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EditNameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditDescriptionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SaveDescriptionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(SaveNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(162, 162, 162))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(MembersLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DeleteGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(CreatePostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ManagePostsButton))
                    .addComponent(GroupPostsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(AdminsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(AdminsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GroupNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GroupDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditDescriptionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveDescriptionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(GroupPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ManagePostsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DeleteGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CreatePostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AdminsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MembersLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(GroupPostsPane)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AdminsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteGroupButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteGroupButtonActionPerformed

    private void CreatePostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePostButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreatePostButtonActionPerformed

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
