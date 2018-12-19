package Tests;

import itutube.Helpers.ImageButtonInfoHelper;
import itutube.models.*;
import itutube.models.media.Media;
import itutube.models.media.Movie;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.fail;

class ImageButtonInfoHelperTest {
    private User adminUser = new User("Vince Offer", UserType.Admin);
    private User adultUser = new User("Jeff", UserType.Adult);
    private User childUser = new User("Simon", UserType.Child);

    private Credits testCredits = new Credits("Test Role", new String[]{"Test Person 1", "Test Person 2"});

    private Movie testMovie = new Movie(
            "001",
            "Test Movie 1",
            "",
            new Date(2000, 1, 1),
            new ArrayList<>(Arrays.asList("Test Category 1", "Test Category 2")),
            10,
            new ArrayList<>(Collections.singletonList(testCredits)),
            120 * 60
    );
    private Movie testKidsMovie = new Movie(
            "002",
            "Test Kids Movie 1",
            "",
            new Date(2010, 1, 1),
            new ArrayList<>(Arrays.asList("Test Category 1", "Family")),
            10,
            new ArrayList<>(Collections.singletonList(testCredits)),
            70 * 60
    );

    private List<Media> testMedias = new ArrayList<>(Arrays.asList(testMovie, testKidsMovie));
    private List<MediaList> testCategories = new ArrayList<>(Arrays.asList(
            new MediaList("Test Category 1", new ArrayList<>(Arrays.asList(testMovie, testKidsMovie))),
            new MediaList("Test Category 2", new ArrayList<>(Arrays.asList(testMovie))),
            new MediaList("Family", new ArrayList<>(Arrays.asList(testKidsMovie)))
    ));
    private List<User> testUsers = new ArrayList<>(Arrays.asList(adminUser, adultUser, childUser));



    @BeforeAll
    static void setup() {
        // From https://stackoverflow.com/a/18980655/4688606
        try {
            Thread thread = new Thread(JFXPanel::new);
            thread.start();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void mediasToImageButtonInfos_Success() {
        List<ImageButtonInfo> result = ImageButtonInfoHelper.mediasToImageButtonInfos(testMedias, m -> {});
        Assertions.assertEquals(result.size(), testMedias.size());
        for (ImageButtonInfo info : result) {
            Assertions.assertNotNull(info.getText());
            Assertions.assertNotNull(info.getImage());
            Assertions.assertNotNull(info.getEventHandler());
        }
    }

    @Test
    void categoriesToImageButtonInfos_Success() {
        List<ImageButtonInfo> result = ImageButtonInfoHelper.categoriesToImageButtonInfos(testCategories, m -> {});
        Assertions.assertEquals(result.size(), testCategories.size());
        for (ImageButtonInfo info : result) {
            Assertions.assertNotNull(info.getText());
            Assertions.assertNotNull(info.getImage());
            Assertions.assertNotNull(info.getEventHandler());
        }
    }

    @Test
    void mediasToCategories_Success() {
        List<MediaList> result = ImageButtonInfoHelper.mediasToCategories(testMedias);
        List<MediaList> expected = new ArrayList<>(Arrays.asList(
                new MediaList("Test Category 1", new ArrayList<>(Arrays.asList(testMovie, testKidsMovie))),
                new MediaList("Test Category 2", new ArrayList<>(Arrays.asList(testMovie))),
                new MediaList("Family", new ArrayList<>(Arrays.asList(testKidsMovie)))
        ));
        Assertions.assertEquals(result, expected);
    }

    @Test
    void usersToImageButtonInfos_Success() {
        List<ImageButtonInfo> result = ImageButtonInfoHelper.usersToImageButtonInfos(testUsers, u -> {});
        Assertions.assertEquals(result.size(), testUsers.size());
        for (ImageButtonInfo info : result) {
            Assertions.assertNotNull(info.getText());
            Assertions.assertNotNull(info.getImage());
            Assertions.assertNotNull(info.getEventHandler());
        }
    }
}
