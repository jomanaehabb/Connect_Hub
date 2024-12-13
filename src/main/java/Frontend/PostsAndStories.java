/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;

import Backend.Manager;
import Backend.PostString;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author User
 */
public class PostsAndStories extends javax.swing.JPanel {

    /**
     * Creates new form MyPosts_Stories
     */
    private Manager a ;
    public PostsAndStories(Manager a) {
        this.a = a;
        initComponents();
        
         postPanel.setLayout(new javax.swing.BoxLayout(postPanel, javax.swing.BoxLayout.Y_AXIS));
          ArrayList <PostString> stories = a.getMyStories();
            for(PostString s : stories){
                String date = s.getDate();
                String name = s.getAuthor();
                String text = s.getText();
                String path = s.getPhoto();
                if(!path.equals("No file selected")){
                    StoryImage story = new StoryImage(text, path, name, date);
                    storyPanel.add(story);
            }
                else{
                    PostText story = new PostText(text, name, date);
                    storyPanel.add(story);
                }
            }
            ArrayList <PostString> posts =  a.getMyPosts();
            for(PostString p : posts){
                String date = p.getDate();
                String name = p.getAuthor();
                String text = p.getText();
                String path = p.getPhoto();
                if(!path.equals("No file selected")){
                PostImage post = new PostImage(text, path, name, date);
                postPanel.add(post);
                }
                else{
                PostText postText = new PostText(text, name, date);
                postPanel.add(postText);
            }
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     public static Result showCustomDialog() {
        // Create a JDialog
        JDialog dialog = new JDialog((Frame) null ,"Custom Dialog", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());


        // Panel for file chooser
        JPanel filePanel = new JPanel(new FlowLayout());
        JLabel fileLabel = new JLabel("No file selected");
        JButton fileButton = new JButton("Choose Image");
        filePanel.add(fileButton);
        filePanel.add(fileLabel);

        // Add file chooser functionality
        fileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            // Filter for image files only
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "bmp");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(dialog);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                fileLabel.setText(selectedFile.getAbsolutePath());
            }
        });

        // Text area for user input
        JTextArea textArea = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(new JLabel("Enter your text:"), BorderLayout.NORTH);
        textPanel.add(scrollPane, BorderLayout.CENTER);

        // Buttons for OK and Cancel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        
        // Variable to hold the result
        final Result[] dialogResult = {null};

        // Action for OK button
        okButton.addActionListener(e -> {
            String imagePath = fileLabel.getText();
            String userText = textArea.getText();
            dialogResult[0] = new Result(imagePath, userText);
            dialog.dispose();
            // Only proceed if a file is selected
//            if (!imagePath.equals("No file selected")) {
//                dialogResult[0] = new Result(imagePath, userText);
//                dialog.dispose();
//            } else {
//                JOptionPane.showMessageDialog(dialog, "Please select an image.", "Warning", JOptionPane.WARNING_MESSAGE);
//            }
        });

        // Action for Cancel button
        cancelButton.addActionListener(e -> {
            dialogResult[0] = null;
            dialog.dispose();
        });

        // Add components to the dialog
        dialog.add(filePanel, BorderLayout.NORTH);
        dialog.add(textPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Show the dialog
        dialog.setVisible(true);

        // Return the result
        return dialogResult[0];
    }

    // Class to hold the result
    public static class Result {
        public String imagePath;
        public String userText;

        public Result(String imagePath, String userText) {
            this.imagePath = imagePath;
            this.userText = userText;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        postPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        storyPanel = new javax.swing.JPanel();
        CreateStoryButton = new javax.swing.JButton();
        CreatePostButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        postPanel.setBackground(new java.awt.Color(255, 255, 255));
        postPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        postPanel.setLayout(new javax.swing.BoxLayout(postPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(postPanel);

        storyPanel.setBackground(new java.awt.Color(255, 255, 255));
        storyPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        storyPanel.setLayout(new javax.swing.BoxLayout(storyPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane2.setViewportView(storyPanel);

        CreateStoryButton.setBackground(new java.awt.Color(102, 153, 255));
        CreateStoryButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CreateStoryButton.setForeground(new java.awt.Color(255, 255, 255));
        CreateStoryButton.setText("Create Story");
        CreateStoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateStoryButtonActionPerformed(evt);
            }
        });

        CreatePostButton.setBackground(new java.awt.Color(102, 153, 255));
        CreatePostButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CreatePostButton.setForeground(new java.awt.Color(255, 255, 255));
        CreatePostButton.setText("Create post");
        CreatePostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePostButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(CreatePostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(CreateStoryButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreatePostButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(CreateStoryButton)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CreateStoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateStoryButtonActionPerformed
        // TODO add your handling code here:
            Result result = showCustomDialog();
            if(result.userText.equals("")){
                JOptionPane.showMessageDialog(null, "Text can't be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else {
                a.createStory(result.imagePath, result.userText);
            }
            postPanel.removeAll();
            ArrayList <PostString> stories = a.getMyStories();
            for(PostString s : stories){
                String date = s.getDate();
                String name = s.getAuthor();
                String text = s.getText();
                String path = s.getPhoto();
                if(!path.equals("No file selected")){
                    StoryImage story = new StoryImage(text, path, name, date);
                    storyPanel.add(story);
            }
                else{
                    PostText story = new PostText(text, name, date);
                    storyPanel.add(story);
                }
            }
            
            
        storyPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
        storyPanel.revalidate();
        storyPanel.repaint();
    }//GEN-LAST:event_CreateStoryButtonActionPerformed

    private void CreatePostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePostButtonActionPerformed
        // TODO add your handling code here:
            Result result = showCustomDialog();
            
            if(result.userText.equals("")){
                JOptionPane.showMessageDialog(null, "Text can't be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else {
                a.createPost(result.imagePath, result.userText);
               
            }
            postPanel.removeAll();  // Remove all components
            
           // System.out.println(result.imagePath);
            ArrayList <PostString> posts =  a.getMyPosts();
            for(PostString p : posts){
                String date = p.getDate();
                String name = p.getAuthor();
                String text = p.getText();
                String path = p.getPhoto();
                if(!path.equals("No file selected")){
                PostImage post = new PostImage(text, path, name, date);
                postPanel.add(post);
                }
                else{
                PostText postText = new PostText(text, name, date);
                postPanel.add(postText);
            }
            }
//        });
      //  postPanel.setBackground(Color.BLUE);
        postPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 100));
        postPanel.revalidate();
        postPanel.repaint();
    }//GEN-LAST:event_CreatePostButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreatePostButton;
    private javax.swing.JButton CreateStoryButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel postPanel;
    private javax.swing.JPanel storyPanel;
    // End of variables declaration//GEN-END:variables
}
