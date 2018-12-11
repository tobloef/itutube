package netflix.views.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import netflix.helpers.ImageHelper;
import netflix.models.media.Media;

public class ImageButton extends Button {

    public ImageButton(String text, Image image, EventHandler<ActionEvent> handleAction) {
        super();
        // TODO: This line should be done in CSS
        this.setPrefSize(200, 250);
        this.setContentDisplay(ContentDisplay.TOP);
        this.getStyleClass().add("image-button");
        this.setOnAction(handleAction);
        this.setText(text);
        if (image != null) {
            ImageView imageView = new ImageView(image);
            double imgWidth = this.getPrefWidth();
            double imgHeight = this.getPrefHeight() - 60;
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(imgWidth);
            imageView.setFitHeight(imgHeight);
            this.setGraphic(imageView);
            this.setGraphicTextGap(15);
        }
    }
}
