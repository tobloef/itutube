package itutube.models;

import itutube.models.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A list of media
 */
public class MediaList {
    private String name;
    private List<Media> media;

    /**
     * The constructor of the MediaList
     * @param name The name for the media list
     * @param media a list of media to put into the media list
     */
    public MediaList(String name, List<Media> media) {
        this.name = name;
        this.media = media;
    }

    /**
     * Constructor without a pre-determined media list to include
     * @param name Name for the media list
     */
    public MediaList(String name) {
        this(name, new ArrayList<>());
    }
    /**
     * Gets the name from media list
     * @return Returns the name from media list
     */
    public String getName() {
        return name;
    }
    /**
     * Gets all of the media from media list
     * @return Returns all of the media from media list
     */
    public List<Media> getMedia() {
        return media;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MediaList mediaList = (MediaList) o;
        return Objects.equals(name, mediaList.name) &&
                Objects.equals(media, mediaList.media);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, media);
    }
}
