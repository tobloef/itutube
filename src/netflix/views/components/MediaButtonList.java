package netflix.views.components;

import netflix.helpers.ImageButtonInfoHelper;
import netflix.models.media.Media;

import java.util.List;
import java.util.function.Consumer;

public class MediaButtonList extends ImageButtonList {
    public MediaButtonList(String title, List<Media> medias, Consumer<Media> handleAction) {
        super(title, ImageButtonInfoHelper.mediasToImageButtonInfos(medias, handleAction));
    }
}
