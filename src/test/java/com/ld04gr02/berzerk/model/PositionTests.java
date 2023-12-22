package com.ld04gr02.berzerk.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        assertEquals(new Position(20, 20), position.getUp());
        assertEquals(new Position(20, 30), position.getDown());
        assertEquals(new Position(25, 25), position.getRight());
        assertEquals(new Position(15, 25), position.getLeft());
    }

    @Test
    public void hashTest() {
        assertEquals(new Position(20, 25).hashCode(), position.hashCode());
        assertNotEquals(new Position(25, 25).hashCode(), position.hashCode());
    }

    @Test
    public void getRandomNeighbourTest() {
        RandomNumber randomNumber = mock(RandomNumber.class);
        when(randomNumber.getNumber()).thenReturn(0, 1, 2, 3);
        position.setRandomNumber(randomNumber);

        assertEquals(new Position(20, 20), position.getRandomNeighbour());
        assertEquals(new Position(25, 25), position.getRandomNeighbour());
        assertEquals(new Position(20, 30), position.getRandomNeighbour());
        assertEquals(new Position(15, 25), position.getRandomNeighbour());
    }

    @Test
    public void randomNumberTest() {
        for (int i = 0; i < 10; i++) {
            assertNotEquals(position.getRandomNumber().getNumber(), -1);
            assertNotEquals(position.getRandomNumber().getNumber(), 4);
        }
    }

    @Test
    public void equalsTest() {
        assertEquals(new Position(20, 25), position);
        assertNotEquals(new Position(50, 50), position);
        String s = "Hello";
        assertNotEquals(position, s);
    }
}
