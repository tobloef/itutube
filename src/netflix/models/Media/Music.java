package netflix.models.Media;

import netflix.models.Playable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Music extends Media implements Playable {
    public Music(String name, String description, Date releaseDate, ArrayList<String> categories, double rating, String imageFileName) {
        super(name, description, releaseDate, categories, rating);
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
