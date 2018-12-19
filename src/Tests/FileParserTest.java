package Tests;

import itutube.controllers.FileParser;
import itutube.models.User;
import itutube.models.media.Media;
import itutube.models.media.Movie;
import itutube.models.media.Series;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileParserTest {

    @Test
    void fetchMovies_Success() throws IOException, InstantiationException, IllegalAccessException {
        assertTrue(FileParser.fetchSaveable(Movie.class).size() > 0);
    }

    @Test
    void fetchSeries_Success() throws IOException, InstantiationException, IllegalAccessException {
        assertTrue(FileParser.fetchSaveable(Series.class).size() > 0);
    }

    @Test
    void fetchUsers_Success() {
        assertDoesNotThrow(() -> FileParser.fetchSaveable(User.class).size() > 0);

    }

}
