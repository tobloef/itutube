package itutube;

import itutube.exceptions.DatabaseIOException;
import itutube.models.User;
import itutube.views.ExceptionAlert;
import itutube.views.pages.UserSelectPage;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stage;
    private static User activeUser;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Set global exception handler
        Thread.currentThread().setUncaughtExceptionHandler((thread, exception) -> {
            Alert alert = new ExceptionAlert(
                    "Unhandled error",
                    "Unfortunately the program encountered an unexpected error and couldn't continue. Sorry about that!",
                    exception
            );
            alert.showAndWait();
            cleanup();
            stage.close();
        });
        // Load database
        try {
            Database.load();
        } catch (DatabaseIOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error when loading the database.");
            alert.setContentText("Couldn't load the database from the disk.");
            alert.showAndWait();
            return;
        }
        // Setup stage
        Main.stage = stage;
        stage.setTitle("ITU-tube");
        stage.setOnCloseRequest(event -> {
            event.consume();
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
        try {
            Database.save();
        } catch (Exception exception) {
            System.err.println("Error cleaning up application." + exception.getMessage());
        }
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