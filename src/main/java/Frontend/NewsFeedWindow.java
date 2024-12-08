package Frontend;

import Backend.ContentDatabase;
import Backend.InternalContent;
import Backend.Post;
import Backend.ProfileManager;
import Backend.User;
import Backend.UserAccountManager;
import java.time.LocalDateTime;

public class NewsFeedWindow extends javax.swing.JFrame {

    private User currentUser;
    private UserAccountManager userManager;
    private ProfileManager profileManager;
    private ContentDatabase contentManager;

    public NewsFeedWindow(String email) {
        userManager = new UserAccountManager();
        profileManager = new ProfileManager();
        contentManager = new ContentDatabase();
        this.currentUser = userManager.getUserByEmail(email);
        initComponents();
        setTitle("NewsFeed");
                // Initialize homeLabel with user's name or email
        homeLabel.setText("Welcome, " + currentUser.getUsername()); // Assuming getName() is available in User

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        homeLabel = new javax.swing.JLabel();
        contentTabbedPane = new javax.swing.JTabbedPane();
        postsPanel = new javax.swing.JPanel();
        storiesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        refreshButton.setBackground(new java.awt.Color(102, 153, 255));
        refreshButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        refreshButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshButton.setText("Refresh");

        settingsButton.setBackground(new java.awt.Color(102, 153, 255));
        settingsButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        settingsButton.setForeground(new java.awt.Color(255, 255, 255));
        settingsButton.setText("Settings");
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        contentTabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout postsPanelLayout = new javax.swing.GroupLayout(postsPanel);
        postsPanel.setLayout(postsPanelLayout);
        postsPanelLayout.setHorizontalGroup(
            postsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );
        postsPanelLayout.setVerticalGroup(
            postsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        contentTabbedPane.addTab("Posts", postsPanel);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout storiesPanelLayout = new javax.swing.GroupLayout(storiesPanel);
        storiesPanel.setLayout(storiesPanelLayout);
        storiesPanelLayout.setHorizontalGroup(
            storiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, storiesPanelLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        storiesPanelLayout.setVerticalGroup(
            storiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(storiesPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        contentTabbedPane.addTab("Stories", storiesPanel);

        addButton.setBackground(new java.awt.Color(102, 153, 255));
        addButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Content");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton))
            .addComponent(contentTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(settingsButton)
                    .addComponent(homeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentTabbedPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        SettingsWindow settings = new SettingsWindow(currentUser.getEmail());
        settings.setVisible(true);
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        InternalContent internalContent = new InternalContent(null, null); // Placeholder for actual content
        LocalDateTime timeStamp = LocalDateTime.now();
        Post post = new Post(currentUser.getUserId(), internalContent, timeStamp);
        AddContentWindow addContentWindow = new AddContentWindow(currentUser, contentManager);
        addContentWindow.setVisible(true);
        addContentWindow.pack();
        addContentWindow.setLocationRelativeTo(null);
        this.dispose();  // Dispose the current window
    }//GEN-LAST:event_addButtonActionPerformed

    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewsFeedWindow().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTabbedPane contentTabbedPane;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel postsPanel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton settingsButton;
    private javax.swing.JPanel storiesPanel;
    // End of variables declaration//GEN-END:variables
}
