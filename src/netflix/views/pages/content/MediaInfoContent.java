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

import java.text.SimpleDateFormat;

import static netflix.helpers.MediaActions.setMediaPlayContent;

/**
 * Page for displaying info about a piece of media
 */
public abstract class MediaInfoContent extends ContentPage {

    private VBox wrapper;

    /**
     * @param media Media to display info for.
     */
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

    /**
     * Add some content to the media info
     * @param content Element to add to the info
     */
    void addContent(Parent content) {
        wrapper.getChildren().add(content);
    }

    /**
     * Create the main element for the page
     * @param media Media to create info for
     * @return Main content
     */
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

    /**
     * Create element with media info
     * @param media Media to create info element for
     * @return Media info element
     */
    private Parent createMediaInfo(Media media) {
        // Title
        Text title = new Text(media.getName());
        title.setWrappingWidth(600);
        title.getStyleClass().add("info-title");
        // Release date
        String yearString = String.valueOf(media.getReleaseDate().getYear());
        Text releaseDate = new Text("Released in: " + yearString);
        releaseDate.getStyleClass().add("info-date");
        // Rating
        Text rating = new Text(media.getRating() + "/10");
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
        mediaInfo.getChildren().addAll(title, releaseDate, rating, categories, description, buttons);
        mediaInfo.getStyleClass().add("info-main-info");

        return mediaInfo;
    }

    /**
     * Create the buttons for the various media action
     * @param media Media to use with the actions
     * @return Element with action buttons
     */
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

    /**
     * Create a button for adding the media to the user's list
     * @param media Media to add
     * @param buttons Element with all the buttons, for replacing the button.
     * @param buttonIndex Index of this button, for replacing the button.
     * @return Button to add media to the user's list
     */
    private ActionButton createAddToListButton(Media media, Pane buttons, int buttonIndex) {
        return new ActionButton("+ My List", "#aa8372", e -> {
            Main.getActiveUser().addMediaToFavorites(media);
            buttons.getChildren().set(buttonIndex, createRemoveFromListButton(media, buttons, buttonIndex));
        });
    }

    /**
     * Create a button for removing the media from the user's list
     * @param media Media to remove
     * @param buttons Element with all the buttons, for replacing the button.
     * @param buttonIndex Index of this button, for replacing the button.
     * @return Button to removing media from the user's list
     */
    private ActionButton createRemoveFromListButton(Media media, Pane buttons, int buttonIndex) {
        return new ActionButton("- My List", "#aaaaaa", e -> {
            Main.getActiveUser().removeMediaFromFavorites(media);
            buttons.getChildren().set(buttonIndex, createAddToListButton(media, buttons, buttonIndex));
        });
    }
}
