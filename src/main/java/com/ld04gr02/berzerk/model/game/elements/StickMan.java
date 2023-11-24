package com.ld04gr02.berzerk.model.game.elements;

public class StickMan extends Element {
    static final int MAX_LIVES = 5;
    private int lives = 3;
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
}
