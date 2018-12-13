package netflix.views.pages.content;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import netflix.Main;
import netflix.helpers.Images;
import netflix.models.Playable;
import netflix.models.Saveable;
import netflix.models.media.Media;
import netflix.views.components.ActionButton;
import netflix.views.pages.ContentPage;

public abstract class MediaInfoContent extends ContentPage {

    public MediaInfoContent(Media media, VBox extraContent) {
        super();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.setCenter(scrollPane);
        VBox wrapper = new VBox();

        Parent mainLayout = getMainContent(media);

        wrapper.getChildren().add(mainLayout);
        wrapper.getChildren().add(extraContent);
        scrollPane.setContent(wrapper);

        wrapper.getStyleClass().add("info-wrapper");
    }

    public MediaInfoContent(Media media) {
        super();

        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        VBox wrapper = new VBox();

        Parent mainLayout = getMainContent(media);

        wrapper.getChildren().add(mainLayout);

        scrollPane.setContent(wrapper);

        wrapper.getStyleClass().add("info-wrapper");
    }

    private Parent getMainContent(Media media) {
        HBox mainLayout = new HBox();

        mainLayout.getChildren().add(new ImageView(Images.getMediaImage(media)));

        VBox mainInfo = new VBox(20);

        Text title = new Text(media.getName());
        Text rating = new Text(String.valueOf(media.getRating()) + "/10");
        Text categories = new Text();
        Text description = new Text(media.getDescription());

        categories.setText(String.join(", ", media.getCategories()));


        title.setWrappingWidth(600);
        description.setWrappingWidth(500);

        mainInfo.getChildren().add(title);
        mainInfo.getChildren().add(rating);
        mainInfo.getChildren().add(categories);
        mainInfo.getChildren().add(description);

        HBox buttons = new HBox(20);

        if(media instanceof Playable) {
            ActionButton playButton = new ActionButton("Play", "#ff4e00", e -> Main.setPage(((Playable) media).createPlayView()));
            buttons.getChildren().add(playButton);
        }

        if(media instanceof Saveable) {
            ActionButton addToListButton;
            if (Main.getActiveUser().getFavoritesList().contains(media)) {
                addToListButton = new ActionButton("- My List", "#aaaaaa", e -> {
                    Main.getActiveUser().removeMediaFromFavorites(media);
                    Alert addedAlert = new Alert(Alert.AlertType.INFORMATION);
                    addedAlert.setTitle("Removed from list");
                    addedAlert.setHeaderText("Removed from list");
                    addedAlert.setContentText("\"" + media.getName() + "\" has been removed from your list.");
                    addedAlert.showAndWait();
                });
            } else {
                addToListButton = new ActionButton("+ My List", "#aa8372", e -> {
                    Main.getActiveUser().addMediaToFavorites(media);
                    Alert addedAlert = new Alert(Alert.AlertType.INFORMATION);
                    addedAlert.setTitle("Added to list");
                    addedAlert.setHeaderText("Added to list");
                    addedAlert.setContentText("\"" + media.getName() + "\" has been successfully added to your list.");
                    addedAlert.showAndWait();
                });
            }
            buttons.getChildren().add(addToListButton);
        }
        mainInfo.getChildren().add(buttons);

        mainLayout.getChildren().add(mainInfo);


        mainLayout.getStyleClass().add("info-main-layout");
        mainInfo.getStyleClass().add("info-main-info");
        title.getStyleClass().add("info-title");
        rating.getStyleClass().add("info-rating");
        description.getStyleClass().add("info-description");

        return mainLayout;
    }
}
