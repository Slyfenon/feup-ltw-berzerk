package com.ld04gr02.berzerk.view.menu;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.menu.InstructionsMenu;
import com.ld04gr02.berzerk.view.game.Sprites;
import com.ld04gr02.berzerk.view.game.Viewer;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_HEIGHT;
import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;
import static com.ld04gr02.berzerk.view.game.Sprites.getLogoLength;

public class InstructionsViewer extends Viewer<InstructionsMenu> {
    public InstructionsViewer(InstructionsMenu model) {
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

        gui.drawText2(MENU_SCREEN_WIDTH / 2 - 7, 12, "GAME OBJECTIVE:", "#ffffff");
        gui.drawText2(3, 14, "SHOOT THE ROBOTS, SCORE POINTS AND RUN FROM EVIL SMILE", "#ffffff");
        gui.drawText2(3, 15, "DESTROY ALL ROBOTS TO OPEN THE GATE AND ADVANCE TO THE NEXT LEVEL", "#ffffff");
        gui.drawText2(3, 16, "PLAYER STARTS WITH 3 LIVES, EACH ROBOT DESTROYED = 50 POINTS", "#ffffff");

        x = 10;
        y = 17;
        for(String line : Sprites.getKeyBoard()){
            gui.drawText2(x, y, line,"#ffffff");
            y += 1;
        }
        y += 1;
        gui.drawText2(x, y, "Use ARROWS to move", "#ffffff");

        x = 40;
        y = 17;
        for (String line : Sprites.getSpace()){
            gui.drawText2(x, y, line,"#ffffff");
            y += 1;
        }
        y += 1;
        gui.drawText2(x, y, "Use SPACE to shoot", "#ffffff");

        gui.drawText2(MENU_SCREEN_WIDTH/2 - 20/2, MENU_SCREEN_HEIGHT - 2, "Press ESC to go back", "#ffffff");
    }
}
