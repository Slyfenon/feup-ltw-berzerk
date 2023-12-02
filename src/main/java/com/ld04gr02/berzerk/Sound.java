package com.ld04gr02.berzerk;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sound {
    Clip clip;
    URL[] soundURL = new URL[15];
    FloatControl volumeControl;

    public Sound(){
        soundURL[0] = getClass().getResource("/sounds/zipclick.wav");
        soundURL[1] = getClass().getResource("/sounds/bullet.wav");
        soundURL[2] = getClass().getResource("/sounds/menu.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        }
        catch(Exception e){}

    }
    public void playSound(float volume) {
        if (clip != null) {
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            volumeControl.setValue(volume);

            clip.start();
        }
    }

    public void stopSound(){
        clip.stop();
    }

    public void loopSound(float volume){
        if (clip != null) {
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            volumeControl.setValue(volume);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }

    }
    public Clip getClip() {
        return clip;
    }
}
