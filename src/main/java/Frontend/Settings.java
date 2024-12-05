package Frontend;

public class Settings extends javax.swing.JFrame {

    public Settings() {
        initComponents();
        setTitle("Settings");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileButton = new javax.swing.JButton();
        friendsButton = new javax.swing.JButton();
        friendsSuggestionsButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        addFriendButton = new javax.swing.JButton();
        blockFriendButton = new javax.swing.JButton();
        friendRequestsButton = new javax.swing.JButton();
        removeFriendButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        profileButton.setText("Profile");

        friendsButton.setText("Friends");
        friendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsButtonActionPerformed(evt);
            }
        });

        friendsSuggestionsButton.setText("Friends Suggestions");
        friendsSuggestionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsSuggestionsButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        addFriendButton.setText("Add Friend");
        addFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendButtonActionPerformed(evt);
            }
        });

        blockFriendButton.setText("Block Friend");
        blockFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockFriendButtonActionPerformed(evt);
            }
        });

        friendRequestsButton.setText("Friend Requests");
        friendRequestsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendRequestsButtonActionPerformed(evt);
            }
        });

        removeFriendButton.setText("Remove Friend");
        removeFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFriendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(removeFriendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addFriendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(blockFriendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friendRequestsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friendsSuggestionsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friendsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(friendsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(friendsSuggestionsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(friendRequestsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addFriendButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeFriendButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blockFriendButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void friendsSuggestionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsSuggestionsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friendsSuggestionsButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed

    }//GEN-LAST:event_logoutButtonActionPerformed

    private void addFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendButtonActionPerformed
        AddFriend addFriend = new AddFriend();
        addFriend.setVisible(true);
    }//GEN-LAST:event_addFriendButtonActionPerformed

    private void blockFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockFriendButtonActionPerformed
        BlockFriend blockFriend = new BlockFriend();
        blockFriend.setVisible(true);
    }//GEN-LAST:event_blockFriendButtonActionPerformed

    private void friendRequestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendRequestsButtonActionPerformed
        FriendRequests friendRequests = new FriendRequests();
        friendRequests.setVisible(true);
    }//GEN-LAST:event_friendRequestsButtonActionPerformed

    private void friendsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsButtonActionPerformed
        FriendsList friends = new FriendsList();
        friends.setVisible(true);
    }//GEN-LAST:event_friendsButtonActionPerformed

    private void removeFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFriendButtonActionPerformed
        RemoveFriend removeFriend = new RemoveFriend();
        removeFriend.setVisible(true);
    }//GEN-LAST:event_removeFriendButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFriendButton;
    private javax.swing.JButton blockFriendButton;
    private javax.swing.JButton friendRequestsButton;
    private javax.swing.JButton friendsButton;
    private javax.swing.JButton friendsSuggestionsButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton removeFriendButton;
    // End of variables declaration//GEN-END:variables
}
