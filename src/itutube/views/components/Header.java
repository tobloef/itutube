package itutube.views.components;

import itutube.Database;
import itutube.Main;
import itutube.controllers.MediaActions;
import itutube.controllers.MediaSorting;
import itutube.models.media.Media;
import itutube.models.media.Movie;
import itutube.models.media.Series;
import itutube.views.pages.UserSelectPage;
import itutube.views.pages.content.FrontPage;
import itutube.views.pages.content.MediaGridPage;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import java.util.List;

import static itutube.controllers.HeaderController.*;

/**
 * A top bar with navigation links
 */
public class Header extends HBox {
    public Header() {
        // Logo
        Hyperlink logo = new Hyperlink("ITÜ-TÜBE");
        logo.getStyleClass().add("header-logo");
        logo.setOnAction(e -> handleFrontPageClick());

        // Front page button
        Hyperlink frontPage = new Hyperlink("Home Page");
        frontPage.getStyleClass().add("header-button");
        frontPage.setOnAction(e -> handleFrontPageClick());

        // Movies button
        Hyperlink movies = new Hyperlink("Movies");
        movies.getStyleClass().add("header-button");
        movies.setOnAction(e -> handleMovieClick());

        // Series button
        Hyperlink series = new Hyperlink("Series");
        series.getStyleClass().add("header-button");
        series.setOnAction(e -> handleSeriesClick());

        // Search bar
        SearchBar searchBar = new SearchBar();

        // My list button
        Hyperlink myList = new Hyperlink("My List");
        myList.getStyleClass().add("header-button");
        myList.setOnAction(e -> handleMyListClick());

        // Change user button
        Hyperlink changeUser = new Hyperlink(Main.getActiveUser().getName());
        changeUser.getStyleClass().add("header-button");
        changeUser.setOnAction(e -> handleChangeUserClick());

        // Middle filler
        Region filler = new Region();
        HBox.setHgrow(filler, Priority.ALWAYS);

        // Header bar
        this.getStyleClass().add("header");
        this.setAlignment(Pos.CENTER);
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
