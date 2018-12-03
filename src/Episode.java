import java.util.ArrayList;
import java.util.Date;

public class Episode extends VideoMedia {
    private Season season;
    private Series series;

    public Episode(String id, String name, String description, Date releaseDate, ArrayList<String> categories, double rating, ArrayList<Credits> credits, String imageFileName, Season season, Series series) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName);
        this.season = season;
        this.series = series;
    }

    public Season getSeason() {
        return season;
    }

    public Series getSeries() {
        return series;
    }
}
