package com.ld04gr02.berzerk.view.game.info;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.view.game.Sprites;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreInfoViewer implements InfoViewer {

    @Override
    public void display(GUI gui) {
        gui.drawSprite(new Position(135,315), Sprites.getScore(), '#', "#ffffff");

        int[] scoreArray = new int[4];
        int score = StickMan.getScore();
        for(int i = 3; i >= 0 && score != 0; i--) {
            int number = score % 10;
            scoreArray[i] = number;
            score /= 10;
        }

        Position pos = new Position(215, 315);
        for(int number : scoreArray) {
            gui.drawSprite(pos, Sprites.getNumber(number), '#', "#ffffff");
            pos.setX(pos.getX() + 14);
        }
    }
}
