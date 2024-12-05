package Frontend;

import Backend.ConnectHub1;
import java.awt.event.*;
import javax.swing.*;

  // Use the MainGUI.java instead
  // Alternative to the GUI but this time instead of tabs we use separate panels for each page(we may use it)
public class AddFriend extends JFrame {
    private JTextField user1Field, user2Field;
    private JButton addFriendButton;

    public AddFriend() {
        setTitle("Add Friend");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        user1Field = new JTextField(15);
        user2Field = new JTextField(15);
        addFriendButton = new JButton("Send Friend Request");

        addFriendButton.addActionListener((ActionEvent e) -> {
            String user1Id = user1Field.getText();
            String user2Id = user2Field.getText();
            if(user1Id.isEmpty() || user2Id.isEmpty())
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            else if (!user1Id.matches("-?\\d+") || !user2Id.matches("-?\\d+")) {
                JOptionPane.showMessageDialog(null, "Please enter valid integers only.");
                user1Field.setText("");
                user2Field.setText("");
            }    
            else if(user1Id.matches("-\\d+") || user2Id.matches("-\\d+")) {
                JOptionPane.showMessageDialog(null, "Please enter positive integers only.");
                user1Field.setText("");
                user2Field.setText("");
            }
            else {
                ConnectHub1 fm = new ConnectHub1();
                fm.sendFriendRequest(user1Id, user2Id);
                JOptionPane.showMessageDialog(null, "Friend has been successfully added!");
                this.setVisible(false);
            } 
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Your ID:"));
        panel.add(user1Field);
        panel.add(new JLabel("Friend's ID:"));
        panel.add(user2Field);
        panel.add(addFriendButton);

        add(panel);
    }
}
