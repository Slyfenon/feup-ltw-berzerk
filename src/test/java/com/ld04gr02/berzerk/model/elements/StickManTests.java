package com.ld04gr02.berzerk.model.elements;

import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import net.jqwik.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StickManTests extends Assertions {
    private StickMan stickMan;

    @BeforeEach
    public void setUp() {
        stickMan = new StickMan(10, 15, Direction.Right);
        StickMan.setLives(3);
    }

    @Test
    public void StickManTest() {
        assertEquals(new Position(10, 15), stickMan.getPosition());
        assertEquals(3, StickMan.getLives());
        assertEquals(5, StickMan.getMaxLives());
    }

    @Test
    public void increaseLivesTest() {
        assertEquals(3, StickMan.getLives());
        assertTrue(stickMan.increaseLives());
        assertEquals(4, StickMan.getLives());
        assertTrue(stickMan.increaseLives());
        assertEquals(5, StickMan.getLives());
        assertFalse(stickMan.increaseLives());
        assertEquals(5, StickMan.getLives());
    }

    @Test
    public void decreaseLivesTest() {
        assertEquals(3, StickMan.getLives());
        stickMan.decreaseLives();
        assertEquals(2, StickMan.getLives());
    }

    @Test
    public void scoreTest() {
        StickMan.setScore(400);
        StickMan.setLives(3);
        assertEquals(400, StickMan.getScore());
        stickMan.increaseScore();
        assertEquals(450, StickMan.getScore());
        assertEquals(3, StickMan.getLives());
        stickMan.increaseScore();
        assertEquals(500, StickMan.getScore());
        assertEquals(4, StickMan.getLives());
        StickMan.setScore(9950);
        stickMan.increaseScore();
        assertEquals(9950, StickMan.getScore());
        StickMan.setScore(0);
        StickMan.setLives(3);
    }

    @Property
    void stickManProperties(
            @ForAll @From("validLives") int lives,
            @ForAll @From("validScores") int score
    ) {
        StickMan.setLives(lives);
        StickMan.setScore(score);

        assertTrue(0 <= StickMan.getLives() && StickMan.getLives() <= StickMan.getMaxLives());

        assertTrue(StickMan.getScore() >= 0);
    }

    @Provide
    Arbitrary<Integer> validLives() {
        return Arbitraries.integers().between(0, StickMan.getMaxLives());
    }

    @Provide
    Arbitrary<Integer> validScores() {
        return Arbitraries.integers().between(0, 9950);
    }

}
