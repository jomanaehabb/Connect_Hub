
package Frontend;

import Frontend.LoginWindow;

public class Main {


    public static void main(String[] args) {

        LoginWindow LoginFrame = new LoginWindow();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null); 
    }
    
}
