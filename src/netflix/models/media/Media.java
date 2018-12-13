package netflix.models.media;

import netflix.models.Credits;

import java.util.Date;

/**
 * Generic media class, for all types of media on the site
 */
public abstract class Media {
    protected String id;
    protected String name;
    protected String description;
    protected Date releaseDate;
    protected String[] categories;
    protected double rating;
    protected Credits[] credits;
    protected String imageFileName;

    public Media(
        String id,
        String name,
        String description,
        Date releaseDate,
        String[] categories,
        double rating,
        Credits[] credits,
        String imageFileName
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.categories = categories;
        this.rating = rating;
        this.credits = credits;
        this.imageFileName = imageFileName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String[] getCategories() {
        return categories;
    }

    public double getRating() {
        return rating;
    }

    public Credits[] getCredits() {
        return credits;
    }

    public String getImageFileName() {
        return imageFileName;
    }
}