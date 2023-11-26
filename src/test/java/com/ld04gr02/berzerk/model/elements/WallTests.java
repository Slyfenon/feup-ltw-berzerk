package com.ld04gr02.berzerk.model.elements;

import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WallTests extends Assertions {
    @Test
    public void WallTest() {
        Wall wall = new Wall(30, 40);
        assertEquals(wall.getPosition(), new Position(30, 40));
        assertEquals(wall.getPosition().getX(), 30);
        assertEquals(wall.getPosition().getY(), 40);
    }
}
