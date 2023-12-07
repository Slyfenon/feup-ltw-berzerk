package com.ld04gr02.berzerk.view.game;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.Bullet;

public class BulletViewer implements ElementViewer<Bullet>{
    @Override
    public void display(Bullet bullet, GUI gui) {
        switch(bullet.getCurrentDirection()) {
            case Up: case Down:
                gui.drawSprite(bullet.getPosition(), Sprites.getVerticalBullet(), '#', "#ffffff");
                break;
            case Left: case Right:
                gui.drawSprite(bullet.getPosition(), Sprites.getHorizontalBullet(), '#', "#ffffff");
                break;
        }
    }
}
