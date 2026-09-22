package template_method;

import java.util.Scanner;

public class DiceGame extends Game {

    private int[] scores;
    private int winner = -1;

    private final int winningScore = 20;

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void initializeGame(int numberOfPlayers) {

        scores = new int[numberOfPlayers];

        System.out.println("Dice Race Game started!");
        System.out.println("Number of players: " + numberOfPlayers);
        System.out.println("First player to reach 20 points wins.");
        System.out.println();
    }

    @Override
    public boolean endOfGame() {
        return winner != -1;
    }

    @Override
    public void playSingleTurn(int player) {

        System.out.print(
                "Player " + (player + 1) +
                        ", enter a number from 1 to 6: "
        );

        int number = scanner.nextInt();

        while (number < 1 || number > 6) {
            System.out.print(
                    "Invalid number. Please enter 1 to 6: "
            );

            number = scanner.nextInt();
        }

        scores[player] += number;

        System.out.println(
                "Player " + (player + 1) +
                        " entered: " + number
        );

        System.out.println(
                "Player " + (player + 1) +
                        " score: " + scores[player]
        );

        System.out.println();

        if (scores[player] >= winningScore) {
            winner = player;
        }
    }

    @Override
    public void displayWinner() {

        System.out.println(
                "Player " + (winner + 1) +
                        " wins!"
        );
    }
}