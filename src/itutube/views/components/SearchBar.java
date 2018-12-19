package itutube.views.components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import static itutube.controllers.SearchController.searchAction;

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
}
