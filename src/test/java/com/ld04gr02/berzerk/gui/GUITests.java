package com.ld04gr02.berzerk.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.view.Sprites;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
        lanternaGUI.drawStickMan(new Position(10, 10), Sprites.getStickManRight(), true);

        verify(textGraphics).setBackgroundColor(any());
        verify(textGraphics, times(40)).fillRectangle(any(), any(), anyChar());
    }

    @Test
    public void drawRobotTest() {
        lanternaGUI.drawRobot(new Position(10, 10));

        verify(textGraphics).setBackgroundColor(any());
        verify(textGraphics, times(95)).fillRectangle(any(), any(), anyChar());
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
        assertEquals(lanternaGUI.getPressedKey(), GUI.KEY.ARROW_UP);
    }

    @Test
    public void getPressedKeyDownTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown)).thenReturn(null);
        assertEquals(lanternaGUI.getPressedKey(), GUI.KEY.ARROW_DOWN);
    }

    @Test
    public void getPressedKeyRightTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight)).thenReturn(null);
        assertEquals(lanternaGUI.getPressedKey(), GUI.KEY.ARROW_RIGHT);
    }

    @Test
    public void getPressedKeyLeftTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft)).thenReturn(null);
        assertEquals(lanternaGUI.getPressedKey(), GUI.KEY.ARROW_LEFT);
    }

    @Test
    public void getPressedKeyEnterTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter)).thenReturn(null);
        assertEquals(lanternaGUI.getPressedKey(), GUI.KEY.ENTER);
    }

    @Test
    public void getPressedKeyEscapeTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Escape)).thenReturn(null);
        assertEquals(lanternaGUI.getPressedKey(), GUI.KEY.ESC);
    }

    @Test
    public void getPressedKeyCharacterTest() throws IOException {
        when(screen.pollInput()).thenReturn(KeyStroke.fromString(" ")).thenReturn(null);
        assertEquals(lanternaGUI.getPressedKey(), GUI.KEY.SPACE);
    }

    @Test
    public void getPressedKeyNullTest() throws IOException {
        when(screen.pollInput()).thenReturn(null);
        assertEquals(lanternaGUI.getPressedKey(), GUI.KEY.NONE);
    }

    @Test
    public void getPressedKeyDefaultTest() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.F1));
        when(screen.pollInput()).thenReturn(null);
        assertEquals(lanternaGUI.getPressedKey(), GUI.KEY.NONE);
    }
}
