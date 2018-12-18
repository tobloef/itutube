package Tests;

import itutube.Database;
import itutube.exceptions.NoSuchIDException;
import itutube.exceptions.UsernameTakenException;
import itutube.models.User;
import itutube.models.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DatabaseTest {

    // TODO: No hard-coding

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
        try {
            Database.addUser(jeff);
            Database.addUser(simon);
            Database.addUser(VinceOffer);
        }
        catch (UsernameTakenException e) {
            e.printStackTrace();
        }
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