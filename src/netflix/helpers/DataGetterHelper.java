package netflix.helpers;


import netflix.Database;
import netflix.models.media.Media;

import java.util.ArrayList;

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
}