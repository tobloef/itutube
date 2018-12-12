package netflix.views.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import netflix.models.media.Media;


public class ActionButton extends Button {

    public ActionButton(String text, String color, EventHandler<ActionEvent> eventHandler) {
        super();
        this.setText(text);
        this.getStyleClass().add("action-button");
        this.setStyle("-fx-background-color: " + color + ";");
        this.setOnAction(eventHandler);
    }
}
