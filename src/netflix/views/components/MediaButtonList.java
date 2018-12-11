package netflix.views.components;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import netflix.models.MediaList;
import netflix.models.media.Media;
import netflix.views.creators.ViewCreator;

import java.util.function.Consumer;


public class MediaButtonList extends VBox {
    public MediaButtonList(MediaList mediaList, Consumer<ViewCreator> setContent) {
        super();
        this.getStyleClass().add("media-list");
        // Title
        Text title = new Text();
        title.setText(mediaList.getName());
        title.getStyleClass().add("title");
        this.getChildren().add(title);
        // The list's content
        HBox wrapper = new HBox();
        if (mediaList.getMedia() != null && mediaList.getMedia().size() > 0) {
            // Scrollable content
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setFitToHeight(true);
            HBox content = new HBox(20);
            for (Media media : mediaList.getMedia()) {
                MediaButton button = new MediaButton(media);
                content.getChildren().add(button);
            }
            scrollPane.setContent(content);
            scrollPane.setFitToHeight(true);
            wrapper.getChildren().add(scrollPane);
        } else {
            // Empty list message
            wrapper.setAlignment(Pos.CENTER);
            Text text = new Text("This list is empty");
            text.getStyleClass().add("empty-message");
            wrapper.getChildren().add(text);
        }
        this.getChildren().add(wrapper);
    }
}
