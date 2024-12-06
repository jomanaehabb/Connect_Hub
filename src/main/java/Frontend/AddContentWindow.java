package Frontend;

import Backend.ContentDatabase;
import javax.swing.JOptionPane;
import Backend.Content;
import Backend.InternalContent;
import Backend.ProfileManager;
import Backend.User;
import Backend.UserAccountManager;

public class AddContentWindow extends javax.swing.JFrame {

    private User currentUser;
    private Content post;
    private String textInput;
    private ContentDatabase contentDatabase;
    private UserAccountManager userManager = new UserAccountManager();
    private ProfileManager profileManager;
    
    public AddContentWindow(User currentUser, ContentDatabase contentDatabase) {
        initComponents();
        setTitle("Add Content");
        this.contentDatabase = contentDatabase;
        this.currentUser = userManager.getUserByEmail(currentUser.getEmail());
    }

private void addPost(String textInput) {
        InternalContent content = new InternalContent(textInput, null); // Assuming no image for now
        String userID = currentUser.getUserId(); // You should replace this with the actual user ID
        contentDatabase.createPost(userID, content.getText(), content.getImagePath()); // Add Post to the database
        System.out.println("Post added: " + content.getText());
    }

    private void addStory(String textInput) {
        InternalContent content = new InternalContent(textInput, null); // Assuming no image for now
        String userID = "currentUserID"; // You should replace this with the actual user ID
        contentDatabase.createStory(userID, content.getText(), content.getImagePath()); // Add Story to the database
        System.out.println("Story added: " + content.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addPost = new javax.swing.JButton();
        addStory = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Write what's on your mind! :3");

        addPost.setBackground(new java.awt.Color(102, 153, 255));
        addPost.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addPost.setForeground(new java.awt.Color(255, 255, 255));
        addPost.setText("Add as Post");
        addPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPostActionPerformed(evt);
            }
        });

        addStory.setBackground(new java.awt.Color(102, 153, 255));
        addStory.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addStory.setForeground(new java.awt.Color(255, 255, 255));
        addStory.setText("Add as Story");
        addStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStoryActionPerformed(evt);
            }
        });

        textArea.setColumns(5);
        textArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textArea.setRows(10);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(addPost, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addStory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPost)
                    .addComponent(addStory))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPostActionPerformed
        textInput = textArea.getText();
        if(!textInput.isEmpty()) {
            this.addPost(textInput); // Call addPost for adding a post
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed to create post");
        }
    }//GEN-LAST:event_addPostActionPerformed

    private void addStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStoryActionPerformed
        // TODO add your handling code here:
        textInput = textArea.getText();
        if(!textInput.isEmpty()) {
            this.addStory(textInput); // Call addStory for adding a story
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed to create story");
        }
    }//GEN-LAST:event_addStoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPost;
    private javax.swing.JButton addStory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
