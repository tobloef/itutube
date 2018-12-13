package netflix.views.components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import netflix.Database;
import netflix.Main;
import netflix.helpers.MediaActions;
import netflix.helpers.MediaSorting;
import netflix.models.media.Media;
import netflix.views.pages.content.MediaGridPage;

import java.util.List;

public class SearchBar extends HBox {

    public SearchBar() {
        super();

        TextField textField = new TextField();
        textField.getStyleClass().add("search-field");
        textField.setPromptText("Search");

        Button button = new Button("Search");
        button.getStyleClass().add("search-button");
        button.setOnAction(e -> {
            String query = textField.getText();
            List<Media> results = MediaSorting.findBySearch(query, Database.getAllMedia());
            String title = results.size() + " results for: \"" + query + "\"";
            Main.setPage(new MediaGridPage(title, results, MediaActions::setMediaInfoContent, false));
        });

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(textField);
        this.getChildren().add(button);
    }
}
