package netflix.models;

import java.awt.*;

public interface Playable {
    public Color getMediaContent();
    public double getProgress();
    public String getProgressString();
}
