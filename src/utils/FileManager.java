package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {
    private static final String inputsRoot = "./inputs/";

    /**
     * Reads a file in a single line
     * 
     * @param filename - the name/path if nested of the file in the inputs folder
     * @return The content of the file in a single line
     */
    public static String readInlineInput(String filename) {
        String content = null;
        try {
            byte[] bytes = Files.readAllBytes(Path.of(inputsRoot + filename));
            content = new String(bytes);
        } catch (IOException e) {
            System.out.println("Failed to get content!" + e.getMessage());
        }
        return content;
    }

    /**
     * Read a file and return a stream of strings
     * 
     * @param filename - the name/path if nested of the file within the inputs
     *                 folder
     * @return a stream of all new lines
     */

    public static Stream<String> readLinesToStream(String filename) {
        Stream<String> contentStream = null;
        try {
            contentStream = Files.lines(Path.of("./inputs/" + filename));
        } catch (IOException e) {
            System.out.println("Failed to get content!" + e.getMessage());
        }

        return contentStream;
    }

    /**
     * Read a file and return a stream of strings
     * 
     * @param filename - the name/path if nested of the file within the inputs
     *                 folder
     * @return a list of all new lines
     */

    public static List<String> readLinesToList(String filename) {
        List<String> contentStream = null;
        try {
            contentStream = Files.lines(Path.of("./inputs/" + filename)).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Failed to get content!" + e.getMessage());
        }

        return contentStream;
    }

    /**
     * Creates new txt input files in the inputs folder
     * 
     * @param filename - name/path (no extension) of the file to be created in
     *                 'inputs'
     */
    public static void createInputFilesTxt(String filename) {
        File inputsFolder = new File(inputsRoot);
        try {
            boolean inputSuccess = new File(inputsFolder, filename + ".txt").createNewFile();
            boolean testInputSuccess = new File(inputsFolder, filename + "_test_intput.txt").createNewFile();

            if (inputSuccess && testInputSuccess) {
                System.out.println("New input files created");
            } else {
                System.out.println("Failed to create new input file(s), file(s) with that name already exist(s)");
            }
        } catch (Exception e) {
            System.out.println("Failed to create new input files");
            System.out.println(e.getMessage());
        }

    }
}
