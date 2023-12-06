package com.ld04gr02.berzerk.model.game.elements;

public class Wall extends Element {
    private boolean isWall;
    public Wall(int x, int y, boolean isWall) {
        super(x, y);
        this.isWall = isWall;
    }

    public boolean isWall() {
        return isWall;
    }
}
