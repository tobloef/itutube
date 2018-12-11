package netflix.views.creators;

import javafx.scene.Parent;
import netflix.models.MediaList;
import netflix.views.content.FrontPageContent;

import java.util.List;
import java.util.function.Consumer;

public class FrontPageCreator extends ViewCreator {

    private List<MediaList> mediaLists;
    private Consumer<ViewCreator> setContent;

    public FrontPageCreator(List<MediaList> mediaLists, Consumer<ViewCreator> setContent) {
        this.mediaLists = mediaLists;
        this.setContent = setContent;
    }

    @Override
    public Parent create() {
        return new FrontPageContent(mediaLists, setContent);
    }
}
