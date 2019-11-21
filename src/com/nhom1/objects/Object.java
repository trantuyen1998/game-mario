/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom1.objects;

import com.nhom1.mario.Main;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author trant
 */
public class Object {
    private int width, height;
    private int x,y;
    //block set
    protected Image imgObject;
    protected ImageIcon iconObject;

    
    public Object(int x, int y,int width, int height) {
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public Image getImgObject() {
        return imgObject;
    }

    public void setImgObject(Image imgObject) {
        this.imgObject = imgObject;
    }

    public ImageIcon getIconObject() {
        return iconObject;
    }

    public void setIconObject(ImageIcon iconObject) {
        this.iconObject = iconObject;
    }
     //METHOD
    
    public void deplacement(){
        if(Main.scene.getxPos()>=0){
            this.x = this.x - Main.scene.getDx();
        }
    }
    
}
