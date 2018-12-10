package netflix.views.components;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaBuilder;
import netflix.models.media.Media;

public class MediaButtonList {
    /*
    public MediaButtonList(Media[] mediaList) {

    }
    */
    public static ScrollPane getMediaButtonList(Media[] mediaList) {
        ScrollPane sp = new ScrollPane();
        HBox content = new HBox();
        for(Media m : mediaList) {
            MediaButton button = new MediaButton(m);
            content.getChildren().add(button);
        }
        sp.setContent(content);
        return sp;
    }
}
