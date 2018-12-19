package itutube.controllers;

import itutube.Main;
import itutube.exceptions.InvalidMediaException;
import itutube.models.Playable;
import itutube.models.Viewable;
import itutube.models.media.Media;

/**
 * General handlers for creating info views for media.
 */
public class MediaActions {

    /**
     * Sets page to info page for given media.
     * @param media Media to generate info page for.
     */
    public static void setMediaInfoContent(Media media) {
        if (media instanceof Viewable) {
            Viewable viewable = (Viewable) media;
            Main.setPage(viewable.createInfoView());
        } else {
            throw new InvalidMediaException("Media is not viewable.", media);
        }
    }

    /**
     * Sets page to player page for given media.
     * @param media Media to generate player page for.
     */
    public static void setMediaPlayContent(Media media) {
        if (media instanceof Playable) {
            Playable playable = (Playable) media;
            Main.setPage(playable.createPlayView());
        } else {
            throw new InvalidMediaException("Media is not playable.", media);
        }
    }
}
