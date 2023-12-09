package com.ld04gr02.berzerk.view.menu;

import com.googlecode.lanterna.SGR;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.view.game.Sprites;
import com.ld04gr02.berzerk.view.game.Viewer;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;
import static com.ld04gr02.berzerk.view.game.Sprites.getLogoLength;

public class MainMenuViewer extends Viewer<MainMenu> {

    public MainMenuViewer(MainMenu model) {
        super(model);
    }

    @Override
    protected void renderElements(GUI gui) {

        Position pos = new Position(MENU_SCREEN_WIDTH / 2 - getLogoLength() / 2, 5);

        for (String line : Sprites.getLogo()){
            gui.drawText(pos, line,"#00ff00");
            pos.setY(pos.getY() + 1);
        }

        pos.setY(15);
        for(int i = 0; i < getModel().getOptions().size() ; i++) {
            if(getModel().isSelected(i)) {
                pos.setX(MENU_SCREEN_WIDTH / 2 - (getModel().getString(i).length() + 4) / 2);
                gui.drawBlinkText(pos, "> " + getModel().getString(i) + " <", "#00ff00");
            }
            else {
                pos.setX(MENU_SCREEN_WIDTH / 2 - getModel().getString(i).length() / 2);
                gui.drawText(pos, getModel().getString(i), "#00ff00");
            }
            pos.setY(pos.getY() + 2);
        }
    }
}
