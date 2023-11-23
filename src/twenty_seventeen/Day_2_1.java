package twenty_seventeen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import utils.FileManager;

public class Day_2_1 {
    private static String testInput = "5 1 9 5\n" + //
            "7 5 3\n" + //
            "2 4 6 8";
    private static String input = FileManager.readInlineInput("day_1.txt");

    public static void main(String[] args) {
        String _i = testInput;
        String[] rowsArray = _i.split("\n");
        int[][] _inputArr = {};
        for (int i = 0; i < rowsArray.length; i++) {
            _inputArr[i] = Stream.of(rowsArray[i]).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.stream(_inputArr).forEach(System.out::println);

    }
}
