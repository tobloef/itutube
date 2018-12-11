package netflix.models.media;

import javafx.scene.Parent;
import netflix.models.Credits;
import netflix.models.Playable;
import netflix.models.Viewable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.Date;

/**
 * A piece of music
 */
public class Music extends Media implements Playable, Viewable {
    public Music(String id, String name, String description, Date releaseDate, String[] categories, double rating, Credits[] credits, String imageFileName) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName);
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

    @Override
    public Parent createPlayView() {
        return null;
    }

    @Override
    public Parent createInfoView() {
        return null;
    }
}
