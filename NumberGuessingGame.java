import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);
    private static final int MAX_ATTEMPTS = 5;


    public static void main(String[] args) {
        int roundsWon = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            boolean hasWon = playRound();
            if (hasWon) {
                roundsWon++;
                System.out.println("You won this round!");
            } else {
                System.out.println("You lost this round. Better luck next time!");
            }

            System.out.println("You have won " + roundsWon + " rounds so far.");
            playAgain = askPlayAgain();
        } while (playAgain);

        System.out.println("Thanks for playing! You won " + roundsWon + " rounds total.");
    }

    // Method to play one round of the game
    private static boolean playRound() {
        int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
            System.out.println("Attempt " + (attempts + 1) + " of " + MAX_ATTEMPTS + ": Enter your guess:");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You guessed the correct number!");
                hasGuessedCorrectly = true;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry! You've used all your attempts. The number was: " + numberToGuess);
        }

        return hasGuessedCorrectly;
    }

    // Method to ask the player if they want to play another round
    private static boolean askPlayAgain() {
        System.out.println("Do you want to play again? (yes/no)");
        String userInput = scanner.next().toLowerCase();
        return userInput.equals("yes");
    }
}
