package netflix.views.pages.content;

import netflix.models.media.Movie;

/**
 * Content page for displaying info about a movie.
 */
public class MovieInfoContent extends MediaInfoContent {

    /**
     * @param movie Movie to display info for.
     */
    public MovieInfoContent(Movie movie) {
        super(movie);
    }
}

