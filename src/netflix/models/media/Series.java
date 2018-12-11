package netflix.models.media;

import netflix.models.Credits;
import netflix.models.Saveable;

import java.util.Date;

/**
 * A series
 */
public class Series extends Media implements Saveable {
    private Date endDate;
    private Season[] seasons;

    public Series(String id, String name, String description, Date releaseDate, Date endDate, String[] categories, double rating, Credits[] credits, String imageFileName) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName);
        this.endDate = endDate;
    }

    public String getSaveString() {
        StringBuilder seasonString = new StringBuilder();
        for(int i = 1; i <= seasons.length; i++) {
            seasonString.append(i).append("-").append(seasons[i-1].getEpisodes().length).append(" ");
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
}
