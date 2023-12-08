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
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.model.menu.InstructionsMenu;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.model.menu.PauseMenu;
import com.ld04gr02.berzerk.view.game.Sprites;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_HEIGHT;
import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;

public class LanternaGUI implements GUI {
    private Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI() {}

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
    public void drawEvilSmile(Position position) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ff0000"));
        String[] sprite = Sprites.getEvilSmile();

        int y = 0;
        for (String s : sprite){
            for (int x = 0; x < s.length(); x++){
                if (s.charAt(x) == '#')
                    graphics.fillRectangle(new TerminalPosition(position.getX() + x, position.getY() + y),  new TerminalSize(1, 1), ' ');
            }
            y++;
        }
    }

    @Override
    public void drawMainMenu(MainMenu model){
        TextGraphics graphics = screen.newTextGraphics();
        String[] sprite = Sprites.getLogo();

        graphics.setForegroundColor(TextColor.Factory.fromString("#00ff00"));
        int y = 5;
        for (String s : sprite){
            graphics.putString(MENU_SCREEN_WIDTH / 2 - s.length() / 2, y, s);
            y++;
        }

        y = 15;
        for(int i = 0; i < model.getOptions().size() ; i++) {
            if(model.getOptions().get(i) == model.getSelected()) {
                graphics.putString(MENU_SCREEN_WIDTH / 2 - (model.getString(i).length() + 4) / 2 , y, "> " + model.getString(i) + " <", SGR.BLINK);
            }
            else {
                graphics.putString(MENU_SCREEN_WIDTH / 2 - model.getString(i).length() / 2, y,  model.getString(i));
            }
            y += 2;
        }
    }


    @Override
    public void drawGameOverMenu(GameOverMenu model){
        TextGraphics graphics = screen.newTextGraphics();
        String[] sprite = Sprites.getGameOver();

        graphics.setForegroundColor(TextColor.Factory.fromString("#ff0000"));
        int y = 5;
        for (String s : sprite){
            graphics.putString(MENU_SCREEN_WIDTH / 2 - s.length()/2 , y, s);
            y++;
        }

        graphics.putString(MENU_SCREEN_WIDTH / 2 - 2,19, "Score:" + model.getStickManScore(), SGR.BLINK);
        TextGraphics graphicsName = screen.newTextGraphics();
        String name = String.valueOf(model.getName());
        graphicsName.putString(MENU_SCREEN_WIDTH / 2 - 8 , 23, "Name: " + name);
        graphicsName.putString(MENU_SCREEN_WIDTH / 2 + 14, MENU_SCREEN_HEIGHT - 1, "ESC -> Back to Menu", SGR.BORDERED);

    }

    public void drawPauseMenu(PauseMenu model){
        TextGraphics graphics = screen.newTextGraphics();
        String[] sprite = Sprites.getLogo();

        graphics.setForegroundColor(TextColor.Factory.fromString("#00ff00"));
        int y = 5;
        for (String s : sprite){
            graphics.putString(MENU_SCREEN_WIDTH / 2 - s.length() / 2, y, s);
            y++;
        }

        y = 15;
        for(int i = 0; i < model.getOptions().size() ; i++) {
            if(model.getOptions().get(i) == model.getSelected()) {
                graphics.putString(MENU_SCREEN_WIDTH / 2 - (model.getString(i).length() + 4) / 2 , y, "> " + model.getString(i) + " <", SGR.BLINK);
            }
            else {
                graphics.putString(MENU_SCREEN_WIDTH / 2 - model.getString(i).length() / 2, y,  model.getString(i));
            }
            y += 2;
        }
    }
    @Override
    public void drawInstructionsMenu(InstructionsMenu model){
        TextGraphics graphics = screen.newTextGraphics();
        String[] sprite = Sprites.getLogo();

        graphics.setForegroundColor(TextColor.Factory.fromString("#00ff00"));
        int y = 5;
        for (String s : sprite){
            graphics.putString(MENU_SCREEN_WIDTH / 2 - s.length() / 2, y, s);
            y++;
        }

        TextGraphics instructions = screen.newTextGraphics();
        instructions.putString(MENU_SCREEN_WIDTH / 2 - 8,14, "GAME OBJECTIVE");
        instructions.putString(3,16, "SHOOT THE ROBOTS, SCORE POINTS AND RUN FROM EVIL SMILE");
        instructions.putString(3,17, "DESTROY ALL ROBOTS TO OPEN THE GATE AND ADVANCE TO THE NEXT LEVEL");
        instructions.putString(3,18, "PLAYER STARTS WITH 3 LIVES WITH 5 MAX, EACH ROBOT SHOT = 50 POINTS");

        int posxK = 19;
        for(String s : Sprites.getKeyBoard()){
            instructions.putString(3,posxK, s);
            posxK++;
        }
        int posyS = 22;
        for(String s : Sprites.getSPACE()){
            instructions.putString(37,posyS, s);
            posyS++;
        }
        posxK++;
        instructions.putString(3, posxK++, "Use ARROWS to move");
        instructions.putString(37, posxK-1, "Use SPACE to shoot");





    }

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


