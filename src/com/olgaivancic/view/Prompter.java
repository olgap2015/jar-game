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
    private void promptForJarFiller() {

        System.out.println("For Administrator:\n");
        System.out.println("Please, enter what would you like to fill the jar with:  ");
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
        System.out.printf("%s is an excellent choice! How many pieces of %s would you like in the jar?  ", mJar.getJarFiller(),
                                                                                                           mJar.getJarFiller());
        String numberAsString = "";
        do {
            try {
                numberAsString = mReader.readLine();
            } catch (IOException e) {
                System.out.println("Unable to read in the input.");
                e.printStackTrace();
            }
            checkIfPositiveInteger(numberAsString);
        }
    }

    /**
     * This method prompts Administrator for data needed to create an instance of a com.olgaivancic.model.Jar class.
     * @return Returns a com.olgaivancic.model.Jar object.
     */
    public Jar promptAdministrator() {
        promptForJarFiller();
        promptForMaxNumberOfItems();

        return mJar;
    }

    /**
     *  This method checks if the parameter is a positive integer.
     * @param numberAsString
     */
    public static void checkIfPositiveInteger(String numberAsString) {

        int number = Integer.parseInt(numberAsString);
        if(number <= 0) {
            System.out.println("This is not a valid number. Please, enter a positive whole number");
        }

    }
}
