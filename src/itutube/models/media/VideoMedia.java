package itutube.models.media;

import itutube.models.Credits;
import itutube.models.Playable;
import itutube.views.pages.PlayerPage;
import javafx.scene.Parent;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Generic video media
 */
public abstract class VideoMedia extends Media implements Playable {
    protected int runtimeSeconds;

    /**
     * @param id Id associated with the video media.
     * @param name Name of the video media.
     * @param description Description of the video media.
     * @param releaseDate Release date of the video media.
     * @param categories Categories held by the video media.
     * @param rating Rating of the video media.
     * @param credits Credits for the video media.
     * @param runtimeSeconds Number of seconds the video media lasts for.
     */
    public VideoMedia(
            String id,
            String name,
            String description,
            Date releaseDate,
            List<String> categories,
            double rating,
            List<Credits> credits,
            int runtimeSeconds
    ) {
        super(
                id,
                name,
                description,
                releaseDate,
                categories,
                rating,
                credits
        );
        this.runtimeSeconds = runtimeSeconds;
    }

    /**
     * @return The runtime in minutes seconds.
     */
    public int getRuntimeSeconds() {
        return runtimeSeconds;
    }

    @Override
    public String getMediaContent() {
        // TODO: This is where we would load the media data from the disk.
        Random r = new Random();
        int rand = r.nextInt(0xffffff + 1);

        // Text formatting: Generates random 6-digit hex-number, starting with a '#', using 6 random numbers from
        // 0 to f, inserting leading zeros if the number is below 6 digits.
        return String.format("#%06x", rand);
    }

    @Override
    public double getProgress() {
        // TODO: This could be loaded from a file or something.
        throw new NotImplementedException();
    }

    @Override
    public String getProgressString() {
        double progress = getProgress();
        int progressSeconds = (int) Math.round(getRuntimeSeconds() * progress);
        return secondsToHHMMSS(progressSeconds);
    }

    /**
     * Format an amount of seconds in HH:MM:SS format.
     * @param totalSeconds The amount of seconds to convert.
     * @return Formatted time string.
     */
    private String secondsToHHMMSS(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = (totalSeconds % 3600) % 60;
        String hoursStr = (hours < 10 ? "0" : "") + hours;
        String minutesStr = (minutes < 10 ? "0" : "") + minutes;
        String secondsStr = (seconds < 10 ? "0" : "")+ seconds;
        return hoursStr + ":" + minutesStr + ":" + secondsStr;
    }

    @Override
    public Parent createPlayView() {
        return new PlayerPage(this);
    }
}
