package itutube.models.media;

import itutube.controllers.FakeData;
import itutube.models.Credits;
import itutube.models.Serializable;
import itutube.models.Viewable;
import itutube.views.pages.content.SeriesInfoContent;
import javafx.scene.Parent;

import java.util.*;

import static itutube.controllers.FileParser.trimArray;

/**
 * A series
 */
public class Series extends Media implements Serializable, Viewable {
    private Date endDate;
    private List<Season> seasons;

    /**
     * @param id Id associated with the series.
     * @param name Name of the series.
     * @param description Description of the series.
     * @param releaseDate Release date of the series.
     * @param endDate End date of the series.
     * @param categories Categories held by the series.
     * @param rating Rating of the series.
     * @param credits Credits for the series.
     */
    public Series(
            String id,
            String name,
            String description,
            Date releaseDate,
            Date endDate,
            List<String> categories,
            double rating,
            List<Credits> credits
    ) {
        super(
                id,
                name,
                description,
                releaseDate,
                categories,
                rating,
                credits
        );
        this.endDate = endDate;
    }

    public Series() {
        super();
    }

    /**
     * The string that should be saved to text file when saving series.
     * @return String containing id, name, release- and end-date, categories, rating and seasons.
     */
    public String getString() {
        StringBuilder seasonString = new StringBuilder();
        for (int i = 1; i <= seasons.size(); i++) {
            seasonString.append(i).append("-").append(seasons.get(i - 1).getEpisodes().size()).append(" ");
        }
        String categoryString = String.join(",", categories);
        String str = id + ";" + name + ";" + releaseDate.getYear();
        if (endDate != releaseDate) {
            str += "-";

            if (endDate != null) {
                str += endDate.getYear();
            }
        }
        str += ";" + categoryString + ";" + rating + ";" + seasonString + ";";
        return str;
    }

    @Override
    public void loadFromString(String string) {
        String[] properties = trimArray(string.split(";"));
        this.id = properties[0];
        this.name = properties[1];

        Date[] dates = getSeriesDates(properties[2]);
        this.releaseDate = dates[0];
        this.endDate = dates[1];

        this.categories = new ArrayList<String>(Arrays.asList(trimArray(properties[3].split(","))));
        this.rating = Double.parseDouble(properties[4].replace(",", "."));

        this.description = FakeData.getLoremIpsum(175);
        this.credits = FakeData.generateFakeCredits();
        this.seasons = createSeasons(this, properties[5]);
    }

    /**
     * @param series The series the season is part of
     * @param line   The line of seasons and episodes
     * @return A list of all seasons in the given series
     */
    private static List<Season> createSeasons(Series series, String line) {
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


            List<Episode> episodes = createEpisodes(series, season, episodeAmount);
            season.setEpisodes(episodes);
            seasons.add(season);
        }
        return seasons;
    }

    /**
     * @param series        The series the episodes are part of
     * @param season        The season the episodes are part of
     * @param episodeAmount The amount of episodes there are to fetch from the season
     * @return A list of episodes from the provided season and series
     */
    private static List<Episode> createEpisodes(Series series, Season season, int episodeAmount) {
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

    public List<Season> getSeasons() {
        return seasons;
    }

    public Date getEndDate() {
        return endDate;
    }

    /**
     * Creates an info view for the object.
     * @return This series's info view.
     */
    @Override
    public Parent createInfoView() {
        return new SeriesInfoContent(this);
    }
}
