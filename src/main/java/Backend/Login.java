/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Backend;

/**
 *
 * @author DELL-G3
 */

import java.util.ArrayList;

public class Login {

  
    public User accessUser (String email, String Password, ArrayList<User> users ){
        for(User u : users){
            if(u.checkPassword(Password) && u.getEmail().equals(email)){
                u.setStatus(true);
                return u;

            }
        }
        return null;
    }
   
}
