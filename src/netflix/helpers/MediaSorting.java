package netflix.helpers;

import netflix.Main;
import netflix.models.ImageButtonInfo;
import netflix.models.Viewable;
import netflix.models.media.Media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MediaSorting {

    public static List<Media> findBySearch(String query, List<Media> list) {
        // Change to lower case for later comparision
        query = query.toLowerCase();
        List<Media> results = new ArrayList<>();
        for (Media media : list) {
            String name = media.getName().toLowerCase();
            if (name.startsWith(query)) {
                // Add the item to the top of the results
                results.add(0, media);
                continue;
            }
            if ((name.contains(query))) {
                results.add(media);
            }
        }
        // Convert results to array
        return results;
    }

    public static List<Media> sortByRating(List<Media> list) {
        List<Media> results = new ArrayList<>(list);
        results.sort(new SortByRating());
        return results;
    }

    public static List<Media> findByType(Class<? extends Media> type, List<Media> list) {
        List<Media> results = new ArrayList<>();
        for (Media m : list) {
            if (m.getClass() == type) {
                results.add(m);
            }
        }
        return results;
    }

    static class SortByRating implements Comparator<Media> {
        public int compare(Media a, Media b) {
            return Double.compare(b.getRating(), a.getRating());
        }
    }
}