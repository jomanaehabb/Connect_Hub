package Frontend;

import Backend.Story;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Backend.Content;
import Backend.ContentDatabase;
import Backend.Post;
import Backend.User;
import Backend.UserAccountManager;
import Backend.UserDatabase;

public class NewsFeedWindow extends javax.swing.JFrame {

    private UserAccountManager userManager;
    private ContentDatabase contentManager;
    private UserDatabase userDatabase;
    private User currentUser;
    private ArrayList<Post> posts;
    private ArrayList<Story> stories;
    private static int postCounter = 0;
    private static int storyCounter = 0;

    public NewsFeedWindow(String email) {
        setTitle("NewsFeed");
        initComponents();
        this.userManager = UserAccountManager.getInstance();
        this.currentUser = userManager.getUserByEmail(email);  // Retrieve the current user by email
        this.contentManager = ContentDatabase.getInstance();
        this.userDatabase = UserDatabase.getInstance();

        if (currentUser == null) {
            // Handle case where user is not found
            JOptionPane.showMessageDialog(null, "User not found");
            this.dispose();  // Close the window if the user is not found
            return;
        }

        homeLabel.setText("Welcome, " + currentUser.getUsername());
        this.posts = contentManager.allPosts();  // Retrieve posts for this user
        this.stories = contentManager.allStories();  // Retrieve stories for this user
        this.showPost();
        this.showStory();
    }

    private void showPost() {
        try {
            if(posts!=null && postCounter<posts.size()){
                ImageIcon image = new ImageIcon(userDatabase.getUserByID(posts.get(this.postCounter).getAuthorID()).getProfilePhotoPath());
                profilePhotoLabel1.setIcon(image);
                postUserLabel.setText(userDatabase.getUserByID(posts.get(this.postCounter).getAuthorID()).getUsername());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = posts.get(this.postCounter).getTimeStamp().format(formatter);
                postDateLabel.setText(formattedDateTime);
                postTextLabel.setText(posts.get(this.postCounter).getContent().getText());
                if (posts.get(this.postCounter).getContent().getImage() != null) {
                    ImageIcon imageIcon = new ImageIcon(posts.get(this.postCounter).getContent().getImage());
                    postImageLabel.setIcon(imageIcon);
                }
                this.postCounter++;
            }
        } catch (NullPointerException | IndexOutOfBoundsException e) {

        }
    }

