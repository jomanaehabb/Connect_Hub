/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend.Group;

import Backend.Manager;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author carls
 */
public class MyGroupsCreator extends javax.swing.JPanel {

    /**
     * Creates new form MyGroupsCreator
     */
    private Manager a;
    private String groupId;
    private String groupPhoto;
    private String groupName;
    public MyGroupsCreator(Manager a , String groupId , String groupPhoto , String groupName) {
        initComponents();
        this.a = a;
        this.groupName = groupName;
        this.groupId = groupId;
        this.groupPhoto = groupPhoto;
        GroupNameField1.setText(groupName);
        ImageIcon imageIcon = new ImageIcon(groupPhoto);
            Image image = imageIcon.getImage().getScaledInstance(
                90, 
                90, 
                Image.SCALE_SMOOTH
            );
            GroupPhotoLabel1.setIcon(new ImageIcon(image));
            GroupPhotoLabel1.setText("");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupPhotoLabel1 = new javax.swing.JLabel();
        GroupNameField1 = new javax.swing.JTextField();
        ViewGroupButton1 = new javax.swing.JButton();
        DeleteGroupButton = new javax.swing.JButton();

        GroupPhotoLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GroupNameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupNameField1ActionPerformed(evt);
            }
        });

        ViewGroupButton1.setBackground(new java.awt.Color(51, 153, 255));
        ViewGroupButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ViewGroupButton1.setForeground(new java.awt.Color(255, 255, 255));
        ViewGroupButton1.setText("View Group");
        ViewGroupButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewGroupButton1ActionPerformed(evt);
            }
        });

        DeleteGroupButton.setBackground(new java.awt.Color(51, 153, 255));
        DeleteGroupButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteGroupButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteGroupButton.setText("Delete Group");
        DeleteGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteGroupButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(GroupPhotoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ViewGroupButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteGroupButton))
                    .addComponent(GroupNameField1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GroupPhotoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(GroupNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ViewGroupButton1)
                            .addComponent(DeleteGroupButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GroupNameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupNameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GroupNameField1ActionPerformed

    private void ViewGroupButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewGroupButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewGroupButton1ActionPerformed

    private void DeleteGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteGroupButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteGroupButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteGroupButton;
    private javax.swing.JTextField GroupNameField1;
    private javax.swing.JLabel GroupPhotoLabel1;
    private javax.swing.JButton ViewGroupButton1;
    // End of variables declaration//GEN-END:variables
}
