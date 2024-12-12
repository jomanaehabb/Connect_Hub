/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;

/**
 *
 * @author carls
 */
public class Admins extends javax.swing.JPanel {

    /**
     * Creates new form Admins
     */
    public Admins() {
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

        AdminPhotoLabel = new javax.swing.JLabel();
        AdminNameField1 = new javax.swing.JTextField();
        RemoveAdminButton = new javax.swing.JButton();
        DemoteButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        AdminPhotoLabel.setBackground(new java.awt.Color(255, 255, 255));

        AdminNameField1.setEditable(false);
        AdminNameField1.setBackground(new java.awt.Color(255, 255, 255));

        RemoveAdminButton.setBackground(new java.awt.Color(102, 153, 255));
        RemoveAdminButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RemoveAdminButton.setForeground(new java.awt.Color(255, 255, 255));
        RemoveAdminButton.setText("Remove");

        DemoteButton.setBackground(new java.awt.Color(102, 153, 255));
        DemoteButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DemoteButton.setForeground(new java.awt.Color(255, 255, 255));
        DemoteButton.setText("Demote");
        DemoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DemoteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(AdminPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdminNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RemoveAdminButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DemoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AdminPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(AdminNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RemoveAdminButton)
                            .addComponent(DemoteButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DemoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DemoteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DemoteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdminNameField1;
    private javax.swing.JLabel AdminPhotoLabel;
    private javax.swing.JButton DemoteButton;
    private javax.swing.JButton RemoveAdminButton;
    // End of variables declaration//GEN-END:variables
}
