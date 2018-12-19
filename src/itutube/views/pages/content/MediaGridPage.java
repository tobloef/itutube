package itutube.views.pages.content;

import itutube.Main;
import itutube.controllers.ImageButtonInfoHelper;
import itutube.controllers.NodeLookup;
import itutube.models.ImageButtonInfo;
import itutube.models.MediaList;
import itutube.models.media.Media;
import itutube.views.components.ActionButton;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import java.util.List;
import java.util.function.Consumer;

import static itutube.controllers.ImageButtonInfoHelper.categoriesToImageButtonInfos;
import static itutube.controllers.ImageButtonInfoHelper.mediasToCategories;

/**
 * Page for displaying a grid of medias, using image buttons.
 */
public class MediaGridPage extends ImageGridPage {
    /**
     * @param title Title of the grid
     * @param medias List of medias to display
     * @param handleAction Handler for what to do when a media is clicked
     * @param showCategoriesButton Whether to show the category filter button
     */
    public MediaGridPage(String title, List<Media> medias, Consumer<Media> handleAction, boolean showCategoriesButton) {
        super(title, ImageButtonInfoHelper.mediasToImageButtonInfos(medias, handleAction));

        if (showCategoriesButton) {
            // Create category page
            List<MediaList> categories = mediasToCategories(medias);
            Consumer<MediaList> handleCategoryAction = category -> {
                String newTitle = title + " - " + category.getName();
                MediaGridPage mediaGridPage = new MediaGridPage(newTitle, category.getMedia(), handleAction, false);
                Main.setPage(mediaGridPage);
            };
            List<ImageButtonInfo> imageButtonInfos = categoriesToImageButtonInfos(categories, handleCategoryAction);
            ImageGridPage categoryGridPage = new ImageGridPage(title + " - Categories", imageButtonInfos);
            ActionButton categoriesButton = new ActionButton(
                    "View categories",
                    "grey",
                    e -> Main.setPage(categoryGridPage)
            );
            // Add category button
            Node titleWrapper = NodeLookup.findFirstByClassName(this, "title-wrapper");
            if (!(titleWrapper instanceof HBox)) {
                System.err.println("Error finding title wrapper, can't add category filter button.");
            } else {
                Region filler = new Region();
                HBox.setHgrow(filler, Priority.ALWAYS);
                ((HBox) titleWrapper).getChildren().add(filler);
                ((HBox) titleWrapper).getChildren().add(categoriesButton);
            }
        }
    }
}
