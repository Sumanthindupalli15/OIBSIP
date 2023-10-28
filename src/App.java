import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 10;
        int attempts = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a random number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please enter a number within the valid range.");
            } else if (userGuess < numberToGuess) {
                System.out.println("The number is higher. You have " + (maxAttempts - attempts) + " attempts left.");
            } else if (userGuess > numberToGuess) {
                System.out.println("The number is lower. You have " + (maxAttempts - attempts) + " attempts left.");
            } else {
                System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                score += maxAttempts - attempts + 1;
                System.out.println("Your current score is: " + score);

                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();

                if (playAgain.equals("no")) {
                    System.out.println("Thanks for playing! Your final score is: " + score);
                    break;
                } else if (playAgain.equals("yes")) {
                    numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                    attempts = 0;
                    System.out.println("I've selected a new number. Let's play again!");
                } else {
                    System.out.println("Invalid input. The game will end.");
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Out of attempts! The number was " + numberToGuess);
                System.out.println("Your final score is: " + score);
                break;
            }
        }

        scanner.close();
    }
}
