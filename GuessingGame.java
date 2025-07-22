import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        final String[] ORDINALS = {
            "first", "second", "third", "fourth", "fifth", "sixth", "seventh"
        };
        final int MAX_INT = 100;
        final int NUM_GUESSES = 7;

        final int secretNumber = (int)((Math.random() * 100) + 1);

        final Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Hi there!");
        System.out.println("I'm thinking of a number between 1 and " + MAX_INT + ".");
        System.out.println("I'll give you " + NUM_GUESSES + " guesses to get it, telling you if each guess is too high or too low.");
        System.out.println("With the right strategy, you can win every time.");
        System.out.println("Good luck!");
        
        int i = 0;
        int playerGuess;

        do {
            System.out.print("What is your " + ORDINALS[i] + " guess? ");
            playerGuess = scanInt(scanner);
            if (playerGuess < secretNumber) {
                System.out.println("That guess is too low!");
            } else if (playerGuess > secretNumber) {
                System.out.println("That guess is too high!");
            } else {
                System.out.println("You got it on the " + ORDINALS[i] + " guess! Congratulations!");
            }
            ++i;
        } while (secretNumber != playerGuess && i < 7);

        if (secretNumber != playerGuess) {
            System.out.println("Sorry! The number was " + secretNumber + ".");
        }

        System.out.println("Thanks for playing!");

        scanner.close();
    }

    // private static String scanString(Scanner scanner) {
    //     String inputString = scanner.nextLine();
    //     return(inputString);
    // }

    private static int scanInt(Scanner scanner) {
        boolean success = false;
        int inputNum = 0; // will be overwritten by user input eventually; jdk just doesn't like it "possibly being uninitialized" (it's not smart enough)
        while (!success) {
            try {
                inputNum = scanner.nextInt();
                scanner.nextLine();
                success = true;
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                System.out.println("Failed to read integer. Please try again.");
            }
        }
        return(inputNum);
    }
}
