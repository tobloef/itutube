package netflix.components;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.util.function.Consumer;

public class View1 extends StackPane {
    public View1(Consumer<Parent> changeView) {
        Button button = new Button();
        button.setText("Say 'Hello World'");
        button.setOnAction(event -> changeView.accept(new View2()));
        this.getChildren().add(button);
    }
}
