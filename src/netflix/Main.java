package netflix;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import netflix.helpers.DataGetterHelper;
import netflix.models.User;
import netflix.models.UserType;
import netflix.models.media.Media;
import netflix.views.pages.ContentPage;
import netflix.views.creators.ViewCreator;
import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static netflix.Database.getUsers;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {

        this.stage = stage;
        stage.setTitle("ITU-tube");
        StackPane contentPage = new StackPane();
        //ContentPage contentPage = new ContentPage(this::setPage);
        stage.setScene(new Scene(contentPage, 600, 400));
        stage.show();

    }

    private void setPage(ViewCreator creator) {
        Parent page = creator.create();
        stage.getScene().setRoot(page);
    }

    public static void main(String[] args) {
        Database.load();
        ArrayList<Media> favs = new ArrayList<>();
        favs.add(Database.getMediaById("150"));
        favs.add(Database.getMediaById("080"));
        Database.addUser(new User("Vince Offer", UserType.Admin, favs));
        DataGetterHelper.searchInMedia("the go"); //DEBUG CODE
        Database.save();
        launch(args);
    }
}
