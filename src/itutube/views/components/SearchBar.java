package itutube.views.components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import itutube.Database;
import itutube.Main;
import itutube.helpers.MediaActions;
import itutube.helpers.MediaSorting;
import itutube.models.media.Media;
import itutube.views.pages.content.MediaGridPage;

import java.util.List;

/**
 * Search bar for searching in all the media.
 */
public class SearchBar extends HBox {

    public SearchBar() {
        super();

        TextField textField = new TextField();
        textField.getStyleClass().add("search-field");
        textField.setPromptText("Search");
        textField.setOnAction(e -> searchAction(textField.getText()));

        Button button = new Button("Search");
        button.getStyleClass().add("search-button");
        button.setOnAction(e -> searchAction(textField.getText()));

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(textField);
        this.getChildren().add(button);
    }

    private void searchAction(String query) {
        List<Media> results = MediaSorting.findBySearch(query, Database.getAllMedia(Main.getActiveUser().getType()));
        String title = results.size() + " result";
        if (results.size() > 1) {
            title += "s";
        }
        title += " for: \"" + query + "\"";
        Main.setPage(new MediaGridPage(title, results, MediaActions::setMediaInfoContent, false));
    }
}
