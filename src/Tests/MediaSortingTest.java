package Tests;

import itutube.Helpers.MediaSorting;
import itutube.models.Credits;
import itutube.models.media.Media;
import itutube.models.media.Movie;
import itutube.models.media.Series;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MediaSortingTest {

    private Credits testCredits = new Credits("Test Role", new String[]{"Test Person 1", "Test Person 2"});
    private Movie testMovie = new Movie(
            "001",
            "Test Movie 1",
            "",
            new Date(2000, 1, 1),
            new ArrayList<>(Arrays.asList("Test Category 1", "Test Category 2")),
            9,
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
    private Movie testFilm = new Movie(
            "003",
            "Test Film 1",
            "",
            new Date(2040, 1, 1),
            new ArrayList<>(Arrays.asList("Test Category 1", "Test Category 2")),
            8,
            new ArrayList<>(Collections.singletonList(testCredits)),
            90 * 60
    );
    private Series testSeries = new Series(
            "004",
            "Test Series 1",
            "",
            new Date(2040, 1, 1),
            new Date(2040, 1, 1),
            new ArrayList<>(Arrays.asList("Test Category 1", "Test Category 2")),
            5,
            new ArrayList<>(Collections.singletonList(testCredits))
    );

    private List<Media> allMedia = new ArrayList<>(Arrays.asList(testMovie, testKidsMovie, testFilm, testSeries));
    private List<Media> searchSortedList = new ArrayList<>(Arrays.asList(testMovie, testKidsMovie));
    private List<Media> ratingSortedList = new ArrayList<>(Arrays.asList(testKidsMovie, testMovie, testFilm, testSeries));
    private List<Media> typeSortedList = new ArrayList<>(Arrays.asList(testMovie, testKidsMovie, testFilm));

    @Test
    void searchSort_Success() {
        String query = "movie";
        assertEquals(searchSortedList, MediaSorting.findBySearch(query, allMedia));

    }

    @Test
    void ratingSort_Success() {
        assertEquals(ratingSortedList, MediaSorting.sortByRating(allMedia));
    }

    @Test
    void typeSort_Success() {
        assertEquals(typeSortedList, MediaSorting.findByType(Movie.class, allMedia));
    }

}
