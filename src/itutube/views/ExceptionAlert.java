package itutube.views;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * An pop-up alert for exceptions. Displays a scrollable exception.
 */
public class ExceptionAlert extends Alert {
    public ExceptionAlert(String title, String content, Throwable exception) {
        super(AlertType.ERROR);
        this.setTitle(title);
        this.setContentText(content);
        Parent exceptionContent = createScrollableStackTrace(exception);
        this.getDialogPane().setExpandableContent(exceptionContent);
    }

    /**
     * Generates a UI element in form of a scrollable stacktrace from a given exception.
     * @param exception The exception from which to get the stacktrace.
     * @return A Parent containing a stacktrace UI-element.
     */
    private Parent createScrollableStackTrace(Throwable exception) {
        // Create expandable Exception.
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        String exceptionText = stringWriter.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane content = new GridPane();
        content.setMaxWidth(Double.MAX_VALUE);
        content.add(label, 0, 0);
        content.add(textArea, 0, 1);
        return content;
    }
}
