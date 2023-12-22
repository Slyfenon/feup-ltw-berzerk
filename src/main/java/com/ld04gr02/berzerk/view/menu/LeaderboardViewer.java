package com.ld04gr02.berzerk.view.menu;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.menu.Leaderboard;
import com.ld04gr02.berzerk.view.game.Sprites;
import com.ld04gr02.berzerk.view.game.Viewer;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_HEIGHT;
import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;
import static com.ld04gr02.berzerk.view.game.Sprites.getLogoLength;

public class LeaderboardViewer extends Viewer<Leaderboard> {

    public LeaderboardViewer(Leaderboard model) {
        super(model);
    }

    @Override
    protected void renderElements(GUI gui) {
        int x = MENU_SCREEN_WIDTH / 2 - getLogoLength() / 2;
        int y = 5;

        for (String line : Sprites.getLogo()){
            gui.drawText2(x, y, line,"#00ff00");
            y += 1;
        }

        gui.drawText2(MENU_SCREEN_WIDTH / 2 - 11/2, 15, "Leaderboard", "#ffffff");

        y = 17;
        for(int i = 0; i < getModel().getNames().size(); i++) {
            gui.drawText2(20, y, getModel().getNames().get(i), "#ffffff");
            gui.drawText2(MENU_SCREEN_WIDTH - 24, y, String.format("%04d", getModel().getScores().get(i)), "#ffffff");
            y += 1;
        }

        gui.drawText2(MENU_SCREEN_WIDTH/2 - 20/2, MENU_SCREEN_HEIGHT - 2, "Press ESC to go back", "#ffffff");
    }
}
