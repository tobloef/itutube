package itutube.helpers;

import itutube.models.User;
import itutube.models.media.Media;
import javafx.scene.image.Image;

import java.io.File;
import java.util.HashMap;

/**
 * Gets images while handling errors caused by missing images.
 */
public class Images {
    private static HashMap<String, Image> cache = new HashMap<>();

    /**
     * Gets matching image file for the given media.
     * @param media Media to get image for.
     * @return Image linked to given media.
     */
    public static Image getMediaImage(Media media) {
        String path = Paths.getMediaImagePath(media);
        Image image = getImage(path);
        if (image == null || image.isError()) {
            return getDefaultMediaImage();
        }
        return image;
    }

    /**
     * Gets matching image file for the given user.
     * @param user User to get image for.
     * @return Image linked to given user.
     */
    public static Image getUserImage(User user) {
        String path = Paths.getUserImagePath(user);
        Image image = getImage(path);
        if (image == null || image.isError()) {
            return getDefaultUserImage();
        }
        return image;
    }

    /**
     * Gets matching image file for the given category.
     * @param category Category to get image for.
     * @return Image linked to given category.
     */
    public static Image getCategoryImage(String category) {
        String path = Paths.getCategoryImagePath(category);
        Image image = getImage(path);
        if (image == null || image.isError()) {
            return getDefaultMediaImage();
        }
        return image;
    }

    public static Image getDefaultUserImage() {
        return getImage(Paths.DefaultUserImage);
    }

    public static Image getAddUserImage() {
        return getImage(Paths.AddUserImage);
    }

    public static Image getDefaultMediaImage() {
        return getImage(Paths.DefaultMediaImage);
    }

    /**
     * Gets image from path and saves it to cache.
     * @param path Path from which to get the image.
     * @return Image from path.
     */
    public static Image getImage(String path) {
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
