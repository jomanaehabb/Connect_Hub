package Frontend;

import Backend.Content;
import Backend.ContentDatabase;
import Backend.Post;
import Backend.Story;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class NewsFeed extends javax.swing.JFrame {

    private String userId;
    private ContentDatabase content = new ContentDatabase();
    private ArrayList<Post> posts;
    private ArrayList<Story> stories;
    private static int postCounter = 0;
    private static int storyCounter = 0;

    public NewsFeed(String userId) {
        initComponents();
        setTitle("NewsFeed");
        homeLabel.setText("Welcome, " +userId);
        this.userId = userId;
        this.posts = content.userFriendPosts(userId);
        this.stories = content.userFriendStories(userId);
        this.showPost();
        this.showStory();
    }
    
    private void showPost() {
        try {
            postUserLabel.setText(((Content) posts.get(this.postCounter)).getAuthorID());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = ((Content) posts.get(this.postCounter)).getTimeStamp().format(formatter);
            postDateLabel.setText(formattedDateTime);
            postTextLabel.setText(((Content) posts.get(this.postCounter)).getContent().getText());
            if(((Content) posts.get(this.postCounter)).getContent().getImage() != null) {
                ImageIcon imageIcon = new ImageIcon(((Content) posts.get(this.postCounter)).getContent().getImage());
                postImageLabel.setIcon(imageIcon);
            }
            this.postCounter++;
        } catch (NullPointerException e) {
            
        } 
    }
    
    private void showStory() {
        try {
            storyUserLabel.setText(((Content) stories.get(this.storyCounter)).getAuthorID());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = ((Content) stories.get(this.storyCounter)).getTimeStamp().format(formatter);
            storyDateLabel.setText(formattedDateTime);
            storyTextLabel.setText(((Content) stories.get(this.storyCounter)).getContent().getText());
            if(((Content) stories.get(this.storyCounter)).getContent().getImage() != null) {
                ImageIcon imageIcon = new ImageIcon(((Content) stories.get(this.storyCounter)).getContent().getImage());
                storyImageLabel.setIcon(imageIcon);
            }
            this.storyCounter++;
        } catch (NullPointerException e) {
            
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
        storiesPanel = new javax.swing.JPanel();
        postsFramePanel1 = new javax.swing.JPanel();
        storyDateLabel = new javax.swing.JLabel();
        storyUserLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        storyTextLabel = new javax.swing.JLabel();
        storyImageLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        settingsButton.setText("Settings");
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        postsFramePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        postDateLabel.setText(" ");

        postUserLabel.setText(" ");

        jScrollPane1.setViewportView(postTextLabel);

        postImageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout postsFramePanelLayout = new javax.swing.GroupLayout(postsFramePanel);
        postsFramePanel.setLayout(postsFramePanelLayout);
        postsFramePanelLayout.setHorizontalGroup(
            postsFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postsFramePanelLayout.createSequentialGroup()
                .addGroup(postsFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(postsFramePanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(postUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(postsFramePanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(postsFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(postDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(postImageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        postsFramePanelLayout.setVerticalGroup(
            postsFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postsFramePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(postUserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout postsPanelLayout = new javax.swing.GroupLayout(postsPanel);
        postsPanel.setLayout(postsPanelLayout);
        postsPanelLayout.setHorizontalGroup(
            postsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, postsPanelLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(postsFramePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        postsPanelLayout.setVerticalGroup(
            postsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postsPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(postsFramePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        contentTabbedPane.addTab("Posts", postsPanel);

        postsFramePanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        storyDateLabel.setText(" ");

        storyUserLabel.setText(" ");

        jScrollPane2.setViewportView(storyTextLabel);

        storyImageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout postsFramePanel1Layout = new javax.swing.GroupLayout(postsFramePanel1);
        postsFramePanel1.setLayout(postsFramePanel1Layout);
        postsFramePanel1Layout.setHorizontalGroup(
            postsFramePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postsFramePanel1Layout.createSequentialGroup()
                .addGroup(postsFramePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(postsFramePanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(storyUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(postsFramePanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(postsFramePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addComponent(storyDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(storyImageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        postsFramePanel1Layout.setVerticalGroup(
            postsFramePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postsFramePanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(storyUserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storyDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(storyImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout storiesPanelLayout = new javax.swing.GroupLayout(storiesPanel);
        storiesPanel.setLayout(storiesPanelLayout);
        storiesPanelLayout.setHorizontalGroup(
            storiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, storiesPanelLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(postsFramePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        storiesPanelLayout.setVerticalGroup(
            storiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(storiesPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(postsFramePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        contentTabbedPane.addTab("Stories", storiesPanel);

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
        Settings settings = new Settings();
        settings.setVisible(true);
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        //send user in the constructor here
        AddContent addContent = new AddContent("1");
        addContent.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        try {
            if(contentTabbedPane.getSelectedIndex() == 0) {
                if(postCounter < posts.size())
                    this.showPost();
                else 
                    JOptionPane.showMessageDialog(null, "There are no new posts, try again later!");
            }
            else if(contentTabbedPane.getSelectedIndex() == 1) {
                if(storyCounter < stories.size())
                    this.showStory();
                else 
                    JOptionPane.showMessageDialog(null, "There are no new stories, try again later!");
            } 
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "hello world!");
        }
    }//GEN-LAST:event_refreshButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewsFeed("1").setVisible(true);
            }
        });
    }
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
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton settingsButton;
    private javax.swing.JPanel storiesPanel;
    private javax.swing.JLabel storyDateLabel;
    private javax.swing.JLabel storyImageLabel;
    private javax.swing.JLabel storyTextLabel;
    private javax.swing.JLabel storyUserLabel;
    // End of variables declaration//GEN-END:variables
}
