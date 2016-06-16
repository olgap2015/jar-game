package com.olgaivancic.model;

import java.util.Random;

/**
 * This class is the Model part of the MVC pattern of the project. It contains the data necessary for the game to start.
 */
public class Jar {

    private String mJarFiller;
    private int mMaxNumberOfItems;
    private int mCorrectAnswer;

    public int getCorrectAnswer() {
        return mCorrectAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        mCorrectAnswer = correctAnswer;
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

    /**
     * This method generates a random integer from the range of numbers between 0 and the maxim number specified.
     *
     * @return Returns a random number between 0 and (Max Number specified - 1).
     */
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(mMaxNumberOfItems);
    }

    /**
     * This method parses integer out of the String parameter and evaluates whether the guess equals the bumber of items in the jar.
     *
     * @param guess current guess
     * @return Returns true if the guess is correct and false if the guess is not correct.
     */
    public boolean checkIfGuessIsCorrect(int guess) {

        return guess == mCorrectAnswer;
    }

    /**
     * This method evaluates whether the guess was too high or too low.
     *
     * @param guess Current guess
     * @return Returns 'Too low' is the guess is lower than the answer and 'Too high" if the guess is higher than the answer.
     */
    public String evaluateGuess(int guess) {
        if (guess < mCorrectAnswer) {
            return "Too low!";
        } else return "Too high!";
    }
}
