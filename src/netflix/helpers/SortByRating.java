package netflix.helpers;

import netflix.models.media.Media;

import java.util.Comparator;

public class SortByRating implements Comparator<Media> {

    public int compare(Media a, Media b) {
        return Double.compare(b.getRating(), a.getRating());
    }
}


