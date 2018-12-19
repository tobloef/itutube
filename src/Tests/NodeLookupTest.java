package Tests;

import itutube.controllers.NodeLookup;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

public class NodeLookupTest {
    private static BorderPane testParent;

    private static BorderPane createBorderPaneParent() {
        Text text1 = new Text("Text 1");
        Text text2 = new Text("Text 1");
        text2.getStyleClass().add("target1");
        Text text3 = new Text("Text 1");
        HBox top = new HBox();
        top.getChildren().addAll(text1, text2, text3);

        Button button3 = new Button("Button 1");
        Button button4 = new Button("Button 2");
        button3.getStyleClass().add("target3");
        VBox scrollContent2 = new VBox();
        scrollContent2.getChildren().addAll(button3, button4);
        ScrollPane nestedScrollPane = new ScrollPane();
        nestedScrollPane.setContent(scrollContent2);

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        button2.getStyleClass().add("target2");
        VBox scrollContent = new VBox();
        scrollContent.getChildren().addAll(button1, button2, nestedScrollPane);

        ScrollPane center = new ScrollPane();
        center.setContent(scrollContent);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(top);
        borderPane.setCenter(center);
        return borderPane;
    }

    @BeforeAll
    static void setup() {
        // From https://stackoverflow.com/a/18980655/4688606
        try {
            Thread thread = new Thread(() -> {
                new JFXPanel();
                Platform.runLater(() -> testParent = createBorderPaneParent());
            });
            thread.start();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void findFirstByClass_Success_BorderPaneTarget() {
        assertNotNull(NodeLookup.findFirstByClassName(testParent, "target1"));
    }

    @Test
    void findFirstByClass_Success_ScrollPaneTarget() {
        assertNotNull(NodeLookup.findFirstByClassName(testParent, "target2"));
    }

    @Test
    void findFirstByClass_Success_NestedScrollPaneTarget() {
        assertNotNull(NodeLookup.findFirstByClassName(testParent, "target3"));
    }

    @Test
    void findFirstByClass_Fail_ClassNameNotFound() {
        assertNull(NodeLookup.findFirstByClassName(testParent, "is-not-there"));
    }
}
