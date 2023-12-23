package com.ld04gr02.berzerk.view.game.info;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.view.game.Sprites;

public class LevelInfoViewer implements InfoViewer{
    @Override
    public void display(GUI gui) {
        gui.drawSprite(30,315, Sprites.getLEVEL(), '#', "#ffffff");
        gui.drawSprite(80, 315, Sprites.getNumber(Game.getLevel()), '#', "#ffffff");
    }
}
