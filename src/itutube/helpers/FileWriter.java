package itutube.helpers;

import itutube.exceptions.InvalidMediaException;
import itutube.models.Saveable;
import itutube.models.User;
import itutube.models.media.Media;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileWriter {
    /**
     * Passes list of medias to save file if they are Saveable.
     * @param medias List of media to save.
     */
    public static void saveMedia(List<Media> medias) {
        List<Saveable> data = new ArrayList<>();
        for (Media media : medias) {
            if (media instanceof Saveable) {
                data.add((Saveable) media);
            } else {
                throw new InvalidMediaException("Media is not saveable.", media);
            }
        }
        try {
            saveData(data);
        } catch (Exception exception) {
            System.err.println("Error saving media: " + exception.getMessage());
        }
    }

    /**
     * Passes list of users to save file.
     * @param users List of users to save.
     */
    public static void saveUsers(List<User> users) {
        try {
            saveData(users);
        } catch (Exception exception) {
            System.err.println("Error saving users: " + exception.getMessage());
        }
    }

    /**
     * Takes a Saveable list and saves each item as a line in file named the same as item class.
     * @param data List of Saveable to save to file.
     * @throws IOException If data cannot be written to the given path.
     */
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
            Files.write(path, entry.getValue(), StandardCharsets.UTF_8);
        }
    }
}
