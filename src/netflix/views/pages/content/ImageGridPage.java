package netflix.views.pages.content;

import netflix.models.ImageButtonInfo;
import netflix.views.components.ImageButtonGrid;
import netflix.views.pages.ContentPage;

import java.util.List;

/**
 * Simple page for displaying a grid of image buttons.
 */
public class ImageGridPage extends ContentPage {

    ImageButtonGrid grid;

    /**
     * @param title Title of the grid
     * @param infos List of items for the grid
     */
    public ImageGridPage(String title, List<ImageButtonInfo> infos) {
        super();
        grid = new ImageButtonGrid(title, infos);
        this.setContent(grid);
    }
}
