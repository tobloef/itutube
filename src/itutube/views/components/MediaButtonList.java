package itutube.views.components;

import itutube.helpers.ImageButtonInfoHelper;
import itutube.models.media.Media;

import java.util.List;
import java.util.function.Consumer;

/**
 * Scrollable list of media
 */
public class MediaButtonList extends ImageButtonList {
    /**
     * @param title Title of the list
     * @param medias List of medias in the list
     * @param handleAction Handler for what to do when a media is clicked
     */
    public MediaButtonList(String title, List<Media> medias, Consumer<Media> handleAction) {
        super(title, ImageButtonInfoHelper.mediasToImageButtonInfos(medias, handleAction));
    }
}
