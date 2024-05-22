import java.util.Random;
import java.util.Scanner;

public class pns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playAgain;

        do {
            playGame(scanner, random);

            System.out.print("Play again? (1 for yes, 0 for no): ");
            playAgain = scanner.nextInt();
        } while (playAgain == 1);

        scanner.close();
    }

    public static void playGame(Scanner scanner, Random random) {
        int secretNumber = random.nextInt(100) + 1;
        int maxAttempts = 10;
        int attempts = 0;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100. You have {maxAttempts} attempts to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess;
            try {
                guess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the number in {attempts} attempts.");
                break;
            } else if (guess < secretNumber) {
                System.out.println("Too low, try again.");
            } else {
                System.out.println("Too high, try again.");
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you ran out of attempts. The number was {secretNumber}.");
        }
    }
}
