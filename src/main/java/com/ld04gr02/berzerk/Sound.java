package com.ld04gr02.berzerk;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sound {
    Clip clip;
    URL[] soundURL = new URL[15];

    public Sound(){
        soundURL[0] = getClass().getResource("/sounds/zipclick.wav");
        soundURL[1] = getClass().getResource("/sounds/bullet.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        }
        catch(Exception e){}

    }
    public void playSound(){
        clip.start();
    }

    public void stopSound(){
        clip.stop();
    }

    public void loopSound(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
