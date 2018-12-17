package itutube.views.pages.content;

import itutube.models.ImageButtonInfo;
import itutube.views.components.ImageButtonGrid;
import itutube.views.pages.ContentPage;

import java.util.List;

/**
 * Simple page for displaying a grid of image buttons.
 */
public class ImageGridPage extends ContentPage {

    /**
     * @param title Title of the grid
     * @param infos List of items for the grid
     */
    public ImageGridPage(String title, List<ImageButtonInfo> infos) {
        super();
        this.setContent(new ImageButtonGrid(title, infos));
    }
}
