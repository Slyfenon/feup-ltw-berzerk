package com.ld04gr02.berzerk.model.game.elements;

import com.ld04gr02.berzerk.model.Direction;

public class StickMan extends MovingElement {
    static final int MAX_LIVES = 5;
    private int lives = 3;

    public StickMan(int x, int y, Direction direction) {
        super(x, y, direction);

    private boolean collided = false;
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

    public boolean isCollided() {
        return collided;
    }
    public void setCollided(boolean collided) {
        this.collided = collided;
    }
}
