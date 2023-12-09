package com.ld04gr02.berzerk.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InstructionsMenuTests extends Assertions {
    private InstructionsMenu instructionsMenu;

    @BeforeEach
    public void setUp() {
        instructionsMenu = new InstructionsMenu();
    }

    @Test
    public void instructionMenuTest() {
        assertEquals(0, instructionsMenu.getCurrentOption());
        assertEquals(0, instructionsMenu.getOptions().size());
    }
}
