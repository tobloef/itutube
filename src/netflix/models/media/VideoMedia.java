package netflix.models.media;

import netflix.models.Credits;
import netflix.models.Playable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.Date;

/**
 * Generic video media
 */
public abstract class VideoMedia extends Media implements Playable {
    private int runtime;

    public VideoMedia(String id, String name, String description, Date releaseDate, String[] categories, double rating, Credits[] credits, String imageFileName, int runtime) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName);
        this.runtime = runtime;
    }

    @Override
    public Color getMediaContent() {
        // TODO
        throw new NotImplementedException();
    }

    @Override
    public double getProgress() {
        // TODO
        throw new NotImplementedException();
    }

    @Override
    public String getProgressString() {
        // TODO
        throw new NotImplementedException();
    }

    public int getRuntime() {
        // TODO
        return runtime;
    }
}
