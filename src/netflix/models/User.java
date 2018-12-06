package netflix.models;

import netflix.models.media.Media;
import java.util.ArrayList;

/**
 * A user for the logged in account
 */
public class User {
    private String name;
    private UserType type;
    private ArrayList<Media> favoritesList;

    public User(String name, UserType type, ArrayList<Media> favoritesList) {
        this.name = name;
        this.type = type;
        this.favoritesList = favoritesList;
    }

    public User(String name, UserType type) {
        this(name, type, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public UserType getType() {
        return type;
    }

    public ArrayList<Media> getFavoritesList() {
        return favoritesList;
    }
}
