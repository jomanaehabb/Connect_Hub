/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import javax.swing.SwingUtilities;

/**
 *
 * @author DELL-G3
 */
public class Main {
    
    public static void main(String[] args) {
        // Use SwingUtilities to ensure the UI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Initialize and display the LoginWindow
                LoginWindow loginWindow = new LoginWindow();
                loginWindow.setVisible(true);
            }
        });
    }
}
