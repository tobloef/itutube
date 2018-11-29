package netflix.models;

import java.util.ArrayList;
import java.util.Date;

public abstract class Media {
    private String name;
    private Date releaseDate;
    private ArrayList<String> categories;
    private double rating;
    private String imageFileName;

    public Media(
        String name,
        Date releaseDate,
        ArrayList<String> categories,
        double rating,
        String imageFileName
    ) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.categories = categories;
        this.rating = rating;
        this.imageFileName = imageFileName;
    }

    public String getName() {
        return name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public double getRating() {
        return rating;
    }

    public String getImageFileName() {
        return imageFileName;
    }
}
