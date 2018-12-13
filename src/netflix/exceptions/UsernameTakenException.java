package netflix.exceptions;

public class UsernameTakenException extends RuntimeException {
    private String username;

    public UsernameTakenException(String username) {
        super("Username " + username + " already taken.");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
