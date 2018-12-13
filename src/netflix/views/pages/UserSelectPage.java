package netflix.views.pages;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import netflix.Database;
import netflix.Main;
import netflix.helpers.ImageHelper;
import netflix.models.ImageButtonInfo;
import netflix.models.User;
import netflix.views.components.ActionButton;
import netflix.views.components.DialogBox;
import netflix.views.components.ImageButtonList;

import javax.naming.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO

/**
 * Page for selecting with user to use
 */
public class UserSelectPage extends BorderPane {

    public UserSelectPage() {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        VBox stack = new VBox();
        scrollPane.setFitToWidth(true);
        this.setCenter(stack);
        ImageButtonList imageButtonList = new ImageButtonList("Select User:", userListToImageButtonInfoList(Database.getUsers()));
        scrollPane.setContent(imageButtonList);
        stack.getChildren().add(scrollPane);
    }

    private static List<ImageButtonInfo> userListToImageButtonInfoList(List<User> userList) {
        List<ImageButtonInfo> infoList = new ArrayList<>();
        for (User user : userList) {
            String text = user.getName();
            Image image = ImageHelper.getUserImage(user);
            infoList.add(new ImageButtonInfo(text, image, e -> {
                Main.setActiveUser(user);
                Main.setPage(new FrontPage());
            }));
        }
        infoList.add(new ImageButtonInfo("add", ImageHelper.getMediaPoster(null), e -> {
            Database.addUser(DialogBox.display());
            Main.setPage(new UserSelectPage());
        }));
        return infoList;
    }
}
