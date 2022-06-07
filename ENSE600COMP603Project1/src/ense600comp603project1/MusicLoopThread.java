package ense600comp603project1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

/**
 * A repeating loop of music, run inside a thread.
 * This script is pretty self-explanatory
 * 
 * @author James Dinsdale(18019702)
 */
public class MusicLoopThread implements Runnable {
    //Fields
    private Clip clip;
    private int loopDurationMillis; //how long to play before resetting music to start
    private boolean isActive = false;

    
    //Constructor
    public MusicLoopThread(String musicFilePath, int millis) {
        AudioInputStream audioStream = null;
        try {
            File file = new File(musicFilePath);
            audioStream = AudioSystem.getAudioInputStream(file);
            //this.file = new File(musicFilePath);
            //this.audioStream = AudioSystem.getAudioInputStream(this.file);
            this.loopDurationMillis = millis;
            this.clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(MusicLoopThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MusicLoopThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(MusicLoopThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioStream.close();
            } catch (IOException ex) {
                Logger.getLogger(MusicLoopThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
