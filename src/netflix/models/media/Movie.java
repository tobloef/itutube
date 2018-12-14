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

    /**
     * @param id Id associated with the movie.
     * @param name Name of the movie.
     * @param description Description of the movie.
     * @param releaseDate Release date of the movie.
     * @param categories Categories held by the movie.
     * @param rating Rating of the movie.
     * @param credits Credits for the movie.
     * @param imageFileName Name of movie image file.
     * @param runtime The number of seconds the movie lasts for.
     */
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

    /**
     * The string that should be saved to text file when saving movies.
     * @return String containing id, name, release date, categories, and rating.
     */
    public String getSaveString() {
        String categoryString = String.join(",", categories);
        return id + ";" + name + ";" + releaseDate.getYear() + ";" + categoryString + ";" + rating + ";";
    }

    /**
     * Creates an info view for the object.
     * @return This movie's info view.
     */
    @Override
    public Parent createInfoView() {
        return new MovieInfoContent(this);
    }
}
