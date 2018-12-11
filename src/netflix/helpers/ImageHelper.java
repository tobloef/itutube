package netflix.helpers;

import javafx.scene.image.Image;
import netflix.models.User;
import netflix.models.media.Media;

import java.io.File;
import java.util.HashMap;

public class ImageHelper {
    private static HashMap<String, Image> cache = new HashMap<>();

    public static Image getMediaImage(Media media) {
        String path = PathsHelper.getMediaImagePath(media);
        Image image = getImage(path);
        if (image == null || image.isError()) {
            return getDefaultImage();
        }
        return image;
    }

    public static Image getUserImage(User user) {
        String path = PathsHelper.getUserImagePath(user);
        Image image = getImage(path);
        if (image == null || image.isError()) {
            return getDefaultUserImage();
        }
        return image;
    }

    public static Image getCategoryImage(String category) {
        String path = PathsHelper.getCategoryImagePath(category);
        Image image = getImage(path);
        if (image == null || image.isError()) {
            return getDefaultCategoryImage();
        }
        return image;
    }

    private static Image getDefaultCategoryImage() {
        return getImage(PathsHelper.getDefaultCategoryImagePath());
    }

    private static Image getDefaultUserImage() {
        return getImage(PathsHelper.getDefaultUserImagePath());
    }

    private static Image getDefaultImage() {
        return getImage(PathsHelper.getDefaultMediaImagePath());
    }

    private static Image getImage(String path) {
        if (path == null) {
            return null;
        }
        if (cache.containsKey(path)) {
            return cache.get(path);
        }
        File file = new File(path);
        Image image = new Image(file.toURI().toString());
        cache.put(path, image);
        return image;
    }
}
