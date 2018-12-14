package netflix.exceptions;
/**
 * Exception thrown when a username already exists in the database.
 */
public class UsernameTakenException extends RuntimeException{
    private String username;

    public UsernameTakenException(String username) {
        super("Username " + username + " already taken.");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
