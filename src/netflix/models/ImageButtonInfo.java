package netflix.models;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

public class ImageButtonInfo {
    private String text;
    private Image image;
    private EventHandler<ActionEvent> eventHandler;

    public ImageButtonInfo(String text, Image image, EventHandler<ActionEvent> eventHandler) {
        this.text = text;
        this.image = image;
        this.eventHandler = eventHandler;
    }


    public String getText() {
        return text;
    }

    public Image getImage() {
        return image;
    }

    public EventHandler<ActionEvent> getEventHandler() {
        return eventHandler;
    }
}
