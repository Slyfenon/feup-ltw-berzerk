package com.ld04gr02.berzerk.view.menu;

import com.ld04gr02.berzerk.gui.GUI;
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
        int x = MENU_SCREEN_WIDTH / 2 - getGameOverLength() / 2;
        int y = 5;
        for (String line : Sprites.getGameOver()){
            gui.drawText(x, y, line, "#ff0000");
            y += 1;
        }

        gui.drawBlinkText(MENU_SCREEN_WIDTH / 2 - 5, 19, "Score:" + String.format("%04d", StickMan.getScore()), "#ffffff");

        gui.drawText(MENU_SCREEN_WIDTH / 2 - 8, 23, "Name: " + getModel().getName().toString(), "#ffffff");

        gui.drawText(MENU_SCREEN_WIDTH/2 - 20/2, MENU_SCREEN_HEIGHT - 2, "Press ESC for Main Menu", "#ffffff");
    }
}
