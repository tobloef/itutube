package Tests;

import itutube.helpers.FileParser;
import itutube.models.media.Media;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileParserTest {

    private static HashMap<String, Media> mediaMap = new HashMap<>();

    @Test
    void fetchMovies_Success() throws IOException {
        assertDoesNotThrow(FileParser::fetchMovies);
        assertTrue(FileParser.fetchMovies().size() > 0);
    }

    @Test
    void fetchSeries_Success() throws IOException {
        assertDoesNotThrow(FileParser::fetchSeries);
        assertTrue(FileParser.fetchSeries().size() > 0);
    }

    @Test
    void fetchUsers_Success() {
        assertDoesNotThrow(() -> FileParser.fetchUsers(mediaMap));
    }

}
