package netflix.models;

import java.util.ArrayList;

/**
 * A user for the logged in account
 */
public class User {
    private String name;
    private UserType type;
    private ArrayList<MediaList> mediaLists;

    public User(String name, UserType type, ArrayList<MediaList> mediaLists) {
        this.name = name;
        this.type = type;
        this.mediaLists = mediaLists;
    }

    public User(String name, UserType type) {
        this(name, type, new ArrayList<MediaList>());
    }

    public String getName() {
        return name;
    }

    public UserType getType() {
        return type;
    }

    public ArrayList<MediaList> getMediaLists() {
        return mediaLists;
    }
}
