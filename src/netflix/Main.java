package netflix;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import netflix.models.User;
import netflix.views.pages.ContentPage;
import netflix.views.pages.UserSelectPage;

public class Main extends Application {

    private Stage stage;
    private User activeUser;

    @Override
    public void start(Stage stage) {
        Database.load();
        this.stage = stage;
        stage.setTitle("ITU-tube");
        // Set default view
        //ContentPage contentPage = new ContentPage(this::setPage);
        UserSelectPage contentPage = new UserSelectPage(this::setPage, this::setActiveUser);
        // Create scene with styles
        stage.setScene(new Scene(contentPage, 1280, 720));
        String style = getClass().getResource("style.css").toExternalForm();
        stage.getScene().getStylesheets().add(style);
        stage.show();

    }

    private void setPage(Parent page) {
        stage.getScene().setRoot(page);
    }

    private void setActiveUser(User user) {
        this.activeUser = user;
        // System.out.println("Active user: " + activeUser.getName()); debug code
    }

    public static void main(String[] args) {
        launch(args);
    }
}
