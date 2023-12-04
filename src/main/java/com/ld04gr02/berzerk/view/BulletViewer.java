package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.Bullet;
import com.ld04gr02.berzerk.model.game.elements.Robot;

public class BulletViewer implements ElementViewer<Bullet>{
    @Override
    public void display(Bullet bullet, GUI gui) {
        gui.drawSprite(bullet.getPosition(), Sprites.getBullet(), '#', "#ffffff");
    }
}
