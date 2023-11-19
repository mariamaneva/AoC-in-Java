package twenty_seventeen;

import java.util.ArrayList;
import java.util.List;

import utils.FileManager;

public class Day_1_2 {
    private static String testInput = "123123";
    private static String input = FileManager.readInlineInput("day_1.txt");

    public static void main(String[] args) {
        String _input = input;
        int step = _input.length() / 2;
        List<Integer> parsed = new ArrayList<>();
        for (char ch : _input.toCharArray()) {
            parsed.add(Character.getNumericValue(ch));
        }

        int total = 0;

        for (int i = 0; i < parsed.size(); i++) {
            int current = parsed.get(i);
            int next = 0;

            try {
                next = parsed.get(i + step);
            } catch (Exception e) {
                System.out.println("Start from beginning");
                next = parsed.get(step - (parsed.size() - 1 - i) - 1);
            }

            System.out.println(next);

            if (current == next) {
                total += next;
            }
        }

        System.out.println(total);
    }
}
