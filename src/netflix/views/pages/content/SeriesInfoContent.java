package netflix.views.pages.content;

import javafx.scene.layout.VBox;
import netflix.helpers.MediaActions;
import netflix.models.media.Media;
import netflix.models.media.Season;
import netflix.models.media.Series;
import netflix.views.components.MediaButtonList;

import java.util.ArrayList;
import java.util.List;

public class SeriesInfoContent extends MediaInfoContent {

    public SeriesInfoContent(Series series) {
        super(series);
        this.addContent(getSeasonsPreview(series));
    }

    private static VBox getSeasonsPreview(Series series) {
        VBox seasons = new VBox();
        seasons.getStyleClass().add("seasons-box");

        for (Season s : series.getSeasons()) {
            List<Media> episodes = new ArrayList<>(s.getEpisodes());
            MediaButtonList buttonList = new MediaButtonList(s.getName(), episodes, MediaActions::setMediaInfoContent);
            seasons.getChildren().add(buttonList);
        }

        return seasons;
    }
}
