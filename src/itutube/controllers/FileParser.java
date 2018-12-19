package itutube.controllers;

import itutube.models.Serializable;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class to format lines of text into model-objects.
 */
public class FileParser {


    public static <T extends Serializable> List<T> fetchSaveable(Class<T> type) throws IOException, IllegalAccessException, InstantiationException {
        String path = Paths.getDataFilePath(type.getSimpleName());
        List<String> lines = getLines(path);
        List<T> saveables = new ArrayList<>();
        for(String line : lines) {
            T saveable = type.newInstance();
            saveable.loadFromString(line);
            saveables.add(saveable);
        }
        return saveables;
    }

    /**
     * Helper-function to trim white-space from strings inside an array.
     * @param toTrim An array of strings
     * @return array of trimmed strings
     */
    public static String[] trimArray(String[] toTrim) {
        for (int i = 0; i < toTrim.length; i++) {
            toTrim[i] = toTrim[i].trim();
        }
        return toTrim;
    }


    /**
     * Reads file with correct encoding (UTF-8).
     * @param path Path to the file to read lines from.
     * @return List of lines from the file.
     */
    private static List<String> getLines(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        File dir = new File(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dir), StandardCharsets.UTF_8));
        String nextLine;
        while((nextLine = reader.readLine()) != null) {
            lines.add(nextLine);
        }
        reader.close();
        return lines;
    }

}
