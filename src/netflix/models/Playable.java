package netflix.models;

import javafx.scene.Parent;


/**
 * Interface specifying that a media is somehow playable
 */
public interface Playable {
    String getMediaContent();

    double getProgress();

    String getProgressString();

    Parent createPlayView();
}
