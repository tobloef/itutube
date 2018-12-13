package netflix.views;

import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import netflix.Database;
import netflix.Main;
import netflix.helpers.MediaActions;
import netflix.helpers.MediaSorting;
import netflix.models.media.Media;
import netflix.models.media.Movie;
import netflix.models.media.Series;
import netflix.views.components.SearchBar;
import netflix.views.pages.UserSelectPage;
import netflix.views.pages.content.FrontPage;
import netflix.views.pages.content.MediaGridPage;

import java.util.List;

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

    private static void handleFrontPageClick() {
        Main.setPage(new FrontPage());
    }

    private static void handleMovieClick() {
        List<Media> movieList = MediaSorting.findByType(Movie.class, Database.getAllMedia());
        Main.setPage(new MediaGridPage("Movies", movieList, MediaActions::setMediaInfoContent, true));
    }

    private static void handleSeriesClick() {
        List<Media> seriesList = MediaSorting.findByType(Series.class, Database.getAllMedia());
        Main.setPage(new MediaGridPage("Series", seriesList, MediaActions::setMediaInfoContent, true));
    }

    private static void handleMyListClick() {
        List<Media> mediaInList = Main.getActiveUser().getFavoritesList();
        String name = nameToPossessiveForm(Main.getActiveUser().getName()) + " List";
        Main.setPage(new MediaGridPage(name, mediaInList, MediaActions::setMediaInfoContent, false));
    }

    private static void handleChangeUserClick() {
        Main.setPage(new UserSelectPage());
    }

    private static String nameToPossessiveForm(String name) {
        if (name.endsWith("s") || name.endsWith("x") || name.endsWith("z")) {
            return name + "'";
        }
        return name + "'s";
    }
}
