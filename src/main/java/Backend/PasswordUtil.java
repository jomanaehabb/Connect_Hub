package Backend;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The PasswordUtil class provides utility methods for password-related operations, 
 * such as hashing passwords using the SHA-256 algorithm.
 */
public class PasswordUtil {

    /**
     * Hashes the given password using the SHA-256 algorithm.
     * 
     * @param password the password to hash
     * @return the hashed password as a hexadecimal string
     */
    public static String hashPassword(String password) {
        try {
            // Get SHA-256 MessageDigest instance
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Hash the password
            byte[] hash = md.digest(password.getBytes());
            
            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                // Convert byte to hex and ensure two-digit format
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0'); // Pad single digits with a leading zero
                hexString.append(hex);
            }
            
            // Return the hashed password as a hexadecimal string
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Throw a runtime exception if the hashing algorithm is not available
            throw new RuntimeException(e);
        }
    }
}
