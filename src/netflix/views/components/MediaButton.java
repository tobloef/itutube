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
import netflix.helpers.ImageHelper;
import netflix.models.media.Media;

import java.util.Objects;

public class MediaButton extends Button {

    public MediaButton(Media media) {
        super();
        // TODO: This should be done in CSS
        this.setPrefSize(150, 250);
        if (media != null) {
            this.setText(media.getName());
        }
        this.setContentDisplay(ContentDisplay.TOP);
        this.getStyleClass().add("image-button");
        double imgWidth = this.getPrefWidth();
        double imgHeight = this.getPrefHeight() - 60;
        Image image = ImageHelper.getMediaPoster(media, imgWidth, imgHeight);
        if (image != null) {
            this.setGraphic(new ImageView(image));
            this.setGraphicTextGap(15);
        }
    }
}
