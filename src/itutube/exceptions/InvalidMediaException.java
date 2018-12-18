package itutube.exceptions;

import itutube.models.media.Media;

/**
 * Unchecked exception, for when a media is not a valid type.
 */
public class InvalidMediaException extends RuntimeException {
    private Media media;

    /**
     * @param message Error message.
     * @param media The invalid media.
     */
    public InvalidMediaException(String message, Media media) {
        super(message);
        this.media = media;
    }

    public Media getMedia() {
        return media;
    }
}
