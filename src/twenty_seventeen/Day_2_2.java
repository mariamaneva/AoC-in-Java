package twenty_seventeen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.FileManager;

public class Day_2_2 {

    // REDDIT SOLUTION

    // List<List<Integer>> spreadsheet = parseInput();
    // return spreadsheet.stream()
    // .map(row -> row.stream().flatMap(i -> row.stream().filter(j -> j != i && j %
    // i == 0).map(j -> j / i)))
    // .flatMap(Function.identity()).reduce(0, Integer::sum);

    public static void main(String[] args) {
        // var rawInput = FileManager.readLinesToList("day_2_2_test_input.txt");
        var rawInput = FileManager.readLinesToList("day_2.txt");
        if (rawInput != null) {
            var input = rawInput.stream().map(line -> Arrays.asList(line.split("\\s+")).stream().map(Integer::parseInt)
                    .collect(Collectors.toList())).collect(Collectors.toList());

            List<Integer> processedLines = new ArrayList<>();

            for (int i = 0; i < input.size(); i++) {
                var line = input.get(i);
                var processedLine = line.stream().filter(num -> {
                    var found = line.stream().filter(num2 -> {
                        if (num > num2 && num % num2 == 0) {
                            return true;
                        }
                        if (num < num2 && num2 % num == 0) {
                            return true;
                        }
                        return false;
                    }).findFirst();

                    return found.isPresent();
                }).reduce(1, (a, b) -> {
                    if (a > b) {
                        return a / b;
                    }
                    return b / a;
                });

                processedLines.add(processedLine);
            }
            System.out.println(processedLines.stream().reduce(0, (a, b) -> a + b));
        }
    }
}
