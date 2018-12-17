package itutube.helpers;

import javafx.scene.control.Alert;
import itutube.Main;
import itutube.models.Playable;
import itutube.models.Viewable;
import itutube.models.media.Media;

// TODO: JavaDoc
// TODO: Move more methods to here?

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Can't view media");
            alert.setContentText("The program is unable to display info about the chosen media.");
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Can't play media");
            alert.setContentText("The program is unable to play the chosen media.");
            alert.showAndWait();
        }
    }
}
