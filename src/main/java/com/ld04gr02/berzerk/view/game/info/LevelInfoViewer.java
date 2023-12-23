package com.ld04gr02.berzerk.view.game.info;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;

import com.ld04gr02.berzerk.view.game.Sprites;

public class LevelInfoViewer implements InfoViewer{
    @Override
    public void display(GUI gui) {
        gui.drawSprite(30,315, Sprites.getLEVEL(), '#', "#ffffff");

        int[] scoreArray = new int[2];
        int level = Game.getLevel() < 100 ? Game.getLevel() : 99;
        for(int i = 1; i >= 0 && level != 0; i--) {
            int number = level % 10;
            scoreArray[i] = number;
            level /= 10;
        }

        int x = 80;
        int y = 315;
        for(int number : scoreArray) {
            gui.drawSprite(x, y, Sprites.getNumber(number), '#', "#ffffff");
            x += 14;
        }
    }
}
