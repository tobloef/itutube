package itutube.models.media;

import javafx.scene.Parent;
import itutube.models.Credits;
import itutube.models.Saveable;
import itutube.models.Viewable;
import itutube.views.pages.content.SeriesInfoContent;

import java.util.Date;
import java.util.List;

/**
 * A series
 */
public class Series extends Media implements Saveable, Viewable {
    private Date endDate;
    private Season[] seasons;

    /**
     * @param id Id associated with the series.
     * @param name Name of the series.
     * @param description Description of the series.
     * @param releaseDate Release date of the series.
     * @param endDate End date of the series.
     * @param categories Categories held by the series.
     * @param rating Rating of the series.
     * @param credits Credits for the series.
     * @param imageFileName Name of series image file.
     */
    public Series(
            String id,
            String name,
            String description,
            Date releaseDate,
            Date endDate,
            List<String> categories,
            double rating,
            List<Credits> credits,
            String imageFileName
    ) {
        super(
                id,
                name,
                description,
                releaseDate,
                categories,
                rating,
                credits,
                imageFileName
        );
        this.endDate = endDate;
    }

    /**
     * The string that should be saved to text file when saving series.
     * @return String containing id, name, release- and end-date, categories, rating and seasons.
     */
    public String getSaveString() {
        StringBuilder seasonString = new StringBuilder();
        for (int i = 1; i <= seasons.length; i++) {
            seasonString.append(i).append("-").append(seasons[i - 1].getEpisodes().size()).append(" ");
        }
        String categoryString = String.join(",", categories);
        String str = id + ";" + name + ";" + releaseDate.getYear();
        if (endDate != releaseDate) {
            str += "-";

            if (endDate != null) {
                str += endDate.getYear();
            }
        }
        str += ";" + categoryString + ";" + rating + ";" + seasonString + ";";
        return str;
    }

    public Season[] getSeasons() {
        return seasons;
    }

    public void setSeasons(Season[] seasons) {
        this.seasons = seasons;
    }

    public Date getEndDate() {
        return endDate;
    }

    /**
     * Creates an info view for the object.
     * @return This series's info view.
     */
    @Override
    public Parent createInfoView() {
        return new SeriesInfoContent(this);
    }
}
