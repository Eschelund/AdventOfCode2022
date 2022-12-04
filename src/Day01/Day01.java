package Day01;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day01 {

    /**
     * --- Day 1: Calorie Counting ---
     * Santa's reindeer typically eat regular reindeer food, but they need a lot of magical energy to deliver presents on Christmas. For that, their favorite snack is a special type of star fruit that only grows deep in the jungle. The Elves have brought you on their annual expedition to the grove where the fruit grows.
     * <p>
     * To supply enough magical energy, the expedition needs to retrieve a minimum of fifty stars by December 25th. Although the Elves assure you that the grove has plenty of fruit, you decide to grab any fruit you see along the way, just in case.
     * <p>
     * Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
     * <p>
     * The jungle must be too overgrown and difficult to navigate in vehicles or access from the air; the Elves' expedition traditionally goes on foot. As your boats approach land, the Elves begin taking inventory of their supplies. One important consideration is food - in particular, the number of Calories each Elf is carrying (your puzzle input).
     * <p>
     * The Elves take turns writing down the number of Calories contained by the various meals, snacks, rations, etc. that they've brought with them, one item per line. Each Elf separates their own inventory from the previous Elf's inventory (if any) by a blank line.
     * <p>
     * For example, suppose the Elves finish writing their items' Calories and end up with the following list:
     * <p>
     * 1000
     * 2000
     * 3000
     * <p>
     * 4000
     * <p>
     * 5000
     * 6000
     * <p>
     * 7000
     * 8000
     * 9000
     * <p>
     * 10000
     * This list represents the Calories of the food carried by five Elves:
     * <p>
     * The first Elf is carrying food with 1000, 2000, and 3000 Calories, a total of 6000 Calories.
     * The second Elf is carrying one food item with 4000 Calories.
     * The third Elf is carrying food with 5000 and 6000 Calories, a total of 11000 Calories.
     * The fourth Elf is carrying food with 7000, 8000, and 9000 Calories, a total of 24000 Calories.
     * The fifth Elf is carrying one food item with 10000 Calories.
     * In case the Elves get hungry and need extra snacks, they need to know which Elf to ask: they'd like to know how many Calories are being carried by the Elf carrying the most Calories. In the example above, this is 24000 (carried by the fourth Elf).
     * <p>
     * Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?
     */

    public static void main(String[] args) {
        try {
            Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2022\\src\\Day01\\input_day01.txt");
            List<String> instructions = Files.readAllLines(path);

            solution1(instructions);
            solution2(instructions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * --- Part Two ---
     * By the time you calculate the answer to the Elves' question, they've already realized that the Elf carrying the most Calories of food might eventually run out of snacks.
     * <p>
     * To avoid this unacceptable situation, the Elves would instead like to know the total Calories carried by the top three Elves carrying the most Calories. That way, even if one of those Elves runs out of snacks, they still have two backups.
     * <p>
     * In the example above, the top three Elves are the fourth Elf (with 24000 Calories), then the third Elf (with 11000 Calories), then the fifth Elf (with 10000 Calories). The sum of the Calories carried by these three elves is 45000.
     * <p>
     * Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
     */

    public static void solution1(List<String> instructions) {
        int max = 0;
        int tmp = 0;
        for (String s : instructions) {
            if (s.isEmpty()) {
                max = Math.max(max, tmp);
                tmp = 0;
                continue;
            }
            tmp += Integer.parseInt(s);
        }
        System.out.println(max);
    }

    public static void solution2(List<String> instructions) {
        List<Integer> calories = new ArrayList<>();
        int tmp = 0;
        for (String s : instructions) {
            if (s.isEmpty()) {
                calories.add(tmp);
                tmp = 0;
                continue;
            }
            tmp += Integer.parseInt(s);
        }
        System.out.println(calories.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()));
        System.out.println(calories.stream().sorted(Comparator.reverseOrder()).limit(3).reduce(Integer::sum));
    }
}
