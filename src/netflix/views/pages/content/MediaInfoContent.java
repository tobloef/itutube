package netflix.views.pages.content;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import netflix.Main;
import netflix.helpers.Images;
import netflix.models.Playable;
import netflix.models.Saveable;
import netflix.models.media.Media;
import netflix.views.components.ActionButton;
import netflix.views.pages.ContentPage;

import static netflix.helpers.MediaActions.setMediaPlayContent;

public abstract class MediaInfoContent extends ContentPage {

    private VBox wrapper;

    public MediaInfoContent(Media media) {
        super();
        wrapper = new VBox();
        wrapper.getChildren().add(createMainContent(media));
        wrapper.getStyleClass().add("info-wrapper");
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(wrapper);
        this.setCenter(scrollPane);
    }

    void addContent(Parent content) {
        wrapper.getChildren().add(content);
    }

    private Parent createMainContent(Media media) {
        // Create elements
        ImageView image = new ImageView(Images.getMediaImage(media));
        Parent mediaInfo = createMediaInfo(media);
        // Create main content
        HBox mainContent = new HBox();
        mainContent.getChildren().add(image);
        mainContent.getChildren().add(mediaInfo);
        mainContent.getStyleClass().add("info-main-layout");
        return mainContent;
    }

    private Parent createMediaInfo(Media media) {
        // Title
        Text title = new Text(media.getName());
        title.setWrappingWidth(600);
        title.getStyleClass().add("info-title");
        // Rating
        Text rating = new Text(String.valueOf(media.getRating()) + "/10");
        rating.getStyleClass().add("info-rating");
        // Categories
        Text categories = new Text();
        categories.setText(String.join(", ", media.getCategories()));
        categories.getStyleClass().add("info-categories");
        // Description
        Text description = new Text(media.getDescription());
        description.setWrappingWidth(500);
        description.getStyleClass().add("info-description");
        // Action buttons
        Parent buttons = createActionButtons(media);
        // Create main media info
        VBox mediaInfo = new VBox(20);
        mediaInfo.getChildren().add(title);
        mediaInfo.getChildren().add(rating);
        mediaInfo.getChildren().add(categories);
        mediaInfo.getChildren().add(description);
        mediaInfo.getChildren().add(buttons);
        mediaInfo.getStyleClass().add("info-main-info");

        return mediaInfo;
    }

    private Parent createActionButtons(Media media) {
        HBox buttons = new HBox(20);

        if (media instanceof Playable) {
            ActionButton playButton = new ActionButton("Play", "#ff4e00", e -> setMediaPlayContent(media));
            buttons.getChildren().add(playButton);
        }

        if (media instanceof Saveable) {
            ActionButton listButton;
            int listButtonIndex = buttons.getChildren().size();
            if (Main.getActiveUser().getFavoritesList().contains(media)) {
                listButton = createRemoveFromListButton(media, buttons, listButtonIndex);
            } else {
                listButton = createAddToListButton(media, buttons, listButtonIndex);
            }
            buttons.getChildren().add(listButton);
        }
        return buttons;
    }

    private ActionButton createAddToListButton(Media media, Pane buttons, int buttonIndex) {
        return new ActionButton("+ My List", "#aa8372", e -> {
            Main.getActiveUser().addMediaToFavorites(media);
            Alert addedAlert = new Alert(Alert.AlertType.INFORMATION);
            addedAlert.setTitle("Added to list");
            addedAlert.setHeaderText("Added to list");
            addedAlert.setContentText("\"" + media.getName() + "\" has been successfully added to your list.");
            addedAlert.showAndWait();
            buttons.getChildren().set(buttonIndex, createRemoveFromListButton(media, buttons, buttonIndex));
        });
    }

    private ActionButton createRemoveFromListButton(Media media, Pane buttons, int buttonIndex) {
        return new ActionButton("- My List", "#aaaaaa", e -> {
            Main.getActiveUser().removeMediaFromFavorites(media);
            Alert addedAlert = new Alert(Alert.AlertType.INFORMATION);
            addedAlert.setTitle("Removed from list");
            addedAlert.setHeaderText("Removed from list");
            addedAlert.setContentText("\"" + media.getName() + "\" has been removed from your list.");
            addedAlert.showAndWait();
            buttons.getChildren().set(buttonIndex, createAddToListButton(media, buttons, buttonIndex));
        });
    }
}
