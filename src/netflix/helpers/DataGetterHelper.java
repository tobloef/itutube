package netflix.helpers;


import netflix.Database;
import netflix.models.media.Media;

public class DataGetterHelper{

    public  Media searchMedia(String name) {
        for (Media m : Database.getMediaList())
            if (m.getName().equals(name)) { //checker først hvis navnet er equal for film som ET
                return m;
            } else if (m.getName().startsWith(name)){ //ellers checker hvis det starter med, så man kan skrive "the god" og få the godfather
                return m;}
        return null;
    }
}