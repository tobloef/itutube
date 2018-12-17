package itutube.helpers;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;

import java.util.ArrayList;
import java.util.List;

public class NodeLookup {
    /**
     * Recursively find the first node in the hierarchy by its class name.
     * @param parent The parent node
     * @param className The class name to search for
     * @return The first node with a matching class name or null.
     */
    public static Node findFirstByClass(Parent parent, String className) {
        List<Node> children = new ArrayList<>(parent.getChildrenUnmodifiable());
        if (parent instanceof ScrollPane) {
            Node child = ((ScrollPane) parent).getContent();
            if (child != null) {
                children.add(child);
            }
        }
        for (Node child : children) {
            if (child.getStyleClass().contains(className)) {
                return child;
            }
            if (child instanceof Parent) {
                Node result = findFirstByClass((Parent) child, className);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}
