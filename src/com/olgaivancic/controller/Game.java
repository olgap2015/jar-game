package com.olgaivancic.controller;

import com.olgaivancic.model.Jar;
import com.olgaivancic.view.Prompter;

/**
 * This class is the Controller part of the MVC pattern of the project. It contains the logic of the game.
 */
public class Game {

    public static void main(String[] args) {

        boolean oneMoreGame;
        do {
            Prompter prompter = new Prompter();

            //Prompt administrator for the jar filler and the number of items in the jar.
            String jarFiller = prompter.promptForJarFiller();
            int maxNumberOfItems = prompter.promptForMaxNumberOfItems(jarFiller);

            // Create the jar
            Jar jar = new Jar(jarFiller, maxNumberOfItems);
            prompter.play();

            // Prompt if the Player would want to play one more game.
            oneMoreGame = prompter.checkIfWantOneMoreGame();
        } while (oneMoreGame);

    }

}