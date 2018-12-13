package netflix.views.pages;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import netflix.Main;
import netflix.models.Playable;
import netflix.models.media.Media;
import netflix.views.components.ActionButton;
import netflix.views.pages.content.FrontPage;

public class PlayerPage extends StackPane {

    public PlayerPage(Media media) {
        VBox content = new VBox(20);
        VBox textContainer = new VBox();
        Text text = new Text();
        text.setText("Now Playing: " + media.getName());

        Playable playable = (Playable) media;

        textContainer.setStyle("-fx-background-color: " + playable.getMediaContent() + ";");
        textContainer.getStyleClass().add("playing-text-container");
        text.getStyleClass().add("playing-text");

        textContainer.getChildren().add(text);
        content.getChildren().add(textContainer);

        ActionButton goBackButton = new ActionButton("Go Back", "#deaa00", e -> Main.setPage(new FrontPage()));
        content.getChildren().add(goBackButton);

        this.getChildren().add(content);
    }
}
