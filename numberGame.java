import java.util.Scanner;
import java.util.Random;

public class encryptix1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 10; 
        int score = 0; 

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between " + minRange + " and " + maxRange + ".");
            
            while (!guessedCorrectly && attempts < attemptsLimit) {
                System.out.print("Enter your guess (attempt " + (attempts + 1) + "/" + attemptsLimit + "): ");
                int guess = scanner.nextInt();
                scanner.nextLine(); 
                
                if (guess < minRange || guess > maxRange) {
                    System.out.println("Please enter a number within the range " + minRange + " to " + maxRange + ".");
                    continue;
                }

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    guessedCorrectly = true;
                    score++;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Oops! You've used all your attempts. The correct number was: " + targetNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over! Your score: " + score + " rounds won.");
        scanner.close();
    }
}
