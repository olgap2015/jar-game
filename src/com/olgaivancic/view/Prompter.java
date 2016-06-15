package com.olgaivancic.view;

import com.olgaivancic.model.Jar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is the View part of the MVC pattern of the project. It is responsible for the input/output functionality.
 */
public class Prompter {

    private Jar mJar;
    private BufferedReader mReader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * This method prompts administrator for an item to fill the jar with and adds it to the Jar object.
     */
    public String promptForJarFiller() {

        System.out.print("Administrator - what would you like to put in the jar?  ");
        String jarFiller = null;
        try {
            jarFiller = mReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jarFiller;
    }


    /**
     * This method prompts for the number of items in the jar and adds it to the Jar object.
     *
     * @param jarFiller
     */
    public int promptForMaxNumberOfItems(String jarFiller) {
        //TODO: Format the jarFiller string so that the first letter is capitalized in the sentence.
        String capitalizedJarFiller = jarFiller.toUpperCase().charAt(0) + jarFiller.substring(1);
        System.out.printf("%s is (are) an excellent choice! What is the maximum amount of pieces of %s would you like to have in the jar?  ",
                capitalizedJarFiller,
                jarFiller);
        String numberAsString = "";
        boolean isPositiveNumber = true;
        do {
            try {
                numberAsString = mReader.readLine();
            } catch (IOException e) {
                System.out.println("Unable to read the input. Please, try again");
                e.printStackTrace();
            }
            isPositiveNumber = checkIfMaxNumberIsPositive(numberAsString);
        } while (!isPositiveNumber);

        return Integer.parseInt(numberAsString);
    }

    /**
     * This method prompts Player and contains the I/O logic of the game.
     *
     * @param jar
     */
    public void play(Jar jar) {
        // Generate a random integer and set the correct answer.
        mJar = jar;
        int randomNumber = mJar.generateRandomNumber();
        mJar.setCorrectAnswer(randomNumber + 1);

        // Output the rules
        System.out.printf("Player - you need to guess the number of %s in the jar. Enter a number between 1 and %d%n",
                mJar.getJarFiller(),
                mJar.getMaxNumberOfItems());

        // Prompt Player for guess until the guess is correct while coounting the valid guesses
        int amountOfTries = promptForGuessUntilSolved();

        // Output the amount of tries it took to guess.
        System.out.printf("Congratulations! You guessed that there are %d pieces of %s in the jar. ",
                mJar.getCorrectAnswer(),
                mJar.getJarFiller());
        System.out.printf("It took you %d tries to guess the correct answer.%n", amountOfTries);

    }

    /**
     * This method prompts the Player for guess until the guess is correct.
     */
    private int promptForGuessUntilSolved() {
        boolean isSolved = false;
        int guessCounter = 0;
        while (!isSolved) {
            int guess = 0;

            // Prompt Player for guess until the guess is a number within the range of 1 to the maximum number of items in the jar.
            do {
                String guessAsString = "";

                System.out.print("Guess:  ");
                // Read in the input
                try {
                    guessAsString = mReader.readLine();
                } catch (IOException e) {
                    System.out.println("\nNot able to read the input!");
                    e.printStackTrace();
                }
                // Convert String into int
                try {
                    guess = Integer.parseInt(guessAsString);
                } catch (NumberFormatException nfe) {
                    System.out.println("Not a valid entry. Please, try again!");
                }

                // make sure that the answer is within the range of 1 to maximum number of items in the jar
                boolean isValid = checkIfGuessIsValid(guess);
                if (isValid) {
                    guessCounter++;
                }
            } while (guess <= 0 || guess > mJar.getMaxNumberOfItems());

            // check to see if the answer is correct.
            isSolved = mJar.checkIfGuessIsCorrect(guess);

            // Evaluate whether the wrong guess was too high or too low.
            if (!isSolved) {
                System.out.println(mJar.evaluateGuess(guess));
            }
        }
        return guessCounter;
    }

    /**
     * This method checks is the guess is within the range of 1 to the maximum amount of items in the jar.
     *
     * @param guess
     * @return Returns true if the guess is valid and false if the guess is not valid.
     */
    private boolean checkIfGuessIsValid(int guess) {
        boolean isValid = true;
        if (guess <= 0 || guess > mJar.getMaxNumberOfItems()) {
            System.out.printf("The guess you entered is not within the range 1 - %d. Please, try again.%n",
                    mJar.getMaxNumberOfItems());
            isValid = false;
        }
        return isValid;
    }

    public boolean checkIfWantOneMoreGame() {
        System.out.println("Would you like to play another game? " +
                "Enter \"yes\" if you would like to play another game and enter \"quit\" if you are done playing.");
        boolean oneMoreGame = false;
        String input = "";
        boolean isValidInput = false;
        do {
            try {
                input = mReader.readLine();
            } catch (IOException e) {
                System.out.println("Not able to read the input!");
                e.printStackTrace();
            }

            // validate the input
            switch (input.toLowerCase()) {
                case "yes":
                    oneMoreGame = true;
                    isValidInput = true;
                    break;
                case "quit":
                    oneMoreGame = false;
                    isValidInput = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please, try again");
                    break;
            }
        } while (!isValidInput);

        return oneMoreGame;
    }

    private boolean checkIfMaxNumberIsPositive(String numberAsString) {

        boolean isPositiveNumber = true;
        int number = 0;
        try {
            number = Integer.parseInt(numberAsString);
        } catch (NumberFormatException nfe) {
            System.out.println("The input is not a number!");
            nfe.printStackTrace();
        }
        if (number <= 0) {
            isPositiveNumber = false;
            System.out.println("Please, enter a positive whole number");
        }
        return isPositiveNumber;
    }
}
