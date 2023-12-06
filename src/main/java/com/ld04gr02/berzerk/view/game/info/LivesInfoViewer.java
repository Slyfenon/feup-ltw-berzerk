package com.ld04gr02.berzerk.view.game.info;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.view.game.Sprites;

public class LivesInfoViewer implements InfoViewer{
    @Override
    public void display(GUI gui) {
        Position pos = new Position(310, 315);

        for (int i = 0; i < StickMan.getMaxLives(); i++) {
            String color = i < StickMan.getLives() ? "#ff0000" : "#221111";

            gui.drawSprite(pos , Sprites.getHeart(), '#', color);

            pos.setX(pos.getX() + 32);
        }
    }
}
