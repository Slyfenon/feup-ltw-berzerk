package com.ld04gr02.berzerk.view.game.info;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.view.game.Sprites;


public class ScoreInfoViewer implements InfoViewer {

    @Override
    public void display(GUI gui) {
        gui.drawSprite2(135,315, Sprites.getScore(), '#', "#ffffff");

        int[] scoreArray = new int[4];
        int score = StickMan.getScore();
        for(int i = 3; i >= 0 && score != 0; i--) {
            int number = score % 10;
            scoreArray[i] = number;
            score /= 10;
        }

        int x = 215;
        int y = 315;
        for(int number : scoreArray) {
            gui.drawSprite2(x, y, Sprites.getNumber(number), '#', "#ffffff");
            x += 14;
        }
    }
}
