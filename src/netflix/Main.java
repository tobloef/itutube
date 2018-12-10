package netflix;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import netflix.helpers.DataGetterHelper;
import netflix.models.User;
import netflix.models.UserType;
import netflix.models.media.Media;
import netflix.views.components.MediaButton;
import netflix.views.components.MediaButtonList;
import netflix.views.pages.ContentPage;
import netflix.views.creators.ViewCreator;
import java.awt.*;
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
        String style = getClass().getResource("style.css").toExternalForm();

        ScrollPane wrapperPage = new ScrollPane();
        wrapperPage.setFitToWidth(true);
        wrapperPage.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        VBox contentPage = new VBox(5);

        //ContentPage contentPage = new ContentPage(this::setPage);

        contentPage.getStylesheets().add(style);
        wrapperPage.getStyleClass().add(style);
        contentPage.setId("contentPage");
        wrapperPage.setId("contentStack");


        Media[] media = {Database.getMediaById("011"), Database.getMediaById("012"), Database.getMediaById("013"), Database.getMediaById("014"), Database.getMediaById("011"), Database.getMediaById("012"), Database.getMediaById("013"), Database.getMediaById("014"), Database.getMediaById("011"), Database.getMediaById("012"), Database.getMediaById("013"), Database.getMediaById("014")};
        Media[] media2 = {Database.getMediaById("021"), Database.getMediaById("022"), Database.getMediaById("023")};
        Media[] media3 = {Database.getMediaById("011"), Database.getMediaById("012"), Database.getMediaById("013"), Database.getMediaById("014"), Database.getMediaById("011"), Database.getMediaById("012"), Database.getMediaById("013"), Database.getMediaById("014"), Database.getMediaById("011"), Database.getMediaById("012"), Database.getMediaById("013"), Database.getMediaById("014")};

        contentPage.getChildren().add(new MediaButtonList("movies1", media));
        contentPage.getChildren().add(new MediaButtonList("movies2", media2));
        contentPage.getChildren().add(new MediaButtonList("movies3", media3));

        wrapperPage.setContent(contentPage);

        stage.setScene(new Scene(wrapperPage, 1280, 720));
        stage.show();
    }

    private void setPage(ViewCreator creator) {
        Parent page = creator.create();
        stage.getScene().setRoot(page);
    }

    public static void main(String[] args) {
        Database.load();

        launch(args);
    }
}
