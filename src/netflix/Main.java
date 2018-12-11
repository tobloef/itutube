package netflix;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import netflix.views.pages.ContentPage;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {
        Database.load();
        this.stage = stage;
        stage.setTitle("ITU-tube");
        // Set default view
        ContentPage contentPage = new ContentPage(this::setPage);
        // Create scene with styles
        stage.setScene(new Scene(contentPage, 1280, 720));
        String style = getClass().getResource("style.css").toExternalForm();
        stage.getScene().getStylesheets().add(style);
        stage.show();
    }

    private void setPage(Parent page) {
        stage.getScene().setRoot(page);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
