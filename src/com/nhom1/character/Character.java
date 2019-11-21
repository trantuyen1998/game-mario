/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom1.character;

import java.awt.Image;
import javax.swing.ImageIcon;
import com.nhom1.mario.Main;
import com.nhom1.objects.Object;

/**
 *
 * @author trant
 */
public class Character {

    private int width, height;
    private int x, y;
    protected boolean walking;
    protected boolean toRight;

    public int meter;
    protected boolean liveOrDie;//live or died

    public Character(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.meter = 0;
        this.walking = false;
        this.toRight = true;
        this.liveOrDie = true;
    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isWalking() {
        return walking;
    }

    public void setWalking(boolean walking) {
        this.walking = walking;
    }

    public boolean isToRight() {
        return toRight;
    }

    public void setToRight(boolean toRight) {
        this.toRight = toRight;
    }

    public int getMeter() {
        return meter;
    }

    public void setMeter(int meter) {
        this.meter = meter;
    }

    public boolean isLiveOrDie() {
        return liveOrDie;
    }

    public void setLiveOrDie(boolean liveOrDie) {
        this.liveOrDie = liveOrDie;
    }

   
//    METHOD
    //set chuyen dong cho nhan vat
    public Image onWalking(String name, int frequence) {
        //frequnece of Object
        String str;
        ImageIcon icon;
        Image img;

        if (this.walking == false) {
            if (this.toRight == true) {
                str = "/images/" + name + "ArretDroite.png";
            } else {
                str = "/images/" + name + "ArretGauche.png";
            }
        } else {
            this.meter++;
            if (this.meter / frequence == 0) {
                if (this.toRight == true) {
                    str = "/images/" + name + "ArretDroite.png";
                } else {
                    str = "/images/" + name + "ArretGauche.png";
                }
            } else {
                if (this.toRight == true) {
                    str = "/images/" + name + "MarcheDroite.png";
                } else {
                    str = "/images/" + name + "MarcheGauche.png";
                }
            }
            if (this.meter == 2 * frequence) {
                this.meter = 0;
            }
        }

        icon = new ImageIcon(getClass().getResource(str));
        img = icon.getImage();
        return img;
    }

    public void deplacement() {
        if (Main.scene.getxPos() >= 0) {
            this.x = this.x - Main.scene.getDx();
        }
    }

    //khong cho cham truong ngai vat dang truoc
    protected boolean contactBefore(Object object) {

        if (this.x + this.width < object.getX()
                || this.x + this.width > object.getX() + 5
                || this.y + this.height <= object.getY()
                || this.y >= object.getY() + object.getHeight()) {
            return false;
        } else {
            return true;
        }

    }

    protected boolean contactAfter(Object object) {

        if (this.x > object.getX() + object.getWidth()
                || this.x + this.width < object.getX() + object.getWidth() - 5
                || this.y + this.height <= object.getY()
                || this.y >= object.getY() + object.getHeight()) {
            return false;
        } else {
            return true;
        }
    }

    protected boolean contactUnder(Object object) {

        if (this.x + this.width < object.getX() + 5
                || this.x > object.getX() + object.getWidth() - 5
                || this.y + this.height < object.getY()
                || this.y + this.height > object.getY() + 5) {
            return false;
        } else {
            return true;
        }

    }

    protected boolean contactAbove(Object object) {

        if (this.x + this.width < object.getX() + 5
                || this.x > object.getX() + object.getWidth() - 5
                || this.y < object.getY() + object.getHeight()
                || this.y > object.getY() + object.getHeight() + 5) {
            return false;
        } else {
            return true;
        }

    }

    public boolean nearObject(Object object) {
        if ((this.x > object.getX() - 10
                && this.x < object.getX() + object.getWidth() + 10)
                || (this.x + this.width > object.getX() - 10
                && this.x + this.width < object.getX() + object.getWidth() + 10)) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean contactBefore(Character character) {

        if (this.isToRight() == true) {
            if (this.x + this.width < character.getX()
                    || this.x + this.width > character.getX() + 5
                    || this.y + this.height <= character.getY()
                    || this.y >= character.getY() + character.getHeight()) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    protected boolean contactAfter(Character character) {

        if (this.x > character.getX() + character.getWidth()
                || this.x + this.width < character.getX() + character.getWidth() - 5
                || this.y + this.height <= character.getY()
                || this.y >= character.getY() + character.getHeight()) {
            return false;
        } else {
            return true;
        }
    }
    protected boolean contactUnder(Character character) {

        if (this.x + this.width < character.getX() 
                || this.x > character.getX() + character.getWidth()
                || this.y + this.height < character.getY()
                || this.y + this.height > character.getY()) {
            return false;
        } else {
            return true;
        }

    }
    public boolean nearObject(Character character) {
        if ((this.x > character.getX() - 10
                && this.x < character.getX() + character.getWidth() + 10)
                || (this.x + this.width > character.getX() - 10
                && this.x + this.width < character.getX() + character.getWidth() + 10)) {
            return true;
        } else {
            return false;
        }
    }
}
