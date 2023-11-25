package com.ld04gr02.berzerk.view.menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.menu.Menu;
import com.ld04gr02.berzerk.view.Viewer;

public class MenuViewer extends Viewer {
    TextGraphics graphics;

    public MenuViewer(Object model) {
        super(model);
    }

    @Override
    protected void renderElements(GUI gui) {

        String[] logo =
               { "___    ____   ___     ____   ____  ___     __ __",
              "/ _ )  / __/   / _  |   /_  /  / __/ / _ |   / //_/",
              "/ _  | / _/   / , _/  / /_  / _/   / , _/   / ,<",
             "/____/ /___/  /_/|_|  /___/ /___/  /_/|_|   /_/|_|"};

        int where = 20;
        for(String s: logo){
            graphics.setForegroundColor(TextColor.Factory.fromString("#00ff00"));
            graphics.putString(40, where, s);
            where++;
        }


    }
}
