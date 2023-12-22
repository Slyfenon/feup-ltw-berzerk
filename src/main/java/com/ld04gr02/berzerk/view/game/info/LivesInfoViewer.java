package com.ld04gr02.berzerk.view.game.info;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.view.game.Sprites;

public class LivesInfoViewer implements InfoViewer{
    @Override
    public void display(GUI gui) {
        int x = 310;
        int y = 315;

        for (int i = 0; i < StickMan.getMaxLives(); i++) {
            String color = i < StickMan.getLives() ? "#ff0000" : "#221111";

            gui.drawSprite2(x, y, Sprites.getHeart(), '#', color);

            x += 32;
        }
    }
}
