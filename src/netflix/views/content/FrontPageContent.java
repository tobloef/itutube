package netflix.views.content;

import javafx.scene.layout.VBox;
import netflix.models.MediaList;
import netflix.views.components.MediaButtonList;
import netflix.views.creators.ViewCreator;

import java.util.List;
import java.util.function.Consumer;

/**
 * Content for the front page, with various media lists
 */
public class FrontPageContent extends VBox {

    public FrontPageContent(List<MediaList> featuredLists, Consumer<ViewCreator> setContent) {
        this.setSpacing(20);
        for (MediaList list : featuredLists) {
            MediaButtonList mediaButtonList = new MediaButtonList(list, setContent);
            this.getChildren().add(mediaButtonList);
        }
    }
}
