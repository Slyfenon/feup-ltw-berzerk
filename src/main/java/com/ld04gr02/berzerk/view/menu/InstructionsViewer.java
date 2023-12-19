package com.ld04gr02.berzerk.view.menu;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
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
        Position pos = new Position(MENU_SCREEN_WIDTH / 2 - getLogoLength() / 2, 5);

        for (String line : Sprites.getLogo()){
            gui.drawText(pos, line,"#00ff00");
            pos.setY(pos.getY() + 1);
        }

        pos.setX(MENU_SCREEN_WIDTH / 2 - 7);
        pos.setY(12);
        gui.drawText(pos, "GAME OBJECTIVE:", "#ffffff");
        pos.setX(3);
        pos.setY(14);
        gui.drawText(pos, "SHOOT THE ROBOTS, SCORE POINTS AND RUN FROM EVIL SMILE", "#ffffff");
        pos.setY(pos.getY() + 1);
        gui.drawText(pos, "DESTROY ALL ROBOTS TO OPEN THE GATE AND ADVANCE TO THE NEXT LEVEL", "#ffffff");
        pos.setY(pos.getY() + 1);
        gui.drawText(pos, "PLAYER STARTS WITH 3 LIVES, EACH ROBOT DESTROYED = 50 POINTS", "#ffffff");


        pos.setX(10);
        pos.setY(17);
        for(String line : Sprites.getKeyBoard()){
            gui.drawText(pos, line,"#ffffff");
            pos.setY(pos.getY() + 1);
        }
        pos.setY(pos.getY() + 1);
        gui.drawText(pos, "Use ARROWS to move", "#ffffff");

        pos.setX(40);
        pos.setY(17);
        for (String line : Sprites.getSpace()){
            gui.drawText(pos, line,"#ffffff");
            pos.setY(pos.getY() + 1);
        }
        pos.setY(pos.getY() + 1);
        gui.drawText(pos, "Use SPACE to shoot", "#ffffff");

        pos.setX(MENU_SCREEN_WIDTH/2 - 20/2);
        pos.setY(MENU_SCREEN_HEIGHT - 2);
        gui.drawText(pos, "Press ESC to go back", "#ffffff");
    }
}
