package com.olgaivancic.controller;

import com.olgaivancic.model.Jar;
import com.olgaivancic.view.Prompter;

/**
 * This class is the Controller part of the MVC pattern of the project. It contains the logic of the game.
 */
public class Game {

    public static void main(String[] args) {
        // Your code here
        Prompter prompter = new Prompter();

        //Prompt administrator for the jar filler and the number of items in the jar.
        prompter.promptAdministrator();


    }

}