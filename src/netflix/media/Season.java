package netflix.media;

import netflix.models.Credits;

import java.util.ArrayList;
import java.util.Date;

public class Season extends Media {
    private Series series;
    private Episode[] episodes;

    public Season(String id, String name, String description, Date releaseDate, String[] categories, double rating, Credits[] credits, String imageFileName, Series series) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName);
        this.series = series;
    }

    public Episode[] getEpisodes() {
        return episodes;
    }

    public Series getSeries() {
        return series;
    }

    public void setEpisodes(Episode[] episodes) {
        this.episodes = episodes;
    }
}
