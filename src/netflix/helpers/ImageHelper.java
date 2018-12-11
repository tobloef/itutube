package netflix.helpers;

import javafx.scene.image.Image;
import netflix.models.media.Media;

import java.io.File;
import java.util.HashMap;

public class ImageHelper {
    private static HashMap<String, Image> cache = new HashMap<>();

    public static Image getMediaPoster(Media media, double width, double height) {
        String path = PathsHelper.getMediaImagePath(media);
        Image image = getImage(path, width, height);
        if (image == null) {
            return getDefaultPoster(width, height);
        }
        return image;
    }

    private static Image getDefaultPoster(double width, double height) {
        return getImage(PathsHelper.getDefaultPosterPath(), width, height);
    }

    private static Image getImage(String path, double width, double height) {
        if (path == null) {
            return null;
        }
        if (cache.containsKey(path)) {
            return cache.get(path);
        }
        File file = new File(path);
        Image image = new Image(file.toURI().toString(), width, height, true, true, true);
        cache.put(path, image);
        return image;
    }
}
