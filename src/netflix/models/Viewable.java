package netflix.models;

import javafx.scene.Parent;
import netflix.views.content.infoview.MediaInfoContent;

public interface Viewable {
    public Parent createInfoView();
}
