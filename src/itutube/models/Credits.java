package itutube.models;

/**
 * A segment of credits for a specific role
 */
public class Credits {
    private String title;
    private String[] people;

    /**
     * @param title Title of the credits role.
     * @param people People that holds this role.
     */
    public Credits(String title, String[] people) {
        this.title = title;
        this.people = people;
    }

    public String getTitle() {
        return title;
    }

    public String[] getPeople() {
        return people;
    }
}
