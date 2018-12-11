package netflix.models.media;

import netflix.models.Credits;

import java.util.Date;
import java.util.List;

/**
 * A season of a series
 */
public class Season extends Media {
    private Series series;
    private List<Episode> episodes;

    public Season(String id, String name, String description, Date releaseDate, String[] categories, double rating, Credits[] credits, String imageFileName, Series series) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName);
        this.series = series;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public Series getSeries() {
        return series;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}
