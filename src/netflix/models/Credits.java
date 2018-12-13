package netflix.models;

/**
 * A segment of credits for a specific role
 */
public class Credits {
    private String title;
    private String[] people;

    public Credits(String title, String[] people) {
        this.title = title;
        this.people = people;
    }

    /**
     * Get the title of the credited people's role
     *
     * @return Title of the job position
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the names of the credited people
     *
     * @return Names of credited people
     */
    public String[] getPeople() {
        return people;
    }
}
