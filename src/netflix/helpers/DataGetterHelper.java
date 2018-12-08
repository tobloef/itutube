package netflix.helpers;


import netflix.Database;
import netflix.models.media.Media;

public class DataGetterHelper {

    public static void searchInMedia(String name) {
        for (Media m : Database.getMediaList()) {
            if (m.getName().equals(name.toLowerCase()) || m.getId().equals(name)) { //checks if search query is equal to a movie name or its id. toLowercase so its not case sensitive
                //return m;
                System.out.println("picked movie: " + m.getName()); //for unit tests
            } else if (m.getName().toLowerCase().startsWith(name.toLowerCase())) { //checks if it starts with search query
                //return m;
                System.out.println("picked movie: " + m.getName());
            }
            //return null;
        }
    }
}