package Frontend;

 // Alternative to the GUI but this time instead of tabs we use separate panels for each page(we may use it)
 // Use the MainGUI.java instead

import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import Backend.ConnectHub1;

public class FriendRequests extends JFrame {
    private JTextField userIdField;
    private JButton loadRequestsButton;
    private JTextArea requestListArea;
    private JTextField requestIdField;
    private JButton acceptButton;
    private JButton declineButton;

    public FriendRequests() {
        setTitle("Friend Requests");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // User input Components
        userIdField = new JTextField(15);
        loadRequestsButton = new JButton("Load Friend Requests");
        requestListArea = new JTextArea(10, 40);
        requestIdField = new JTextField(15);
        acceptButton = new JButton("Accept Request");
        declineButton = new JButton("Decline Request");

        // Action for loading friend requests
        loadRequestsButton.addActionListener((ActionEvent e) -> {
            String userId = userIdField.getText();
            if (userId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your user ID.");
                return;
            }
            
            // Get a list of friend requests from the backend
            ConnectHub1 connectHub = new ConnectHub1();
            List<String> requests = connectHub.getPendingFriendRequests(userId);
            
            if (requests.isEmpty()) {
                requestListArea.setText("No pending friend requests.");
            } else {
                StringBuilder sb = new StringBuilder();
                for (String request : requests) {
                    sb.append(request).append("\n");
                }
                requestListArea.setText(sb.toString());
            }
        });

        // Action for accepting a friend request
        acceptButton.addActionListener((ActionEvent e) -> {
            String requestId = requestIdField.getText();
            String userId = userIdField.getText();
            if (requestId.isEmpty() || userId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your user ID and request ID.");
                return;
            }
            else if (!requestId.matches("-?\\d+") || !userId.matches("-?\\d+")) {
                JOptionPane.showMessageDialog(null, "Please enter valid integers only.");
                requestIdField.setText("");
                userIdField.setText("");
                return;
            }    
            else if(requestId.matches("-\\d+") || userId.matches("-\\d+")) {
                JOptionPane.showMessageDialog(null, "Please enter positive integers only.");
                requestIdField.setText("");
                userIdField.setText("");
                return;
            }
            
            // Accept the friend request
            ConnectHub1 connectHub = new ConnectHub1();
            connectHub.respondToFriendRequest(requestId,userId, true);
            JOptionPane.showMessageDialog(null, "Friend request accepted!");
            requestListArea.setText("");
            requestIdField.setText("");
        });

        // Action for declining a friend request
        declineButton.addActionListener((ActionEvent e) -> {
            String requestId = requestIdField.getText();
            String userId = userIdField.getText();
            if (requestId.isEmpty() || userId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your user ID and request ID.");
                return;
            }
            
            // Decline the friend request
            ConnectHub1 connectHub = new ConnectHub1();
            connectHub.respondToFriendRequest(requestId,userId, false);
            JOptionPane.showMessageDialog(null, "Friend request declined.");
            requestListArea.setText("");
            requestIdField.setText("");
        });

        
        JPanel panel = new JPanel();
        panel.add(new JLabel("Your User ID:"));
        panel.add(userIdField);
        panel.add(loadRequestsButton);
        panel.add(new JScrollPane(requestListArea));
        panel.add(new JLabel("Request ID:"));
        panel.add(requestIdField);
        panel.add(acceptButton);
        panel.add(declineButton);

        add(panel);
    }
}
