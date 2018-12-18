package itutube.helpers;

import itutube.models.Credits;
import itutube.models.User;
import itutube.models.UserType;
import itutube.models.media.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Helper class to format lines of text into model-objects.
 */
public class FileParser {

    /**
     * Returns a list of users, generated from the user file.
     * @param mediaMap HashMap of all media in the database.
     * @return List of user objects.
     */
    public static List<User> fetchUsers(HashMap<String, Media> mediaMap) throws IOException {
        if (mediaMap == null) {
            throw new IllegalArgumentException("Map of media cannot be null.");
        }
        List<User> newUsers = new ArrayList<>();
        // Try to read the file
        String path = Paths.getDataFilePath(User.class.getSimpleName());
        List<String> lines = getLines(path);
        // Parse the lines in the file
        for(String line : lines) {
            String[] properties = line.split(";");
            String name = properties[0];
            UserType type = UserType.valueOf(properties[1]);
            ArrayList<Media> favoritesList = new ArrayList<>();
            if (properties.length == 3) {
                String[] favoriteIds = trimArray(properties[2].split(","));
                for (String id : favoriteIds) {
                    if (mediaMap.containsKey(id)) {
                        favoritesList.add(mediaMap.get(id));
                    }
                }
            }
            newUsers.add(new User(name, type, favoritesList));
        }
        return newUsers;
    }

    /**
     * Helper-function to trim white-space from strings inside an array.
     * @param toTrim An array of strings
     * @return array of trimmed strings
     */
    private static String[] trimArray(String[] toTrim) {
        for (int i = 0; i < toTrim.length; i++) {
            toTrim[i] = toTrim[i].trim();
        }
        return toTrim;
    }

    /**
     * Helper-function to format ratings from using commas to using dots (for parsing doubles directly from strings)
     *
     * @param rating rating string loaded from file, containing a "," (comma)
     * @return The same string, where the comma is replaced with a period.
     */
    private static String formatRating(String rating) {
        return rating.replace(",", ".");
    }


    /**
     * @param line one line of the text file
     * @return A movie generated from the line.
     */
    private static Movie lineToMovie(String line) {
        String[] properties = trimArray(line.split(";"));
        String id = properties[0];
        String name = properties[1];
        Date releaseDate = new Date(Integer.parseInt(properties[2]), 1, 1);
        List<String> categories = Arrays.asList(trimArray(properties[3].split(",")));
        double rating = Double.parseDouble(formatRating(properties[4]));
        String description = FakeData.getLoremIpsum(100);
        List<Credits> credits = FakeData.generateFakeCredits();
        int runtime = FakeData.generateFakeRuntime();

        return new Movie(id, name, description, releaseDate, categories, rating, credits, runtime);
    }


    /**
     * Passes text file of movies to lineToMovie and returns the constructed objects.
     * @return List of all movies in file.
     */
    public static List<Movie> fetchMovies() throws IOException {
        String path = Paths.getDataFilePath(Movie.class.getSimpleName());
        List<String> lines = getLines(path);
        List<Movie> movies = new ArrayList<>();
        for(String line : lines) {
            movies.add(lineToMovie(line));
        }
        return movies;
    }


    /**
     * Passes text file of series to lineToSeries and returns the constructed objects.
     * @return List of all series in file.
     */
    public static List<Series> fetchSeries() throws IOException {
        String path = Paths.getDataFilePath(Series.class.getSimpleName());
        List<String> lines = new ArrayList<String>(getLines(path));
        List<Series> series = new ArrayList<>();
        for(String line : lines) {
            series.add(lineToSeries(line));
        }
        return series;
    }


    /**
     * @param series        The series the episodes are part of
     * @param season        The season the episodes are part of
     * @param episodeAmount The amount of episodes there are to fetch from the season
     * @return An array of episodes from the provided season and series
     */
    private static List<Episode> fetchEpisodes(Series series, Season season, int episodeAmount) {
        ArrayList<Episode> episodes = new ArrayList<>();
        for (int i = 1; i <= episodeAmount; i++) {
            String id = FakeData.generateFakeId();
            String name = season.getName() + "E" + i;
            String description = FakeData.getLoremIpsum(200);
            Date releaseDate = season.getReleaseDate();
            List<String> categories = season.getCategories();
            double rating = FakeData.generateFakeRating();
            List<Credits> credits = season.getCredits();
            int runtime = FakeData.generateFakeRuntime();
            episodes.add(new Episode(id, name, description, releaseDate, categories, rating, credits, runtime, season, series));
        }
        return episodes;
    }


    /**
     * @param series The series the season is part of
     * @param line   The line of seasons and episodes
     * @return An array of all seasons in the given series
     */
    private static Season[] fetchSeasons(Series series, String line) {
        ArrayList<Season> seasons = new ArrayList<>();
        String[] seasonsString = trimArray(line.split(" "));

        for (String s : seasonsString) {
            int seasonNumber = Integer.parseInt(s.split("-")[0]);
            int episodeAmount = Integer.parseInt(s.split("-")[1]);
            String id = FakeData.generateFakeId();
            String name = series.getName() + " S" + seasonNumber;
            String description = FakeData.getLoremIpsum(150);

            Date firstSeasonDate = series.getReleaseDate();
            Calendar c = Calendar.getInstance();
            c.setTime(firstSeasonDate);
            c.add(Calendar.YEAR, seasonNumber - 1);
            Date currentSeasonDate = c.getTime();

            List<String> categories = series.getCategories();
            double rating = FakeData.generateFakeRating();
            List<Credits> credits = series.getCredits();
            Season season = new Season(id, name, description, currentSeasonDate, categories, rating, credits, series);


            List<Episode> episodes = fetchEpisodes(series, season, episodeAmount);
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
        Date releaseDate = new Date(Integer.parseInt(line.substring(0, 4)), 1, 1);
        Date endDate = releaseDate;
        if (line.length() == 9) {
            endDate = new Date(Integer.parseInt(line.substring(5, 9)), 1, 1);
        } else if (line.length() > 4) {
            endDate = null;
        }
        return new Date[]{releaseDate, endDate};
    }


    /**
     * @param line a line of text from the series file
     * @return a series created from the parameters in the line
     */
    private static Series lineToSeries(String line) {
        String[] properties = trimArray(line.split(";"));
        String id = properties[0];
        String name = properties[1];

        Date[] dates = getSeriesDates(properties[2]);
        Date releaseDate = dates[0];
        Date endDate = dates[1];

        List<String> categories = Arrays.asList(trimArray(properties[3].split(",")));
        double rating = Double.parseDouble(formatRating(properties[4]));

        String description = FakeData.getLoremIpsum(175);
        List<Credits> credits = FakeData.generateFakeCredits();
        Series series = new Series(id, name, description, releaseDate, endDate, categories, rating, credits);
        Season[] seasons = fetchSeasons(series, properties[5]);
        series.setSeasons(seasons);

        return series;
    }

    /**
     * Reads file with correct encoding (UTF-8).
     * @param path Path to the file to read lines from.
     * @return List of lines from the file.
     */
    private static List<String> getLines(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        File dir = new File(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dir), StandardCharsets.UTF_8));
        String nextLine;
        while((nextLine = reader.readLine()) != null) {
            lines.add(nextLine);
        }
        reader.close();
        return lines;
    }

}
