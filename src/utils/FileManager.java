package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    private static Path getInputsPath(String filename) {
        String root = System.getProperty("user.dir");
        return Path.of(root, "inputs", filename);
    }

    /**
     * Reads a file in a single line
     * 
     * @param filename - the name of the file in the inputs folder
     * @return The content of the file in a single line
     */
    public static String readInlineInput(String filename) {
        String content = null;
        System.out.println(FileManager.getInputsPath(filename));
        try {
            byte[] bytes = Files.readAllBytes(FileManager.getInputsPath(filename));
            content = new String(bytes);
            System.out.println(111 + content);
        } catch (IOException e) {
            System.out.println("Failed to get content!" + e.getMessage());
        }
        return content;
    }
}
