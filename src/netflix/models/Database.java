package netflix.models;

import netflix.models.Media.Media;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;

public final class Database {
    private static Database databaseInstance = null;

    private static HashMap<String, Media> media;
    private static ArrayList<User> users;

    private Database() {
        media = new HashMap<String, Media>();
        users = new ArrayList<User>();
    }

    /**
     * Get singleton instance of Database class
     * @return Instance of Database class
     */
    public static Database getInstance() {
        if (databaseInstance == null) {
            databaseInstance = new Database();
        }
        return databaseInstance;
    }

    /**
     * Get a Media by its ID.
     * @param id Id of the media
     * @return Media with the ID, otherwise null
     */
    public static Media getMediaById(String id) {
        throw new NotImplementedException();
    }

    /**
     * Get all media in the database as a list
     * @return List of all media
     */
    public static ArrayList<Media> getMediaList() {
        return new ArrayList<Media>(media.values());
    }

    /**
     * Get all users in the database;
     * @return List of all users
     */
    public static ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Add a new user to the database
     * @param user The user to add
     */
    public static void addUser(User user) {
        throw new NotImplementedException();
    }

    /**
     * Save the database to the disk.
     */
    public static void save() {
        throw new NotImplementedException();
    }

    /**
     * Load the database from the disk.
     */
    public static void load() {
        throw new NotImplementedException();
    }
}
