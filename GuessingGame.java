import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        int attemptsLimit = 5;
        int score = 0;
        int rounds = 0;
        String playAgain = "y";

        while (playAgain.equalsIgnoreCase("y")) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;
            rounds++;

            System.out.println("\nRound " + rounds);
            System.out.println("I have generated a number between 1 and 100. You have " + attemptsLimit + " attempts to guess it, " + playerName + ".");

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                try {
                    int guess = Integer.parseInt(scanner.nextLine());
                    attempts++;

                    if (guess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations, " + playerName + "! You guessed the number in " + attempts + " attempts.");
                        guessedCorrectly = true;
                        score++;
                        break;
                    }

                    int remainingAttempts = attemptsLimit - attempts;
                    System.out.println("You have " + remainingAttempts + " attempts left, " + playerName + ".");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, " + playerName + ", you've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.print("Do you want to play another round, " + playerName + "? (y/n): ");
            playAgain = scanner.nextLine();
        }

        System.out.println("\nGame Over!");
        System.out.println("You played " + rounds + " rounds and your score is " + score + ", " + playerName + ".");
        
        scanner.close();
    }
}
