package netflix.views.pages.content;

import javafx.scene.layout.VBox;
import netflix.Database;
import netflix.helpers.MediaActions;
import netflix.models.MediaList;
import netflix.views.components.MediaButtonList;
import netflix.views.pages.ContentPage;

import java.util.List;

/**
 * Front page of the application, after the user has logged in.
 * Displays a number of featured media lists.
 */
public class FrontPage extends ContentPage {
    public FrontPage() {
        super();
        List<MediaList> featuredLists = Database.getFeaturedLists();
        VBox content = new VBox();
        content.setSpacing(20);
        content.getStyleClass().add("front-page-content");
        for (MediaList list : featuredLists) {
            MediaButtonList mediaButtonList = new MediaButtonList(
                    list.getName(),
                    list.getMedia(),
                    MediaActions::setMediaInfoContent
            );
            content.getChildren().add(mediaButtonList);
        }

        this.setContent(content);
    }
}
