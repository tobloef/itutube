package itutube.views.pages;

import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import itutube.Main;
import itutube.models.Playable;
import itutube.models.media.Media;
import itutube.views.components.ActionButton;
import itutube.views.pages.content.FrontPage;

/**
 * Mock page for displaying a media.
 * Just displays the Media's color, for testing.
 */
public class PlayerPage extends StackPane {

    /**
     * @param media The media to play
     */
    public PlayerPage(Media media) {
        Text nowPlayingText = new Text();
        nowPlayingText.setText("Now Playing: " + media.getName());
        nowPlayingText.getStyleClass().add("playing-text");

        VBox textContainer = new VBox();
        if (!(media instanceof Playable)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error playing the media");
            alert.setContentText("The was an error playing the media. The media is not playable.");
            alert.showAndWait();
            return;
        } else {
            Playable playable = (Playable) media;
            textContainer.setStyle("-fx-background-color: " + playable.getMediaContent() + ";");
        }
        textContainer.getStyleClass().add("playing-text-container");
        textContainer.getChildren().add(nowPlayingText);

        ActionButton goBackButton = new ActionButton(
                "Go Back",
                "#deaa00",
                e -> Main.setPage(new FrontPage())
        );

        VBox content = new VBox(20);
        content.getChildren().add(textContainer);
        content.getChildren().add(goBackButton);

        this.getChildren().add(content);
    }
}
