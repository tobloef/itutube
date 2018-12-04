package netflix;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import netflix.components.View1;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("ITU-tube");
        View1 testView = new View1(this::changeView);
        primaryStage.setScene(new Scene(testView, 600, 400));
        primaryStage.show();
    }

    private void changeView(Parent newView) {
        primaryStage.getScene().setRoot(newView);
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println();
    }
}
