package netflix.helpers;

import netflix.Main;
import netflix.models.Playable;
import netflix.models.Viewable;
import netflix.models.media.Media;

public class Actions {

    public static void setMediaInfoContent(Media media) {
        if (media instanceof Viewable) {
            Viewable viewable = (Viewable) media;
            Main.setPage(viewable.createInfoView());
        } else {
            // TODO: Handle non-viewable media
        }
    }

    public static void setMediaPlayContent(Media media) {
        if (media instanceof Playable) {
            Playable playable = (Playable) media;
            Main.setPage(playable.createPlayView());
        } else {
            // TODO: Handle non-viewable media
        }
    }
}
