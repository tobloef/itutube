package netflix.exceptions;

public class UsernameTakenException extends RuntimeException{
    private String username;

    public UsernameTakenException(String username) {
        super("*** username taken: ");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return super.getMessage() + username;
    }
}
