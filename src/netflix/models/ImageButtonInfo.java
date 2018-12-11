package netflix.models;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

public class ImageButtonInfo {
    private String text;
    private Image image;
    private EventHandler<ActionEvent> handleAction;

    public ImageButtonInfo(String text, Image image, EventHandler<ActionEvent> handleAction) {
        this.text = text;
        this.image = image;
        this.handleAction = handleAction;
    }


    public String getText() {
        return text;
    }

    public Image getImage() {
        return image;
    }

    public EventHandler<ActionEvent> getHandleAction() {
        return handleAction;
    }
}
