package netflix;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import netflix.models.User;
import netflix.views.pages.UserSelectPage;

public class Main extends Application {

    private static Stage stage;
    private static User activeUser;

    @Override
    public void start(Stage stage) {
        Database.load();
        // Setup stage
        Main.stage = stage;
        stage.setTitle("ITU-tube");
        stage.setOnCloseRequest(e -> {
            e.consume();
            saveAndClose();
        });
        // Set default view
        Parent defaultPage = new UserSelectPage();
        // Create scene with styles
        stage.setScene(new Scene(defaultPage, 1280, 720));
        String style = getClass().getResource("style.css").toExternalForm();
        stage.getScene().getStylesheets().add(style);
        stage.show();
    }

    public static void setPage(Parent page) {
        stage.getScene().setRoot(page);
    }

    private void saveAndClose() {
        Database.save();
        stage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static User getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(User user) {
        Main.activeUser = user;
    }
}