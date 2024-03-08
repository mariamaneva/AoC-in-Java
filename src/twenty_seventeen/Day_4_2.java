package twenty_seventeen;

import java.util.Arrays;
import java.util.stream.Collectors;

import utils.FileManager;

public class Day_4_2 {
  public static String sortString(String input) {
    return input.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
  }

  public static void main(String[] args) {
    var rawInput = FileManager.readLinesToList("day_4.txt");
    int[] valid = new int[1];

    if (rawInput != null) {
      var originalInput = rawInput.stream()
          .map(line -> Arrays.asList(line.split("\\s")).stream().map(word -> sortString(word))
              .collect(Collectors.toList()))
          .collect(Collectors.toList());
      for (int i = 0; i < originalInput.size(); i++) {
        var originalLine = originalInput.get(i);
        var processedLine = originalInput.get(i).stream().distinct().collect(Collectors.toList());

        if (originalLine.size() == processedLine.size()) {
          valid[0]++;
        }
      }

      System.out.println(valid[0]);
    }
  }
}
