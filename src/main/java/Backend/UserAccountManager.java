package Backend;

import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Pattern;

public class UserAccountManager extends Manager {

    public UserAccountManager() {
        loadUsers();
    }

    public boolean signUp(String email, String username, String password, LocalDate dateOfBirth) {
        loadUsers();
        if (users.containsKey(email) || !isValidEmail(email)) return false;
        String userId = generateUniqueUserId();
        User user = new User(userId, email, username, hashPassword(password), dateOfBirth);
        users.put(email, user);
        saveUsers();
        return true;
    }

    public String generateUniqueUserId() {
        String userId;
        do {
            userId = UUID.randomUUID().toString();
        } while (isUserIdTaken(userId));
        return userId;
    }

    public boolean isUserIdTaken(String userId) {
        return users.values().stream().anyMatch(user -> user.getUserId().equals(userId));
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email != null && Pattern.compile(emailRegex).matcher(email).matches();
    }

    public boolean login(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getHashedPassword().equals(hashPassword(password))) {
            user.setStatus("Online");
            saveUsers();
            return true;
        }
        return false;
    }
    
    public User getUserByEmail(String email) {
        return users.get(email);
    }

    public void logout(String email) {
        User user = users.get(email);
        if (user != null) {
            user.setStatus("Offline");
            saveUsers();
        }
    }
}


