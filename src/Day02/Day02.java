package Day02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day02 {

    /**
     * --- Day 2: Rock Paper Scissors ---
     * The Elves begin to set up camp on the beach. To decide whose tent gets to be closest to the snack storage, a giant Rock Paper Scissors tournament is already in progress.
     * <p>
     * Rock Paper Scissors is a game between two players. Each game contains many rounds; in each round, the players each simultaneously choose one of Rock, Paper, or Scissors using a hand shape. Then, a winner for that round is selected: Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock. If both players choose the same shape, the round instead ends in a draw.
     * <p>
     * Appreciative of your help yesterday, one Elf gives you an encrypted strategy guide (your puzzle input) that they say will be sure to help you win. "The first column is what your opponent is going to play: A for Rock, B for Paper, and C for Scissors. The second column--" Suddenly, the Elf is called away to help with someone's tent.
     * <p>
     * The second column, you reason, must be what you should play in response: X for Rock, Y for Paper, and Z for Scissors. Winning every time would be suspicious, so the responses must have been carefully chosen.
     * <p>
     * The winner of the whole tournament is the player with the highest score. Your total score is the sum of your scores for each round. The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors) plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
     * <p>
     * Since you can't be sure if the Elf is trying to help you or trick you, you should calculate the score you would get if you were to follow the strategy guide.
     * <p>
     * For example, suppose you were given the following strategy guide:
     * <p>
     * A Y
     * B X
     * C Z
     * This strategy guide predicts and recommends the following:
     * <p>
     * In the first round, your opponent will choose Rock (A), and you should choose Paper (Y). This ends in a win for you with a score of 8 (2 because you chose Paper + 6 because you won).
     * In the second round, your opponent will choose Paper (B), and you should choose Rock (X). This ends in a loss for you with a score of 1 (1 + 0).
     * The third round is a draw with both players choosing Scissors, giving you a score of 3 + 3 = 6.
     * In this example, if you were to follow the strategy guide, you would get a total score of 15 (8 + 1 + 6).
     * <p>
     * What would your total score be if everything goes exactly according to your strategy guide?
     */

    public static void main(String[] args) {
        try {
            Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2022\\src\\Day02\\input_day02.txt");
            List<String> instructions = Files.readAllLines(path);

            solution1(instructions);
            solution2(instructions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void solution1(List<String> instructions) {
        AtomicInteger score = new AtomicInteger();
        instructions.forEach(s -> score.addAndGet(scoreCalculator1(s)));
        System.out.println(score);
    }

    private static int scoreCalculator1(String hands) {
        return switch (hands) {
            case "A X" -> 4;
            case "B X" -> 1;
            case "C X" -> 7;
            case "A Y" -> 8;
            case "B Y" -> 5;
            case "C Y" -> 2;
            case "A Z" -> 3;
            case "B Z" -> 9;
            case "C Z" -> 6;
            default -> throw new IllegalStateException("Unexpected value: " + hands);
        };
    }

    /**
     * --- Part Two ---
     * The Elf finishes helping with the tent and sneaks back over to you. "Anyway, the second column says how the round needs to end: X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win. Good luck!"
     * <p>
     * The total score is still calculated in the same way, but now you need to figure out what shape to choose so the round ends as indicated. The example above now goes like this:
     * <p>
     * In the first round, your opponent will choose Rock (A), and you need the round to end in a draw (Y), so you also choose Rock. This gives you a score of 1 + 3 = 4.
     * In the second round, your opponent will choose Paper (B), and you choose Rock so you lose (X) with a score of 1 + 0 = 1.
     * In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
     * Now that you're correctly decrypting the ultra top secret strategy guide, you would get a total score of 12.
     * <p>
     * Following the Elf's instructions for the second column, what would your total score be if everything goes exactly according to your strategy guide?
     */
    public static void solution2(List<String> instructions) {
        AtomicInteger score = new AtomicInteger();
        instructions.forEach(s -> score.addAndGet(scoreCalculator2(s)));
        System.out.println(score);
    }

    private static int scoreCalculator2(String hands) {
        return switch (hands) {
            case "A X" -> 3;
            case "B X" -> 1;
            case "C X" -> 2;
            case "A Y" -> 4;
            case "B Y" -> 5;
            case "C Y" -> 6;
            case "A Z" -> 8;
            case "B Z" -> 9;
            case "C Z" -> 7;
            default -> throw new IllegalStateException("Unexpected value: " + hands);
        };
    }

}
