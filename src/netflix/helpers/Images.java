package netflix.helpers;

import javafx.scene.image.Image;
import netflix.models.User;
import netflix.models.media.Media;

import java.io.File;
import java.util.HashMap;

public class Images {
    private static HashMap<String, Image> cache = new HashMap<>();

    public static Image getMediaImage(Media media) {
        String path = Paths.getMediaImagePath(media);
        Image image = getImage(path);
        if (image == null || image.isError()) {
            return getDefaultMediaImage();
        }
        return image;
    }

    public static Image getUserImage(User user) {
        String path = Paths.getUserImagePath(user);
        Image image = getImage(path);
        if (image == null || image.isError()) {
            return getDefaultUserImage();
        }
        return image;
    }

    public static Image getCategoryImage(String category) {
        String path = Paths.getCategoryImagePath(category);
        Image image = getImage(path);
        if (image == null || image.isError()) {
            return getDefaultMediaImage();
        }
        return image;
    }

    private static Image getDefaultUserImage() {
        return getImage(Paths.getDefaultUserImagePath());
    }

    public static Image getAddUserImage(){
        return getImage(Paths.getAddUserImagePath());
    }

    private static Image getDefaultMediaImage() {
        return getImage(Paths.getDefaultMediaImagePath());
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
