package com.ld04gr02.berzerk.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTests extends Assertions {
    private MainMenu mainMenu;

    @BeforeEach
    public void setUp() {
        mainMenu = new MainMenu();
    }

    @Test
    public void selectsTest() {
        mainMenu.selectPrev();
        assertEquals(mainMenu.getCurrentOption(), mainMenu.getOptions().size()-1);
        mainMenu.selectNext();
        assertEquals(mainMenu.getCurrentOption(), 0);
    }

    @Test
    public void stringsTest() {
        assertEquals(mainMenu.getSelected().convertString() ,mainMenu.getString(0));
    }
}
