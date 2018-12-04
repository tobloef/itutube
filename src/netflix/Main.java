package netflix;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import netflix.models.media.Media;
import netflix.views.pages.ContentPage;
import netflix.views.creators.ViewCreator;

import javax.xml.crypto.Data;
import java.util.Arrays;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {

        this.stage = stage;
        stage.setTitle("ITU-tube");
        StackPane stackpane = new StackPane();
        //ContentPage contentPage = new ContentPage(this::setPage);
        stage.setScene(new Scene(stackpane, 600, 400));
        stage.show();

    }

    private void setPage(ViewCreator creator) {
        Parent page = creator.create();
        stage.getScene().setRoot(page);
    }

    public static void main(String[] args) {
        Database.load();
        for(Media m : Database.getMediaList()) {
            System.out.println(m.getId() + ";" + m.getName() + ";" + Arrays.toString(m.getCategories()) + ";" + m.getRating() + ";");
        }
        launch(args);

    }
}
