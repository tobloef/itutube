package itutube.models;

/**
 * Interface specifying that an object is somehow serializable to and from a string.
 * This is used for saving and loading data.
 */
public interface Serializable {
    /**
     * Convert the implementing object to a string.
     * @return Serialized string.
     */
    String getString();

    /**
     * Load the implementing object's properties from a serialized string.
     * @param string String to load data from.
     */
    void loadFromString(String string);
}
