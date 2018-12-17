package itutube.models;

import javafx.scene.Parent;
/**
 * Interface specifying that a media is somehow viewable
 */
public interface Viewable {
    Parent createInfoView();
}
