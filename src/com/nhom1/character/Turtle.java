/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom1.character;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.nhom1.objects.Object;

/**
 *
 * @author trant
 */
public class Turtle extends Character implements Runnable{
    private Image imgTurtle;
    private ImageIcon iconTurtle;
    private final int PAUSE = 15;
    private int dxTurtle;
    public Turtle(int x, int y) {
        super(x, y, 43, 50);
        super.setToRight(true);
        super.setWalking(true);
        this.dxTurtle = 1;

        this.iconTurtle = new ImageIcon(getClass().getResource("/images/tortueArretGauche.png"));
        this.imgTurtle = this.iconTurtle.getImage();

        Thread threadTurtle = new Thread(this);
        threadTurtle.start();
    }

    public Image getImgTurtle() {
        return imgTurtle;
    }

    public void move() {
        if (super.isToRight() == true) {
            this.dxTurtle = 1;
        } else {
            this.dxTurtle = -1;
        }
        super.setX(super.getX() + this.dxTurtle);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
        while (true) {
            if (this.liveOrDie == true) {

                this.move();
                try {
                    Thread.sleep(PAUSE);
                } catch (Exception e) {}
            }
        }
    }

    public void contact(Object object) {
        if (super.contactBefore(object) == true && this.isToRight() == true) {
            super.setToRight(false);
            this.dxTurtle = -1;
        } else if (super.contactAfter(object) == true && this.isToRight() == false) {
            super.setToRight(true);
            this.dxTurtle = 1;
        }
    
    }

    public void contact(Character character) {
        if (super.contactBefore(character) == true && this.isToRight() == true) {
            super.setToRight(false);
            this.dxTurtle = -1;
        } else if (super.contactAfter(character) == true && this.isToRight() == false) {
            super.setToRight(true);
            this.dxTurtle = 1;
        }
    }

    public Image onDied() {
        String str;
        ImageIcon icon;
        Image img;

        str = "/images/tortueFermee.png";

        icon = new ImageIcon(getClass().getResource(str));
        img = icon.getImage();
        return img;
    }
}
