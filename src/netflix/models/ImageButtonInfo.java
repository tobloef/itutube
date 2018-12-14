package netflix.models;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

/**
 * Info to display on image button
 */
public class ImageButtonInfo {
    private String text;
    private Image image;
    private EventHandler<ActionEvent> eventHandler;

    /**
     *
     * @param text Text to display
     * @param image Image to display
     * @param eventHandler Event handler to determine what happens on click
     */
    public ImageButtonInfo(String text, Image image, EventHandler<ActionEvent> eventHandler) {
        this.text = text;
        this.image = image;
        this.eventHandler = eventHandler;
    }

    /**
     * Gets the text from image button
     * @return Returns the text from image button
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the image from image button
     * @return Returns the image from image button
     */
    public Image getImage() {
        return image;
    }
    /**
     * Gets the eventHandler from image button
     * @return Returns the eventHandler from image button
     */
    public EventHandler<ActionEvent> getEventHandler() {
        return eventHandler;
    }
}
