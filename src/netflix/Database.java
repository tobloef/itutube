package netflix;

import netflix.media.*;
import netflix.models.Credits;
import netflix.models.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
     * Get singleton instance of netflix.Database class
     * @return Instance of netflix.Database class
     */
    public static Database getInstance() {
        if (databaseInstance == null) {
            databaseInstance = new Database();
        }
        return databaseInstance;
    }

    /**
     * Get a netflix.media.Media by its ID.
     * @param id Id of the media
     * @return netflix.media.Media with the ID, otherwise null
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

    private static Movie lineToMovie(String line) {
        String[] properties = line.split(";");
        for(int i = 0; i < properties.length; i++) {
            properties[i] = properties[i].trim();
        }
        String id = properties[0];
        String name = properties[1];
        Date releaseDate = new Date(Integer.parseInt(properties[2]), 1, 1);
        String[] categories = properties[3].split(", ");
        double rating = Double.parseDouble(properties[4]);

        String description = FakeDataGenerator.generateFakeDescription();
        Credits[] credits = FakeDataGenerator.generateFakeCredits();
        String imageFileName = name + ".png";
        int runtime = 123;

        return new Movie(id, name, description, releaseDate, categories, rating, credits, imageFileName, runtime);
    }

    public static Movie[] fetchMovies() {
        Scanner s = new Scanner("movies.txt");
        ArrayList<Movie> movies = new ArrayList<>();
        while(s.hasNext()) {
            String line = s.nextLine();
            movies.add(lineToMovie(line));
        }
        Movie[] movieArray = new Movie[movies.size()];
        return movies.toArray(movieArray);
    }

    public static Episode[] fetchEpisodes(String seriesName, int season, int episodeAmount) {
        ArrayList<Episode> episodes = new ArrayList<>();
        for(int i = 1; i < episodeAmount; i++) {

            String id = FakeDataGenerator.generateFakeId();
            String episodeName = seriesName + " S" + season + "E" + i;
            double rating = FakeDataGenerator.generateFakeRating();
            Credits[] credits =;

            Series

            episodes.add(new Episode());
        }
    }

    private static Season[] fetchSeasons(Series series, String line) {
        ArrayList<Season> seasons = new ArrayList<>();
        String[] seasonsString = line.split(" ");
        for(String s : seasonsString) {

            int seasonNumber = Integer.parseInt(s.split("-")[0]);
            String id = FakeDataGenerator.generateFakeId();
            String name = series.getName() + " S" + seasonNumber;
            String description = FakeDataGenerator.generateFakeDescription();
            double rating = FakeDataGenerator.generateFakeRating();
            Credits[] credits = series.getCredits();
            String imageFileName = series.getImageFileName();
            Series seasonSeries = series;

            seasons.add(new Season(id, name, description, rating, credits, imageFileName, seasonSeries));
        }
    }

    private static Date[] getSeriesDates(String line) {
        Date releaseDate = new Date(Integer.parseInt(line.substring(0,3)), 1, 1);
        Date endDate = null;
        if(line.length() == 9) {
            endDate = new Date(Integer.parseInt(line.substring(5, 8)), 1, 1);
        }
        else if(line.length() == 4) {
            endDate = releaseDate;
        }
        return new Date[]{releaseDate, endDate};
    }

    private static Series lineToSeries(String line) {
        String[] properties = line.split(";");
        String id = properties[0];
        String name = properties[1];

        Date[] dates = getSeriesDates(properties[2]);
        Date releaseDate = dates[0];
        Date endDate = dates[1];

        String[] categories = properties[3].split(", ");
        double rating = Double.parseDouble(properties[4]);

        String description = FakeDataGenerator.generateFakeDescription();
        Credits[] credits = FakeDataGenerator.generateFakeCredits();
        String imageFileName = name + ".png";

        Series series = new Series(id, name, description, releaseDate, endDate, categories, rating, credits, imageFileName);

    }

    public static Series[] fetchSeries() {
        Scanner s = new Scanner("series.txt");
        ArrayList<Series> series = new ArrayList<>();
        while(s.hasNext()) {
            String line = s.nextLine();
            Series serie = lineToSeries(line);
            series.add(serie);
        }
        Series[] seriesArray = new Series[series.size()];
        return series.toArray(seriesArray);
    }


}
