import java.util.ArrayList;
import java.util.Date;

public class Season extends Media {
    private Series series;
    private ArrayList<Episode> episodes;

    public Season(String id, String name, String description, Date releaseDate, String[] categories, double rating, Credits[] credits, String imageFileName, Series series, ArrayList<Episode> episodes) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName);
        this.series = series;
        this.episodes = episodes;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public Series getSeries() {
        return series;
    }
}
