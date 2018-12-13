package netflix.helpers;

import javafx.scene.control.Alert;
import netflix.Main;
import netflix.models.Playable;
import netflix.models.Viewable;
import netflix.models.media.Media;

public class MediaActions {

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
