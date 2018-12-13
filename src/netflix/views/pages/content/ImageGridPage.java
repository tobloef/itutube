package netflix.views.pages.content;

import netflix.models.ImageButtonInfo;
import netflix.views.components.ImageButtonGrid;
import netflix.views.pages.ContentPage;

import java.util.List;

public class ImageGridPage extends ContentPage {
    ImageButtonGrid grid;

    public ImageGridPage(String title, List<ImageButtonInfo> infos) {
        super();
        grid = new ImageButtonGrid(title, infos);
        this.setContent(grid);
    }
}