    private void showStory() {
        try {
            if(stories!=null){
                ImageIcon image = new ImageIcon(userDatabase.getUserByID(posts.get(this.postCounter).getAuthorID()).getProfilePhotoPath());
                profilePhotoLabel2.setIcon(image);
                 storyUserLabel.setText(userDatabase.getUserByID(stories.get(this.storyCounter).getAuthorID()).getUsername());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = stories.get(this.storyCounter).getTimeStamp().format(formatter);
                storyDateLabel.setText(formattedDateTime);
                storyTextLabel.setText(stories.get(this.storyCounter).getContent().getText());
                if (stories.get(this.storyCounter).getContent().getImage() != null) {
                    ImageIcon imageIcon = new ImageIcon(((Content) stories.get(this.storyCounter)).getContent().getImage());
                    storyImageLabel.setIcon(imageIcon);
                }
                this.storyCounter++;
            }
        } catch (NullPointerException | IndexOutOfBoundsException e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        homeLabel = new javax.swing.JLabel();
        contentTabbedPane = new javax.swing.JTabbedPane();
        postsPanel = new javax.swing.JPanel();
        postsFramePanel = new javax.swing.JPanel();
        postDateLabel = new javax.swing.JLabel();
        postUserLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        postTextLabel = new javax.swing.JLabel();
        postImageLabel = new javax.swing.JLabel();
        profilePhotoLabel1 = new javax.swing.JLabel();
        storiesPanel = new javax.swing.JPanel();
        postsFramePanel1 = new javax.swing.JPanel();
        storyDateLabel = new javax.swing.JLabel();
        storyUserLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        storyTextLabel = new javax.swing.JLabel();
        storyImageLabel = new javax.swing.JLabel();
        profilePhotoLabel2 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        refreshButton.setBackground(new java.awt.Color(102, 153, 255));
        refreshButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        refreshButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshButton.setText("Refresh");
        refreshButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        settingsButton.setBackground(new java.awt.Color(102, 153, 255));
        settingsButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        settingsButton.setForeground(new java.awt.Color(255, 255, 255));
        settingsButton.setText("Settings");
        settingsButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        homeLabel.setBackground(new java.awt.Color(255, 255, 255));

        contentTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        contentTabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        postsPanel.setBackground(new java.awt.Color(255, 255, 255));

        postsFramePanel.setBackground(new java.awt.Color(255, 255, 255));
        postsFramePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        postDateLabel.setText(" ");

        postUserLabel.setText(" ");

        postTextLabel.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(postTextLabel);

        postImageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        profilePhotoLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout postsFramePanelLayout = new javax.swing.GroupLayout(postsFramePanel);
        postsFramePanel.setLayout(postsFramePanelLayout);
        postsFramePanelLayout.setHorizontalGroup(
            postsFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postsFramePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilePhotoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(postsFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(postImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addComponent(postUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        postsFramePanelLayout.setVerticalGroup(
            postsFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postsFramePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(postsFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(postsFramePanelLayout.createSequentialGroup()
                        .addComponent(postUserLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(postDateLabel))
                    .addComponent(profilePhotoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(postImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout postsPanelLayout = new javax.swing.GroupLayout(postsPanel);
        postsPanel.setLayout(postsPanelLayout);
        postsPanelLayout.setHorizontalGroup(
            postsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, postsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(postsFramePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        postsPanelLayout.setVerticalGroup(
            postsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postsPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(postsFramePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        contentTabbedPane.addTab("Posts", postsPanel);

        storiesPanel.setBackground(new java.awt.Color(255, 255, 255));

        postsFramePanel1.setBackground(new java.awt.Color(255, 255, 255));
        postsFramePanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        storyDateLabel.setText(" ");

        storyUserLabel.setText(" ");

        jScrollPane2.setViewportView(storyTextLabel);

        storyImageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        profilePhotoLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout postsFramePanel1Layout = new javax.swing.GroupLayout(postsFramePanel1);
        postsFramePanel1.setLayout(postsFramePanel1Layout);
        postsFramePanel1Layout.setHorizontalGroup(
            postsFramePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postsFramePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilePhotoLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(postsFramePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(storyDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storyUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2)
                    .addComponent(storyImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        postsFramePanel1Layout.setVerticalGroup(
            postsFramePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postsFramePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(postsFramePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(postsFramePanel1Layout.createSequentialGroup()
                        .addComponent(storyUserLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(storyDateLabel))
                    .addComponent(profilePhotoLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(storyImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout storiesPanelLayout = new javax.swing.GroupLayout(storiesPanel);
        storiesPanel.setLayout(storiesPanelLayout);
        storiesPanelLayout.setHorizontalGroup(
            storiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(storiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(postsFramePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        storiesPanelLayout.setVerticalGroup(
            storiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(storiesPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(postsFramePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        contentTabbedPane.addTab("Stories", storiesPanel);

        addButton.setBackground(new java.awt.Color(102, 153, 255));
        addButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Content");
        addButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        SettingsWindow settings = new SettingsWindow(currentUser.getEmail());  // Use the instance variable email
        settings.setVisible(true);
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        //send user in the constructor here
        AddContentWindow addContent = new AddContentWindow(currentUser);
        addContent.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        try {
            if (contentTabbedPane.getSelectedIndex() == 0) {
                if (postCounter < posts.size()) {
                    this.showPost();
                } else {
                    JOptionPane.showMessageDialog(null, "There are no new posts, try again later!");
                }
            } else if (contentTabbedPane.getSelectedIndex() == 1) {
                if (storyCounter < stories.size()) {
                    this.showStory();
                } else {
                    JOptionPane.showMessageDialog(null, "There are no new stories, try again later!");
                }
            }
        } catch (NullPointerException e) {
        }
    }//GEN-LAST:event_refreshButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTabbedPane contentTabbedPane;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel postDateLabel;
    private javax.swing.JLabel postImageLabel;
    private javax.swing.JLabel postTextLabel;
    private javax.swing.JLabel postUserLabel;
    private javax.swing.JPanel postsFramePanel;
    private javax.swing.JPanel postsFramePanel1;
    private javax.swing.JPanel postsPanel;
    private javax.swing.JLabel profilePhotoLabel1;
    private javax.swing.JLabel profilePhotoLabel2;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton settingsButton;
    private javax.swing.JPanel storiesPanel;
    private javax.swing.JLabel storyDateLabel;
    private javax.swing.JLabel storyImageLabel;
    private javax.swing.JLabel storyTextLabel;
    private javax.swing.JLabel storyUserLabel;
    // End of variables declaration//GEN-END:variables
}
