package com.ld04gr02.berzerk.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameOverMenuTests extends Assertions {
    private GameOverMenu gameOverMenu;

    @BeforeEach
    public void setUp() {
        gameOverMenu = new GameOverMenu();
    }

    @Test
    public void nameTest() {
        StringBuilder name = gameOverMenu.getName();
        name.append("Yoda");
        assertEquals("Yoda", gameOverMenu.getName().toString());
    }
}
