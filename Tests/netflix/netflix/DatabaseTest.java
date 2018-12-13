package netflix;

import netflix.exceptions.NoSuchIDException;
import netflix.exceptions.UsernameTakenException;
import netflix.models.User;
import netflix.models.UserType;
import netflix.models.media.Media;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private User VinceOffer = new User("Vince Offer", UserType.Admin);
    private User jeff = new User("jeff", UserType.Admin);
    private User simon = new User("simon", UserType.Admin);

    @BeforeEach
    void setUp() {
        Database.load();
    }

    @Test
    void getMediaById() {
        assertEquals("Rocky", Database.getMediaById("040").getName());
    }

    @Test
    void getMediaById2() {
        assertThrows(NoSuchIDException.class,()-> Database.getMediaById("400"));
    }

    @Test
    void getMediaById4() {
        assertThrows(NoSuchIDException.class,()-> Database.getMediaById("jeff"));
    }

    void addPeople(){
        Database.addUser(jeff);
        Database.addUser(simon);
        Database.addUser(VinceOffer);
    }

    @Test
    void addUser(){
        assertThrows(UsernameTakenException.class, this::addPeople);
    }

    @Test
    void addUser2(){
        assertThrows(UsernameTakenException.class, () -> Database.addUser(VinceOffer));
    }
}