/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Backend;

/**
 *
 * @author DELL-G3
 */

public class RelationshipStatus {
    private String status;

    public RelationshipStatus() {
        this.status = "pending";
    }

    public void setFriend() {
        this.status = "Friend";

    }
    public void setBlock() {
        this.status = "Block";
    }
    public void setCanceled() {
        this.status = "Cancel";
    }
    public String getRelation() {
        return status;
    }
}
