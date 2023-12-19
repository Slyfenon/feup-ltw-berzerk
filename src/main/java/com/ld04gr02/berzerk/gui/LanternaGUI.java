package com.ld04gr02.berzerk.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.ld04gr02.berzerk.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        createMenuScreen(width, height);
    }

    @Override
    public void createGameScreen(int width, int height) throws URISyntaxException, IOException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont(2);
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    @Override
    public void createMenuScreen(int width, int height) throws IOException {
        Terminal terminal = createTerminal(width, height, null);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont(int size) throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, size);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
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
    @Override
    public KEY getPressedKey() throws IOException {
        KeyStroke key = screen.pollInput();
        if (key == null) return KEY.NONE;
        while(screen.pollInput() != null) {
            // This loop discards all pending input events
        }
        switch (key.getKeyType()){
            case ArrowUp : {
                return KEY.ARROW_UP;
            }
            case ArrowDown : {
                return KEY.ARROW_DOWN;
            }
            case ArrowLeft : {
                return KEY.ARROW_LEFT;
            }
            case ArrowRight : {
                return KEY.ARROW_RIGHT;
            }
            case Enter : {
                return KEY.ENTER;
            }
            case Escape : {
                return KEY.ESC;
            }
            case Character :{
                if (key.getCharacter() == ' ') {
                    return KEY.SPACE;
                }
                else{
                    return KEY.CHAR;
                }
            }
            default :
            {
                return KEY.NONE;
            }
        }
    }


    @Override
    public String getCharPressedKey() throws IOException {

        KeyStroke key = screen.pollInput();
        if(key == null) return "";
        while(screen.pollInput() != null) {
        }

        if (key.getKeyType() == KeyType.Character){
            return Character.toString(key.getCharacter());
        }
        else if(key.getKeyType() == KeyType.Escape){
            return KeyType.Escape.toString();
        }
        else if(key.getKeyType() == KeyType.Enter){
            return KeyType.Enter.toString();
        }
        else if(key.getKeyType() == KeyType.Backspace){
            return KeyType.Backspace.toString();
        }
        else {
            return "";
        }
    }

    @Override
    public void drawFrame(int width, int height) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ffc000"));
        for(int i = 0; i < height; i++) {
            if(i == 0 || i == height - 1) {
                graphics.fillRectangle(new TerminalPosition(0, i),  new TerminalSize(width, 1), ' ');
            }
            else {
                graphics.fillRectangle(new TerminalPosition(0, i),  new TerminalSize(1, 1), ' ');
                graphics.fillRectangle(new TerminalPosition(width - 1, i),  new TerminalSize(1, 1), ' ');
            }
        }
    }

    @Override
    public void drawWall(Position position, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.fillRectangle(new TerminalPosition(position.getX(), position.getY()),  new TerminalSize(5, 5), ' ');
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void drawBlinkText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text, SGR.BLINK);
    }

    @Override
    public void drawSprite(Position position, String[] sprite, char symbol, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));

        int y = 0;
        for (String s : sprite){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == symbol)
                    graphics.fillRectangle(new TerminalPosition(position.getX() + x, position.getY() + y),  new TerminalSize(1, 1), ' ');
            }
            y++;
        }
    }
}


