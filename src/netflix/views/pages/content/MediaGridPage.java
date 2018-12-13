package netflix.views.pages.content;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import netflix.Main;
import netflix.helpers.ImageButtonInfoHelper;
import netflix.models.ImageButtonInfo;
import netflix.models.MediaList;
import netflix.models.media.Media;
import netflix.views.components.ActionButton;

import java.util.List;
import java.util.function.Consumer;

import static netflix.helpers.ImageButtonInfoHelper.categoriesToImageButtonInfos;
import static netflix.helpers.ImageButtonInfoHelper.mediasToCategories;

public class MediaGridPage extends ImageGridPage {
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
            HBox titleWrapper = this.grid.getTitleWrapper();
            if (titleWrapper == null) {
                System.err.println("Error finding title wrapper.");
            } else {
                Region filler = new Region();
                HBox.setHgrow(filler, Priority.ALWAYS);
                titleWrapper.getChildren().add(filler);
                titleWrapper.getChildren().add(categoriesButton);
            }
        }
    }
}
