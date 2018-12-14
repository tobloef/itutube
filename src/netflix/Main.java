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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Database.load();
        // Setup stage
        Main.stage = stage;
        stage.setTitle("ITU-tube");
        stage.setOnCloseRequest(e -> {
            e.consume();
            cleanup();
            stage.close();
        });
        // Set default view
        Parent defaultPage = new UserSelectPage();
        // Create scene with styles
        stage.setScene(new Scene(defaultPage, 1280, 720));
        String style = getClass().getResource("style.css").toExternalForm();
        stage.getScene().getStylesheets().add(style);
        stage.show();
    }

    /**
     * Set the current active view to display in the view
     * @param page Page to display
     */
    public static void setPage(Parent page) {
        stage.getScene().setRoot(page);
    }

    /**
     * Do anything necessary before the application closes
     */
    private void cleanup() {
        Database.save();
    }

    /**
     * Get the currently logged in user
     * @return Logged in user
     */
    public static User getActiveUser() {
        return activeUser;
    }

    /**
     * Set the currently logged in user
     * @param user User to log in
     */
    public static void setActiveUser(User user) {
        Main.activeUser = user;
    }
}