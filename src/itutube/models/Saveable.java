package itutube.models;

/**
 * Interface specifying that a media is somehow saveable
 */
public interface Saveable {
    String getSaveString();
    void loadFromSaveString(String string);
}
