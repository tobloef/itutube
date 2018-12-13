package netflix.models.media;

import javafx.scene.Parent;
import netflix.models.Credits;
import netflix.models.Saveable;
import netflix.models.Viewable;
import netflix.views.pages.content.SeriesInfoContent;

import java.util.Date;

/**
 * A series
 */
public class Series extends Media implements Saveable, Viewable {
    private Date endDate;
    private Season[] seasons;

    public Series(String id, String name, String description, Date releaseDate, Date endDate, String[] categories, double rating, Credits[] credits, String imageFileName) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName);
        this.endDate = endDate;
    }

    public String getSaveString() {
        StringBuilder seasonString = new StringBuilder();
        for(int i = 1; i <= seasons.length; i++) {
            seasonString.append(i).append("-").append(seasons[i-1].getEpisodes().size()).append(" ");
        }
        String categoryString = String.join(",", categories);
        String str = id + ";" + name + ";" + releaseDate.getYear();
        if(endDate != releaseDate) {
            str += "-";

            if(endDate != null) {
                str += endDate.getYear();
            }
        }
        str += ";" + categoryString + ";" + rating + ";" + seasonString + ";";
        return str;
    }

    public Season[] getSeasons() {
        return seasons;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setSeasons(Season[] seasons) {
        this.seasons = seasons;
    }

    @Override
    public Parent createInfoView() {
        return new SeriesInfoContent(this);
    }
}
