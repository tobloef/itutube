package itutube.models.media;

import itutube.models.Credits;

import java.util.Date;
import java.util.List;

/**
 * A season of a series
 */
public class Season extends Media {
    private Series series;
    private List<Episode> episodes;

    /**
     * @param id Id associated with the season.
     * @param name Name of the season.
     * @param description Description of the season.
     * @param releaseDate Release date of the season.
     * @param categories Categories held by the season.
     * @param rating Rating of the season.
     * @param credits Credits for the season.
     * @param series The series that the season is part of.
     */
    public Season(
            String id,
            String name,
            String description,
            Date releaseDate,
            List<String> categories,
            double rating,
            List<Credits> credits,
            Series series
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
        this.series = series;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public Series getSeries() {
        return series;
    }

    @Override
    public String getImageFileName() {
        return series.getImageFileName();
    }
}
