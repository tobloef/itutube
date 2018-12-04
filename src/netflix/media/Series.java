package netflix.media;

import netflix.models.Credits;

import java.util.Date;

public class Series extends Media {
    private Date endDate;
    private Season[] seasons;

    public Series(String id, String name, String description, Date releaseDate, Date endDate, String[] categories, double rating, Credits[] credits, String imageFileName) {
        super(id, name, description, releaseDate, categories, rating, credits, imageFileName);
        this.endDate = endDate;
    }

    public Season[] getSeasons() {
        return seasons;
    }

    public Date getEndDate() {
        return endDate;
    }
}
