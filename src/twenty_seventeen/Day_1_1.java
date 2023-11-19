package twenty_seventeen;

import java.util.ArrayList;
import java.util.List;

import utils.FileManager;

public class Day_1_1 {
    private static String testInput = "91212129";
    private static String input = FileManager.readInlineInput("day_1.txt");

    public static void main(String[] args) {
        List<Integer> parsed = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            parsed.add(Character.getNumericValue(ch));
        }

        int total = 0;

        for (int i = 0; i < parsed.size(); i++) {
            int current = parsed.get(i);
            int next = 0;

            try {
                next = parsed.get(i + 1);
            } catch (Exception e) {
                next = parsed.get(0);
            }

            if (current == next) {
                total += next;
            }
        }

        System.out.println(total);
    }
}
