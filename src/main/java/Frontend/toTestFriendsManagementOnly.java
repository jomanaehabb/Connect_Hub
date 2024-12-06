/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import Backend.FriendsManagement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lenovo
 */
// This file is only used to test the friendsmanagment gui only.
//when you add to the main program you can just call the FriendsManagement(username)  instaed
//you will need the username to access the friends section
public class toTestFriendsManagementOnly {
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Replace "testUser" with any sample username for testing
            FriendsManagementWindow friendsManagementPanel = new FriendsManagementWindow("omar123");

            // Embed the panel in a JFrame for testing
            JFrame frame = new JFrame("Friends Management Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.add(friendsManagementPanel);
            frame.setVisible(true);
        });
}


}

