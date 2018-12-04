package netflix.creators;

import javafx.scene.Parent;
import netflix.models.MediaList;
import netflix.views.content.FrontPageContent;

public class FrontPageCreator extends ViewCreator {

    private final MediaList[] mediaLists;

    public FrontPageCreator(MediaList[] mediaLists) {
        this.mediaLists = mediaLists;
    }

    @Override
    public Parent create() {
        return new FrontPageContent(mediaLists);
    }
}
