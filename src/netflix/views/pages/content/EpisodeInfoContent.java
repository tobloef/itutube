package netflix.views.pages.content;

import netflix.models.media.Episode;

/**
 * Content page with info about the given episode
 */
public class EpisodeInfoContent extends MediaInfoContent {
    /**
     * @param episode Episode to display info for.
     */
    public EpisodeInfoContent(Episode episode) {
        super(episode);
    }
}
