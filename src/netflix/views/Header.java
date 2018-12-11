package netflix.views;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import netflix.views.components.SearchBar;
import netflix.views.creators.ViewCreator;

import java.util.function.Consumer;

// TODO

/**
 * A top bar with navigation links
 */
public class Header extends HBox {
    public Header(Consumer<ViewCreator> setPage, Consumer<ViewCreator> setContent) {
        // Header bar
        this.getStyleClass().add("header");
        this.setAlignment(Pos.CENTER);
        // Logo
        Label logo = new Label("ITÜ-TÜBE");
        logo.getStyleClass().add("header-logo");
        // Front page button
        Label frontPage = new Label("Forside");
        frontPage.getStyleClass().add("header-button");
        // Movies button
        Label movies = new Label("Film");
        movies.getStyleClass().add("header-button");
        // Series button
        Label series = new Label("Serier");
        series.getStyleClass().add("header-button");
        // Music button
        Label music = new Label("Musik");
        music.getStyleClass().add("header-button");
        // Search bar
        SearchBar searchBar = new SearchBar();
        // My list button
        Label myList = new Label("Min Liste");
        myList.getStyleClass().add("header-button");
        // Change user button
        Label changeUser = new Label("Skift Bruger");
        changeUser.getStyleClass().add("header-button");
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
