package netflix.views.pages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import netflix.Database;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import netflix.helpers.ImageHelper;
import netflix.models.ImageButtonInfo;
import netflix.models.User;
import netflix.models.media.Media;
import netflix.views.components.ImageButton;
import netflix.views.components.ImageButtonList;

// TODO

/**
 * Page for selecting with user to use
 */
public class UserSelectPage extends BorderPane {

    private VBox wrapper;

    public UserSelectPage(Consumer<User> handleAction) {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setFitToWidth(true);
        wrapper = new VBox();
        wrapper.getStyleClass().add("content-wrapper");
        scrollPane.setContent(wrapper);
        this.setCenter(scrollPane);
        ImageButtonList imageButtonList = new ImageButtonList("Select User:", userListToImageButtonInfoList(Database.getUsers(), handleAction));
        setContent(imageButtonList);
    }

    private static List<ImageButtonInfo> userListToImageButtonInfoList(List<User> userList, Consumer<User> handleAction) {
        List<ImageButtonInfo> infoList = new ArrayList<>();
        for (User user : userList) {
            String text = user.getName();
            Image image = ImageHelper.getUserImage(user);
            EventHandler<ActionEvent> eventHandler = event -> handleAction.accept(user);
            infoList.add(new ImageButtonInfo(text, image, eventHandler));
        }
        return infoList;
    }

    private void setContent(Parent view) {
        wrapper.getChildren().clear();
        wrapper.getChildren().add(view);
    }
}


