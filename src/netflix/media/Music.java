package netflix.media;

import netflix.models.Credits;
import netflix.models.Playable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Music extends Media implements Playable {
    public Music(String id, String name, String description, Date releaseDate, String[] categories, double rating, Credits[] credits, String imageFileName) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName);
    }

    @Override
    public Color getMediaContent() {
        throw new NotImplementedException();
    }

    @Override
    public double getProgress() {
        throw new NotImplementedException();
    }

    @Override
    public String getProgressString() {
        throw new NotImplementedException();
    }
}
