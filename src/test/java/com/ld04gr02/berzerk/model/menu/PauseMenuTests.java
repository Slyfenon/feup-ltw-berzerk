package com.ld04gr02.berzerk.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PauseMenuTests extends Assertions {
    private PauseMenu pauseMenu;

    @BeforeEach
    public void setUp() {
        pauseMenu = new PauseMenu();
    }

    @Test
    public void selectsTest() {
        assertEquals(3, pauseMenu.getOptions().size());
        assertEquals("Resume", pauseMenu.getSelected().convertString());
    }
}
