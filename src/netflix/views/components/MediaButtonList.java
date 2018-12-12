package netflix.views.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import netflix.Main;
import netflix.helpers.ImageHelper;
import netflix.models.ImageButtonInfo;
import netflix.models.MediaList;
import netflix.models.Viewable;
import netflix.models.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MediaButtonList extends ImageButtonList {
    public MediaButtonList(MediaList mediaList) {
        super(mediaList.getName(), mediaListToImageButtonInfoList(mediaList.getMedia()));
    }

    private static List<ImageButtonInfo> mediaListToImageButtonInfoList(List<Media> mediaList) {
        List<ImageButtonInfo> infoList = new ArrayList<>();
        for (Media media : mediaList) {
            String text = media.getName();
            Image image = ImageHelper.getMediaPoster(media);
            Viewable viewable = (Viewable) media;
            infoList.add(new ImageButtonInfo(text, image, e -> Main.setPage(viewable.createInfoView())));
        }
        return infoList;
    }
}
