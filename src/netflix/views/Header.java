package netflix.views;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import netflix.views.creators.ViewCreator;
import java.util.function.Consumer;

// TODO

/**
 * A top bar with navigation links
 */
public class Header extends HBox {
    public Header(Consumer<ViewCreator> setPage, Consumer<ViewCreator> setContent) {
        // Styles
        this.getStylesheets().add("netflix/views/Header.css");
        // Header bar
        this.getStyleClass().add("header");

        // Logo
        Label logo = new Label("ITU-Tube");
        logo.getStyleClass().add("headerButton");
        // Front page button
        Label frontPage = new Label("Forside");
        frontPage.getStyleClass().add("headerButton");
        // Movies button
        Label movies = new Label("Film");
        movies.getStyleClass().add("headerButton");
        // Series button
        Label series = new Label("Serier");
        series.getStyleClass().add("headerButton");
        // Music button
        Label music = new Label("Musik");
        music.getStyleClass().add("headerButton");
        // Search bar
        SearchBar searchBar = new SearchBar();
        // My list button
        Label myList = new Label("Min Liste");
        myList.getStyleClass().add("headerButton");
        // Change user button
        Label changeUser = new Label("Skift Bruger");
        changeUser.getStyleClass().add("headerButton");
        // Middle filler
        Region filler = new Region();
        HBox.setHgrow(filler, Priority.ALWAYS);
        // Add components
        this.getChildren().add(logo);
        this.getChildren().add(frontPage);
        this.getChildren().add(movies);
        this.getChildren().add(series);
        this.getChildren().add(music);
        this.getChildren().add(filler);
        this.getChildren().add(searchBar);
        this.getChildren().add(myList);
        this.getChildren().add(changeUser);
    }
}
