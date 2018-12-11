package netflix.views;

import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import java.util.function.Consumer;

/**
 * A top bar with navigation links
 */
public class Header extends HBox {
    public Header(Consumer<Parent> setPage, Consumer<Parent> setContent) {
        // Header bar
        this.getStyleClass().add("header");
        this.setAlignment(Pos.CENTER);
        // Logo
        Hyperlink logo = new Hyperlink("ITÜ-TÜBE");
        logo.getStyleClass().add("header-logo");
        // Front page button
        Hyperlink frontPage = new Hyperlink("Forside");
        frontPage.getStyleClass().add("header-button");
        // Movies button
        Hyperlink movies = new Hyperlink("Film");
        movies.getStyleClass().add("header-button");
        // Series button
        Hyperlink series = new Hyperlink("Serier");
        series.getStyleClass().add("header-button");
        // Music button
        Hyperlink music = new Hyperlink("Musik");
        music.getStyleClass().add("header-button");
        // Search bar
        SearchBar searchBar = new SearchBar();
        // My list button
        Hyperlink myList = new Hyperlink("Min Liste");
        myList.getStyleClass().add("header-button");
        // Change user button
        Hyperlink changeUser = new Hyperlink("Skift Bruger");
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
