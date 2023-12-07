package com.ld04gr02.berzerk.model.game.elements;

import com.ld04gr02.berzerk.model.Direction;

public abstract class MovingElement extends Element{
    boolean isMoving = false;
    private boolean isCollided = false;
    private Direction currentDirection = Direction.None;
    public MovingElement(int x, int y, Direction direction) {
        super(x, y);
        this.currentDirection = direction;
    }

    public boolean isMoving() {
        return this.isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public void changeMoving() {
        this.isMoving = !this.isMoving;
    }
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setDirection(Direction direction) {
        currentDirection = direction;
    }

    public boolean isCollided() {
        return isCollided;
    }
    public void setCollided(boolean collided) {
        this.isCollided = collided;
    }
}
