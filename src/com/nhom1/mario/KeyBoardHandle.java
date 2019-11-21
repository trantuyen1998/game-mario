/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom1.mario;

import com.nhom1.audio.Audio;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.nhom1.mario.Scene;
/**
 *
 * @author trant
 */
public class KeyBoardHandle implements KeyListener{
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (Main.scene.mario.isLiveOrDie() ==  true) {

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (Main.scene.getxPos() == -1) {
                    Main.scene.setxPos(0);
                    Main.scene.setxFond1(-50);
                    Main.scene.setxFond2(750);
                }
                Main.scene.mario.setWalking(true);
                Main.scene.mario.setToRight(true);
                Main.scene.setDx(1);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (Main.scene.getxPos() == 4431) {
                    Main.scene.setxPos(4430);
                    Main.scene.setxFond1(-50);
                    Main.scene.setxFond2(750);
                }
                Main.scene.mario.setWalking(true);
                Main.scene.mario.setToRight(false);
                Main.scene.setDx(-1);
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                Main.scene.mario.setLeap(true);
                Audio.playSound("/audio/saut.wav");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.scene.mario.setWalking(false);
        Main.scene.setDx(0);
    }
}
