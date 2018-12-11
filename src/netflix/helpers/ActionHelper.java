package netflix.helpers;

import javafx.scene.Parent;
import netflix.models.Playable;
import netflix.models.Viewable;
import netflix.models.media.Media;

import java.util.function.Consumer;

public class ActionHelper {
    public static void setMediaInfoContent(Media media, Consumer<Parent> setContent) {
        if (media instanceof Viewable) {
            Viewable viewable = (Viewable) media;
            setContent.accept(viewable.createInfoView());
        }
        // TODO: Show error?
    }

    public static void setMediaPlayContent(Media media, Consumer<Parent> setPage) {
        if (media instanceof Viewable) {
            Playable viewable = (Playable) media;
            setPage.accept(viewable.createPlayView());
        }
        // TODO: Show error?
    }
}
