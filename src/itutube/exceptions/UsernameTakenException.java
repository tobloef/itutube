package itutube.exceptions;
/**
 * Exception thrown when a username already exists in the database.
 */
public class UsernameTakenException extends Exception{
    private String username;

    /**
     * @param username Inputted username that does not exist
     */
    public UsernameTakenException(String username) {
        super("Username " + username + " already taken.");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
