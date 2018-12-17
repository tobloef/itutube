package netflix;

import netflix.exceptions.NoSuchIDException;
import netflix.exceptions.UsernameTakenException;
import netflix.helpers.FakeData;
import netflix.helpers.FileParser;
import netflix.helpers.FileWriter;
import netflix.models.MediaList;
import netflix.models.User;
import netflix.models.UserType;
import netflix.models.media.Media;
import netflix.models.media.Movie;
import netflix.models.media.Series;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Database object for the entire application.
 */
public final class Database {
    private static HashMap<String, Media> mediaMap = new HashMap<>();
    private static List<User> users = new ArrayList<>();

    /**
     * Get a netflix.media.Media by its ID.
     *
     * @param id Id of the media
     * @return netflix.media.Media with the ID, otherwise null
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
     * Get a list of the featured lists for the front page
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
     */
    public static void addUser(User user) {
        for (User existingUser : users) {
            // Checks if user already exists before adding to list
            if (existingUser.getName().equals(user.getName())) {
                throw new UsernameTakenException(user.getName());
            }
        }
        users.add(user);
    }

    /**
     * Save the database to the disk.
     */
    public static void save() {
        FileWriter.saveMedia(getAllMedia());
        FileWriter.saveUsers(getUsers());
    }

    /**
     * Load the database from the disk.
     */
    public static void load() {
        mediaMap = fetchMedia();
        try {
            users = FileParser.fetchUsers(mediaMap);
        } catch (IOException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
    }

    /**
     * Get a list of all media in the database
     *
     * @return List of all media
     */
    private static HashMap<String, Media> fetchMedia() {
        List<Media> allMedia = new ArrayList<>();
        // Try to load the different types of media
        List<Movie> movies = FileParser.fetchMovies();
        allMedia.addAll(movies);

        List<Series> series = FileParser.fetchSeries();
        allMedia.addAll(series);
        // Return Id/Media map
        HashMap<String, Media> newMediaMap = new HashMap<>();
        for (Media m : allMedia) {
            newMediaMap.put(m.getId(), m);
        }
        return newMediaMap;
    }


}
