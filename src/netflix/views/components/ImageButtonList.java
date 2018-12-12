package netflix.views.components;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import netflix.models.ImageButtonInfo;

import java.util.List;

public class ImageButtonList extends VBox {
    public ImageButtonList(String name, List<ImageButtonInfo> items) {
        super();
        this.getStyleClass().add("image-button-list");
        // Title
        Text title = new Text();
        title.setText(name);
        title.getStyleClass().add("title");
        this.getChildren().add(title);
        // The list's content
        HBox wrapper = new HBox();
        if (items != null && items.size() > 0) {
            // Scrollable content
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setFitToHeight(true);
            HBox content = new HBox(20);
            for (ImageButtonInfo item : items) {
                ImageButton button = new ImageButton(item);
                content.getChildren().add(button);
            }
            scrollPane.setContent(content);
            scrollPane.setFitToHeight(true);
            wrapper.getChildren().add(scrollPane);
        } else {
            // Empty list message
            wrapper.setAlignment(Pos.CENTER);
            Text text = new Text("This list is empty");
            text.getStyleClass().add("empty-message");
            wrapper.getChildren().add(text);
        }
        this.getChildren().add(wrapper);
    }


}
