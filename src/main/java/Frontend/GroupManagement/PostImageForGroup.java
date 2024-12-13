/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend.GroupManagement;

import Backend.Manager;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL-G3
 */
public class PostImageForGroup extends javax.swing.JPanel {

    /**
     * Creates new form GroupPostImage
     */
    Manager a;
    String name;
    String photo;
    String date;
    String text;
    String postId;
    String gpId;
    public PostImageForGroup(Manager a, String name, String photo, String date, String text, String postId, String gpId) {
        initComponents();
        this.a = a;
        this.name = name;
        this.date = date;
        this.photo = photo;
        textArea.setText(text);
        ImageIcon imageIcon = new ImageIcon(photo);
            Image image = imageIcon.getImage().getScaledInstance(
                276, 
                274, 
                Image.SCALE_SMOOTH
            );
            postPhoto.setIcon(new ImageIcon(image));
            postPhoto.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserNameField = new javax.swing.JTextField();
        DateField = new javax.swing.JTextField();
        textArea = new javax.swing.JTextField();
        postPhoto = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        AcceptButton1 = new javax.swing.JButton();
        DeclineButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        UserNameField.setEditable(false);

        DateField.setEditable(false);

        textArea.setEditable(false);

        postPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        AcceptButton1.setBackground(new java.awt.Color(102, 153, 255));
        AcceptButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AcceptButton1.setForeground(new java.awt.Color(255, 255, 255));
        AcceptButton1.setText("Accept");
        AcceptButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptButton1ActionPerformed(evt);
            }
        });

        DeclineButton2.setBackground(new java.awt.Color(102, 153, 255));
        DeclineButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeclineButton2.setForeground(new java.awt.Color(255, 255, 255));
        DeclineButton2.setText("Decline");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(postPhoto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DeclineButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AcceptButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(UserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AcceptButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeclineButton2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AcceptButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptButton1ActionPerformed
        // TODO add your handling code here:
        a.approvePostRequest(postId, gpId);
    }//GEN-LAST:event_AcceptButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptButton1;
    private javax.swing.JTextField DateField;
    private javax.swing.JButton DeclineButton2;
    private javax.swing.JTextField UserNameField;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel postPhoto;
    private javax.swing.JTextField textArea;
    // End of variables declaration//GEN-END:variables
}