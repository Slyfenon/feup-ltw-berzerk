package com.ld04gr02.berzerk;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.net.URL;

public class Sound {
    private Clip clip;

    public Clip getClip() {
        return clip;
    }

    public Sound(String path) {
        this.clip =setFile(path);
    }
    private Clip setFile(String path) {
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            File musicFile = new File(rootPath + path);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return musicClip;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public void playSound(float volume) {
        if(getClip() != null) {
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(volume);
            getClip().setMicrosecondPosition(0);
            getClip().start();
        }
    }

    public void stopSound(){
        getClip().stop();
    }

    public void loopSound(float volume){
        getClip().setMicrosecondPosition(0);
        FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volumeControl.setValue(volume);
        getClip().start();
        getClip().loop(Clip.LOOP_CONTINUOUSLY);
    }
}
