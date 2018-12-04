package netflix.components;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class View2 extends StackPane {
    public View2() {
        Button button = new Button();
        button.setText("The new view!");
        this.getChildren().add(button);
    }
}
