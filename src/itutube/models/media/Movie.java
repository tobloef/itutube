package itutube.models.media;

import itutube.models.Credits;
import itutube.models.Saveable;
import itutube.models.Viewable;
import itutube.views.pages.content.MovieInfoContent;
import javafx.scene.Parent;

import java.util.Date;
import java.util.List;

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
     * @param runtimeSeconds The number of seconds the movie lasts for.
     */
    public Movie(
            String id,
            String name,
            String description,
            Date releaseDate,
            List<String> categories,
            double rating,
            List<Credits> credits,
            int runtimeSeconds
    ) {
        super(
                id,
                name,
                description,
                releaseDate,
                categories,
                rating,
                credits,
                runtimeSeconds
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
