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
        assertEquals(stickMan.getPosition(), new Position(10, 15));
        assertEquals(StickMan.getLives(), 3);
    }

    @Test
    public void increaseLivesTest() {
        assertEquals(StickMan.getLives(), 3);
        stickMan.increaseLives();
        assertEquals(StickMan.getLives(), 4);
        stickMan.increaseLives();
        assertEquals(StickMan.getLives(), 5);
        assertFalse(stickMan.increaseLives());
        assertEquals(StickMan.getLives(), 5);
    }

    @Test
    public void decreaseLivesTest() {
        assertEquals(StickMan.getLives(), 3);
        stickMan.decreaseLives();
        assertEquals(StickMan.getLives(), 2);
    }

    @Test
    public void scoreTest() {
        StickMan.setScore(550);
        assertEquals(StickMan.getScore(), 550);
    }

}
