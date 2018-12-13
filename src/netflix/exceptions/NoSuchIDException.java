package netflix.exceptions;

public class NoSuchIDException extends RuntimeException {
    private String id;

    public NoSuchIDException(String id) {
        super("No such id: " + id);
        this.id = id;
    }


}
