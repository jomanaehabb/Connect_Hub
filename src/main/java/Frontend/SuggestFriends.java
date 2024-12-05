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
import Backend.ConnectHub;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SuggestFriends extends JPanel {
    public SuggestFriends(String currentUsername, ConnectHub connectHub) {
        setLayout(new BorderLayout());

        JLabel header = new JLabel("Suggested Friends for: " + currentUsername, JLabel.CENTER);
        add(header, BorderLayout.NORTH);

        // Get the list of suggested friends from the backend
        List<String> suggestedFriends = connectHub.suggestFriends(currentUsername);

        JPanel suggestionsPanel = new JPanel(new GridLayout(suggestedFriends.size(), 1, 5, 5));

        for (String suggestion : suggestedFriends) {
            JPanel suggestionRow = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JLabel suggestionLabel = new JLabel(suggestion);
            JButton addButton = new JButton("Add");

            addButton.addActionListener(e -> {
                connectHub.sendFriendRequest(currentUsername, suggestion);
                JOptionPane.showMessageDialog(this, "Friend request sent to " + suggestion + "!");
            });

            suggestionRow.add(suggestionLabel);
            suggestionRow.add(addButton);
            suggestionsPanel.add(suggestionRow);
        }

        JScrollPane scrollPane = new JScrollPane(suggestionsPanel);
        add(scrollPane, BorderLayout.CENTER);
    }
}
