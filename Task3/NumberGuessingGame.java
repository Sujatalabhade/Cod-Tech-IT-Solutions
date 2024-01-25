//Number Guessing Game

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 10;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game..!!!");
        System.out.println("I Have Selected a Number between 1 and 100. Try to Guess it...");

        while (attempts < maxAttempts) {
            System.out.print("Enter your Guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You Guessed the number in " + attempts + " attempts.");
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Too low. Try Again.");
            } else {
                System.out.println("Too high. Try Again.");
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you have reached the maximum number of attempts. The correct number was " + targetNumber + ".");
            }
        }

        scanner.close();
    }
}
