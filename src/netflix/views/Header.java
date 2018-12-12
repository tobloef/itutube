package netflix.views;

import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import netflix.Database;
import netflix.HeaderController;
import netflix.Main;
import netflix.helpers.MediaListHelper;
import netflix.models.ImageButtonInfo;
import netflix.models.media.Media;
import netflix.views.components.SearchBar;
import netflix.views.pages.FrontPage;
import netflix.views.pages.ImageButtonGrid;

import java.util.ArrayList;
import java.util.List;

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
        logo.setOnAction(HeaderController::handleFrontPageClick);

        // Front page button
        Hyperlink frontPage = new Hyperlink("Home Page");
        frontPage.getStyleClass().add("header-button");
        frontPage.setOnAction(HeaderController::handleFrontPageClick);

        // Movies button
        Hyperlink movies = new Hyperlink("Movies");
        movies.getStyleClass().add("header-button");
        movies.setOnAction(HeaderController::handleMovieClick);


        // Series button
        Hyperlink series = new Hyperlink("Series");
        series.getStyleClass().add("header-button");
        series.setOnAction(HeaderController::handleSeriesClick);

        // Categories button
        Hyperlink categories = new Hyperlink("Categories");
        categories.getStyleClass().add("header-button");
        categories.setOnAction(HeaderController::handleCategoriesClick);

        // Search bar
        SearchBar searchBar = new SearchBar();
        // My list button
        Hyperlink myList = new Hyperlink("My List");
        myList.getStyleClass().add("header-button");
        myList.setOnAction(HeaderController::handleMyListClick);

        // Change user button
        Hyperlink changeUser = new Hyperlink(Main.getActiveUser().getName());
        changeUser.getStyleClass().add("header-button");
        changeUser.setOnAction(HeaderController::handleChangeUserClick);

        // Middle filler
        Region filler = new Region();
        HBox.setHgrow(filler, Priority.ALWAYS);
        // Add components
        this.getChildren().add(logo);
        this.getChildren().add(frontPage);
        this.getChildren().add(movies);
        this.getChildren().add(series);
        this.getChildren().add(categories);
        this.getChildren().add(filler);
        this.getChildren().add(searchBar);
        this.getChildren().add(myList);
        this.getChildren().add(changeUser);
    }
}
