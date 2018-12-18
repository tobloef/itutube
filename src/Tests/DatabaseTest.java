package Tests;

import itutube.Database;
import itutube.exceptions.NoSuchIDException;
import itutube.exceptions.UserNotFoundException;
import itutube.exceptions.UsernameTakenException;
import itutube.models.Credits;
import itutube.models.User;
import itutube.models.UserType;
import itutube.models.media.Media;
import itutube.models.media.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private User adminUser = new User("Vince Offer", UserType.Admin);
    private User adultUser = new User("Jeff", UserType.Adult);
    // Not in initial database
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

    void addTestUsers() throws UsernameTakenException {
        Database.addUser(adminUser);
        Database.addUser(adultUser);
    }

    void addTestMedia() {
        HashMap<String, Media> newMediaMap = new HashMap<>();
        newMediaMap.put(testMovie.getId(), testMovie);
        newMediaMap.put(testKidsMovie.getId(), testKidsMovie);
        Database.setMediaMap(newMediaMap);
    }

    void setupTestDatabase() throws UsernameTakenException {
        addTestMedia();
        addTestUsers();
    }

    @BeforeEach
    void setUp() {
        try {
            setupTestDatabase();
        } catch (Exception e) {
            (new Exception("Error setting up tests.", e)).printStackTrace();
        }
    }

    @Test
    void getMediaById_Success() {
        assertEquals(testMovie.getName(), Database.getMediaById(testMovie.getId()).getName());
    }

    @Test
    void getMediaById_Throws_InvalidId() {
        assertThrows(NoSuchIDException.class, () -> Database.getMediaById("invalid_id"));
    }

    @Test
    void addUser_Success() {
        assertDoesNotThrow(() -> Database.addUser(childUser));
        Database.removeUser(childUser);
    }

    @Test
    void addUser_Throws_UsernameTaken() {
        assertThrows(UsernameTakenException.class, () -> Database.addUser(adminUser));
    }

    @Test
    void getAllMedia_Success() {
        assertEquals(2, Database.getAllMedia(UserType.Adult).size());
    }

    @Test
    void getAllMedia_Success_KidsOnly() {
        assertEquals(1, Database.getAllMedia(UserType.Child).size());
    }

    @Test
    void getUsers_Success() {
        assertEquals(2, Database.getUsers().size());
    }

    @Test
    void removeUser_Success() throws UsernameTakenException {
        assertDoesNotThrow(() -> Database.removeUser(adultUser));
        Database.addUser(adultUser);
    }

    @Test
    void removeUser_Throws_UserNotFound() {
        assertThrows(UserNotFoundException.class, () -> Database.removeUser(childUser));
    }
}