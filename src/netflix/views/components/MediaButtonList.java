package netflix.views.components;

import javafx.scene.image.Image;
import netflix.helpers.ImageHelper;
import netflix.models.ImageButtonInfo;
import netflix.models.MediaList;
import netflix.models.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MediaButtonList extends ImageButtonList {
    public MediaButtonList(MediaList mediaList, Consumer<Media> handleAction) {
        super(mediaList.getName(), mediaListToImageButtonInfoList(mediaList.getMedia(), handleAction));
    }

    private static List<ImageButtonInfo> mediaListToImageButtonInfoList(List<Media> mediaList, Consumer<Media> handleAction) {
        List<ImageButtonInfo> infoList = new ArrayList<>();
        for (Media media : mediaList) {
            Image image = ImageHelper.getMediaPoster(media);
            infoList.add(new ImageButtonInfo(media.getName(), image, event -> handleAction.accept(media)));
        }
        return infoList;
    }
}
