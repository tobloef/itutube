package netflix.models;

import javafx.scene.Parent;


/**
 * Interface specifying that a media is somehow playable
 */
public interface Playable {
    public String getMediaContent();
    public double getProgress();
    public String getProgressString();
    public Parent createPlayView();
}
