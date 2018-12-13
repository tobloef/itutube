package netflix.views.components;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import netflix.models.User;
import netflix.models.UserType;


public class CreateUserDialog {

    public static User display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add User");
        window.setWidth(500);
        window.setHeight(175);
        window.initStyle(StageStyle.UTILITY);

        Label title = new Label("Add User:");
        Label name = new Label("Name: ");
        Label type = new Label("Type:");

        TextField nameField = new TextField();

        ComboBox<UserType> typeField = new ComboBox<>();
        typeField.getItems().addAll(
                UserType.Adult,
                UserType.Admin,
                UserType.Child
        );

        VBox vBox = new VBox(10);

        HBox nameBox = new HBox(20);
        HBox typeBox = new HBox(20);

        nameBox.getChildren().add(name);
        nameBox.getChildren().add(nameField);
        nameBox.getChildren().add(type);
        nameBox.getChildren().add(typeField);

        Button button = new Button("Create");
        button.setOnAction(e -> window.hide());

        vBox.getChildren().add(title);
        vBox.getChildren().add(nameBox);
        vBox.getChildren().add(typeBox);
        vBox.getChildren().add(button);

        window.setScene(new Scene(vBox, 300, 175));
        window.showAndWait();

        UserType userType = typeField.getValue();

        return new User(nameField.getText(), userType);
    }
}