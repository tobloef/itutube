package itutube.helpers;

import itutube.models.User;
import itutube.models.media.Media;

/**
 * Class for directly handling file-paths for text files and image files.
 */
public class Paths {
    private static final String Resources = "resources/";
    public static final String DefaultMediaImage = Resources + "posters/default.jpg";
    public static final String DefaultUserImage = Resources + "userImages/ProfilePicture.png";
    public static final String AddUserImage = Resources + "AddUser.png";

    /**
     * Gets file path for Saveable data.
     * @param dataType Type of data to get path for.
     * @return Path to file for dataType.
     */
    public static String getDataFilePath(String dataType) {
        return Resources + dataType + ".txt";
    }

    /**
     * Gets file path for an image for a given media.
     * @param media Media to get image path for.
     * @return Path to image for media.
     */
    public static String getMediaImagePath(Media media) {
        if (media == null) {
            return null;
        }
        String mediaType = media.getClass().getSimpleName();
        String mediaName = media.getName();
        return Resources + "posters/" + mediaType + "Posters/" + mediaName + ".jpg";
    }

    /**
     * Gets file path for an image for a given user.
     * @param user User to get image path for.
     * @return Path to image for user.
     */
    public static String getUserImagePath(User user) {
        if (user == null) {
            return null;
        }
        String userName = user.getName();
        return Resources + "userImages/" + userName + ".png";
    }

    /**
     * Gets file path for an image for a given category.
     * @param category Category to get image path for.
     * @return Path to image for category.
     */
    public static String getCategoryImagePath(String category) {
        return Resources + "categoryImages/" + category + ".jpg";
    }
}
