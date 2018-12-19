package itutube;

import itutube.exceptions.DatabaseIOException;
import itutube.exceptions.NoSuchIDException;
import itutube.exceptions.UserNotFoundException;
import itutube.exceptions.UsernameTakenException;
import itutube.helpers.FakeData;
import itutube.helpers.FileParser;
import itutube.helpers.FileWriter;
import itutube.models.CheckedSupplier;
import itutube.models.MediaList;
import itutube.models.User;
import itutube.models.UserType;
import itutube.models.media.Media;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Database object for the entire application.
 */
public final class Database {
    /**
     * List of methods for loading media into the database from list.
     * You have to add a new method to this list when you need to load a new type of media.
     */
    private static final List<CheckedSupplier<List<? extends Media>, IOException>> mediaLoaders = new ArrayList<>(Arrays.asList(
            FileParser::fetchMovies,
            FileParser::fetchSeries
    ));

    private static HashMap<String, Media> mediaMap = new HashMap<>();
    private static List<User> users = new ArrayList<>();

    /**
     * Get a Media by its ID.
     *
     * @param id Id of the media
     * @return Media with the ID, otherwise null
     */
    public static Media getMediaById(String id) {
        if (mediaMap.containsKey(id)) {
            return mediaMap.get(id);
        }
        throw new NoSuchIDException(id);
    }

    /**
     * Get a list of all media in the database appropriate to the given user type.
     *
     * @param userType Type of user to get media for, used for filtering.
     * @return List of user-appropriate media
     */
    public static List<Media> getAllMedia(UserType userType) {
        if (userType == UserType.Child) {
            return getAllMedia().stream()
                    .filter(m -> m.getCategories().contains("Family"))
                    .collect(Collectors.toList());
        }
        return getAllMedia();
    }

    /**
     * Get all media in the database as a list
     * @return List of all media
     */
    private static List<Media> getAllMedia() {
        if (mediaMap == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(mediaMap.values());
    }

    /**
     * Get all users in the database;
     *
     * @return List of all users
     */
    public static List<User> getUsers() {
        return users;
    }

    /**
     * Get a list of the featured lists for the front page.
     *
     * @param userType Type of user to get featured lists for.
     *
     * @return List of featured media lists
     */
    public static List<MediaList> getFeaturedLists(UserType userType) {
        // TODO: Load this from a file
        return FakeData.generateFakeFeaturedLists(getAllMedia(userType));
    }

    /**
     * Add a new user to the database
     *
     * @param user The user to add
     *
     * @throws UsernameTakenException if the user's name has already been taken.
     */
    public static void addUser(User user) throws UsernameTakenException {
        for (User existingUser : users) {
            // Checks if user already exists before adding to list
            if (existingUser.getName().equals(user.getName())) {
                throw new UsernameTakenException(user.getName());
            }
        }
        users.add(user);
    }

    /**
     * Removes a user from the database, which name matches the parameter's name
     * @param user The user to remove
     */
    public static void removeUser(User user) {
        boolean userRemove = users.removeIf(u -> u.getName().equals(user.getName()));
        if (!userRemove) {
            throw new UserNotFoundException("Tried to remove a user that was not in the database.", user);
        }
    }

    /**
     * Save the database to the disk.
     *
     * @throws DatabaseIOException if the database couldn't be saved to disk
     */
    public static void save() throws DatabaseIOException {
        FileWriter.saveMedia(getAllMedia());
        FileWriter.saveUsers(getUsers());
    }

    /**
     * Load the database from the disk.
     *
     * @throws DatabaseIOException if the database couldn't be loaded from disk
     */
    public static void load() throws DatabaseIOException {
        mediaMap = fetchMedia();
        try {
            users = FileParser.fetchUsers(mediaMap);
        } catch (IOException e) {
            throw new DatabaseIOException("Error loading users.", e);
        }
    }

    /**
     * Get a list of all media in the database
     *
     * @return List of all media
     */
    private static HashMap<String, Media> fetchMedia() throws DatabaseIOException {
        List<Media> allMedia = new ArrayList<>();
        for (CheckedSupplier<List<? extends Media>, IOException> loader : mediaLoaders) {
            try {
                List<? extends Media> media = loader.get();
                allMedia.addAll(media);
            } catch (IOException e) {
                String className = loader.getClass().getSimpleName();
                throw new DatabaseIOException("Error loading media of type " + className + ".", e);
            }
        }
        // Return Id/Media map
        HashMap<String, Media> newMediaMap = new HashMap<>();
        for (Media m : allMedia) {
            newMediaMap.put(m.getId(), m);
        }
        return newMediaMap;
    }

    public static void setMediaMap(HashMap<String, Media> mediaMap) {
        Database.mediaMap = mediaMap;
    }

    public static void setUsers(List<User> users) {
        Database.users = users;
    }
}
