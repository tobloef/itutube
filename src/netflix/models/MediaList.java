package netflix.models;

import netflix.models.media.Media;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of media
 */
public class MediaList {
    private String name;
    private List<Media> media;

    public MediaList(String name, List<Media> media) {
        this.name = name;
        this.media = media;
    }

    public MediaList(String name) {
        this(name, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public List<Media> getMedia() {
        return media;
    }
}
