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
public class Monster extends Character implements Runnable{
    private Image imgMonster;
    private ImageIcon iconMonster;
    private final int PAUSE = 15;
    private int dxMonster;
    public Monster(int x, int y) {
        super(x, y, 27, 30);
        super.setToRight(true);
        super.setWalking(true);
        this.dxMonster = 1;

        this.iconMonster = new ImageIcon(getClass().getResource("/images/champArretDroite.png"));
        this.imgMonster = this.iconMonster.getImage();

        Thread threadMonster = new Thread(this);
        threadMonster.start();
    }

    public Image getImgMonster() {
        return imgMonster;
    }

    public void setImgMonster(Image imgMonster) {
        this.imgMonster = imgMonster;
    }

    public ImageIcon getIconMonster() {
        return iconMonster;
    }

    public void setIconMonster(ImageIcon iconMonster) {
        this.iconMonster = iconMonster;
    }

    public int getDxMonster() {
        return dxMonster;
    }

    public void setDxMonster(int dxMonster) {
        this.dxMonster = dxMonster;
    }
    public void move() {
        if (super.isToRight()== true) {
            this.dxMonster= 1;
        } else {
            this.dxMonster = -1;
        }
        super.setX(super.getX() + this.dxMonster);
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
            this.dxMonster = -1;
        } else if (super.contactAfter(object) == true && this.isToRight() == false) {
            super.setToRight(true);
            this.dxMonster = 1;
        }
    }

    public void contact(Character character) {
        if (super.contactBefore(character) == true && this.isToRight() == true) {
            super.setToRight(false);
            this.dxMonster = -1;
        } else if (super.contactAfter(character) == true && this.isToRight() == false) {
            super.setToRight(true);
            this.dxMonster = 1;
        }
    }

    public Image onDied() {
        String str;
        ImageIcon icon;
        Image img;
        
        
        if (this.isToRight() == true) {
            str = "/images/champEcraseDroite.png";
        } else {
            str = "/images/champEcraseGauche.png";
        }

        icon = new ImageIcon(getClass().getResource(str));
        img = icon.getImage();
        return img;
    }
    
}
