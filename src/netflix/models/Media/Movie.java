package netflix.models.Media;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends VideoMedia {

    public Movie(String name, String description, Date releaseDate, ArrayList<String> categories, double rating, String imageFileName) {
        super(name, description, releaseDate, categories, rating, imageFileName);
    }
}
