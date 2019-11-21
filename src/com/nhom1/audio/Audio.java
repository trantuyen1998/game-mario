/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom1.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author trant
 */
public class Audio {
    private Clip clip;
    
    public Audio(String son){
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(son));
            clip = AudioSystem.getClip();
            clip.open(audio);
        } catch (Exception e) {
        }
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }
    
//    METHOD
    public void play(){
        clip.start();
    }
    public void stop(){
        clip.stop();
    }
    
    public static void playSound(String son){
        Audio s = new Audio(son);
        s.play();
    }
}
