package netflix.views.content;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import netflix.models.MediaList;
import netflix.views.components.MediaButtonList;

import java.util.List;
import java.util.function.Consumer;

import static netflix.helpers.ActionHelper.setMediaInfoContent;

/**
 * Content for the front page, with various media lists
 */
public class FrontPageContent extends VBox {

    public FrontPageContent(List<MediaList> featuredLists) {
        this.setSpacing(20);
        for (MediaList list : featuredLists) {
            MediaButtonList mediaButtonList = new MediaButtonList(list);
            this.getChildren().add(mediaButtonList);
        }
    }
}
