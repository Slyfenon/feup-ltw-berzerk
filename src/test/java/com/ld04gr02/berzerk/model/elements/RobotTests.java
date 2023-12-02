package com.ld04gr02.berzerk.model.elements;

import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTests extends Assertions {
    @Test
    public void RobotTest() {
        Robot robot = new Robot(10, 15, Direction.Right);
        assertEquals(robot.getPosition(), new Position(10, 15));
        assertEquals(robot.getPosition().getX(), 10);
        assertEquals(robot.getPosition().getY(), 15);
    }
}
