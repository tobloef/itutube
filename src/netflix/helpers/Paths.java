package netflix.helpers;

import netflix.models.User;
import netflix.models.media.Media;

/**
 * Class for directly handling file-paths for text files and image files.
 */
public class Paths {
    public static final String DefaultMediaImage = "src/resources/posters/default.jpg";
    public static final String DefaultUserImage = "src/resources/userImages/ProfilePicture.png";
    public static final String AddUserImage = "src/resources/AddUser.png";

    /**
     * Gets file path for Saveable data.
     * @param dataType Type of data to get path for.
     * @return Path to file for dataType.
     */
    public static String getDataFilePath(String dataType) {
        return "src/resources/" + dataType + ".txt";
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
        return "src/resources/posters/" + mediaType + "Posters/" + mediaName + ".jpg";
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
        return "src/resources/userImages/" + userName + ".png";
    }

    /**
     * Gets file path for an image for a given category.
     * @param category Category to get image path for.
     * @return Path to image for category.
     */
    public static String getCategoryImagePath(String category) {
        return "src/resources/categoryImages/" + category + ".jpg";
    }
}
