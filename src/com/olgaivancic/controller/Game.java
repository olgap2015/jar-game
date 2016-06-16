package com.olgaivancic.controller;

import com.olgaivancic.model.Jar;
import com.olgaivancic.model.Player;
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
            String jarFiller = prompter.promptForJarFiller().toLowerCase();
            int maxNumberOfItems = prompter.promptForMaxNumberOfItems(jarFiller);

            // Prompt Player for his/her name
            String playerName = prompter.promptForPlayerName();

            // Create record for a player
            Player player = new Player(playerName);

            // Create the jar
            Jar jar = new Jar(jarFiller, maxNumberOfItems);

            // Play the game
            int score = prompter.play(player, jar);

            // Check if the current score is better than previous scores for this player
            // and update the record if the current score if better.
            int scoreEvaluation = player.evaluateCurrentScore(score);
            String message = "";
            if (player.getHighestScore() != 0) {
                if (scoreEvaluation == -1) {
                    System.out.printf("Congratulations, %s! You've just set a new personal record - " +
                                    "you guessed the number of items in the jar in %d attempts.%n",
                            player.getName(), player.getHighestScore());
                } else if (scoreEvaluation == 0) {
                    System.out.println("Your current score equals your best recorded score. " +
                            "You are on your way to set a new personal record!");
                } else if (scoreEvaluation == 1) {
                    System.out.printf("This is not the best score you've had. Your best score is %d. " +
                            "Keep trying!%n", player.getHighestScore());
                }
            }

            // Prompt if the Player would want to play one more game.
            oneMoreGame = prompter.checkIfWantOneMoreGame();
            if (!oneMoreGame) {
                System.out.printf("Goodbye, %s!", player.getName());
            }
        } while (oneMoreGame);

    }

}