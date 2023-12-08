package com.ld04gr02.berzerk.model.elements;

import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.Bullet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BulletTests extends Assertions {
    @Test
    public void BulletTest() {
        Bullet bullet = new Bullet(5, 10, Direction.Right);
        assertEquals(bullet.getPosition(), new Position(5, 10));
        assertEquals(bullet.getPosition().getX(), 5);
        assertEquals(bullet.getPosition().getY(), 10);
    }
}
