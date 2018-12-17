package itutube.helpers;

import javafx.scene.image.Image;
import itutube.Main;
import itutube.models.ImageButtonInfo;
import itutube.models.MediaList;
import itutube.models.User;
import itutube.models.UserType;
import itutube.models.media.Media;
import itutube.views.pages.content.FrontPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

/**
 * Helper methods to create lists of ImageButtonInfo and MediaList.
 */
public class ImageButtonInfoHelper {

    /**
     * Converts list of Media to a list of ImageButtonInfo.
     * @param medias List of media to construct the info from.
     * @param handleAction Functionality to be handed to a button.
     * @return List of ImageButtonInfo for Media.
     */
    public static List<ImageButtonInfo> mediasToImageButtonInfos(List<Media> medias, Consumer<Media> handleAction) {
        List<ImageButtonInfo> infoList = new ArrayList<>();
        for (Media media : medias) {
            String text = media.getName();
            Image image = Images.getMediaImage(media);
            infoList.add(new ImageButtonInfo(text, image, e -> handleAction.accept(media)));
        }
        return infoList;
    }

    /**
     * Converts list of categories to ImageButtonInfo.
     * @param categories Categories to create button info from.
     * @param handleAction Functionality to be handed to a button.
     * @return List of ImageButtonList for categories.
     */
    public static List<ImageButtonInfo> categoriesToImageButtonInfos(List<MediaList> categories, Consumer<MediaList> handleAction) {
        List<ImageButtonInfo> imageButtonInfos = new ArrayList<>();
        for (MediaList category : categories) {
            Image image = Images.getCategoryImage(category.getName());
            String title = category.getName();
            ImageButtonInfo imageButtonInfo = new ImageButtonInfo(title, image, e -> handleAction.accept(category));
            imageButtonInfos.add(imageButtonInfo);
        }
        return imageButtonInfos;
    }

    /**
     * Gets all existing categories in the a given list of Media.
     * @param medias List of Media to get categories from.
     * @return List of all existing categories in list.
     */
    public static List<MediaList> mediasToCategories(List<Media> medias) {
        HashMap<String, List<Media>> categoryMap = new HashMap<>();
        for (Media media : medias) {
            for (String category : media.getCategories()) {
                if (!categoryMap.containsKey(category)) {
                    categoryMap.put(category, new ArrayList<>());
                }
                categoryMap.get(category).add(media);
            }
        }
        List<MediaList> categories = new ArrayList<>();
        for (HashMap.Entry<String, List<Media>> entry : categoryMap.entrySet()) {
            MediaList category = new MediaList(entry.getKey(), entry.getValue());
            categories.add(category);
        }
        return categories;
    }

    /**
     * Converts list of users to ImageButtonInfo.
     * @param users Users to get button info from.
     * @return list of ImageButtonInfo generated from list.
     */
    public static List<ImageButtonInfo> usersToImageButtonInfos(List<User> users) {
        List<ImageButtonInfo> infos = new ArrayList<>();
        for (User user : users) {
            String text = user.getName();
            if (user.getType() == UserType.Admin) {
                text += " (Admin)";
            }
            Image image = Images.getUserImage(user);
            infos.add(new ImageButtonInfo(text, image, e -> {
                Main.setActiveUser(user);
                Main.setPage(new FrontPage());
            }));
        }
        return infos;
    }
}
