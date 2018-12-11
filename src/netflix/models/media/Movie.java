package netflix.models.media;

import javafx.scene.Parent;
import netflix.models.Credits;
import netflix.models.Saveable;
import netflix.models.Viewable;
import netflix.views.content.infoview.MovieInfoContent;
import netflix.views.content.infoview.MusicInfoContent;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;

/**
 * A movie
 */
public class Movie extends VideoMedia implements Saveable, Viewable {

    public Movie(String id, String name, String description, Date releaseDate, String[] categories, double rating, Credits[] credits, String imageFileName, int runtime) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName, runtime);

    }

    public String getSaveString() {
        String categoryString = String.join(",", categories);
        String str = id + ";" + name + ";" + releaseDate.getYear() + ";" + categoryString + ";" + rating + ";";
        return str;
    }

    @Override
    public Parent createInfoView() {
        return new MovieInfoContent(this);
    }
}
