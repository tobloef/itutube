package netflix.models;

import netflix.models.media.Media;
import java.util.ArrayList;

/**
 * A list of media
 */
public class MediaList {
    private String name;
    private ArrayList<Media> media;

    public MediaList(String name, ArrayList<Media> media) {
        this.name = name;
        this.media = media;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Media> getMedia() {
        return media;
    }
}
