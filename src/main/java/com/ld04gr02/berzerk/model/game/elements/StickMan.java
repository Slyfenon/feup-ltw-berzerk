package com.ld04gr02.berzerk.model.game.elements;

public class StickMan extends Element {
    static final int MAX_LIVES = 5;
    private int lives = 3;

    private int score = 0;

    public StickMan(int x, int y) {
        super(x, y);
    }
    public boolean increaseLives() {
        if(this.lives < MAX_LIVES) {
            this.lives++;
            return true;
        }
        return false;
    }
    public void decreaseLives() {
        this.lives--;
    }

    public int getLives() {
        return lives;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
