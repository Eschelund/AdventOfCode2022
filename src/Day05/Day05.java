package Day05;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day05 {

    /**
     * --- Day 5: Supply Stacks ---
     * The expedition can depart as soon as the final supplies have been unloaded from the ships. Supplies are stored in stacks of marked crates, but because the needed supplies are buried under many other crates, the crates need to be rearranged.
     * <p>
     * The ship has a giant cargo crane capable of moving crates between stacks. To ensure none of the crates get crushed or fall over, the crane operator will rearrange them in a series of carefully-planned steps. After the crates are rearranged, the desired crates will be at the top of each stack.
     * <p>
     * The Elves don't want to interrupt the crane operator during this delicate procedure, but they forgot to ask her which crate will end up where, and they want to be ready to unload them as soon as possible so they can embark.
     * <p>
     * They do, however, have a drawing of the starting stacks of crates and the rearrangement procedure (your puzzle input). For example:
     * <p>
     * [D]
     * [N] [C]
     * [Z] [M] [P]
     * 1   2   3
     * <p>
     * move 1 from 2 to 1
     * move 3 from 1 to 3
     * move 2 from 2 to 1
     * move 1 from 1 to 2
     * In this example, there are three stacks of crates. Stack 1 contains two crates: crate Z is on the bottom, and crate N is on top. Stack 2 contains three crates; from bottom to top, they are crates M, C, and D. Finally, stack 3 contains a single crate, P.
     * <p>
     * Then, the rearrangement procedure is given. In each step of the procedure, a quantity of crates is moved from one stack to a different stack. In the first step of the above rearrangement procedure, one crate is moved from stack 2 to stack 1, resulting in this configuration:
     * <p>
     * [D]
     * [N] [C]
     * [Z] [M] [P]
     * 1   2   3
     * In the second step, three crates are moved from stack 1 to stack 3. Crates are moved one at a time, so the first crate to be moved (D) ends up below the second and third crates:
     * <p>
     * [Z]
     * [N]
     * [C] [D]
     * [M] [P]
     * 1   2   3
     * Then, both crates are moved from stack 2 to stack 1. Again, because crates are moved one at a time, crate C ends up below crate M:
     * <p>
     * [Z]
     * [N]
     * [M]     [D]
     * [C]     [P]
     * 1   2   3
     * Finally, one crate is moved from stack 1 to stack 2:
     * <p>
     * [Z]
     * [N]
     * [D]
     * [C] [M] [P]
     * 1   2   3
     * The Elves just need to know which crate will end up on top of each stack; in this example, the top crates are C in stack 1, M in stack 2, and Z in stack 3, so you should combine these together and give the Elves the message CMZ.
     * <p>
     * After the rearrangement procedure completes, what crate ends up on top of each stack?
     */

    public static void main(String[] args) {
        try {
            Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2022\\src\\Day05\\input_day05.txt");
            List<String> instructions = Files.readAllLines(path).stream().skip(10).collect(Collectors.toList());

            solution1(getCrates(), instructions);
            solution2(getCrates(), instructions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<Integer, Stack<Character>> getCrates() {
        Map<Integer, Stack<Character>> crates = new HashMap<>();

        Stack<Character> stack1 = new Stack<>();
        stack1.addAll(List.of('W', 'R', 'F'));
        crates.put(1, stack1);
        Stack<Character> stack2 = new Stack<>();
        stack2.addAll(List.of('T', 'H', 'M', 'C', 'D', 'V', 'W', 'P'));
        crates.put(2, stack2);
        Stack<Character> stack3 = new Stack<>();
        stack3.addAll(List.of('P', 'M', 'Z', 'N', 'L'));
        crates.put(3, stack3);
        Stack<Character> stack4 = new Stack<>();
        stack4.addAll(List.of('J', 'C', 'H', 'R'));
        crates.put(4, stack4);
        Stack<Character> stack5 = new Stack<>();
        stack5.addAll(List.of('C', 'P', 'G', 'H', 'Q', 'T', 'B'));
        crates.put(5, stack5);
        Stack<Character> stack6 = new Stack<>();
        stack6.addAll(List.of('G', 'C', 'W', 'L', 'F', 'Z'));
        crates.put(6, stack6);
        Stack<Character> stack7 = new Stack<>();
        stack7.addAll(List.of('W', 'V', 'L', 'Q', 'Z', 'J', 'G', 'C'));
        crates.put(7, stack7);
        Stack<Character> stack8 = new Stack<>();
        stack8.addAll(List.of('P', 'N', 'R', 'F', 'W', 'T', 'V', 'C'));
        crates.put(8, stack8);
        Stack<Character> stack9 = new Stack<>();
        stack9.addAll(List.of('J', 'W', 'H', 'G', 'R', 'S', 'V'));
        crates.put(9, stack9);

        return crates;
    }

    public static void solution1(Map<Integer, Stack<Character>> crates, List<String> instructions) {
        instructions.forEach(s -> {
            String[] array = s.split("\\s");
            for (int i = 0; i < Integer.parseInt(array[1]); i++) {
                crates.get(Integer.parseInt(array[5])).push(crates.get(Integer.parseInt(array[3])).pop());
            }
        });
        System.out.println(crates.values().stream().map(Stack::pop).collect(Collectors.toList()));
    }

    /**
     * --- Part Two ---
     * As you watch the crane operator expertly rearrange the crates, you notice the process isn't following your prediction.
     * <p>
     * Some mud was covering the writing on the side of the crane, and you quickly wipe it away. The crane isn't a CrateMover 9000 - it's a CrateMover 9001.
     * <p>
     * The CrateMover 9001 is notable for many new and exciting features: air conditioning, leather seats, an extra cup holder, and the ability to pick up and move multiple crates at once.
     * <p>
     * Again considering the example above, the crates begin in the same configuration:
     * <p>
     * [D]
     * [N] [C]
     * [Z] [M] [P]
     * 1   2   3
     * Moving a single crate from stack 2 to stack 1 behaves the same as before:
     * <p>
     * [D]
     * [N] [C]
     * [Z] [M] [P]
     * 1   2   3
     * However, the action of moving three crates from stack 1 to stack 3 means that those three moved crates stay in the same order, resulting in this new configuration:
     * <p>
     * [D]
     * [N]
     * [C] [Z]
     * [M] [P]
     * 1   2   3
     * Next, as both crates are moved from stack 2 to stack 1, they retain their order as well:
     * <p>
     * [D]
     * [N]
     * [C]     [Z]
     * [M]     [P]
     * 1   2   3
     * Finally, a single crate is still moved from stack 1 to stack 2, but now it's crate C that gets moved:
     * <p>
     * [D]
     * [N]
     * [Z]
     * [M] [C] [P]
     * 1   2   3
     * In this example, the CrateMover 9001 has put the crates in a totally different order: MCD.
     * <p>
     * Before the rearrangement process finishes, update your simulation so that the Elves know where they should stand to be ready to unload the final supplies. After the rearrangement procedure completes, what crate ends up on top of each stack?
     */

    public static void solution2(Map<Integer, Stack<Character>> crates, List<String> instructions) {
        instructions.forEach(s -> {
            String[] array = s.split("\\s");
            List<Character> tmp = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(array[1]); i++) {
                tmp.add(crates.get(Integer.parseInt(array[3])).pop());
            }
            for (int i = tmp.size() - 1; i >= 0; i--) {
                crates.get(Integer.parseInt(array[5])).push(tmp.get(i));
            }
        });
        System.out.println(crates.values().stream().map(Stack::pop).collect(Collectors.toList()));
    }
}
