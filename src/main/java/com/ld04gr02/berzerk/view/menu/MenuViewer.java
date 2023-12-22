package com.ld04gr02.berzerk.view.menu;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.model.menu.Menu;
import com.ld04gr02.berzerk.view.game.Sprites;
import com.ld04gr02.berzerk.view.game.Viewer;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;
import static com.ld04gr02.berzerk.view.game.Sprites.getLogoLength;

public class MenuViewer<T extends Menu> extends Viewer<T> {

    public MenuViewer(T model) {
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

        y = 15;
        for(int i = 0; i < getModel().getOptions().size() ; i++) {
            if(getModel().isSelected(i)) {
                x = MENU_SCREEN_WIDTH / 2 - (getModel().getString(i).length() + 4) / 2;
                gui.drawBlinkText2(x, y, "> " + getModel().getString(i) + " <", "#00ff00");
            }
            else {
                x = MENU_SCREEN_WIDTH / 2 - getModel().getString(i).length() / 2;
                gui.drawText2(x, y, getModel().getString(i), "#00ff00");
            }
            y += 2;
        }
    }
}
