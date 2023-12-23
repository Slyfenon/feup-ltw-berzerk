package com.ld04gr02.berzerk;

import java.io.IOException;

public class Soundboard {
    private final Sound shock;
    private final Sound bullet;
    private final Sound click;
    private final Sound menuSong;
    private final Sound gameOverSound;
    private final Sound playSong;

    private static Soundboard soundboard;

    private Soundboard() throws IOException {
        shock = new Sound("/src/main/resources/sounds/shock.wav");
        bullet = new Sound("/src/main/resources/sounds/bullet.wav");
        click = new Sound("/src/main/resources/sounds/zipclick.wav");
        menuSong = new Sound("/src/main/resources/sounds/menu.wav");
        gameOverSound = new Sound("/src/main/resources/sounds/GameOver.wav");
        playSong = new Sound("/src/main/resources/sounds/playsong.wav");
    }

    public static Soundboard getInstance() throws IOException {
        if (soundboard == null) {
            soundboard= new Soundboard();
        }
        return soundboard;
    }

    public Sound getShock() {
        return shock;
    }

    public Sound getBullet() {
        return bullet;
    }

    public Sound getClick() {
        return click;
    }

    public Sound getMenuSong() {
        return menuSong;
    }

    public Sound getGameOverSound() {
        return gameOverSound;
    }

    public Sound getPlaySong() {
        return playSong;
    }
}
