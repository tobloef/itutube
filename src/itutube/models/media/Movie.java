package itutube.models.media;

import itutube.Helpers.FakeData;
import itutube.models.Credits;
import itutube.models.Serializable;
import itutube.models.Viewable;
import itutube.views.pages.content.MovieInfoContent;
import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static itutube.Helpers.FileParser.trimArray;

/**
 * A movie
 */
public class Movie extends VideoMedia implements Serializable, Viewable {

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

    public Movie() {
        super();
    }

    /**
     * The string that should be saved to text file when saving movies.
     * @return String containing id, name, release date, categories, and rating.
     */
    public String getString() {
        String categoryString = String.join(",", categories);
        return id + ";" + name + ";" + releaseDate.getYear() + ";" + categoryString + ";" + rating + ";";
    }

    @Override
    public void loadFromString(String string) {
        String[] properties = trimArray(string.split(";"));
        this.id = properties[0];
        this.name = properties[1];
        this.releaseDate = new Date(Integer.parseInt(properties[2]), 1, 1);
        this.categories = new ArrayList<>(Arrays.asList(trimArray(properties[3].split(","))));
        this.rating = Double.parseDouble((properties[4].replace(",", ".")));
        this.description = FakeData.getLoremIpsum(100);
        this.credits = FakeData.generateFakeCredits();
        this.runtimeSeconds = FakeData.generateFakeRuntime();
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
