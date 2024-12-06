/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import Backend.FriendsManagement;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lenovo
 */
public class testfriendslist {
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Friends List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Replace with actual ConnectHub implementation
        FriendsManagement connectHub = new FriendsManagement();

        String username="alice789";
        // Create FriendsList panel
        FriendsListWindow friendsListPanel = new FriendsListWindow(username,connectHub);

        // Initialize the panel with a username
        

        frame.add(friendsListPanel);
        frame.setVisible(true);
    });
}

}
