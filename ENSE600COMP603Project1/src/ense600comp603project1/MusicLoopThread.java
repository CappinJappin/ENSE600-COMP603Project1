package ense600comp603project1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

/**
 *
 * @author Mr Me
 */
public class MusicLoopThread implements Runnable {
    //Fields
    private Clip clip;
    private int loopDurationMillis; //how long to play before resetting music to start
    private boolean isActive = false;

    
    //Constructor
    public MusicLoopThread(String musicFilePath, int millis) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File(musicFilePath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        //this.file = new File(musicFilePath);
        //this.audioStream = AudioSystem.getAudioInputStream(this.file);

        this.loopDurationMillis = millis;
        this.clip = AudioSystem.getClip();
        clip.open(audioStream);
    }

    @Override
    public void run() {
        clip.start(); //Play the Audio
        this.isActive = true;
        while (this.isActive) {
            try {
                Thread.sleep(this.getLoopDurationMillis()); //wait 4 seconds, then overlay more music lol
            } catch (InterruptedException ex) {
                //this error will probably never show
                Logger.getLogger(MusicLoopThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            clip.setFramePosition(0); //reset the music to beginning
        }
        clip.stop();
    }
    
    
    /**
     * Stop music:
     * 
     * this method might not be necessary
     * if i can close the entire MusicLoopThread,
     * will probably test later
     */
    public void stop() {
        this.isActive = false;
    }

    /**
     * @return the loopDurationMillis
     */
    public int getLoopDurationMillis() {
        return loopDurationMillis;
    }

    /**
     * @param loopDurationMillis the loopDurationMillis to set
     */
    public void setLoopDurationMillis(int loopDurationMillis) {
        this.loopDurationMillis = loopDurationMillis;
    }
}
