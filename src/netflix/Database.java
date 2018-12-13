package netflix;

import netflix.exceptions.UsernameTakenException;
import netflix.exceptions.NoSuchIDException;
import netflix.helpers.FakeData;
import netflix.helpers.FileParser;
import netflix.helpers.FileWriter;
import netflix.models.MediaList;
import netflix.models.User;
import netflix.models.media.Media;
import netflix.models.media.Movie;
import netflix.models.media.Series;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Database {
    private static HashMap<String, Media> mediaMap = new HashMap<>();
    private static List<User> users = new ArrayList<>();



    /**
     * Get a netflix.media.Media by its ID.
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
     * Get all media in the database as a list
     * @return List of all media
     */
    public static List<Media> getAllMedia() {
        if (mediaMap == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(mediaMap.values());
    }

    /**
     * Get all users in the database;
     * @return List of all users
     */
    public static List<User> getUsers() {
        return users;
    }

    public static List<MediaList> getFeaturedLists() {
        // TODO: Load this from a file
        return FakeData.generateFakeFeaturedLists(getAllMedia());
    }

    /**
     * Add a new user to the database
     * @param user The user to add
     */
    public static void addUser(User user) {
        for (User existingUser : users){
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

    private static HashMap<String, Media> fetchMedia() {
        List<Media> allMedia = new ArrayList<>();
        // Try to load the different types of media
        try {
            List<Movie> movies = FileParser.fetchMovies();
            allMedia.addAll(movies);
        } catch (IOException e) {
            System.err.println("Error loading movies: " + e.getMessage());
        }
        try {
            List<Series> series = FileParser.fetchSeries();
            allMedia.addAll(series);
        } catch (IOException e) {
            System.err.println("Error loading series: " + e.getMessage());
        }
        // Return Id/Media map
        HashMap<String, Media> newMediaMap = new HashMap<>();
        for(Media m : allMedia) {
            newMediaMap.put(m.getId(), m);
        }
        return newMediaMap;
    }


}
