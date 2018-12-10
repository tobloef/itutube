package netflix.views.components;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import netflix.Main;
import netflix.models.media.Media;

import java.util.Objects;

public class MediaButton extends Button {

    public MediaButton(Media media) {
        super();
        this.setText(media.getName());
        String className = media.getClass().getSimpleName();
        this.setContentDisplay(ContentDisplay.TOP);
        this.setId("MediaBTN");
        this.setGraphic(new ImageView(new Image("netflix/posters/" + className + "Posters/" + media.getName() + ".jpg")));
    }
}
