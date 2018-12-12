package netflix.views.content.infoview;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import netflix.helpers.ImageHelper;
import netflix.models.ImageButtonInfo;
import netflix.models.MediaList;
import netflix.models.media.*;
import netflix.views.components.ImageButton;
import netflix.views.components.MediaButtonList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeriesInfoContent extends MediaInfoContent {

    public SeriesInfoContent(Series series) {
        super(series, getSeasonsPreview(series));


    }

    private static VBox getSeasonsPreview(Series series) {
        VBox seasons = new VBox();
        seasons.getStyleClass().add("seasons-box");

        for(Season s : series.getSeasons()) {
            List<Media> episodes = new ArrayList<>(s.getEpisodes());
            MediaButtonList buttonList = new MediaButtonList(new MediaList(s.getName(), episodes));
            seasons.getChildren().add(buttonList);
        }

        return seasons;
    }
}
