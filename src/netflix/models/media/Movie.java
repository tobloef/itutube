package netflix.models.media;

import netflix.models.Credits;
import netflix.models.Saveable;

import java.util.Date;

/**
 * A movie
 */
public class Movie extends VideoMedia implements Saveable {

    public Movie(String id, String name, String description, Date releaseDate, String[] categories, double rating, Credits[] credits, String imageFileName, int runtime) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName, runtime);

    }

    public String getSaveString() {
        String categoryString = String.join(",", categories);
        String str = id + ";" + name + ";" + releaseDate.getYear() + ";" + categoryString + ";" + rating + ";";
        return str;
    }
}
