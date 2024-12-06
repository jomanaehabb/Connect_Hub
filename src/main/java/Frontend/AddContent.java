package Frontend;

import Backend.ContentDatabase;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AddContent extends javax.swing.JFrame {

    private String userId;
    private String textInput;
    private Image image;
    
    public AddContent(String userId) {
        initComponents();
        setTitle("Add Content");
        this.userId = userId;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        writeLabel = new javax.swing.JLabel();
        addPostButton = new javax.swing.JButton();
        addStoryButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        imageLabel = new javax.swing.JLabel();
        addImageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        writeLabel.setText("Write what's on your mind! :3");

        addPostButton.setText("Add as Post");
        addPostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPostButtonActionPerformed(evt);
            }
        });

        addStoryButton.setText("Add as Story");
        addStoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStoryButtonActionPerformed(evt);
            }
        });

        textArea.setColumns(5);
        textArea.setRows(10);
        jScrollPane1.setViewportView(textArea);

        imageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        addImageButton.setText("Add Image");
        addImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(addPostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addStoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                            .addComponent(writeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(writeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(addImageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPostButton)
                    .addComponent(addStoryButton))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPostButtonActionPerformed
        textInput = textArea.getText();
        if(textInput.isEmpty() && image == null)
            //if the text area and image are empty
            JOptionPane.showMessageDialog(null, "Failed to create post.");
        else {
            ContentDatabase content = new ContentDatabase();
            if(textInput.isEmpty()) {
                content.createPost(userId, null, image);
                content.saveToFiles();
            }    
            else if(image == null) {
                content.createPost(userId, textInput, null);
                content.saveToFiles();
            }    
            else {
                content.createPost(userId, textInput, image);
                content.saveToFiles();
            }
            System.out.println(content.findPost(userId).getAuthorID());
            System.out.println(content.findPost(userId).getContentID());
            System.out.println(content.findPost(userId).getTimeStamp());
            System.out.println(content.findPost(userId).getContent().getText());
            System.out.println(content.findPost(userId).getContent().getImage());
            JOptionPane.showMessageDialog(null, "Post has been successfully added!");
        }
    }//GEN-LAST:event_addPostButtonActionPerformed

    private void addImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addImageButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if(file != null) {
            //get image from file and scale it to fit the label properly
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            image = icon.getImage().getScaledInstance(imageLabel.getSize().width, imageLabel.getSize().height, imageLabel.getSize().width);
            ImageIcon imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
        }
        else
            //if failed to open file or the user clicked cancel
            JOptionPane.showMessageDialog(null, "Error loading file.");
    }//GEN-LAST:event_addImageButtonActionPerformed

    private void addStoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStoryButtonActionPerformed
        textInput = textArea.getText();
        if(!textInput.isEmpty()) {
            ContentDatabase content = new ContentDatabase();
            if(image != null)
                content.createStory(userId, textInput, image);
            else {
                content.createStory(userId, textInput, null);
                //make sure it actually saves in a file
                content.saveToFiles();
            }
            //for testing
            System.out.println(content.findStory(userId).getAuthorID());
            System.out.println(content.findStory(userId).getContentID());
            System.out.println(content.findStory(userId).getTimeStamp());
            System.out.println(content.findStory(userId).getContent().getText());
            System.out.println(content.findStory(userId).getContent().getImage());
            JOptionPane.showMessageDialog(null, "Story has been successfully added!");
        }
        else 
            //if the text area is empty
            JOptionPane.showMessageDialog(null, "Failed to create story.");
    }//GEN-LAST:event_addStoryButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addImageButton;
    private javax.swing.JButton addPostButton;
    private javax.swing.JButton addStoryButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel writeLabel;
    // End of variables declaration//GEN-END:variables
}
