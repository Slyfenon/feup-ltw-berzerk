package com.ld04gr02.berzerk.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.view.Sprites;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private Screen screen;

    

    public void createGameScreen(int width, int height) throws URISyntaxException, IOException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont(1);
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    public void createMenuScreen(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont(22);
        Terminal terminal = createTerminal(width, height, null);
        this.screen = createScreen(terminal);
    }

    public int getRows() {
        return screen.getTerminalSize().getRows();
    }

    public int getColumns() {
        return screen.getTerminalSize().getColumns();
    }

    public Screen getScreen() {
        return screen;
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
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
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
        switch (key.getKeyType()){
            case ArrowUp -> {
                return KEY.ARROW_UP;
            }
            case ArrowDown -> {
                return KEY.ARROW_DOWN;
            }
            case ArrowLeft -> {
                return KEY.ARROW_LEFT;
            }
            case ArrowRight -> {
                return KEY.ARROW_RIGHT;
            }
            case Enter -> {
                return KEY.ENTER;
            }
            case Escape -> {
                return KEY.ESC;
            }
            case Character ->{
                return KEY.SPACE;
            }
            default ->
            {
                return KEY.NONE;
            }
        }
    }
    @Override
    public void drawStickMan(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#00ff00"));

        String[] sprite = Sprites.STICKMAN_RIGHT;

        int y = 0;
        for (String s : sprite){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == '#')
                    graphics.fillRectangle(new TerminalPosition(position.getX() + x, position.getY() + y * 2),  new TerminalSize(1, 2), ' ');
            }
            y++;
        }
    }

    @Override
    public void drawWall(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0000ff"));
        graphics.fillRectangle(new TerminalPosition(position.getX(), position.getY()),  new TerminalSize(30, 30), ' ');
    }

    @Override
    public void drawRobot(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ff0000"));
        String[] sprite = Sprites.ROBOT;

        int y = 0;
        for (String s : sprite){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == '#')
                    graphics.fillRectangle(new TerminalPosition(position.getX() + x, position.getY() + y * 2),  new TerminalSize(1, 2), ' ');
            }
            y++;
        }
    }

    public  void drawMainMenu(MainMenu model){
        TextGraphics graphics = screen.newTextGraphics();
        String[] sprite = Sprites.LOGO;

        int y = 5;
        graphics.setForegroundColor(TextColor.Factory.fromString("#00ff00"));
        for (String s : sprite){
            graphics.putString(10, y, s);
            y++;
        }


        y = 15;
        if(model.getOptions().get(0) == model.getSelected()){
            graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
            graphics.putString(40, y, model.getSelected().toString(), SGR.BLINK);
            graphics.putString(40, y+=2, model.getString(1));
            y+=2;
        }
        if(model.getOptions().get(1) == model.getSelected()){
            graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
            graphics.putString(40, y, model.getString(0));
            graphics.putString(40, y+=2, model.getSelected().toString(), SGR.BLINK);
            y+=2;
        }


    }
}


