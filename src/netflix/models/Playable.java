package netflix.models;

import java.awt.*;

/**
 * Interface specifying that a media is somehow playable
 */
public interface Playable {
    public Color getMediaContent();
    public double getProgress();
    public String getProgressString();
}
