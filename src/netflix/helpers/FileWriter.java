package netflix.helpers;

import netflix.models.Saveable;
import netflix.models.User;
import netflix.models.media.Media;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileWriter {
    /**
     * Saves the list of media to the disk.
     */
    public static void saveMedia(List<Media> media) {
        List<Saveable> data = new ArrayList<>();
        for (Media m : media) {
            if (m instanceof Saveable) {
                data.add((Saveable) m);
            } else {
                String className = m.getClass().getSimpleName();
                System.err.println("Attempted to save media type " + className + "which isn't saveable.");
            }
        }
        try {
            saveData(data);
        } catch (Exception exception) {
            System.err.println("Error saving media: " + exception.getMessage());
        }
    }

    public static void saveUsers(List<User> users) {
        try {
            saveData(users);
        } catch (Exception exception) {
            System.err.println("Error saving users: " + exception.getMessage());
        }
    }

    private static void saveData(List<? extends Saveable> data) throws IOException {
        HashMap<String, List<String>> dataMap = new HashMap<>();
        for (Saveable saveable : data) {
            String className = saveable.getClass().getSimpleName();
            if (!dataMap.containsKey(className)) {
                dataMap.put(className, new ArrayList<>());
            }
            dataMap.get(className).add(saveable.getSaveString());
        }
        for (HashMap.Entry<String, List<String>> entry : dataMap.entrySet()) {
            Path path = java.nio.file.Paths.get(Paths.getDataFilePath(entry.getKey()));
            Files.write(path, entry.getValue());
        }
    }
}
