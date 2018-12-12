package netflix.views.pages;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import netflix.models.ImageButtonInfo;
import netflix.models.media.Media;
import netflix.views.components.ImageButton;

import java.util.List;

public class ImageButtonGrid extends ContentPage {

    public ImageButtonGrid(String name, List<ImageButtonInfo> data) {
        super();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.getStyleClass().add("scroll-pane-wrapper");
        VBox content = new VBox(20);
        content.getStyleClass().add("front-page-wrapper");
        Text title = new Text();
        title.setText(name);
        title.getStyleClass().add("grid-title");

        FlowPane flowPane = new FlowPane();
        flowPane.getStyleClass().add("flow-pane-grid");
        for(ImageButtonInfo bi : data) {
            ImageButton button = new ImageButton(bi);
            flowPane.getChildren().add(button);
        }
        content.getChildren().add(title);
        content.getChildren().add(flowPane);
        scrollPane.setContent(content);

        this.setCenter(scrollPane);
    }

}
