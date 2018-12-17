package itutube.models.media;

import javafx.scene.Parent;
import itutube.models.Credits;
import itutube.models.Viewable;
import itutube.views.pages.content.EpisodeInfoContent;

import java.util.Date;
import java.util.List;

/**
 * An episode of a series
 */
public class Episode extends VideoMedia implements Viewable {
    private Season season;
    private Series series;

    /**
     * @param id Id associated with the episode.
     * @param name Name of the episode.
     * @param description Description of the episode.
     * @param releaseDate Release date of the episode.
     * @param categories Categories held by the episode.
     * @param rating Rating of the episode.
     * @param credits Credits for the episode.
     * @param imageFileName Name of episode image file.
     * @param runtime Number of seconds the episode lasts for.
     * @param season The season containing this episode.
     * @param series The series the episode is part of.
     */
    public Episode(
            String id,
            String name,
            String description,
            Date releaseDate,
            List<String> categories,
            double rating,
            List<Credits> credits,
            String imageFileName,
            int runtime,
            Season season,
            Series series
    ) {
        super(
                id,
                name,
                description,
                releaseDate,
                categories,
                rating,
                credits,
                imageFileName,
                runtime
        );
        this.season = season;
        this.series = series;
    }

    /**
     * Creates an info view for the object.
     * @return This episodes's info view.
     */
    @Override
    public Parent createInfoView() {
        return new EpisodeInfoContent(this);
    }

    public Season getSeason() {
        return season;
    }

    public Series getSeries() {
        return series;
    }
}