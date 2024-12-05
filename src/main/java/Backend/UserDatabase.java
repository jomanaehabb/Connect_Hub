/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.*;
import java.util.ArrayList;

public class UserDatabase {
    private ArrayList<User> users;
    private final String databaseFile = "users.db";

    public UserDatabase() {
        users = new ArrayList<>();
        loadDatabase();
    }

    private void loadDatabase() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(databaseFile))) {
            users = (ArrayList<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            users = new ArrayList<>();
        }
    }

    private void saveDatabase() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(databaseFile))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        users.add(user);
        saveDatabase();
    }

    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) return user;
        }
        return null;
    }

    public boolean authenticateUser(String email, String hashedPassword) {
        User user = getUserByEmail(email);
        return user != null && user.getHashedPassword().equals(hashedPassword);
    }

    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(user.getUserId())) {
                users.set(i, user);
                break;
            }
        }
        saveDatabase();
    }

    public void deleteUser(String userId) {
        users.removeIf(user -> user.getUserId().equals(userId));
        saveDatabase();
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }
}