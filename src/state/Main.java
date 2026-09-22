package state;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        GameCharacter character =
                new GameCharacter(name);

        while (!(character.getState()
                instanceof MasterState)) {

            character.displayStatus();

            System.out.println("\nAvailable actions:");

            if (character.getState()
                    instanceof NoviceState) {

                System.out.println("1. Train");
            }

            else if (character.getState()
                    instanceof IntermediateState) {

                System.out.println("1. Train");
                System.out.println("2. Meditate");
            }

            else if (character.getState()
                    instanceof ExpertState) {

                System.out.println("1. Train");
                System.out.println("2. Meditate");
                System.out.println("3. Fight");
            }

            System.out.print("Choose action: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    character.train();
                    break;

                case 2:
                    character.meditate();
                    break;

                case 3:
                    character.fight();
                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }

        character.displayStatus();

        System.out.println(
                "\nCongratulations! You reached Master level!"
        );

        System.out.println("Game Over!");

        scanner.close();
    }
}