/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend.GroupManagement;

import Backend.Manager;

/**
 *
 * @author carls
 */
public class PostText extends javax.swing.JPanel {

    /**
     * Creates new form AcceptedPostText
     */
    private Manager a;
    private String postId;
    private String GroupId;
    public PostText(String text,String name, String date,Manager a,String postId,String GroupId) {
        initComponents();
        this.a = a;
        textArea.setText(text);
        Name.setText(name);
        this.date.setText(date);
        this.postId = postId;
        this.GroupId = GroupId;
    }

    PostText(String text, String name, String date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    PostText(String photo, String text, String name, String date, Manager a, String postId, String id) {
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

        Name = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        textArea = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        EditButton1 = new javax.swing.JButton();
        EditButton2 = new javax.swing.JButton();
        save = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        Name.setEnabled(false);

        date.setEnabled(false);

        textArea.setFocusable(false);
        textArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAreaActionPerformed(evt);
            }
        });

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        EditButton1.setBackground(new java.awt.Color(102, 153, 255));
        EditButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditButton1.setForeground(new java.awt.Color(255, 255, 255));
        EditButton1.setText("Edit");
        EditButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButton1ActionPerformed(evt);
            }
        });

        EditButton2.setBackground(new java.awt.Color(102, 153, 255));
        EditButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditButton2.setForeground(new java.awt.Color(255, 255, 255));
        EditButton2.setText("Remove");
        EditButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButton2ActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.setEnabled(false);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textArea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(save)
                            .addComponent(EditButton1)
                            .addComponent(EditButton2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(EditButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EditButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButton1ActionPerformed
        // TODO add your handling code here:
        textArea.setFocusable(true);
        save.setEnabled(true);
        
    }//GEN-LAST:event_EditButton1ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        a.editPost(postId, GroupId, textArea.getText(), "No file selected");
        save.setEnabled(false);
        textArea.setFocusable(false);
    }//GEN-LAST:event_saveActionPerformed

    private void EditButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButton2ActionPerformed
        // TODO add your handling code here:
        a.deletePost(postId, GroupId);
    }//GEN-LAST:event_EditButton2ActionPerformed

    private void textAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAreaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditButton1;
    private javax.swing.JButton EditButton2;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField date;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton save;
    private javax.swing.JTextField textArea;
    // End of variables declaration//GEN-END:variables
}
