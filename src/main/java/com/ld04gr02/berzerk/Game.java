package com.ld04gr02.berzerk;

import com.ld04gr02.berzerk.gui.LanternaGUI;

import java.io.IOException;

public class Game {
    private final LanternaGUI gui;
    // private State state;
    public Game() throws IOException {
        this.gui = new LanternaGUI(50,25);
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
    }

    // private void run() throws IOException {}
}
