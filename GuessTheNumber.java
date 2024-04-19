import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    private static final Scanner inputScanner = new Scanner(System.in);
    private static final Random randomGenerator = new Random();
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int ATTEMPTS_LIMIT = 5;

    public static void main(String[] args) {
        System.out.println("Welcome to the Guess the Number Game!");

        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int score = playGame();
            totalScore += score;
            System.out.println("Your score for this game: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = inputScanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Your total score is: " + totalScore);
        System.out.println("Thank you for playing!");
        inputScanner.close();
    }

    private static int playGame() {
        int randomNumber = randomGenerator.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
        int attempts = 0;

        System.out.println("A random number between " + MIN_RANGE + " and " + MAX_RANGE + " has been chosen.");
        System.out.println("You have " + ATTEMPTS_LIMIT + " attempts to guess it.");

        while (attempts < ATTEMPTS_LIMIT) {
            System.out.print("Enter your guess: ");
            int userGuess = inputScanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                return ATTEMPTS_LIMIT - attempts + 1; // Score is based on remaining attempts
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
        System.out.println("Thank you for playing!");
        return 0; // Score is 0 if user couldn't guess the number
    }
}
