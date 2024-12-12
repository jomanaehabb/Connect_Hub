/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Backend;

/**
 *
 * @author DELL-G3
 */

import java.time.LocalDate;
import java.util.ArrayList;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import Backend.DataBase.Database;

public class User implements Database {

    private String userId;
    private String email;
    private String userName;
    private String password;
    private LocalDate DateOfBirth;
    private Boolean status;
    private String profilePhoto;
    private String coverPhoto;
    private String bio;
    
    private ArrayList<String> myPosts = new ArrayList<>();
    private ArrayList<String> myStories;
    private ArrayList<String> myGroups;
    private ArrayList<String> groupRequests;
    private ArrayList<String> groupsLeftByMe;


    /*m7tagen arraylist ll friend 3lshan deh el httn3t lama a7tag a3rf men el online*/
 /*lw 3mlna keda hn8yr fel relations w m7tagen nn2l kol relation l arraylist*/
    public User(String userId, String email, String userName, String password, LocalDate DateOfBirth) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.setPassword(password);
        this.DateOfBirth = DateOfBirth;


        myStories = new ArrayList<>();
        this.myGroups = new ArrayList<>();
        this.groupsLeftByMe = new ArrayList<>();
        this.groupRequests = new ArrayList<>();
      }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(hashPassword(password));
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public Boolean getStatus() {

        return status;
    }

    public void setStatus(boolean status) {

        this.status = status;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    
    public ArrayList<String> getMyPosts() {
        return myPosts;
    }

    

    

  

    public void addPost(String contentID) {

        myPosts.addFirst(contentID);
    }

    public void addStory(String contentID) {
        myStories.addFirst(contentID);
    }

    public ArrayList<String> getMyStories() {
        return myStories;
    }

    public void removeContent(String contentID) {
        myPosts.remove(contentID);
    }

  

    public ArrayList<String> getAllMyGroups() {
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(this.myGroups);
        return temp;
    }

    public ArrayList<String> getAllGroupsLeftByMe() {
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(this.groupsLeftByMe);
        return temp;
    }

    public ArrayList<String> getAllGroupRequests() {
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(this.groupRequests);
        return temp;
    }

    public void addGroupRequest(String groupID){
        groupRequests.add(groupID);
    }

    public void removeGroupRequest(String groupID){
        groupRequests.remove(groupID);
    }

    public void joinGroup(String groupID){
        groupRequests.remove(groupID);
        myGroups.add(groupID);
        groupsLeftByMe.remove(groupID);
    }

    public void leaveGroup(String groupID){
        myGroups.remove(groupID);
        groupsLeftByMe.add(groupID);
    }

    public void removeGroup(String groupID){
         myGroups.remove(groupID);
    }
    
public boolean isMember(String key){
    for (int i = 0; i < myGroups.size(); i++) {
        if(myGroups.get(i).equalsIgnoreCase(key)){
            return true;
        }

    }
        return false;
}
    public boolean isPendingGroup(String key){
        for (int i = 0; i < groupRequests.size(); i++) {
            if(groupRequests.get(i).equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;
    }

}
