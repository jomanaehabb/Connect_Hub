/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
// This file is only used to test the friendsmanagment gui only.
//when you add to the main program you can just call the FriendsManagement(username)  instaed
//you will need the username to access the friends section
public class toTestFriendsManagementOnly {
    public static void main(String[] args) {
        String username = JOptionPane.showInputDialog("Enter your username:");
        if (username != null && !username.isEmpty()) {
            new FriendsManagement(username);
        } else {
            System.out.println("Username is required!");
        }
    }
}
