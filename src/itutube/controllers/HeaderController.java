package itutube.controllers;

import itutube.Database;
import itutube.Helpers.MediaSorting;
import itutube.Main;
import itutube.models.media.Media;
import itutube.models.media.Movie;
import itutube.models.media.Series;
import itutube.views.pages.UserSelectPage;
import itutube.views.pages.content.MediaGridPage;

import java.util.List;

import static itutube.controllers.PageActions.setFrontPage;

public class HeaderController {
    /**
     * Go to the front page
     */
    public static void handleFrontPageClick() {
        setFrontPage();
    }

    /**
     * Go to the movies page
     */
    public static void handleMovieClick() {
        List<Media> movieList = MediaSorting.findByType(Movie.class, Database.getAllMedia(Main.getActiveUser().getType()));
        Main.setPage(new MediaGridPage("Movies", movieList, PageActions::setMediaInfoContent, true));
    }

    /**
     * Go to the series page
     */
    public static void handleSeriesClick() {
        List<Media> seriesList = MediaSorting.findByType(Series.class, Database.getAllMedia(Main.getActiveUser().getType()));
        Main.setPage(new MediaGridPage("Series", seriesList, PageActions::setMediaInfoContent, true));
    }

    /**
     * Go to the user's favorites list page
     */
    public static void handleMyListClick() {
        List<Media> mediaInList = Main.getActiveUser().getFavoritesList();
        String name = nameToPossessiveForm(Main.getActiveUser().getName()) + " List";
        Main.setPage(new MediaGridPage(name, mediaInList, PageActions::setMediaInfoContent, false));
    }

    /**
     * Go to the change user page
     */
    public static void handleChangeUserClick() {
        Main.setPage(new UserSelectPage());
    }

    /**
     * Convert a name to the possessive form, with a 's or ' suffix.
     * @param name The name to convert
     * @return The name in possessive form
     */
    private static String nameToPossessiveForm(String name) {
        if (name.endsWith("s") || name.endsWith("x") || name.endsWith("z")) {
            return name + "'";
        }
        return name + "'s";
    }
}
