package netflix.views.pages;

import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import netflix.Database;
import netflix.models.MediaList;
import netflix.views.Header;
import netflix.views.components.MediaButtonList;
import netflix.views.creators.FrontPageCreator;
import netflix.views.creators.ViewCreator;

import java.util.List;
import java.util.function.Consumer;

// TODO

/**
 * A page with a header and some main content
 */
public class ContentPage extends BorderPane {
    private VBox wrapper;

    public ContentPage(Consumer<ViewCreator> setPage) {
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
        FrontPageCreator frontPageCreator = new FrontPageCreator(frontPageLists, this::setContent);
        setContent(frontPageCreator);
    }

    /**
     * Set the main content in the center of the view
     * @param creator ViewCreator to create the content view with
     */
    private void setContent(ViewCreator creator) {
        Parent view = creator.create();
        wrapper.getChildren().clear();
        wrapper.getChildren().add(view);
    }
}
