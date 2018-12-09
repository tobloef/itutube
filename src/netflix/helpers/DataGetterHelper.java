package netflix.helpers;


import netflix.Database;
import netflix.models.media.Media;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class DataGetterHelper {

    public static void /*ArrayList<Media>*/ searchInMedia(String name) { //set as void for debugging
        ArrayList<Media> results = new ArrayList<Media>();
        for (Media m : Database.getMediaList()) {
            if (m.getName().toLowerCase().startsWith(name.toLowerCase())) { //checks if it starts with search query. toLowercase so its not case sensitibe
                //return m;
                results.add(m);
                System.out.println("picked movie: " + m.getName()); //for unit tests
            }
        }
        //return results; remove comment after debug
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
}