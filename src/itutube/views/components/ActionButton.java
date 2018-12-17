package itutube.views.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * A simple custom button.
 */
public class ActionButton extends Button {

    /**
     * @param text Text on the button
     * @param color Color of the button
     * @param eventHandler Event handler to call when clicking the button
     */
    public ActionButton(String text, String color, EventHandler<ActionEvent> eventHandler) {
        super();
        this.setText(text);
        this.getStyleClass().add("action-button");
        this.setStyle("-fx-background-color: " + color + ";");
        this.setOnAction(eventHandler);
    }
}
