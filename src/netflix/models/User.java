package netflix.models;

import netflix.models.media.Media;

import java.util.ArrayList;

/**
 * A user for the logged in account
 */
public class User implements Saveable {
    private String name;
    private UserType type;
    private ArrayList<Media> favoritesList;

    /**
     * The constructor of a user if they have a pre-determined favourites list already
     * @param name The users name
     * @param type The users type. Admin, Adult or Child. Different usertypes can have different functions.
     * @param favoritesList The list over a users favourite media.
     */
    public User(String name, UserType type, ArrayList<Media> favoritesList) {
        this.name = name;
        this.type = type;
        this.favoritesList = favoritesList;
    }

    /**
     * Generates user without a pre-determined favourites list
     * @param name The users name
     * @param type The users type. Admin, Adult or Child. Different usertypes can have different functions.
     */
    public User(String name, UserType type) {
        this(name, type, new ArrayList<>());
    }

    /**
     * Gets a users name
     * @return Returns the users name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets a users usertype
     * @return Returns the users usertype
     */
    public UserType getType() {
        return type;
    }

    /**
     * Gets a users favourites list
     * @return Returns the users favourites list
     */
    public ArrayList<Media> getFavoritesList() {
        return favoritesList;
    }

    /**
     * Adds a media to a users favourite list
     * @param media The media to add to list
     */
    public void addMediaToFavorites(Media media) {
        if (favoritesList.stream().noneMatch(m -> m.getId().equals(media.getId()))) {
            favoritesList.add(media);
        }
    }

    /**
     * Removes a media from the users favourite list
     * @param media The media to remove from the list
     */
    public void removeMediaFromFavorites(Media media) {
        favoritesList.removeIf(m -> m.getId().equals(media.getId()));
    }

    /**
     * Gets the string to save to the database over users. This includes name, usertype and their favourites.
     * @return returns a string with name, usertype and their favourites
     */
    @Override
    public String getSaveString() {
        String[] idArray = new String[favoritesList.size()];
        for (int i = 0; i < favoritesList.size(); i++) {
            idArray[i] = favoritesList.get(i).getId();
        }
        String idString = String.join(",", idArray);
        return name + ";" + type + ";" + idString + ";";
    }
}
