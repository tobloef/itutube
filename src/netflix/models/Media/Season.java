package netflix.models.Media;

import java.util.ArrayList;
import java.util.Date;

public class Season extends Media {
    private Series series;
    private ArrayList<Episode> episodes;

    public Season(String name, String description, Date releaseDate, ArrayList<String> categories, double rating, String imageFileName, Series series, ArrayList<Episode> episodes) {
        super(name, description, releaseDate, categories, rating);
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
