package netflix;

import netflix.helpers.Actions;
import netflix.helpers.MediaSorting;
import netflix.models.media.Media;
import netflix.models.media.Movie;
import netflix.models.media.Series;
import netflix.views.pages.UserSelectPage;
import netflix.views.pages.content.FrontPage;
import netflix.views.pages.content.MediaGridPage;

import java.util.List;

public class HeaderController {

    public static void handleFrontPageClick() {
        Main.setPage(new FrontPage());
    }

    public static void handleMovieClick() {
        List<Media> movieList = MediaSorting.findByType(Movie.class, Database.getAllMedia());
        Main.setPage(new MediaGridPage("Movies", movieList, Actions::setMediaInfoContent, true));
    }

    public static void handleSeriesClick() {
        List<Media> seriesList = MediaSorting.findByType(Series.class, Database.getAllMedia());
        Main.setPage(new MediaGridPage("Series", seriesList, Actions::setMediaInfoContent, true));
    }

    public static void handleMyListClick() {
        List<Media> mediaInList = Main.getActiveUser().getFavoritesList();
        String name = nameToPossessiveForm(Main.getActiveUser().getName());
        Main.setPage(new MediaGridPage(name, mediaInList, Actions::setMediaInfoContent, true));
    }

    public static void handleChangeUserClick() {
        Main.setPage(new UserSelectPage());
    }

    private static String nameToPossessiveForm(String name) {
        if (name.endsWith("s") || name.endsWith("x") || name.endsWith("z")) {
            return name + "'";
        }
        return name + "'s";
    }
}
