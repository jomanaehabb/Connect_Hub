/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend.GroupManagement;

import Backend.Manager;
import java.awt.Image;
import javax.swing.ImageIcon;


public class PendingMembers extends javax.swing.JPanel {

    /**
     * Creates new form PendingMembers
     */
    private Manager a;
    private String name;
    private String photo;
    private String userId;
    private String gpId ;
    public PendingMembers(Manager a, String name, String photo ,String userId, String gpId ) {
        initComponents();
        this.a = a;
        this.photo = photo;
        this.name = name;
        this.userId = userId;
        this.gpId = gpId;
        ImageIcon imageIcon = new ImageIcon(photo);
            Image image = imageIcon.getImage().getScaledInstance(
                90, 
                90, 
                Image.SCALE_SMOOTH
            );
            PendingMemberPhoto.setIcon(new ImageIcon(image));
            PendingMemberPhoto.setText("");
        PendingMemberPhoto.setText(name);
        PendingMemberName.setText(name);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PendingMemberPhoto = new javax.swing.JLabel();
        PendingMemberName = new javax.swing.JTextField();
        AcceptButton = new javax.swing.JButton();
        DeclineButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        PendingMemberPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PendingMemberName.setEditable(false);

        AcceptButton.setBackground(new java.awt.Color(102, 153, 255));
        AcceptButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AcceptButton.setForeground(new java.awt.Color(255, 255, 255));
        AcceptButton.setText("Accept");
        AcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptButtonActionPerformed(evt);
            }
        });

        DeclineButton2.setBackground(new java.awt.Color(102, 153, 255));
        DeclineButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeclineButton2.setForeground(new java.awt.Color(255, 255, 255));
        DeclineButton2.setText("Decline");
        DeclineButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeclineButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PendingMemberPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AcceptButton)
                        .addGap(18, 18, 18)
                        .addComponent(DeclineButton2))
                    .addComponent(PendingMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PendingMemberPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PendingMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AcceptButton)
                            .addComponent(DeclineButton2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptButtonActionPerformed
        // TODO add your handling code here:
        a.approveRequest(userId, gpId);
    }//GEN-LAST:event_AcceptButtonActionPerformed

    private void DeclineButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeclineButton2ActionPerformed
        // TODO add your handling code here:
        a.declineRequest(userId, gpId);
    }//GEN-LAST:event_DeclineButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptButton;
    private javax.swing.JButton DeclineButton2;
    private javax.swing.JTextField PendingMemberName;
    private javax.swing.JLabel PendingMemberPhoto;
    // End of variables declaration//GEN-END:variables
}