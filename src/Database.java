import netflix.models.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.*;

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

    public static Movie[] collectMovies() {
        Scanner s = new Scanner("movies.txt");
        ArrayList<Movie> movies = new ArrayList<Movie>();
        while(s.hasNext()) {
            String line = s.nextLine();
            String[] properties = line.split(";");
            String id = properties[0];
            String name = properties[1];
            String description = "Lorem Ipsum";
            Date releaseDate = new Date(Integer.parseInt(properties[2]), 1, 1);
            String[] categories = properties[3].split(", ");
            double rating = Double.parseDouble(properties[4]);
            String[] people = {"Michael Bay", "Stanley Kubrick"};
            Credits[] credits = {new Credits("Director", people)};
            String imageFileName = name + ".txt";
            Movie movie = new Movie(id, name, description, releaseDate, categories, rating, credits, imageFileName);
            movies.add(movie);
        }
        Movie[] movieArray = new Movie[movies.size()];
        return movies.toArray(movieArray);
    }

    public static Series[] collectSeries() {
        Scanner s = new Scanner("series.txt");
        ArrayList<Series> series = new ArrayList<Series>();
        while(s.hasNext()) {
            String line = s.nextLine();
            String[] properties = line.split(";");
            String id = properties[0];
            String name = properties[1];
            String description = "Lorem Ipsum";
            Date releaseDate = new Date(Integer.parseInt(properties[2].substring(0,3)), 1, 1);
            //doesn't take end date into account.
            String[] categories = properties[3].split(", ");
            double rating = Double.parseDouble(properties[4]);
            String[] people = {"Michael Bay", "Stanley Kubrick"};
            Credits[] credits = {new Credits("Director", people)};
            String imageFileName = name + ".txt";
            Season[] seasons = {};
            Series serie = new Series(id, name, description, releaseDate, categories, rating, credits, imageFileName, seasons);
            series.add(serie);
        }
        Series[] seriesArray = new Series[series.size()];
        return series.toArray(seriesArray);
    }
}
