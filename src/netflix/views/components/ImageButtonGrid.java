package netflix.views.components;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import netflix.models.ImageButtonInfo;

import java.util.List;

/**
 * Grid of image buttons
 */
public class ImageButtonGrid extends VBox {

    private HBox titleWrapper;

    /**
     * @param title Title to display above the grid
     * @param items Info objects for the items in the grid
     */
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
        for (ImageButtonInfo imageButtonInfo : items) {
            ImageButton button = new ImageButton(imageButtonInfo);
            grid.getChildren().add(button);
        }

        this.getChildren().add(titleWrapper);
        this.getChildren().add(grid);
        this.getStyleClass().add("image-button-grid");
    }

    /**
     * Get the wrapper that contains the title.
     * Used for adding stuff to the top of the grid.
     * @return The title wrapper
     */
    public HBox getTitleWrapper() {
        return titleWrapper;
    }
}
