package netflix.models;

import javafx.scene.image.Image;
import netflix.models.media.Media;

import java.util.HashMap;
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

    public String getName() {
        return name;
    }

    public List<Media> getMedia() {
        return media;
    }
}
