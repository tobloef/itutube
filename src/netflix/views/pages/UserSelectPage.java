package netflix.views.pages;

import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import netflix.Database;
import netflix.Main;
import netflix.helpers.Images;
import netflix.models.ImageButtonInfo;
import netflix.models.User;
import netflix.views.components.ImageButtonGrid;
import netflix.views.pages.content.FrontPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Page for selecting with user to use
 */
public class UserSelectPage extends ScrollPane {

    public UserSelectPage() {
        // User list
        List<ImageButtonInfo> imageButtonInfos = usersToImageButtonInfos(Database.getUsers());
        Parent usersView = new ImageButtonGrid("Select User", imageButtonInfos);
        usersView.getStyleClass().add("center");
        // Wrapper
        VBox wrapper = new VBox();
        wrapper.getStyleClass().add("user-select-wrapper");
        wrapper.getStyleClass().add("center");
        wrapper.getChildren().add(usersView);
        wrapper.setFillWidth(true);

        this.setFitToWidth(true);
        this.setContent(wrapper);
    }

    private static List<ImageButtonInfo> usersToImageButtonInfos(List<User> users) {
        List<ImageButtonInfo> infos = new ArrayList<>();
        for (User user : users) {
            String text = user.getName();
            Image image = Images.getUserImage(user);
            infos.add(new ImageButtonInfo(text, image, e -> {
                Main.setActiveUser(user);
                Main.setPage(new FrontPage());
            }));
        }
        return infos;
    }
}
