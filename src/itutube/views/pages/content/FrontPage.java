package itutube.views.pages.content;

import itutube.Database;
import itutube.Main;
import itutube.helpers.MediaActions;
import itutube.models.MediaList;
import itutube.views.components.MediaButtonList;
import itutube.views.pages.ContentPage;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Front page of the application, after the user has logged in.
 * Displays a number of featured media lists.
 */
public class FrontPage extends ContentPage {
    public FrontPage() {
        super();
        List<MediaList> featuredLists = Database.getFeaturedLists(Main.getActiveUser().getType());
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
