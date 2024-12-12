/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Backend;

/**
 *
 * @author DELL-G3
 */

public class Online {
    private Boolean status;

    public Online(Boolean status, String user) {
        this.status = status;
        this.user = user;
    }

    private String user;

    public Boolean getStatus() {
        return status;
    }

    public String getUser() {
        return user;
    }
}
