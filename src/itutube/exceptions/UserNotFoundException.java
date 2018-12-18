package itutube.exceptions;

import itutube.models.User;

public class UserNotFoundException extends RuntimeException {
    private User user;

    public UserNotFoundException(String message, User user) {
        super(message);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
