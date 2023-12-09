package com.ld04gr02.berzerk.model.elements;

import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
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
        stickMan.increaseLives();
        assertEquals(4, StickMan.getLives());
        stickMan.increaseLives();
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
        StickMan.setScore(550);
        assertEquals(550, StickMan.getScore());
        stickMan.increaseScore();
        assertEquals(600, StickMan.getScore());
    }

}
