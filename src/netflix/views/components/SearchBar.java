package netflix.views.components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import javax.naming.directory.SearchControls;

public class SearchBar extends HBox {

    public SearchBar() {
        super();

        this.setAlignment(Pos.CENTER);
        TextField textField = new TextField();
        textField.getStyleClass().add("search-field");
        textField.setPromptText("Search");

        Button button = new Button("Search");
        button.getStyleClass().add("search-button");


        this.getChildren().add(textField);
        this.getChildren().add(button);
    }
}
