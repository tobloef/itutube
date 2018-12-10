package netflix.views.components;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaBuilder;
import netflix.models.media.Media;

public class MediaButtonList {

    public MediaButtonList(Media[] mediaList) {
        ScrollPane sp = new ScrollPane();
        VBox content = new VBox();
        for(Media m : mediaList) {
            MediaButton button = new MediaButton(m);
            content.getChildren().add(button);
        }
    }
}
