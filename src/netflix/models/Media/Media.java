package netflix.models.Media;

import netflix.models.Credits;

import java.util.ArrayList;
import java.util.Date;

public abstract class Media {
    private String id;
    private String name;
    private String description;
    private Date releaseDate;
    private ArrayList<String> categories;
    private double rating;
    private ArrayList<Credits> credits;

    public Media(String name, String description, Date releaseDate, ArrayList<String> categories, double rating) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.categories = categories;
        this.rating = rating;
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

    public ArrayList<String> getCategories() {
        return categories;
    }

    public double getRating() {
        return rating;
    }

    public ArrayList<Credits> getCredits() {
        return credits;
    }
}