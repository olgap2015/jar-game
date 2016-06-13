package com.olgaivancic.model;

/**
 * This class is the Model part of the MVC pattern of the project. It contains the data necessary for the game to start.
 */
public class Jar {

    private String mJarFiller;
    private int mMaxNumberOfItems;

    public Jar(){
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


}
