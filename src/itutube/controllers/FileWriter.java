package itutube.controllers;

import itutube.exceptions.DatabaseIOException;
import itutube.exceptions.InvalidMediaException;
import itutube.models.Serializable;
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
     * Passes list of medias to save file if they are Serializable.
     * @param medias List of media to save.
     * @throws DatabaseIOException if the data couldn't be saved to disk
     */
    public static void saveMedia(List<Media> medias) throws DatabaseIOException {
        List<Serializable> mediaData = new ArrayList<>();
        for (Media media : medias) {
            if (media instanceof Serializable) {
                mediaData.add((Serializable) media);
            } else {
                throw new InvalidMediaException("Media is not saveable.", media);
            }
        }
        try {
            saveData(mediaData);
        } catch (IOException e) {
            throw new DatabaseIOException("Error saving media.", e);
        }
    }

    /**
     * Passes list of users to save file.
     * @param users List of users to save.
     * @throws DatabaseIOException if the data couldn't be saved to disk
     */
    public static void saveUsers(List<User> users) throws DatabaseIOException {
        try {
            saveData(users);
        } catch (IOException e) {
            throw new DatabaseIOException("Error saving users.", e);
        }
    }

    /**
     * Takes a Serializable list and saves each item as a line in file named the same as item class.
     * @param data List of Serializable to save to file.
     * @throws IOException If data cannot be written to the given path.
     */
    private static void saveData(List<? extends Serializable> data) throws IOException {
        HashMap<String, List<String>> dataMap = new HashMap<>();
        for (Serializable serializable : data) {
            String className = serializable.getClass().getSimpleName();
            if (!dataMap.containsKey(className)) {
                dataMap.put(className, new ArrayList<>());
            }
            dataMap.get(className).add(serializable.getString());
        }
        for (HashMap.Entry<String, List<String>> entry : dataMap.entrySet()) {
            Path path = java.nio.file.Paths.get(Paths.getDataFilePath(entry.getKey()));
            Files.write(path, entry.getValue(), StandardCharsets.UTF_8);
        }
    }
}
