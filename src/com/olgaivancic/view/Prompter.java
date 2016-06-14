package com.olgaivancic.view;

import com.olgaivancic.model.Jar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * This class is the View part of the MVC pattern of the project. It is responsible for the input/output functionality.
 */
public class Prompter {

    private Jar mJar = new Jar();
    private BufferedReader mReader = new BufferedReader(new InputStreamReader(System.in));

    public Prompter (Jar jar) {
        mJar = jar;
    }


    /**
     * This method prompts administrator for an item to fill the jar with and adds it to the Jar object.
     */
    private void promptForJarFiller() {

        System.out.print("Administrator - enter what would you like to fill the jar with:  ");
        String jarFiller = null;
        try {
            jarFiller = mReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mJar.setJarFiller(jarFiller);
    }


    /**
     * This method prompts for the number of items in the jar and adds it to the Jar object.
     */
    private void promptForMaxNumberOfItems() {
        //TODO: Format the jarFiller string so that the first letter is capitalized in the sentence.
        System.out.printf("%s is an excellent choice! How many pieces of %s would you like in the jar?  ", mJar.getJarFiller(),
                mJar.getJarFiller());
        String numberAsString = "";
        boolean isPositiveNumber = true;
        do {
            try {
                numberAsString = mReader.readLine();
            } catch (IOException e) {
                System.out.println("Unable to read in the input.");
                e.printStackTrace();
            }
            isPositiveNumber = mJar.checkIfMaxNumberIsPositive(numberAsString);
        } while (!isPositiveNumber);
        mJar.setMaxNumberOfItems(Integer.parseInt(numberAsString));
    }

    /**
     * This method prompts Administrator for data needed to create an instance of a com.olgaivancic.model.Jar class.
     *
     * @return Returns a com.olgaivancic.model.Jar object.
     */
    public Jar promptAdministrator() {
        promptForJarFiller();
        promptForMaxNumberOfItems();

        return mJar;
    }

    /**
     * This method prompts Player and contains the I/O logic of the game.
     */
    public void play() {
        // Generate a random integer.
        int randomNumber = mJar.generateRandomNumber();

        // Prompt the Player for the number
        System.out.printf("Player: you need to guess the number of %s in the jar.%n", mJar.getJarFiller());
        System.out.println("Please, enter a number between 1 and "+ randomNumber + 1);
    }

}
