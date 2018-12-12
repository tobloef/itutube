package netflix.views.pages;

import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import netflix.Database;
import netflix.models.MediaList;
import netflix.views.Header;
import netflix.views.content.FrontPageContent;

import java.util.List;
import java.util.function.Consumer;

/**
 * A page with a header and some main content
 */
public class ContentPage extends BorderPane {

    public ContentPage() {
        // Initialize header
        Header header = new Header();
        this.setTop(header);
    }

}
