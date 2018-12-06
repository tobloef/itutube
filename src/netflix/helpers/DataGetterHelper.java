package netflix.helpers;


import netflix.Database;
import netflix.models.media.Media;

public class DataGetterHelper{

    public  Media searchMedia(String name) {
        for (Media m : Database.getMediaList())
            if (m.getName() == name) {
                return m;
            }
        return null;
    }
}



