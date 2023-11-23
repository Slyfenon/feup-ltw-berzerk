package com.ld04gr02.berzerk.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException {
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
    }

    public int getRows() {
        return screen.getTerminalSize().getRows();
    }

    public int getColumns() {
        return screen.getTerminalSize().getColumns();
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    enum KEYS {
        ARROW_LEFT,
        ARROW_RIGHT,
        ARROW_UP,
        ARROW_DOWN,
        ENTER,
        ESC,
        SPACE,
        NONE;
    }

    public KEYS getPressedKey() throws IOException {
        KeyStroke key = screen.pollInput();

        switch (key.getKeyType()){
            case ArrowUp -> {
                return KEYS.ARROW_UP;
            }
            case ArrowDown -> {
                return KEYS.ARROW_DOWN;
            }
            case ArrowLeft -> {
                return KEYS.ARROW_LEFT;
            }
            case ArrowRight -> {
                return KEYS.ARROW_RIGHT;
            }
            case Enter -> {
                return KEYS.ENTER;
            }
            case Escape -> {
                return KEYS.ESC;
            }
            case Character ->{
                return KEYS.SPACE;
            }
            default ->
            {
                return KEYS.NONE;
            }
        }


    }


}
