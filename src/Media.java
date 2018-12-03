import java.util.ArrayList;
import java.util.Date;

public abstract class Media {
    private String id;
    private String name;
    private String description;
    private Date releaseDate;
    private String[] categories;
    private double rating;
    private Credits[] credits;
    private String imageFileName;

    public Media(String id, String name, String description, Date releaseDate, String[] categories, double rating, Credits[] credits, String imageFileName) {
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