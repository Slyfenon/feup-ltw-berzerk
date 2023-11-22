package com.ld04gr02.berzerk.model.game.elements;

import com.ld04gr02.berzerk.model.Position;

public class Element {
    private Position position;
    public Element(int x, int y) {
        this.position = new Position(x, y);
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}
