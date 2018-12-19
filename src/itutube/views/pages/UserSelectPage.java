package itutube.views.pages;

import itutube.Database;
import itutube.Main;
import itutube.exceptions.UsernameTakenException;
import itutube.controllers.Images;
import itutube.models.ImageButtonInfo;
import itutube.models.User;
import itutube.views.components.CreateUserDialog;
import itutube.views.components.ImageButtonGrid;
import itutube.views.pages.content.FrontPage;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.List;

import static itutube.controllers.ImageButtonInfoHelper.usersToImageButtonInfos;

/**
 * Page for selecting which user to use
 */
public class UserSelectPage extends ScrollPane {

    public UserSelectPage() {
        // User list
        List<ImageButtonInfo> imageButtonInfos = usersToImageButtonInfos(Database.getUsers(), this::handleClickUser);
        imageButtonInfos.add(new ImageButtonInfo("Add User", Images.getAddUserImage(), e -> this.handleAddUser()));
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

    /**
     * Opens user creation pop-up, validates the user and tries to add the user to the database.
     */
    private void handleAddUser() {
        User newUser = CreateUserDialog.display();
        if (userInfoIsValid(newUser)) {
            try {
                Database.addUser(newUser);
            }
            catch (UsernameTakenException err) {
                errorAddingUser("This username is already taken. Please try again with another username.");
            }
        } else {
            errorAddingUser("The user couldn't be added. Please try again with the correct info.");
        }
        Main.setPage(new UserSelectPage());
    }

    private void handleClickUser(User user) {
        Main.setActiveUser(user);
        Main.setPage(new FrontPage());
    }


    private boolean userInfoIsValid(User user) {
        if (user == null) {
            return false;
        }
        if (user.getName().equals("")) {
            return false;
        }
        if (user.getType() == null) {
            return false;
        }
        return true;
    }

    private static void errorAddingUser(String reason) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Can't create user");
        alert.setContentText(reason);
        alert.showAndWait();
    }
}
