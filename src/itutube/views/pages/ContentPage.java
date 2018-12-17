package itutube.views.pages;

import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import itutube.views.Header;

/**
 * A page with a header and some main content
 */
public class ContentPage extends BorderPane {

    private VBox wrapper;

    public ContentPage() {
        // Initialize header
        Header header = new Header();
        this.setTop(header);
        // Wrapper
        wrapper = new VBox();
        wrapper.getStyleClass().add("content-wrapper");
        wrapper.getStyleClass().add("center");
        // Scroll pane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(wrapper);
        this.setCenter(scrollPane);
    }

    protected void setContent(Parent content) {
        wrapper.getChildren().clear();
        wrapper.getChildren().add(content);
    }
}
