package netflix.helpers;

import netflix.models.media.Media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MediaListHelper {

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
        return results;
    }

    public static List<Media> findByCategory(String category, List<Media> list) {
        ArrayList<Media> results = new ArrayList<>();
        for(Media m : list) {
            if(Arrays.asList(m.getCategories()).contains(category)) {
                results.add(m);
            }
        }
        return results;
    }

    public static List<Media> sortByRating(List<Media> list){
        List<Media> results = new ArrayList<>(list);
        results.sort(new SortByRating());
        return results;
    }
}

