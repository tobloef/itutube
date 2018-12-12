package netflix.views.pages;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import netflix.Database;
import netflix.Main;
import netflix.models.MediaList;
import netflix.views.content.FrontPageContent;

import java.util.List;

public class FrontPage extends ContentPage {

    public FrontPage() {
        super();
        List<MediaList> frontPageLists = Database.getFeaturedLists();
        FrontPageContent frontPageContent = new FrontPageContent(frontPageLists);
        VBox wrapper = new VBox();
        wrapper.getChildren().add(frontPageContent);
        wrapper.getStyleClass().add("front-page-wrapper");
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(wrapper);
        this.setCenter(scrollPane);
    }
}
