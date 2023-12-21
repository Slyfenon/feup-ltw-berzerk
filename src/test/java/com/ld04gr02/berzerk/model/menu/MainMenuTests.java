package com.ld04gr02.berzerk.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainMenuTests extends Assertions {
    private MainMenu mainMenu;

    @BeforeEach
    public void setUp() {
        mainMenu = new MainMenu();
    }

    @Test
    public void selectsTest() {
        assertTrue(mainMenu.isSelected(0));
        assertFalse(mainMenu.isSelected(1));
        mainMenu.selectPrev();
        assertEquals(mainMenu.getOptions().size()-1, mainMenu.getCurrentOption());
        mainMenu.selectNext();
        assertEquals(0, mainMenu.getCurrentOption());
        mainMenu.selectNext();
        mainMenu.selectNext();
        mainMenu.selectNext();
        assertEquals(3, mainMenu.getCurrentOption());
        mainMenu.selectNext();
        assertEquals(0, mainMenu.getCurrentOption());
    }

    @Test
    public void stringsTest() {
        assertEquals(mainMenu.getString(0), mainMenu.getSelected().convertString());
    }
}
