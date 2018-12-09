package netflix.helpers;


import netflix.Database;
import netflix.models.media.Media;
import java.util.*;


public class DataGetterHelper {

    public static Media[] searchInMedia(String name) { //set as void for debugging
        ArrayList<Media> results = new ArrayList<>();
        for (Media m : Database.getMediaList()) {
            int i = 0;
            if (m.getName().toLowerCase().startsWith(name.toLowerCase())) { //checks if it starts with search query. toLowercase so its not case sensitive
                results.add(0,m); //add onto index 0, so it will be the first ones that shows up in the result list. (This saves a whole nother loop which will generate same output)
            }
            if ((m.getName().toLowerCase().contains(name.toLowerCase()))) { //afterwards add all substring matches
               if(!results.contains(m)){
                   results.add(m);
               }
            }
        }
        for (Media result : results){
            System.out.println(result.getName());
        }

        Media[] resultArray = new Media[results.size()]; //makes array
        return results.toArray(resultArray);
    }

    public static Media[] getMediaListByCategory(String category, Media[] list) {
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

