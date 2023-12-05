package com.ld04gr02.berzerk.model.game.elements;

import com.ld04gr02.berzerk.model.Direction;

public abstract class MovingElement extends Element{
    boolean isMoving = false;
    private Direction currentDirection = Direction.None;
    private boolean collided = false;
    public MovingElement(int x, int y, Direction direction) {
        super(x, y);
        this.currentDirection = direction;
    }

    public boolean isMoving() {
        return this.isMoving;
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
        return collided;
    }
    public void setCollided(boolean collided) {
        this.collided = collided;
    }
}
