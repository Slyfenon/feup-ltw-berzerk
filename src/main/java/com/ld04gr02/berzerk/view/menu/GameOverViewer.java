package com.ld04gr02.berzerk.view.menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.view.game.Sprites;
import com.ld04gr02.berzerk.view.game.Viewer;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_HEIGHT;
import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;
import static com.ld04gr02.berzerk.view.game.Sprites.getGameOverLength;

public class GameOverViewer extends Viewer<GameOverMenu> {
    public GameOverViewer(GameOverMenu model) {
        super(model);
    }

    @Override
    protected void renderElements(GUI gui) {
        Position pos = new Position(MENU_SCREEN_WIDTH / 2 - getGameOverLength() / 2, 5);
        for (String line : Sprites.getGameOver()){
            gui.drawText(pos, line, "#ff0000");
            pos.setY(pos.getY() + 1);
        }

        pos.setX(MENU_SCREEN_WIDTH / 2 - 5);
        pos.setY(19);
        gui.drawBlinkText(pos, "Score:" + String.format("%04d", StickMan.getScore()), "#ffffff");

        pos.setX(MENU_SCREEN_WIDTH / 2 - 8);
        pos.setY(23);
        gui.drawText(pos, "Name: " + getModel().getName().toString(), "#ffffff");

        pos.setX(MENU_SCREEN_WIDTH / 2 - 9);
        pos.setY(MENU_SCREEN_HEIGHT - 1);
        gui.drawText(pos, "ESC -> Back to Menu", "#ffffff");
    }
}
