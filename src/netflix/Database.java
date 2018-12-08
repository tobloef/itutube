package netflix;

import netflix.helpers.FakeDataHelper;
import netflix.models.Credits;
import netflix.models.Saveable;
import netflix.models.User;
import netflix.models.UserType;
import netflix.models.media.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        // TODO
        for(Media m : getMediaList()) {
            if(m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Get all media in the database as a list
     * @return List of all media
     */
    public static ArrayList<Media> getMediaList() {
        return new ArrayList<>(media.values());
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
        boolean userAdded = false;
        for (User m : users){
            if(!users.contains(m)){  //checks if user already exists before adding to list
                    users.add(user);
                    userAdded = true;
            }}
        if(!userAdded){
            System.out.println("User \"" + user.getName() + "\" already exists."); //DEBUG CODE
        }
    }

    /**
     * Save the database to the disk.
     */
    public static void save() {
        // TODO - save user database

        saveMedia();
        saveUsers();

    }


    /**
     * Saves the list of media to the disk.
     */
    private static void saveMedia() {
        HashMap<String, ArrayList<Saveable>> mediaToStore = new HashMap<>();
        for(Media m : getMediaList()) {
            String typeName = m.getClass().getSimpleName();
            if(!mediaToStore.containsKey(typeName)) {
                mediaToStore.put(typeName, new ArrayList<>());
            }
            ArrayList<Saveable> mediaList = mediaToStore.get(typeName);
            mediaList.add((Saveable) m);
            mediaToStore.put(typeName, mediaList);
        }

        for(Map.Entry<String, ArrayList<Saveable>> entry : mediaToStore.entrySet()) {
            Path mediaStorage = Paths.get("./src/" + entry.getKey() + "-saved.txt");
            ArrayList<String> lines = new ArrayList<>();
            for(Saveable m : entry.getValue()) {
                lines.add(m.getSaveString());
            }
            try {
                Files.write(mediaStorage, lines);
            }
            catch (IOException e) {
                System.out.println("Can't write to file:" + e.getMessage());
            }
        }
    }


    private static void saveUsers() {
        Path userStorage = Paths.get("./src/users.txt");
        ArrayList<String> lines = new ArrayList<>();
        for(User u : users) {
            ArrayList<Media> favoritesList = u.getFavoritesList();
            String[] idArray = new String[favoritesList.size()];
            for(int i = 0; i < favoritesList.size(); i++) {
                idArray[i] = favoritesList.get(i).getId();
            }
            String idString = String.join(",", idArray);
            lines.add(u.getName() + ";" + u.getType() + ";" + idString + ";");
        }
        try {
            Files.write(userStorage, lines);
        }
        catch (IOException e) {
            System.out.println("Can't write to file:" + e.getMessage());
        }

    }


    /**
     * Load the database from the disk.
     */
    public static void load() {
        try {
            loadMedia();
            loadUsers();
        }
        catch (FileNotFoundException e) {
            System.out.println("File(s) not found: " + e.getMessage());
        }
    }


    private static void loadMedia() throws FileNotFoundException {
        HashMap<String, Media> db = new HashMap<>();

        Movie[] movies;
        Series[] series;

        movies = fetchMovies();
        series = fetchSeries();

        ArrayList<Media> allMedia = new ArrayList<>(Arrays.asList(movies));
        allMedia.addAll(Arrays.asList(series));

        for(Media m : allMedia) {
            db.put(m.getId(), m);
        }
        media = db;
    }


    private static void loadUsers() throws FileNotFoundException {
        ArrayList<User> db = new ArrayList<>();

        File usersFile = new File("./src/users.txt");
        Scanner s = new Scanner(usersFile);

        while(s.hasNext()) {
            String userLine = s.nextLine();
            String[] properties = userLine.split(";");
            String name = properties[0];
            UserType type = UserType.valueOf(properties[1]);
            ArrayList<Media> favoritesList = new ArrayList<>();
            String[] favoriteIds = trimArray(properties[2].split(","));
            for(String id : favoriteIds) {
                favoritesList.add(getMediaById(id));
            }
            db.add(new User(name, type, favoritesList));
        }
        users = db;
    }

    /**
     * Helper-function to trim white-space from strings inside an array.
     * @param toTrim An array of strings
     * @return array of trimmed strings
     */
    private static String[] trimArray(String[] toTrim) {
        for(int i = 0; i < toTrim.length; i++) {
            toTrim[i] = toTrim[i].trim();
        }
        return toTrim;
    }

    /**
     * Helper-function to format ratings from using commas to using dots (for parsing doubles directly from strings)
     * @param rating rating string loaded from file, containing a "," (comma)
     * @return The same string, where the comma is replaced with a period.
     */
    private static String formatRating(String rating) {
        rating = rating.replace(",", ".");
        return rating;
    }


    /**
     * @param line one line of the textfile
     * @return A movie generated from the line.
     */
    private static Movie lineToMovie(String line) {
        String[] properties = trimArray(line.split(";"));
        String id = properties[0];
        String name = properties[1];
        Date releaseDate = new Date(Integer.parseInt(properties[2]), 1, 1);
        String[] categories = properties[3].split(", ");
        double rating = Double.parseDouble(formatRating(properties[4]));

        String description = FakeDataHelper.getLoremIpsum(100);
        Credits[] credits = FakeDataHelper.generateFakeCredits();
        String imageFileName = name + ".png";
        int runtime = FakeDataHelper.generateFakeRuntime();

        return new Movie(id, name, description, releaseDate, categories, rating, credits, imageFileName, runtime);
    }


    /**
     * @return An array of the movies generated by lineToMovie()
     */
    private static Movie[] fetchMovies() throws FileNotFoundException {
        File moviesFile = new File("./src/movies.txt");
        Scanner s = new Scanner(moviesFile);
        ArrayList<Movie> movies = new ArrayList<>();
        while(s.hasNext()) {
            String line = s.nextLine();
            movies.add(lineToMovie(line));
        }
        Movie[] movieArray = new Movie[movies.size()];
        return movies.toArray(movieArray);
    }


    /**
     * @return all lines from the file in an array of series
     */
    private static Series[] fetchSeries() throws FileNotFoundException {
        File seriesFile = new File("./src/series.txt");
        Scanner s = new Scanner(seriesFile);
        ArrayList<Series> seriesList = new ArrayList<>();
        while(s.hasNext()) {
            String line = s.nextLine();
            Series series = lineToSeries(line);
            seriesList.add(series);
        }
        Series[] seriesArray = new Series[seriesList.size()];
        return seriesList.toArray(seriesArray);
    }


    /**
     * @param series The series the episodes are part of
     * @param season The season the episodes are part of
     * @param episodeAmount The amount of episodes there are to fetch from the season
     * @return An array of episodes from the provided season and series
     */
    private static Episode[] fetchEpisodes(Series series, Season season, int episodeAmount) {
        ArrayList<Episode> episodes = new ArrayList<>();
        for(int i = 1; i <= episodeAmount; i++) {
            String id = FakeDataHelper.generateFakeId();
            String name = season.getName() + "E" + i;
            String description = FakeDataHelper.getLoremIpsum(200);
            Date releaseDate = season.getReleaseDate();
            String[] categories = season.getCategories();
            double rating = FakeDataHelper.generateFakeRating();
            Credits[] credits = season.getCredits();
            String imageFileName = season.getImageFileName();
            int runtime = FakeDataHelper.generateFakeRuntime();

            episodes.add(new Episode(id, name, description, releaseDate, categories, rating, credits, imageFileName, runtime, season, series));
        }
        Episode[] episodeArray = new Episode[episodes.size()];
        return episodes.toArray(episodeArray);
    }


    /**
     * @param series The series the season is part of
     * @param line The line of seasons and episodes (last parameter in each line of series.txt)
     * @return An array of all seasons in the given series
     */
    private static Season[] fetchSeasons(Series series, String line) {
        ArrayList<Season> seasons = new ArrayList<>();
        String[] seasonsString = trimArray(line.split(","));

        for(String s : seasonsString) {
            int seasonNumber = Integer.parseInt(s.split("-")[0]);
            int episodeAmount = Integer.parseInt(s.split("-")[1]);
            String id = FakeDataHelper.generateFakeId();
            String name = series.getName() + " S" + seasonNumber;
            String description = FakeDataHelper.getLoremIpsum(150);

            Date firstSeasonDate = series.getReleaseDate();
            Calendar c = Calendar.getInstance();
            c.setTime(firstSeasonDate);
            c.add(Calendar.YEAR, seasonNumber-1);
            Date currentSeasonDate = c.getTime();

            String[] categories = series.getCategories();
            double rating = FakeDataHelper.generateFakeRating();
            Credits[] credits = series.getCredits();
            String imageFileName = series.getImageFileName();

            Season season = new Season(id, name, description, currentSeasonDate, categories, rating, credits, imageFileName, series);


            Episode[] episodes = fetchEpisodes(series, season, episodeAmount);
            season.setEpisodes(episodes);
            seasons.add(season);
        }
        Season[] seasonArray = new Season[seasons.size()];
        return seasons.toArray(seasonArray);
    }


    /**
     * @param line The start-date and end-date (if it exists) as a string
     * @return An array of the start-date and end-date as Date-objects. If there is no '-' after the first date, the end-date will be the same. Else, the end date will be null (if the show is ongoing).
     */
    private static Date[] getSeriesDates(String line) {
        Date releaseDate = new Date(Integer.parseInt(line.substring(0,4)), 1, 1);
        Date endDate = releaseDate;
        if(line.length() == 9) {
            endDate = new Date(Integer.parseInt(line.substring(5, 9)), 1, 1);
        }
        else if(line.length() > 4) {
            endDate = null;
        }
        return new Date[]{releaseDate, endDate};
    }


    /**
     * @param line a line of text rom the file series.txt
     * @return a series created from the parameters in the line
     */
    private static Series lineToSeries(String line) {
        String[] properties = trimArray(line.split(";"));
        String id = properties[0];
        String name = properties[1];

        Date[] dates = getSeriesDates(properties[2]);
        Date releaseDate = dates[0];
        Date endDate = dates[1];

        String[] categories = properties[3].split(",");
        double rating = Double.parseDouble(formatRating(properties[4]));

        String description = FakeDataHelper.getLoremIpsum(175);
        Credits[] credits = FakeDataHelper.generateFakeCredits();
        String imageFileName = name + ".png";

        Series series = new Series(id, name, description, releaseDate, endDate, categories, rating, credits, imageFileName);
        Season[] seasons = fetchSeasons(series, properties[5]);
        series.setSeasons(seasons);

        return series;
    }


}
