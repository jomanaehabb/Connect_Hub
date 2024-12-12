/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Backend.FriendManagement;

/**
 *
 * @author DELL-G3
 */

import Backend.User;
import Backend.DataBase.Database;

public class friendRequest implements Database {
private String senderID;
private String receiverID;
private RelationshipStatus status;
private String notificationId;

    public friendRequest(String senderID, String receiverID) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.status = new RelationshipStatus();
    }
    public void make(User sender,User receiver){
        
        sender.sendRelation(new Relationship(status,receiverID));
        receiver.receiveRelation(new Relationship(status,senderID));
    }
    public void accept(){
        status.setFriend();
    }
    public void decline(){
        status.setCanceled();
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public RelationshipStatus getStatus() {
        return status;
    }

    public String getSenderID() {
        return senderID;
    }

    public String getReceiverID() {
        return receiverID;
    }
    public void block(){
        status.setBlock();
    }
    public void blockAndSwitch(){
        String temp=senderID;
        senderID=receiverID;
        receiverID=temp;
        status.setBlock();
    }
    
}
