package netflix.helpers;

import netflix.models.User;
import netflix.models.media.Media;

public class Paths {
    public static final String DefaultMediaImage = "src/resources/posters/default.jpg";
    public static final String DefaultUserImage = "src/resources/userImages/ProfilePicture.png";
    public static final String AddUserImage = "src/resources/AddUser.png";

    public static String getDataFilePath(String dataType) {
        return "src/resources/" + dataType + ".txt";
    }

    public static String getMediaImagePath(Media media) {
        if (media == null) {
            return null;
        }
        String mediaType = media.getClass().getSimpleName();
        String mediaName = media.getName();
        return "src/resources/posters/" + mediaType + "Posters/" + mediaName + ".jpg";
    }

    public static String getUserImagePath(User user) {
        if (user == null) {
            return null;
        }
        String userName = user.getName();
        return "src/resources/userImages/" + userName + ".png";
    }

    public static String getCategoryImagePath(String category) {
        return "src/resources/categoryImages/" + category + ".jpg";
    }
}
