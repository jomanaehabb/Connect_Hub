/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend.Group;

/**
 *
 * @author carls
 */
public class MembersForCreator extends javax.swing.JPanel {

    /**
     * Creates new form Members
     */
    public MembersForCreator() {
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

        MemberPhotoLabel1 = new javax.swing.JLabel();
        MemberNameField = new javax.swing.JTextField();
        RemoveMemberButton = new javax.swing.JButton();
        MakeAdminButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        MemberNameField.setEditable(false);

        RemoveMemberButton.setBackground(new java.awt.Color(51, 153, 255));
        RemoveMemberButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RemoveMemberButton.setForeground(new java.awt.Color(255, 255, 255));
        RemoveMemberButton.setText("Remove");

        MakeAdminButton1.setBackground(new java.awt.Color(51, 153, 255));
        MakeAdminButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MakeAdminButton1.setForeground(new java.awt.Color(255, 255, 255));
        MakeAdminButton1.setText("Make admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MemberPhotoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RemoveMemberButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MakeAdminButton1))
                    .addComponent(MemberNameField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(MemberPhotoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(MemberNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RemoveMemberButton)
                            .addComponent(MakeAdminButton1))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MakeAdminButton1;
    private javax.swing.JTextField MemberNameField;
    private javax.swing.JLabel MemberPhotoLabel1;
    private javax.swing.JButton RemoveMemberButton;
    // End of variables declaration//GEN-END:variables
}
