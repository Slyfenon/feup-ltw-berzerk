package com.ld04gr02.berzerk.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTests extends Assertions {
    private Position position;

    @BeforeEach
    public void setUp() {
        position = new Position(20, 25);
    }

    @Test
    public void settersTest() {
        position.setX(40);
        position.setY(50);
        assertEquals(40, position.getX());
        assertEquals(50, position.getY());
    }

    @Test
    public void getNeighboursTest() {
        assertEquals(position.getUp(), new Position(20, 20));
        assertEquals(position.getDown(), new Position(20, 30));
        assertEquals(position.getRight(), new Position(25, 25));
        assertEquals(position.getLeft(), new Position(15, 25));
    }

    @Test void hashTest() {
        assertEquals(position.hashCode(), new Position(20, 25).hashCode());
    }
}
