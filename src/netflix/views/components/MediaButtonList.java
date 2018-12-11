package netflix.views.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
            String text = media.getName();
            Image image = ImageHelper.getMediaPoster(media);
            EventHandler<ActionEvent> eventHandler = event -> handleAction.accept(media);
            infoList.add(new ImageButtonInfo(text, image, eventHandler));
        }
        return infoList;
    }
}
