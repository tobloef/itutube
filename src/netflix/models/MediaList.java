package netflix.models;

import netflix.media.Media;
import java.util.ArrayList;

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
