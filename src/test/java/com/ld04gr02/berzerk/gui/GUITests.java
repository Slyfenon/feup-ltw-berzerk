
package com.ld04gr02.berzerk.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.view.game.Sprites;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GUITests extends Assertions {
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
    public void drawStickManTest() {
        lanternaGUI.drawSprite(new Position(10, 10), Sprites.getStickManRight(), '#', "#00ff00");
        verify(textGraphics).setBackgroundColor(TextColor.Factory.fromString("#00ff00"));
        verify(textGraphics, times(40)).fillRectangle(any(), any(), anyChar());

        lanternaGUI.drawSprite(new Position(10, 10), Sprites.getStickManRight(), '#', "#0000ff");
        verify(textGraphics).setBackgroundColor(TextColor.Factory.fromString("#00ff00"));
    }

    @Test
    public void drawRobotTest() {
        lanternaGUI.drawSprite(new Position(10, 10), Sprites.getRobot(), '#', "#ff0000");

        verify(textGraphics).setBackgroundColor(any());
        verify(textGraphics, times(96)).fillRectangle(any(), any(), anyChar());
    }

    @Test
    public void drawWallTest() {
        lanternaGUI.drawWall(new Position(10, 10), "#0000ff");

        verify(textGraphics).setBackgroundColor(any());
        verify(textGraphics, times(1)).fillRectangle(any(), any(), anyChar());
    }

    @Test
    public void clearTest() {
        lanternaGUI.clear();
        verify(screen).clear();
    }

    @Test
    public void refreshTest() throws IOException {
        lanternaGUI.refresh();
        verify(screen).refresh();
    }

    @Test
    public void closeTest() throws IOException {
        lanternaGUI.close();
        verify(screen).close();
    }

    @Test
    public void getPressedKeyUpTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp)).thenReturn(null);
        assertEquals(GUI.KEY.ARROW_UP, lanternaGUI.getPressedKey());
    }

    @Test
    public void getPressedKeyDownTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown)).thenReturn(null);
        assertEquals(GUI.KEY.ARROW_DOWN, lanternaGUI.getPressedKey());
    }

    @Test
    public void getPressedKeyRightTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight)).thenReturn(null);
        assertEquals(GUI.KEY.ARROW_RIGHT, lanternaGUI.getPressedKey());
    }

    @Test
    public void getPressedKeyLeftTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft)).thenReturn(null);
        assertEquals(GUI.KEY.ARROW_LEFT, lanternaGUI.getPressedKey());
    }

    @Test
    public void getPressedKeyEnterTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter)).thenReturn(null);
        assertEquals(GUI.KEY.ENTER, lanternaGUI.getPressedKey());
    }

    @Test
    public void getPressedKeyEscapeTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Escape)).thenReturn(null);
        assertEquals(GUI.KEY.ESC, lanternaGUI.getPressedKey());
    }

    @Test
    public void getPressedKeySpaceTest() throws IOException {
        when(screen.pollInput()).thenReturn(KeyStroke.fromString(" ")).thenReturn(null);
        assertEquals(GUI.KEY.SPACE, lanternaGUI.getPressedKey());
    }

    @Test
    public void getPressedKeyCharacterTest() throws IOException {
        when(screen.pollInput()).thenReturn(KeyStroke.fromString("a")).thenReturn(null);
        assertEquals(GUI.KEY.CHAR, lanternaGUI.getPressedKey());
    }

    @Test
    public void getPressedKeyNullTest() throws IOException {
        when(screen.pollInput()).thenReturn(null);
        assertEquals(GUI.KEY.NONE, lanternaGUI.getPressedKey());
    }

    @Test
    public void getPressedKeyDefaultTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.F1)).thenReturn(null);
        assertEquals(GUI.KEY.NONE, lanternaGUI.getPressedKey());
    }

    @Test
    public void drawMainMenuTest() {
        MainMenu mainMenu = new MainMenu();
        lanternaGUI.drawMainMenu(mainMenu);
        verify(textGraphics).setForegroundColor(TextColor.Factory.fromString("#00ff00"));
        verify(textGraphics, times(9)).putString(anyInt(), anyInt(), anyString());
    }

    @Test
    public void createGameScreenTest() throws URISyntaxException, IOException, FontFormatException {
        lanternaGUI.createGameScreen(100, 200);
        assertEquals(200, lanternaGUI.getRows());
        assertEquals(100, lanternaGUI.getColumns());
        assertEquals(new TerminalSize(100, 200), lanternaGUI.getScreen().getTerminalSize());
    }
}

