package Backend;
import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Pattern;

public class UserAccountManager extends Manager {
    private static UserAccountManager instance;
    // Constructor loads the users from the database when an instance is created
    private UserAccountManager() {
        loadUsers();
    }
    
    public static UserAccountManager getInstance(){
         if(instance == null){
             synchronized (UserAccountManager.class){
                if(instance == null){
                    instance = new UserAccountManager();
                }
            }
        }
        return instance;
    }

    /**
     * Method to sign up a new user.
     *
     * @param email The user's email address
     * @param username The user's chosen username
     * @param password The user's chosen password
     * @param dateOfBirth The user's date of birth
     * @return boolean indicating success (true) or failure (false)
     */
    public boolean signUp(String email, String username, String password, LocalDate dateOfBirth) {
        loadUsers();  // Reload the users to ensure we're working with the latest data

        // Check if the email already exists or if the email is invalid
        if (users.containsKey(email) || !isValidEmail(email)) return false;

        // Generate a unique userId using UUID
        String userId = generateUniqueUserId();

        // Create a new User object with the provided details
        User user = new User(userId, email, username, hashPassword(password), dateOfBirth);

        // Store the new user in the database (users map) using the email as the key
        users.put(email, user);

        // Save the users list to the database (file)
        saveUsers();
        return true;
    }

    /**
     * Generates a unique user ID that is not already taken by another user.
     *
     * @return A unique user ID
     */
    public String generateUniqueUserId() {
        String userId;
        do {
            // Generate a random UUID
            userId = UUID.randomUUID().toString();
        } while (isUserIdTaken(userId));  // Ensure the user ID is not already taken
        return userId;
    }

    /**
     * Checks if a user ID is already taken.
     *
     * @param userId The user ID to check
     * @return true if the user ID is already taken, false otherwise
     */
    public boolean isUserIdTaken(String userId) {
        // Check if any existing user has the same user ID
        return users.values().stream().anyMatch(user -> user.getUserId().equals(userId));
    }

    /**
     * Validates the format of the provided email.
     *
     * @param email The email to validate
     * @return true if the email format is valid, false otherwise
     */
    public boolean isValidEmail(String email) {
        // Regular expression pattern for validating email format
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Return true if email matches the regex pattern
        return email != null && Pattern.compile(emailRegex).matcher(email).matches();
    }

    /**
     * Method to log a user in by checking the email and password.
     *
     * @param email The email of the user trying to log in
     * @param password The password provided by the user
     * @return boolean indicating success (true) or failure (false)
     */
    public boolean login(String email, String password) {
        User user = users.get(email);  // Get the user by email
        if (user != null && user.getHashedPassword().equals(hashPassword(password))) {
            // If user exists and password matches, set status to "Online"
            user.setStatus("Online");
            saveUsers();  // Save the updated user data
            return true;
        }
        return false;  // Invalid login details
    }

    /**
     * Retrieves a user by their email address.
     *
     * @param email The email of the user
     * @return The User object associated with the email, or null if not found
     */
    public User getUserByEmail(String email) {
        return users.get(email);
    }
    

    /**
     * Method to log a user out by setting their status to "Offline".
     *
     * @param email The email of the user who wants to log out
     */
    public void logout(String email) {
        User user = users.get(email);  // Retrieve the user by email
        if (user != null) {
            user.setStatus("Offline");  // Set user status to "Offline"
            saveUsers();
        }
    }
}