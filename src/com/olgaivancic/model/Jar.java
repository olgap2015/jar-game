package com.olgaivancic.model;

import java.util.Random;

/**
 * This class is the Model part of the MVC pattern of the project. It contains the data necessary for the game to start.
 */
public class Jar {

    private String mJarFiller;
    private int mMaxNumberOfItems;
    private int mRandomNumberOfItems;

    public int getRandomNumberOfItems() {
        return mRandomNumberOfItems;
    }

    public void setRandomNumberOfItems(int randomNumberOfItems) {
        mRandomNumberOfItems = randomNumberOfItems;
    }

    public Jar() {
        mJarFiller = "";

        mMaxNumberOfItems = 0;
    }

    public Jar(String jarFiller, int maxNumberOfItems) {
        mJarFiller = jarFiller;
        mMaxNumberOfItems = maxNumberOfItems;
    }

    public String getJarFiller() {
        return mJarFiller;
    }

    public void setJarFiller(String jarFiller) {
        mJarFiller = jarFiller;
    }

    public int getMaxNumberOfItems() {
        return mMaxNumberOfItems;
    }

    public void setMaxNumberOfItems(int maxNumberOfItems) {
        mMaxNumberOfItems = maxNumberOfItems;
    }


    public boolean checkIfMaxNumberIsPositive(String numberAsString) {

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

    /**
     * This method generates a random integer from the range of numbers between 0 and the maxim number specified.
     *
     * @return Returns a random number between 0 and (Max Number specified - 1).
     */
    public int generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(mMaxNumberOfItems);
        return randomNumber;
    }
}
