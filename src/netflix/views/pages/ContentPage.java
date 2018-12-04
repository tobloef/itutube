package netflix.views.pages;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import netflix.helpers.MediaListsHelper;
import netflix.creators.FrontPageCreator;
import netflix.creators.ViewCreator;
import netflix.models.MediaList;
import netflix.views.Header;

import java.util.function.Consumer;

/**
 * A page with a header and some main content
 */
public class ContentPage extends BorderPane {
    public ContentPage(Consumer<ViewCreator> setPage) {
        // Initialize header
        Header header = new Header(setPage, this::setContent);
        this.setTop(header);
        // Set default content
        MediaList[] frontPageLists = MediaListsHelper.getFrontPageLists();
        FrontPageCreator frontPageCreator = new FrontPageCreator(frontPageLists);
        setContent(frontPageCreator);
    }

    /**
     * Set the main content in the center of the view
     * @param creator ViewCreator to create the content view with
     */
    private void setContent(ViewCreator creator) {
        Parent view = creator.create();
        this.setCenter(view);
    }
}
