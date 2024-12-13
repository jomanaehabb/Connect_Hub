/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;
/**
 *
 * @author DELL-G3
 */
import Backend.Manager;
import Backend.Notification;  // Make sure to import the correct Notification class
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public class NotificationPanel extends javax.swing.JPanel {

    private Manager a;  // Manager that holds the current user

    public NotificationPanel(Manager a) {
        initComponents();
        this.a = a;
        displayNotifications();  // Display the notifications when the panel is created
    }

    // Method to display notifications in the scrollable panel
    private void displayNotifications() {
        ArrayList<Notification> notifications = a.getCurrentUserNotifications();  // Get current user's notifications

        // Create a panel to hold the notifications
        JPanel notificationsContainer = new JPanel();
        notificationsContainer.setLayout(new javax.swing.BoxLayout(notificationsContainer, javax.swing.BoxLayout.Y_AXIS));
        notificationsContainer.setBackground(Color.WHITE);

        // Loop through the notifications and create a JLabel for each
        for (Notification notification : notifications) {
            JLabel notificationLabel = new JLabel("<html>" + notification.getName() + ": " + notification.getMessage() + "</html>");
            notificationLabel.setPreferredSize(new Dimension(550, 40));
            notificationsContainer.add(notificationLabel);  // Add the label to the container
        }

        // Add the notifications container to the scroll panel
        notificationPanel.setViewportView(notificationsContainer);  // Set the scrollable view

        // Refresh the UI to reflect the changes
        this.revalidate();
        this.repaint();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        notificationPanel = new javax.swing.JScrollPane();

        setMaximumSize(new java.awt.Dimension(636, 468));

        notificationPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(notificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(notificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane notificationPanel;
    // End of variables declaration//GEN-END:variables
}
