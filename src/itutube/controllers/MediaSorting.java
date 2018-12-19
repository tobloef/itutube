package itutube.controllers;

import itutube.models.media.Media;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Ways of sorting media, to be displayed.
 */
public class MediaSorting {

    /**
     * Searches given list for any media which name contains the search query.
     * @param query String to filter media by.
     * @param list List of media to search through.
     * @return All results that match the query.
     */
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

    /**
     * Sorts list of media by rating.
     * @param list List of media to sort.
     * @return List of media, sorted by rating.
     */
    public static List<Media> sortByRating(List<Media> list) {
        List<Media> results = new ArrayList<>(list);
        results.sort(new SortByRating());
        return results;
    }

    /**
     * Gets list of media of matching type, from list of media.
     * @param type Type of media to get.
     * @param list List of media to pick from.
     * @return List of media of requested type.
     */
    public static List<Media> findByType(Class<? extends Media> type, List<Media> list) {
        List<Media> results = new ArrayList<>();
        for (Media m : list) {
            if (m.getClass() == type) {
                results.add(m);
            }
        }
        return results;
    }

    /**
     * Comparator class to sort by rating.
     */
    static class SortByRating implements Comparator<Media> {
        public int compare(Media a, Media b) {
            return Double.compare(b.getRating(), a.getRating());
        }
    }
}