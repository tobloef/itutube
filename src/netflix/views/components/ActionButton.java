package netflix.views.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class ActionButton extends Button {

    public ActionButton(String text, String color, EventHandler<ActionEvent> eventHandler) {
        super();
        this.setText(text);
        this.getStyleClass().add("action-button");
        this.setStyle("-fx-background-color: " + color + ";");
        this.setOnAction(eventHandler);
    }
}
