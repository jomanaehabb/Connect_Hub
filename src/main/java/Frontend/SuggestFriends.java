/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;
import Backend.ConnectHub;


/**
 *
 * @author cf
 */
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userIdField = new JTextField(15);
        suggestButton = new JButton("Get Suggestions");
        suggestionsArea = new JTextArea(10, 30);

        suggestButton.addActionListener((ActionEvent e) -> {
            String userId = userIdField.getText();
            ConnectHub fm = new ConnectHub();
            List<String> suggestions = fm.suggestFriends(userId);
            suggestionsArea.setText(String.join("\n", suggestions));
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Your ID:"));
        panel.add(userIdField);
        panel.add(suggestButton);
        panel.add(new JScrollPane(suggestionsArea));

        add(panel);
    }

    public static void main(String[] args) {
        new SuggestFriends().setVisible(true);
    }
}

