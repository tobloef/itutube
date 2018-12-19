package itutube.views.pages.content;

import itutube.controllers.MediaActions;
import itutube.models.media.Media;
import itutube.models.media.Season;
import itutube.models.media.Series;
import itutube.views.components.MediaButtonList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

import static itutube.controllers.NodeLookup.findFirstByClassName;

/**
 * Page for displaying information about a series.
 */
public class SeriesInfoContent extends MediaInfoContent {

    /**
     * @param series The series to display info for
     */
    public SeriesInfoContent(Series series) {
        super(series);
        this.addContent(getSeasonsPreview(series));
        this.setDateInfo(series);
    }

    /**
     * Create elements displaying the series's seasons.
     * @param series The series to display the seasons of
     * @return Elements display the series's seasons
     */
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

    private void setDateInfo(Series series) {
        Node dateInfo = findFirstByClassName(this, "info-date");
        if (dateInfo instanceof Text) {
            Text text = (Text) dateInfo;
            if (series.getEndDate() != series.getReleaseDate()) {
                String startYear = String.valueOf(series.getReleaseDate().getYear());
                String newStr = "Release years: " + startYear + " - ";
                if (series.getEndDate() != null) {
                    newStr += String.valueOf(series.getEndDate().getYear());
                } else {
                    newStr += "Present";
                }
                text.setText(newStr);
            }
        }
    }
}
