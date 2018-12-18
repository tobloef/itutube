package itutube.models.media;

import itutube.models.Credits;
import itutube.models.Playable;
import itutube.models.Saveable;
import itutube.models.Viewable;
import javafx.scene.Parent;

import java.util.Date;
import java.util.List;

public class Music extends Media implements Playable, Viewable, Saveable {
    /**
     * @param id          Id associated with the media.
     * @param name        Name of the media.
     * @param description Description of the media.
     * @param releaseDate Release date of the media.
     * @param categories  Categories held by the media.
     * @param rating      Rating of the media.
     * @param credits     Credits for the media.
     */
    public Music(String id, String name, String description, Date releaseDate, List<String> categories, double rating, List<Credits> credits) {
        super(id, name, description, releaseDate, categories, rating, credits);
    }

    @Override
    public String getMediaContent() {
        return null;
    }

    @Override
    public double getProgress() {
        return 0;
    }

    @Override
    public String getProgressString() {
        return null;
    }

    @Override
    public Parent createPlayView() {
        return null;
    }

    @Override
    public String getSaveString() {
        return null;
    }

    @Override
    public Parent createInfoView() {
        return null;
    }
}
