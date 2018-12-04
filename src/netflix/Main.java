package netflix;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import netflix.views.pages.ContentPage;
import netflix.views.creators.ViewCreator;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("ITU-tube");
        ContentPage contentPage = new ContentPage(this::setPage);
        stage.setScene(new Scene(contentPage, 600, 400));
        stage.show();
    }

    private void setPage(ViewCreator creator) {
        Parent page = creator.create();
        stage.getScene().setRoot(page);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
