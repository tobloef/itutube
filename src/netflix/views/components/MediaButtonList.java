package netflix.views.components;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.media.MediaBuilder;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import netflix.models.media.Media;


public class MediaButtonList extends VBox {
    public MediaButtonList(String name, Media[] mediaList) {
        super();

        Text title = new Text();
        title.setText(name);
        title.setFill(Color.WHITE);
        title.setId("MediaListTitle");
        this.getChildren().add(title);
        ScrollPane sp = new ScrollPane();
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        HBox content = new HBox(20);

        for(Media m : mediaList) {
            MediaButton button = new MediaButton(m);
            content.getChildren().add(button);
        }

        content.setId("MediaListContent");
        sp.setContent(content);
        sp.setId("MediaScrollList");
        this.setId("MediaList");
        this.getChildren().add(sp);
    }
}
