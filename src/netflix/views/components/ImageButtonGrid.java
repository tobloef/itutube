package netflix.views.components;

import javafx.scene.layout.*;
import javafx.scene.text.Text;
import netflix.models.ImageButtonInfo;

import java.util.List;

public class ImageButtonGrid extends VBox {

    private HBox titleWrapper;

    public ImageButtonGrid(String title, List<ImageButtonInfo> items) {
        super();

        Text titleText = new Text();
        titleText.setText(title);
        titleText.getStyleClass().add("title");

        titleWrapper = new HBox();
        titleWrapper.getStyleClass().add("title-wrapper");
        titleWrapper.getChildren().add(titleText);

        FlowPane grid = new FlowPane();
        grid.setHgap(5);
        grid.setVgap(5);
        for(ImageButtonInfo imageButtonInfo : items) {
            ImageButton button = new ImageButton(imageButtonInfo);
            grid.getChildren().add(button);
        }

        this.getChildren().add(titleWrapper);
        this.getChildren().add(grid);
        this.getStyleClass().add("image-button-grid");
    }

    public HBox getTitleWrapper() {
        return titleWrapper;
    }
}
