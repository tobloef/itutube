package netflix.media;

import netflix.models.Credits;

import java.util.Date;

public class Episode extends VideoMedia {
    private Season season;
    private Series series;

    public Episode(String id, String name, String description, Date releaseDate, String[] categories, double rating, Credits[] credits, String imageFileName, int runtime, Season season, Series series) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName, runtime);
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
