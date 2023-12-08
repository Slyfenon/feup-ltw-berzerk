package com.ld04gr02.berzerk.model.game.elements;

import com.ld04gr02.berzerk.model.Direction;

public class StickMan extends MovingElement {
    static final int MAX_LIVES = 5;
    private static int lives = 3;
    private static int score = 0;
    private boolean isShooting = false;

    public StickMan(int x, int y, Direction direction) {
        super(x, y, direction);

    }
    public boolean increaseLives() {
        if(lives < MAX_LIVES) {
            lives++;
            return true;
        }
        return false;
    }

    public void decreaseLives() {StickMan.lives--;
    }

    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        StickMan.lives = lives;
    }

    public static int getMaxLives() {
        return MAX_LIVES;
    }

    public static void setScore(int score) {
        StickMan.score = score;
    }

    public static int getScore() {
        return StickMan.score;
    }

    public void increaseScore() {
        if (StickMan.score < 9950) StickMan.score += 50;
        if (score % 500 == 0) increaseLives();
    }

    public boolean isShooting() {
        return isShooting;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }
}
