package netflix;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import netflix.models.User;
import netflix.models.media.Media;
import netflix.views.components.ImageButton;
import netflix.views.pages.ContentPage;
import netflix.views.pages.FrontPage;

import javax.xml.crypto.Data;
import java.util.List;

public class Main extends Application {

    private static Stage stage;
    private static User activeUser;
    private static List<Media> activeMedia;

    @Override
    public void start(Stage stage) {
        Database.load();
        activeUser = Database.getUsers().get(0);
        Main.stage = stage;
        activeMedia = Database.getAllMedia();

        stage.setOnCloseRequest(e -> {
            e.consume();
            saveAndClose();
        });

        stage.setTitle("ITU-tube");
        // Set default view
        FrontPage frontPage = new FrontPage();
        // Create scene with styles
        stage.setScene(new Scene(frontPage, 1280, 720));
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

    public static List<Media> getActiveMedia() {
        return activeMedia;
    }

    public static void setActiveMedia(List<Media> activeMedia) {
        Main.activeMedia = activeMedia;
    }

    public static void setActiveUser(User user) {Main.activeUser = user;}
}