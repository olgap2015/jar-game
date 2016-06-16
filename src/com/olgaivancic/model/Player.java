package com.olgaivancic.model;

/**
 * Created by Olga on 6/16/2016.
 */
public class Player {

    private String mName;
    private int mHighestScore;

    public Player(String name) {
        mName = name;
        mHighestScore = 0;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getHighestScore() {
        return mHighestScore;
    }

    public void setHighestScore(int highestScore) {
        mHighestScore = highestScore;
    }

    /**
     * This method compares current score to the player's highest score. It also updates
     * mHighestScore if the current score is better (lower).
     *
     * @param score
     * @return Returns 0 if the scores are equal, -1 is the current score is lower,
     * 1 - if the the current score is higher than the highest score.
     */
    public int evaluateCurrentScore(int score) {
        int scoreEvaluation = 0;

        if (score < mHighestScore) {
            scoreEvaluation = -1;
            mHighestScore = score;
        }
        if (score == mHighestScore) {
            scoreEvaluation = 0;
        }
        if (score > mHighestScore) {
            scoreEvaluation = 1;
        }
        return scoreEvaluation;
    }
}
