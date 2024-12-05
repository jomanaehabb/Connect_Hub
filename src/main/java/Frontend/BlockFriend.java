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

public class BlockFriend extends JFrame {
    private JTextField user1Field, user2Field;
    private JButton blockFriendButton;

    public BlockFriend() {
        setTitle("Block Friend");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        user1Field = new JTextField(15);
        user2Field = new JTextField(15);
        blockFriendButton = new JButton("Block Friend");

        blockFriendButton.addActionListener((ActionEvent e) -> {
            String user1Id = user1Field.getText();
            String user2Id = user2Field.getText();
            ConnectHub fm = new ConnectHub();
            fm.blockFriend(user1Id, user2Id);
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Your ID:"));
        panel.add(user1Field);
        panel.add(new JLabel("Friend's ID:"));
        panel.add(user2Field);
        panel.add(blockFriendButton);

        add(panel);
    }

    public static void main(String[] args) {
        new BlockFriend().setVisible(true);
    }
}

