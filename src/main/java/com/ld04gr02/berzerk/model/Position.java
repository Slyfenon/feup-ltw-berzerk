package com.ld04gr02.berzerk.model;

import java.util.Objects;

public class Position {
    private int x;
    private int y;
    private RandomNumber randomNumber = new RandomNumber();

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position getUp() {
        return new Position(x, y - 5);
    }

    public Position getDown() {
        return new Position(x, y + 5);
    }

    public Position getLeft() {
        return new Position(x - 5, y);
    }

    public Position getRight() {
        return new Position(x + 5, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void setRandomNumber(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }
    public RandomNumber getRandomNumber() {
        return randomNumber;
    }

    public Position getRandomNeighbour() {
        int n = randomNumber.getNumber();
        switch (n) {
            case 0:
                return getUp();
            case 1:
                return getRight();
            case 2:
                return getDown();
            default:
                return getLeft();
        }
    }
}
