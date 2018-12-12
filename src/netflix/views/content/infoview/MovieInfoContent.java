package netflix.views.content.infoview;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import netflix.helpers.ImageHelper;
import netflix.models.ImageButtonInfo;
import netflix.models.media.Media;
import netflix.models.media.Movie;
import netflix.views.components.ImageButton;

public class MovieInfoContent extends MediaInfoContent {

    public MovieInfoContent(Movie movie) {
        super(movie);
    }
}

