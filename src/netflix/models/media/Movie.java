package netflix.models.media;

import javafx.scene.Parent;
import netflix.models.Credits;
import netflix.models.Saveable;
import netflix.models.Viewable;
import netflix.views.pages.content.MovieInfoContent;

import java.util.Date;

/**
 * A movie
 */
public class Movie extends VideoMedia implements Saveable, Viewable {

    public Movie(
            String id,
            String name,
            String description,
            Date releaseDate,
            String[] categories,
            double rating,
            Credits[] credits,
            String imageFileName,
            int runtime
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

    }

    public String getSaveString() {
        String categoryString = String.join(",", categories);
        return id + ";" + name + ";" + releaseDate.getYear() + ";" + categoryString + ";" + rating + ";";
    }

    @Override
    public Parent createInfoView() {
        return new MovieInfoContent(this);
    }
}
