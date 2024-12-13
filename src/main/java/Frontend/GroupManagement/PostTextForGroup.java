/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend.GroupManagement;

import Backend.Manager;

/**
 *
 * @author DELL-G3
 */
public class PostTextForGroup extends javax.swing.JPanel {

    /**
     * Creates new form GroupPostText
     */
    Manager a;
    String name;
   
    
    String postId;
    String gpId;
    public PostTextForGroup(Manager a, String name, String date, String text, String postId, String gpId) {
        initComponents();
        this.a = a;
        this.gpId = gpId;
        this.postId = postId;
        UserName.setText(name);
        DateField.setText(date);
        textArea.setText(text);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserName = new javax.swing.JTextField();
        DateField = new javax.swing.JTextField();
        textArea = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        AcceptButton1 = new javax.swing.JButton();
        DeclineButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        UserName.setEditable(false);
        UserName.setFocusable(false);

        DateField.setEditable(false);
        DateField.setFocusable(false);

        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAreaActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DeclineButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AcceptButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AcceptButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeclineButton2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AcceptButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptButton1ActionPerformed
        // TODO add your handling code here:
        a.approvePostRequest(postId, gpId);
    }//GEN-LAST:event_AcceptButton1ActionPerformed

    private void DeclineButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeclineButton2ActionPerformed
        // TODO add your handling code here:
        a.declinePostRequest(postId, gpId);
    }//GEN-LAST:event_DeclineButton2ActionPerformed

    private void textAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAreaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptButton1;
    private javax.swing.JTextField DateField;
    private javax.swing.JButton DeclineButton2;
    private javax.swing.JTextField UserName;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textArea;
    // End of variables declaration//GEN-END:variables
}
