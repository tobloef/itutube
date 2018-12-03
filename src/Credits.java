import java.util.ArrayList;

public class Credits {
    private String title;
    private String[] people;

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
