package com.ld04gr02.berzerk.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GUITerminalTests extends Assertions {
    private Screen screen;
    private TextGraphics textGraphics;
    private LanternaGUI lanternaGUI;

    @BeforeEach
    public void setUp() {
        screen = mock(Screen.class);
        textGraphics = mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(textGraphics);
        lanternaGUI = new LanternaGUI(screen);
    }

    @Test
    public void createGameScreenTest() throws URISyntaxException, IOException, FontFormatException {
        //lanternaGUI.createGameScreen(10, 20);
        //assertEquals(new TerminalSize(10, 20), lanternaGUI.getScreen().getTerminalSize());
    }

    @Test
    public void createMenuScreenTest() throws URISyntaxException, IOException, FontFormatException {
        //lanternaGUI = new LanternaGUI(10, 20);
        //assertEquals(new TerminalSize(10, 20), lanternaGUI.getScreen().getTerminalSize());
    }
}
