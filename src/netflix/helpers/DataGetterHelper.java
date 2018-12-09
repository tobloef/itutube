package netflix.helpers;


import netflix.Database;
import netflix.models.media.Media;

import javax.xml.crypto.Data;
import java.util.*;

public class DataGetterHelper {

    public Media[] searchInMedia(String name) { //set as void for debugging
        ArrayList<Media> results = new ArrayList<>();
        for (Media m : Database.getMediaList()) {
            if (m.getName().toLowerCase().startsWith(name.toLowerCase())) { //checks if it starts with search query. toLowercase so its not case sensitive
                results.add(m);
            }
        }
        Media[] resultArray = new Media[results.size()];
        return results.toArray(resultArray);
    }

    public Media[] getMediaListByCategory(String category, Media[] list) {
        ArrayList<Media> media = new ArrayList<>();
        for(Media m : list) {
            if(Arrays.asList(m.getCategories()).contains(category)) {
                media.add(m);
            }
        }
        Media[] mediaArray = new Media[media.size()];
        return media.toArray(mediaArray);
    }

    public static Media[] sortByRating(Media[] list){
        ArrayList<Media> ratingList = new ArrayList<>(Arrays.asList(list));
        ratingList.sort(new SortByRating());
        Media[] ratingArray = new Media[ratingList.size()];
        return ratingList.toArray(ratingArray);
    }

}

