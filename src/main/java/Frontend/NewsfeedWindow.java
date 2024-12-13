/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.Manager;
import Backend.FriendManagement.PostString;
import Backend.GroupString;
import Backend.Notification;
import Backend.Online;
import Backend.User;
import Frontend.Group.MyGroups;
import Frontend.Group.MyGroupsCreator;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carls
 */
public class NewsfeedWindow extends javax.swing.JFrame {

    /**
     * Creates new form NewsfeedWindow
     */
    private Manager a ;
    public NewsfeedWindow(Manager a) {
        initComponents();
        this.a = a;
         postPanel.setLayout(new javax.swing.BoxLayout(postPanel, javax.swing.BoxLayout.Y_AXIS));
         ImageIcon imageIcon = new ImageIcon(a.getProfilePhoto());
            Image image = imageIcon.getImage().getScaledInstance(
                223, 
                85, 
                Image.SCALE_SMOOTH
            );
            photoLabel.setIcon(new ImageIcon(image));
            photoLabel.setText("");
            ArrayList<Online> o = a.getOnline();
            DefaultTableModel model = (DefaultTableModel) status.getModel();
            model.setRowCount(0);
        for(Online on : o){
            //DefaultTableModel model = new DefaultTableModel();
            
            String user  = on.getUser();
            String status;
            if(on.getStatus()){
                status = "online";
            }
            else{
                status = "offline";
            }
            model.addRow(new Object[]{user, status});    
           
        }
        ArrayList<PostString> postString = a.getPosts();
        for(PostString p : postString){
            String date = p.getDate();
            String photo = p.getPhoto();
            String name = p.getAuthor();
            String text = p.getText();
            if(photo.equals("No file selected")){
                PostText pt = new PostText(text, name, date);
                postPanel.add(pt);
            }
            else{
                PostImage pi = new PostImage(text, photo, name, date);
                postPanel.add(pi);
            }
            postPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
            postPanel.revalidate();
            postPanel.repaint(); 
        }
        ArrayList<PostString> storyString = a.getStories();
        for(PostString s : storyString){
            String date = s.getDate();
            String photo = s.getPhoto();
            String name = s.getAuthor();
            String text = s.getText();
            if(photo.equals("No file selected")){
                PostText pt = new PostText(text, name, date);
                storyPanel.add(pt);
            }
            else{
                StoryImage si = new StoryImage(text, text, date, name);
                storyPanel.add(si);
            }
            storyPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
            storyPanel.revalidate();
            storyPanel.repaint(); 
        }
        ArrayList<GroupString> groupString = a.getMyGroups();
        for(GroupString g : groupString){
            if(g.getRule().equalsIgnoreCase("owner")){
                System.out.println("carl");
                String groupPhoto = g.getPhoto();
                String groupName = g.getName();
                String groupID = g.getId();
                MyGroupsCreator myGroup = new MyGroupsCreator(a,groupID,groupPhoto,groupName);
                GroupPanel1.add(myGroup);
            }
            else{
                System.out.println("mina");
                String groupPhoto = g.getPhoto();
                String groupName = g.getName();
                String groupID = g.getId();
                MyGroups myGroup = new MyGroups(a,groupID,groupPhoto,groupName);
                GroupPanel1.add(myGroup);
            }
        }
        GroupPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GroupPanel1.revalidate();
        GroupPanel1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        storyPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        postPanel = new javax.swing.JPanel();
        photoLabel = new javax.swing.JLabel();
        RefreshButton = new javax.swing.JButton();
        profileMangmentButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        status = new javax.swing.JTable();
        friendManagement_btn = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        SearchUserBtn = new javax.swing.JButton();
        MyGroupsLabel = new javax.swing.JLabel();
        MyGroupsPane = new javax.swing.JScrollPane();
        GroupPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        GroupSuggestPane = new javax.swing.JScrollPane();
        NotificitionButton = new javax.swing.JButton();
        SearchGroupButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setViewportBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        storyPanel.setLayout(new javax.swing.BoxLayout(storyPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane3.setViewportView(storyPanel);

        jScrollPane4.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jScrollPane4ComponentAdded(evt);
            }
        });
        jScrollPane4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jScrollPane4FocusGained(evt);
            }
        });

        postPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        postPanel.setAutoscrolls(true);
        postPanel.setLayout(new javax.swing.BoxLayout(postPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane4.setViewportView(postPanel);

        photoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        photoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photoLabel.setText("photo");

        RefreshButton.setBackground(new java.awt.Color(0, 153, 255));
        RefreshButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RefreshButton.setForeground(new java.awt.Color(255, 255, 255));
        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        profileMangmentButton.setBackground(new java.awt.Color(0, 153, 255));
        profileMangmentButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        profileMangmentButton.setForeground(new java.awt.Color(255, 255, 255));
        profileMangmentButton.setText("My profile");
        profileMangmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileMangmentButtonActionPerformed(evt);
            }
        });

        LogoutButton.setBackground(new java.awt.Color(0, 153, 255));
        LogoutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        status.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "User", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(status);
        if (status.getColumnModel().getColumnCount() > 0) {
            status.getColumnModel().getColumn(0).setPreferredWidth(120);
            status.getColumnModel().getColumn(0).setMaxWidth(120);
            status.getColumnModel().getColumn(1).setPreferredWidth(121);
            status.getColumnModel().getColumn(1).setMaxWidth(121);
        }

        friendManagement_btn.setBackground(new java.awt.Color(102, 153, 255));
        friendManagement_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        friendManagement_btn.setForeground(new java.awt.Color(255, 255, 255));
        friendManagement_btn.setText("Friend Settings");
        friendManagement_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendManagement_btnActionPerformed(evt);
            }
        });

        searchField.setText("Search...");

        SearchUserBtn.setBackground(new java.awt.Color(0, 153, 255));
        SearchUserBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SearchUserBtn.setText("Search User");
        SearchUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchUserBtnActionPerformed(evt);
            }
        });

        MyGroupsLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MyGroupsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MyGroupsLabel.setText("My Groups");

        MyGroupsPane.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GroupPanel1.setLayout(new javax.swing.BoxLayout(GroupPanel1, javax.swing.BoxLayout.LINE_AXIS));
        MyGroupsPane.setViewportView(GroupPanel1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Group Suggestions");

        NotificitionButton.setBackground(new java.awt.Color(0, 153, 255));
        NotificitionButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NotificitionButton.setForeground(new java.awt.Color(255, 255, 255));
        NotificitionButton.setText("Notifications");
        NotificitionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificitionButtonActionPerformed(evt);
            }
        });

        SearchGroupButton1.setBackground(new java.awt.Color(51, 153, 255));
        SearchGroupButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SearchGroupButton1.setText("Search Group");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(SearchUserBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(SearchGroupButton1))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(MyGroupsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(MyGroupsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addComponent(GroupSuggestPane))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(NotificitionButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friendManagement_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LogoutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileMangmentButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefreshButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(photoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchUserBtn)
                    .addComponent(SearchGroupButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RefreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profileMangmentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LogoutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friendManagement_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NotificitionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MyGroupsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MyGroupsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GroupSuggestPane, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        // TODO add your handling code here:
        //status.removeAll();
        storyPanel.removeAll();
        DefaultTableModel model = (DefaultTableModel) status.getModel();
        model.setRowCount(0);
        
        postPanel.setLayout(new javax.swing.BoxLayout(postPanel, javax.swing.BoxLayout.Y_AXIS));
         ImageIcon imageIcon = new ImageIcon(a.getProfilePhoto());
            Image image = imageIcon.getImage().getScaledInstance(
                223, 
                85, 
                Image.SCALE_SMOOTH
            );
            photoLabel.setIcon(new ImageIcon(image));
            photoLabel.setText("");
        ArrayList<Online> o = a.getOnline();
        for(Online on : o){
            //DefaultTableModel model = new DefaultTableModel();
            
            String user  = on.getUser();
            String status;
            if(on.getStatus()){
                status = "online";
            }
            else{
                status = "offline";
            }
            model.addRow(new Object[]{user, status});    
        }
        ArrayList<PostString> postString = a.getPosts();
        for(PostString p : postString){
            String date = p.getDate();
            String photo = p.getPhoto();
            String name = p.getAuthor();
            String text = p.getText();
            if(photo.equals("No file selected")){
                PostText pt = new PostText(text, name, date);
            }
            else{
                PostImage pi = new PostImage(text, photo, name, date);
            }
            postPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
            postPanel.revalidate();
            postPanel.repaint(); 
        }
        ArrayList<PostString> storyString = a.getStories();
        for(PostString s : storyString){
            String date = s.getDate();
            String photo = s.getPhoto();
            String name = s.getAuthor();
            String text = s.getText();
            if(photo.equals("No file selected")){
                PostText pt = new PostText(text, name, date);
                storyPanel.add(pt);
            }
            else{
                StoryImage si = new StoryImage(text, text, date, name);
                storyPanel.add(si);
            }
            storyPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
            storyPanel.revalidate();
            storyPanel.repaint(); 
        }
        status.repaint();
        ArrayList<GroupString> groupString = a.getMyGroups();
        for(GroupString g : groupString){
            if(g.getRule().equalsIgnoreCase("owner")){
                                System.out.println("carl");

                String groupPhoto = g.getPhoto();
                String groupName = g.getName();
                String groupID = g.getId();
                MyGroupsCreator myGroup = new MyGroupsCreator(a,groupID,groupPhoto,groupName);
                GroupPanel1.add(myGroup);
            }
            else{
                                System.out.println("mina");

                String groupPhoto = g.getPhoto();
                String groupName = g.getName();
                String groupID = g.getId();
                MyGroups myGroup = new MyGroups(a,groupID,groupPhoto,groupName);
                GroupPanel1.add(myGroup);
            }
        }
        GroupPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GroupPanel1.revalidate();
        GroupPanel1.repaint();
    
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void profileMangmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileMangmentButtonActionPerformed
        // TODO add your handling code here:
        ProfileDetails profileDetails = new ProfileDetails(a);
        profileDetails.setVisible(true);
    }//GEN-LAST:event_profileMangmentButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
        a.LogoutUser();
        this.dispose();
        LoginWindow l = new LoginWindow();
        l.setVisible(true);
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void jScrollPane4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane4FocusGained

    private void jScrollPane4ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jScrollPane4ComponentAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jScrollPane4ComponentAdded

    private void friendManagement_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendManagement_btnActionPerformed
        // TODO add your handling code here:
         
              JFrame frame = new JFrame("Friend Management");
              frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close on exit
               frame.setSize(1176, 615); // Set the frame size
             frame.add(new FriendManagement(a)); // Add your panel
             frame.setVisible(true); // Make the frame visible
        
    }//GEN-LAST:event_friendManagement_btnActionPerformed

    private void NotificitionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificitionButtonActionPerformed
        // TODO add your handling code here:
        // Create a new frame to display the notifications
        JFrame frame = new JFrame("Notifications");

        // Set the frame to close on exit
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(1176, 615);

        // Create the Notification panel (which will handle the display of notifications)
        NotificationPanel notificationPanel = new NotificationPanel(a); // 'a' is your Manager instance

        // Add the Notification panel to the frame
        frame.add(notificationPanel);

        // Make the frame visible
        frame.setVisible(true);

    }//GEN-LAST:event_NotificitionButtonActionPerformed

    private void SearchUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchUserBtnActionPerformed
        // TODO add your handling code here:
            String searchName = searchField.getText(); // Get the name entered in the search field
    User foundUser = a.searchUserByName(searchName); // Search for the user in the backend

    // Open the new page (Search Results) with the result
    JFrame searchResultFrame = new JFrame("Search Results");
    searchResultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    searchResultFrame.setSize(500, 400);
    searchResultFrame.add(new searchResultPanel(a, foundUser));
    searchResultFrame.setVisible(true);
    }//GEN-LAST:event_SearchUserBtnActionPerformed
    


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewsfeedWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewsfeedWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewsfeedWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewsfeedWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //    new NewsfeedWindow(a).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GroupPanel1;
    private javax.swing.JScrollPane GroupSuggestPane;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JLabel MyGroupsLabel;
    private javax.swing.JScrollPane MyGroupsPane;
    private javax.swing.JButton NotificitionButton;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchGroupButton1;
    private javax.swing.JButton SearchUserBtn;
    private javax.swing.JButton friendManagement_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JPanel postPanel;
    private javax.swing.JButton profileMangmentButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTable status;
    private javax.swing.JPanel storyPanel;
    // End of variables declaration//GEN-END:variables
}
