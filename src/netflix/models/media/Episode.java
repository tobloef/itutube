package netflix.models.media;

import javafx.scene.Parent;
import netflix.Database;
import netflix.models.Credits;
import netflix.models.Viewable;
import netflix.views.content.infoview.EpisodeInfoContent;
import netflix.views.content.infoview.MovieInfoContent;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * An episode of a series
 */
public class Episode extends VideoMedia implements Viewable {
    private Season season;
    private Series series;

    public Episode(String id, String name, String description, Date releaseDate, String[] categories, double rating, Credits[] credits, String imageFileName, int runtime, Season season, Series series) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName, runtime);
        this.season = season;
        this.series = series;
    }

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
