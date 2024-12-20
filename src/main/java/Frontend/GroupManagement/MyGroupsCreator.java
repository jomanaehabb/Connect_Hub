/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend.GroupManagement;

import Backend.Manager;
import Backend.GroupString;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
        DeleteGroupButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        GroupPhotoLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GroupNameField1.setEditable(false);
        GroupNameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupNameField1ActionPerformed(evt);
            }
        });

        ViewGroupButton1.setBackground(new java.awt.Color(102, 153, 255));
        ViewGroupButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ViewGroupButton1.setForeground(new java.awt.Color(255, 255, 255));
        ViewGroupButton1.setText("View Group");
        ViewGroupButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewGroupButton1ActionPerformed(evt);
            }
        });

        DeleteGroupButton2.setBackground(new java.awt.Color(102, 153, 255));
        DeleteGroupButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteGroupButton2.setForeground(new java.awt.Color(255, 255, 255));
        DeleteGroupButton2.setText("Delete Group");
        DeleteGroupButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteGroupButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GroupPhotoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ViewGroupButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteGroupButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(GroupNameField1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(GroupNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewGroupButton1)
                    .addComponent(DeleteGroupButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(GroupPhotoLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GroupNameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupNameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GroupNameField1ActionPerformed

    private void ViewGroupButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewGroupButton1ActionPerformed
        // TODO add your handling code here:
         GroupString groupString = a.getCroupInfo(groupId);
         GroupForCreator ownerGroup = new GroupForCreator(a, groupString);
         ownerGroup.setVisible(true);
    }//GEN-LAST:event_ViewGroupButton1ActionPerformed

    private void DeleteGroupButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteGroupButton2ActionPerformed
        int response = JOptionPane.showConfirmDialog(
            null,                       
            "Do you want to delete group",                    
            "Delete Group",                      
            JOptionPane.YES_NO_OPTION,  
            JOptionPane.QUESTION_MESSAGE  
        );
        if (response == JOptionPane.YES_OPTION) {
            a.deleteGroup(groupId);
        }
    }//GEN-LAST:event_DeleteGroupButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteGroupButton2;
    private javax.swing.JTextField GroupNameField1;
    private javax.swing.JLabel GroupPhotoLabel1;
    private javax.swing.JButton ViewGroupButton1;
    // End of variables declaration//GEN-END:variables
}
