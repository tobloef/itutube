package netflix;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import netflix.helpers.ImageHelper;
import netflix.helpers.MediaListHelper;
import netflix.models.ImageButtonInfo;
import netflix.models.Viewable;
import netflix.models.media.Media;
import netflix.views.pages.FrontPage;
import netflix.views.pages.ImageButtonGrid;
import netflix.views.pages.UserSelectPage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeaderController implements EventHandler {

    @Override
    public void handle(Event event) {

    }

    public static void handleFrontPageClick(ActionEvent event) {
        List<Media> mediaList = Database.getAllMedia();
        Main.setActiveMedia(mediaList);
        Main.setPage(new FrontPage());
    }

    public static void handleMovieClick(ActionEvent event) {
        List<Media> movieList = MediaListHelper.findByType("Movie", Database.getAllMedia());
        List<ImageButtonInfo> movieButtonInfoList = MediaListHelper.getListAsImageButtonInfoList(movieList);
        Main.setActiveMedia(movieList);
        Main.setPage(new ImageButtonGrid("Movies", movieButtonInfoList));
    }

    public static void handleSeriesClick(ActionEvent event) {
        List<Media> seriesList = MediaListHelper.findByType("Series", Database.getAllMedia());
        List<ImageButtonInfo> seriesButtonInfoList = MediaListHelper.getListAsImageButtonInfoList(seriesList);
        Main.setActiveMedia(seriesList);
        Main.setPage(new ImageButtonGrid("Series", seriesButtonInfoList));
    }

    public static void handleCategoriesClick(ActionEvent event) {
        List<ImageButtonInfo> categoryButtonInfoList = getCategoriesAsImageButtonInfoList(Main.getActiveMedia());
        Main.setPage(new ImageButtonGrid("Categories", categoryButtonInfoList));
    }

    public static void handleMyListClick(ActionEvent event) {
        List<ImageButtonInfo> myListButtonInfoList = MediaListHelper.getListAsImageButtonInfoList(Main.getActiveUser().getFavoritesList());
        Main.setPage(new ImageButtonGrid(Main.getActiveUser().getName() + "'s List", myListButtonInfoList));
    }

    public static void handleChangeUserClick(ActionEvent event) {
        Main.setPage(new UserSelectPage());
    }


    private static List<ImageButtonInfo> getCategoriesAsImageButtonInfoList(List<Media> mediaList) {
        List<ImageButtonInfo> categoryList = new ArrayList<>();
        for(String s : getAllCategories(mediaList)) {
            List<ImageButtonInfo> mediaButtonList = new ArrayList<>();
            for(Media m : mediaList) {
                if(m instanceof Viewable) {
                    Viewable viewable = (Viewable) m;
                    if (Arrays.asList(m.getCategories()).contains(s)) {
                        mediaButtonList.add(new ImageButtonInfo(m.getName(), ImageHelper.getMediaPoster(m), e -> Main.setPage(viewable.createInfoView())));
                    }
                }
            }
            categoryList.add(new ImageButtonInfo(s, null, e -> Main.setPage(new ImageButtonGrid(s, mediaButtonList))));
        }
        return categoryList;
    }

    private static List<String> getAllCategories(List<Media> mediaList) {
        List<String> categories = new ArrayList<>();
        for(Media m : mediaList) {
            for(String s : m.getCategories()) {
                if(!categories.contains(s)) {
                    categories.add(s);
                }
            }
        }
        return categories;
    }

}
