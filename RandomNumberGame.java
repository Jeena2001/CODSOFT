import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int totalScore = 0;
        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nRound " + (rounds + 1));
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (hasGuessedCorrectly) {
                int roundScore = maxAttempts - attempts + 1;
                totalScore += roundScore;
                System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                System.out.println("Round Score: " + roundScore + " | Total Score: " + totalScore);
            } else {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
                System.out.println("Round Score: 0 | Total Score: " + totalScore);
            }

            rounds++;

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);

        System.out.println("\nGame Over! Your final score is: " + totalScore);
        scanner.close();
    }
}
