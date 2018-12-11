package netflix.views.pages;

import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
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
    private VBox wrapper;

    public ContentPage(Consumer<Parent> setPage) {
        // Initialize header
        Header header = new Header(setPage, this::setContent);
        this.setTop(header);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        wrapper = new VBox();
        wrapper.getStyleClass().add("content-wrapper");
        scrollPane.setContent(wrapper);
        this.setCenter(scrollPane);

        // Set default content
        List<MediaList> frontPageLists = Database.getFeaturedLists();
        FrontPageContent frontPageContent = new FrontPageContent(frontPageLists, this::setContent);
        setContent(frontPageContent);
    }

    private void setContent(Parent view) {
        wrapper.getChildren().clear();
        wrapper.getChildren().add(view);
    }
}
