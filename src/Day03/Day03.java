package Day03;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day03 {

    /**
     * --- Day 3: Rucksack Reorganization ---
     * One Elf has the important job of loading all of the rucksacks with supplies for the jungle journey. Unfortunately, that Elf didn't quite follow the packing instructions, and so a few items now need to be rearranged.
     * <p>
     * Each rucksack has two large compartments. All items of a given type are meant to go into exactly one of the two compartments. The Elf that did the packing failed to follow this rule for exactly one item type per rucksack.
     * <p>
     * The Elves have made a list of all of the items currently in each rucksack (your puzzle input), but they need your help finding the errors. Every item type is identified by a single lowercase or uppercase letter (that is, a and A refer to different types of items).
     * <p>
     * The list of items for each rucksack is given as characters all on a single line. A given rucksack always has the same number of items in each of its two compartments, so the first half of the characters represent items in the first compartment, while the second half of the characters represent items in the second compartment.
     * <p>
     * For example, suppose you have the following list of contents from six rucksacks:
     * <p>
     * vJrwpWtwJgWrhcsFMMfFFhFp
     * jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
     * PmmdzqPrVvPwwTWBwg
     * wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
     * ttgJtRGJQctTZtZT
     * CrZsJsPPZsGzwwsLwLmpwMDw
     * The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp, which means its first compartment contains the items vJrwpWtwJgWr, while the second compartment contains the items hcsFMMfFFhFp. The only item type that appears in both compartments is lowercase p.
     * The second rucksack's compartments contain jqHRNqRjqzjGDLGL and rsFMfFZSrLrFZsSL. The only item type that appears in both compartments is uppercase L.
     * The third rucksack's compartments contain PmmdzqPrV and vPwwTWBwg; the only common item type is uppercase P.
     * The fourth rucksack's compartments only share item type v.
     * The fifth rucksack's compartments only share item type t.
     * The sixth rucksack's compartments only share item type s.
     * To help prioritize item rearrangement, every item type can be converted to a priority:
     * <p>
     * Lowercase item types a through z have priorities 1 through 26.
     * Uppercase item types A through Z have priorities 27 through 52.
     * In the above example, the priority of the item type that appears in both compartments of each rucksack is 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s); the sum of these is 157.
     * <p>
     * Find the item type that appears in both compartments of each rucksack. What is the sum of the priorities of those item types?
     */

    public static void main(String[] args) {
        try {
            Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2022\\src\\Day03\\input_day03.txt");
            List<String> instructions = Files.readAllLines(path);

            solution1(instructions);
            solution2(instructions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void solution1(List<String> instructions) {
        AtomicInteger score = new AtomicInteger();
        instructions.forEach(s -> {
            Character[] first = s.substring(0, s.length() / 2).chars().mapToObj(c -> (char) c).toArray(Character[]::new);
            Character[] second = s.substring(s.length() / 2).chars().mapToObj(c -> (char) c).toArray(Character[]::new);
            score.addAndGet(duplicateItemPriority(first, second));
        });
        System.out.println(score);
    }

    private static int duplicateItemPriority(Character[] first, Character[] second) {
        for (Character c : first) {
            if (Arrays.stream(second).anyMatch(c2 -> c == c2)) {
                return (int) c > 96 ? ((int) c) - 96 : ((int) c) - 64 + 26;
            }
        }
        return 0;
    }

    /**
     * --- Part Two ---
     * As you finish identifying the misplaced items, the Elves come to you with another issue.
     * <p>
     * For safety, the Elves are divided into groups of three. Every Elf carries a badge that identifies their group. For efficiency, within each group of three Elves, the badge is the only item type carried by all three Elves. That is, if a group's badge is item type B, then all three Elves will have item type B somewhere in their rucksack, and at most two of the Elves will be carrying any other item type.
     * <p>
     * The problem is that someone forgot to put this year's updated authenticity sticker on the badges. All of the badges need to be pulled out of the rucksacks so the new authenticity stickers can be attached.
     * <p>
     * Additionally, nobody wrote down which item type corresponds to each group's badges. The only way to tell which item type is the right one is by finding the one item type that is common between all three Elves in each group.
     * <p>
     * Every set of three lines in your list corresponds to a single group, but each group can have a different badge item type. So, in the above example, the first group's rucksacks are the first three lines:
     * <p>
     * vJrwpWtwJgWrhcsFMMfFFhFp
     * jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
     * PmmdzqPrVvPwwTWBwg
     * And the second group's rucksacks are the next three lines:
     * <p>
     * wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
     * ttgJtRGJQctTZtZT
     * CrZsJsPPZsGzwwsLwLmpwMDw
     * In the first group, the only item type that appears in all three rucksacks is lowercase r; this must be their badges. In the second group, their badge item type must be Z.
     * <p>
     * Priorities for these items must still be found to organize the sticker attachment efforts: here, they are 18 (r) for the first group and 52 (Z) for the second group. The sum of these is 70.
     * <p>
     * Find the item type that corresponds to the badges of each three-Elf group. What is the sum of the priorities of those item types?
     */
    public static void solution2(List<String> instructions) {

    }
}
