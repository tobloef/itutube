package netflix.models.Media;

import java.util.ArrayList;
import java.util.Date;

public class Series extends Media {
    private ArrayList<Season> seasons;

    public Series(String name, String description, Date releaseDate, ArrayList<String> categories, double rating, String imageFileName, ArrayList<Season> seasons) {
        super(name, description, releaseDate, categories, rating);
        this.seasons = seasons;
    }
}
