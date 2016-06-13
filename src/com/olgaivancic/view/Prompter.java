package com.olgaivancic.view;

import com.olgaivancic.model.Jar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is the View part of the MVC pattern of the project. It is responsible for the input/output functionality.
 */
public class Prompter {

    private Jar mJar = new Jar();
    private BufferedReader mReader = new BufferedReader(new InputStreamReader(System.in));


    /**
     * This method prompts administrator for an item to fill the jar with and adds it to the Jar object.
     */
    private void promptForJarFiller() {

        System.out.println("For Administrator:\n");
        System.out.print("Please, enter what would you like to fill the jar with:  ");
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
            isPositiveNumber = checkIfPositiveInteger(numberAsString);
            if (isPositiveNumber == false) {
                System.out.println("This is not a valid number. Please, enter a positive whole number");
            }
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
     * This method checks if the parameter is a positive integer.
     *
     * @param numberAsString
     */
    public static boolean checkIfPositiveInteger(String numberAsString) {

        boolean isPositiveNumber = true;
        int number = 0;
        try{
            number = Integer.parseInt(numberAsString);
        } catch (NumberFormatException nfe){
            System.out.println("The input is not a number!");
            nfe.printStackTrace();
        }
        if (number <= 0) {
            isPositiveNumber = false;
        }
        return isPositiveNumber;
    }
}
