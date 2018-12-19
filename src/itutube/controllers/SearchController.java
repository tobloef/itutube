package itutube.controllers;

import itutube.Database;
import itutube.Main;
import itutube.models.media.Media;
import itutube.views.pages.content.MediaGridPage;

import java.util.List;

public class SearchController {
    public static void searchAction(String query) {
        List<Media> results = MediaSorting.findBySearch(query, Database.getAllMedia(Main.getActiveUser().getType()));
        String title = results.size() + " result";
        if (results.size() > 1) {
            title += "s";
        }
        title += " for: \"" + query + "\"";
        Main.setPage(new MediaGridPage(title, results, MediaActions::setMediaInfoContent, false));
    }
}
