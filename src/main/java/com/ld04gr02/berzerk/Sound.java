package com.ld04gr02.berzerk;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.io.IOException;

public class Sound {
    private Clip clip;

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public Sound(String path) throws IOException {
        this.clip = setFile(path);
    }
    private Clip setFile(String path) throws IOException {
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            File musicFile = new File(rootPath + path);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            return musicClip;
        } catch (Exception e) {
            System.err.println("Error: opening " + path);
        }
        return null;
    }
    public void playSound(float volume) {
        if(clip != null) {
            changeVolume(volume);
            clip.setMicrosecondPosition(0);
            clip.start();
        }
    }

    public void stopSound(){
        clip.stop();
    }

    public void loopSound(float volume){
        if(clip != null) {
            clip.setMicrosecondPosition(0);
            changeVolume(volume);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void changeVolume(float volume) {
        FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volumeControl.setValue(volume);
    }
}
