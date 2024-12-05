package Frontend;

import Backend.ConnectHub;

  // Use the MainGUI.java instead
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class SuggestFriendsWindow extends JFrame {
    private JTextField userIdField;
    private JButton suggestButton;
    private JTextArea suggestionsArea;

    public SuggestFriendsWindow() {
        setTitle("Friend Suggestions");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        userIdField = new JTextField(15);
        suggestButton = new JButton("Get Suggestions");
        suggestionsArea = new JTextArea(10, 30);

        suggestButton.addActionListener((ActionEvent e) -> {
            String userId = userIdField.getText();
            if(userId.isEmpty())
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            else if (!userId.matches("-?\\d+")) {
                JOptionPane.showMessageDialog(null, "Please enter valid integers only.");
                userIdField.setText("");
            }    
            else if(userId.matches("-\\d+")) {
                JOptionPane.showMessageDialog(null, "Please enter positive integers only.");
                userIdField.setText("");
            }
            else {
                ConnectHub fm = new ConnectHub();
                List<String> suggestions = fm.suggestFriends(userId);
                suggestionsArea.setText(String.join("\n", suggestions));
            } 
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Your ID:"));
        panel.add(userIdField);
        panel.add(suggestButton);
        panel.add(new JScrollPane(suggestionsArea));

        add(panel);
    }
}