/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom1.objects;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author trant
 */
public class Golden extends Object implements Runnable{
    private int meter;
    private final int PAUSE = 15;

    public Golden(int x, int y) {
        super(x, y,30,30);
        super.iconObject = new ImageIcon(getClass().getResource("/images/piece1.png"));
        super.imgObject = super.iconObject.getImage();
    }
     public Image move(){
        String str;
        ImageIcon icon;
        Image img;
        
        this.meter++;
        if(this.meter/100 ==0){
            str = "/images/piece1.png";
        }else{
            str = "/images/piece2.png";
        }
        if(this.meter ==200){
            this.meter  =0;
        }
        
        icon = new ImageIcon(getClass().getResource(str));
        img = icon.getImage();
        return img;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
        while (true) {            
            this.move();
            try {
                Thread.sleep(PAUSE);
            } catch (Exception e) {
            }
        }
    }
}
