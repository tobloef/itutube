package netflix.views;

import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import netflix.HeaderController;
import netflix.Main;
import netflix.views.components.SearchBar;

/**
 * A top bar with navigation links
 */
public class Header extends HBox {
    public Header() {
        // Header bar
        this.getStyleClass().add("header");
        this.setAlignment(Pos.CENTER);
        // Logo
        Hyperlink logo = new Hyperlink("ITÜ-TÜBE");
        logo.getStyleClass().add("header-logo");
        logo.setOnAction(e -> HeaderController.handleFrontPageClick());

        // Front page button
        Hyperlink frontPage = new Hyperlink("Home Page");
        frontPage.getStyleClass().add("header-button");
        frontPage.setOnAction(e -> HeaderController.handleFrontPageClick());

        // Movies button
        Hyperlink movies = new Hyperlink("Movies");
        movies.getStyleClass().add("header-button");
        movies.setOnAction(e -> HeaderController.handleMovieClick());


        // Series button
        Hyperlink series = new Hyperlink("Series");
        series.getStyleClass().add("header-button");
        series.setOnAction(e -> HeaderController.handleSeriesClick());

        // Search bar
        SearchBar searchBar = new SearchBar();

        // My list button
        Hyperlink myList = new Hyperlink("My List");
        myList.getStyleClass().add("header-button");
        myList.setOnAction(e -> HeaderController.handleMyListClick());

        // Change user button
        Hyperlink changeUser = new Hyperlink(Main.getActiveUser().getName());
        changeUser.getStyleClass().add("header-button");
        changeUser.setOnAction(e -> HeaderController.handleChangeUserClick());

        // Middle filler
        Region filler = new Region();
        HBox.setHgrow(filler, Priority.ALWAYS);

        // Add components
        this.getChildren().add(logo);
        this.getChildren().add(frontPage);
        this.getChildren().add(movies);
        this.getChildren().add(series);
        this.getChildren().add(filler);
        this.getChildren().add(searchBar);
        this.getChildren().add(myList);
        this.getChildren().add(changeUser);
    }
}
