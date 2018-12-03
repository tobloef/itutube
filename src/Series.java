import java.util.ArrayList;
import java.util.Date;

public class Series extends Media {

    private Season[] seasons;

    public Series(String id, String name, String description, Date releaseDate, String[] categories, double rating, Credits[] credits, String imageFileName, Season[] seasons) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName);
        this.seasons = seasons;
    }

    public Season[] getSeasons() {
        return seasons;
    }
}
