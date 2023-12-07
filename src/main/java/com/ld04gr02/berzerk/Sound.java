package com.ld04gr02.berzerk;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {
    Clip clip;
    URL[] soundURL = new URL[15];
    FloatControl volumeControl;

    public Sound(){
        soundURL[0] = getClass().getResource("/sounds/zipclick.wav");
        soundURL[1] = getClass().getResource("/sounds/bullet.wav");
        soundURL[2] = getClass().getResource("/sounds/menu.wav");
        soundURL[3] = getClass().getResource("/sounds/shock.wav");
        soundURL[4] = getClass().getResource("/sounds/GameOver.wav");
        soundURL[5] = getClass().getResource("/sounds/playsong.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        }
        catch(Exception e){
            throw new RuntimeException("Exception", e);
        }

    }
    public void playSound(float volume) {
        if (clip != null) {
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            volumeControl.setValue(volume);

            clip.start();
        }
    }

    public void stopSound(){
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.setFramePosition(0);
        }
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


    public void setupClickSound(){
        setFile(0);
    }
    public void setupBulletSound(){
        setFile(1);
    }
    public void setupShockSound(){
        setFile(3);
    }
    public void playClickSound(float volume){
        clip.setFramePosition(0);
        playSound(volume);
    }

    public void playMenuSong(float volume){
        setFile(2);
        loopSound(volume);
    }

    public void playBulletSound(float volume){
        clip.setFramePosition(0);
        playSound(volume);
    }

    public void playShockSound(float volume) {
        clip.setFramePosition(0);
        playSound(volume);
    }

    public void playGameMusic(float volume){
        setFile(5);
        loopSound(volume);
    }
    public void playGameOverMusic(float volume){
        setFile(4);
        playSound(volume);
    }
}
