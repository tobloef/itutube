package netflix.views.pages;

import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import netflix.Database;
import netflix.Main;
import netflix.helpers.Images;
import netflix.models.ImageButtonInfo;
import netflix.views.components.DialogBox;
import netflix.views.components.ImageButtonGrid;

import java.util.List;

import static netflix.helpers.ImageButtonInfoHelper.usersToImageButtonInfos;

/**
 * Page for selecting with user to use
 */
public class UserSelectPage extends ScrollPane {

    public UserSelectPage() {
        // User list
        List<ImageButtonInfo> imageButtonInfos = usersToImageButtonInfos(Database.getUsers());
        imageButtonInfos.add(new ImageButtonInfo("Add User", Images.getAddUserImage(), e -> {
            Database.addUser(DialogBox.display());
            Main.setPage(new UserSelectPage());
        }));
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
}
