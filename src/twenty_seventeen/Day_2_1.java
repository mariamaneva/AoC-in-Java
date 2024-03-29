package twenty_seventeen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import utils.FileManager;

public class Day_2_1 {

    // REDDIT SOLUTION

    // public static void main(String[] args) {
    // BufferedReader r = new BufferedReader(new StringReader(input));
    // int sum = r.lines().mapToInt(Day2_2017::diff).sum();
    // }

    // private static int diff(String line) {
    // IntSummaryStatistics intSummaryStatistics =
    // Arrays.stream(line.split("\\t")).mapToInt(Integer::valueOf).summaryStatistics();
    // return intSummaryStatistics.getMax() - intSummaryStatistics.getMin();
    // }

    public static void main(String[] args) {
        // Stream<String> rawInput =
        // FileManager.readLinesToStream("day_2_test_input.txt");
        Stream<String> rawInput = FileManager.readLinesToStream("day_2.txt");
        if (rawInput != null) {
            Stream<Stream<Integer>> input = rawInput
                    .map(line -> Arrays.asList(line.split("\\s+")).stream().map(num -> Integer.parseInt(num))
                            .sorted((a, b) -> a - b));

            // input.forEach(line -> {
            // System.out.println("----");
            // System.out.println(line.map(Object::toString).collect(Collectors.joining("
            // ")));
            // });

            Stream<Integer> results = input.map(line -> {
                List<Integer> list = line.toList();
                return list.get(list.size() - 1) - list.get(0);
            });

            // System.out.println(results.reduce(0, (a, b) -> a + b));
            System.out.println(results.reduce(0, (a, b) -> a + b));
        }
    }
}
