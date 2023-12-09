package com.ld04gr02.berzerk.view.menu;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.menu.Leaderboard;
import com.ld04gr02.berzerk.view.game.Sprites;
import com.ld04gr02.berzerk.view.game.Viewer;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;
import static com.ld04gr02.berzerk.view.game.Sprites.getLogoLength;

public class LeaderboardViewer extends Viewer<Leaderboard> {

    public LeaderboardViewer(Leaderboard model) {
        super(model);
    }

    @Override
    protected void renderElements(GUI gui) {
        Position pos = new Position(MENU_SCREEN_WIDTH / 2 - getLogoLength() / 2, 5);

        for (String line : Sprites.getLogo()){
            gui.drawText(pos, line,"#00ff00");
            pos.setY(pos.getY() + 1);
        }

        pos.setX(MENU_SCREEN_WIDTH / 2 - 11/2);
        pos.setY(15);
        gui.drawText(pos, "Leaderboard", "#ffffff");
        pos.setY(pos.getY() + 2);

        for(int i = 0; i < getModel().getNames().size(); i++) {
            pos.setX(20);
            gui.drawText(pos, getModel().getNames().get(i), "#ffffff");
            pos.setX(MENU_SCREEN_WIDTH - 24);
            gui.drawText(pos, String.format("%04d", getModel().getScores().get(i)), "#ffffff");
            pos.setY(pos.getY() + 1);
        }
    }
}
