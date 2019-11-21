/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom1.mario;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trant
 */
public class ThreadMajor implements Runnable{
    private final int PAUSE = 3;//time wait among 2 circle
    
    @Override
    public void run(){
        while(true){
            Main.scene.repaint();
            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException ex) {
                
            }
        }
    }
}
