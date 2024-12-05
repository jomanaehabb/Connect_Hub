package Frontend;

import Backend.ConnectHub1;

  // Use the MainGUI.java instead
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class SuggestFriends extends JFrame {
    private JTextField userIdField;
    private JButton suggestButton;
    private JTextArea suggestionsArea;

    public SuggestFriends() {
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
                ConnectHub1 fm = new ConnectHub1();
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
