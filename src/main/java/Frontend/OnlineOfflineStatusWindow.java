/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

/**
 *
 * @author cf
 */
  // Use the MainGUI.java instead
  // This should be handled through the loggin page not here but incase it didn't we can do it here
import Backend.UserActivity;
import java.awt.event.*;
import javax.swing.*;

public class OnlineOfflineStatusWindow extends JFrame {
    private JTextField userIdField;
    private JButton updateStatusButton;

    public OnlineOfflineStatusWindow() {
        setTitle("Update Online/Offline Status");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userIdField = new JTextField(15);
        updateStatusButton = new JButton("Update Status");

        updateStatusButton.addActionListener((ActionEvent e) -> {
            String userId = userIdField.getText();
            boolean isLoggedIn = true;  // Assume the user is logging in. You can change as needed.
            UserActivity.updateUserStatus(userId, isLoggedIn);
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("User ID:"));
        panel.add(userIdField);
        panel.add(updateStatusButton);

        add(panel);
    }

    /*public static void main(String[] args) {
        new OnlineOfflineStatus().setVisible(true);
    }*/
}
