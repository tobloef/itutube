package itutube.exceptions;

/**
 * An exception to throw, when the requested media ID is incorrect
 */
public class NoSuchIDException extends RuntimeException {
    private String id;

    /**
     * @param id The ID given
     */
    public NoSuchIDException(String id) {
        super("No such id: " + id);
        this.id = id;
    }

    /**
     * Gets the id of the NoSuchIDException
     * @return Returns the id of the NoSuchIDException
     */
    public String getId() {
        return id;
    }
}
