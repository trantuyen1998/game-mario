/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom1.character;

import com.nhom1.audio.Audio;
import com.nhom1.mario.Main;
import com.nhom1.objects.Golden;
import com.nhom1.objects.Object;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author trant
 */
public class Mario extends Character{
    private Image imgMario;
    private ImageIcon icoMario;

    private boolean leap;
    private int meterLeap;
    
    private int meterDeath;

    public Mario(int x, int y) {
        super(x, y, 28, 50);
        this.icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();

        this.leap = false;
        this.meterLeap = 0;
        this.meterDeath =0;
    }

    public Image getImgMario() {
        return imgMario;
    }

    public void setImgMario(Image imgMario) {
        this.imgMario = imgMario;
    }

    public ImageIcon getIcoMario() {
        return icoMario;
    }

    public void setIcoMario(ImageIcon icoMario) {
        this.icoMario = icoMario;
    }

    public boolean isLeap() {
        return leap;
    }

    public void setLeap(boolean leap) {
        this.leap = leap;
    }

    public int getMeterLeap() {
        return meterLeap;
    }

    public void setMeterLeap(int meterLeap) {
        this.meterLeap = meterLeap;
    }

    public int getMeterDeath() {
        return meterDeath;
    }

    public void setMeterDeath(int meterDeath) {
        this.meterDeath = meterDeath;
    }
    //METHOD
    
    @Override
     public Image onWalking(String name, int frequence) {
        //frequnece of Object
        String str;
        ImageIcon icon;
        Image img;

        if (this.walking == false || Main.scene.getxPos() <= 0 
                || Main.scene.getxPos() > 4430) {
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
    public Image onLeap() {
        //frequnece of Object
        ImageIcon icon;
        Image img;
        String str;

        this.meterLeap++;
        if (this.meterLeap <= 40) {
            if (this.getY() > Main.scene.getHeightCeil()) {this.setY(this.getY() - 4);}
            else {this.meterLeap = 41;}
            if (this.isToRight() == true) {str = "/images/marioSautDroite.png";}
            else {str = "/images/marioSautGauche.png";}
        } else if ((this.getY() + this.getHeight()) < Main.scene.getySo1()) {this.setY(this.getY() + 1);
            if (this.isToRight() == true) { str = "/images/marioSautDroite.png";}
            else {str = "/images/marioSautGauche.png";}
        } else {
            if (this.isToRight() == true) {str = "/images/marioArretDroite.png";}
            else {str = "/images/marioArretGauche.png";}
            this.leap = false;
            this.meterLeap = 0;
        }
        icon = new ImageIcon(getClass().getResource(str));
        img = icon.getImage();
        return img;
    }
    public void contact(Object object){
        //contact horizontal
        if((super.contactBefore(object) == true 
                && this.isToRight()== true)||
                (super.contactAfter(object) == true 
                && this.isToRight() == false)
                ){
            Main.scene.setDx(0);
            this.setWalking(false);
            
        }
        
        if(super.contactUnder(object) == true && this.leap == true){
            Main.scene.setySo1(object.getY());
        }else if(super.contactUnder(object)== false ){
            Main.scene.setySo1(293);
            if(this.leap == false){
                this.setY(243);
            }
        }
        
        if(super.contactAbove(object) == true){
            Main.scene.setHeightCeil(object.getY() + object.getHeight());
            
        }else if(super.contactAbove(object) == false && this.leap == false){
            Main.scene.setHeightCeil(0);
        }
    }
    
    public boolean contactGolden(Golden golden){
        if(this.contactAfter(golden) == true || this.contactBefore(golden) == true ||
                this.contactUnder(golden) == true || this.contactAbove(golden) == true
                ){
           return true; 
        }else{
            return false;
        }
    }
    
    public void contact (Character character){
        if((super.contactBefore(character) == true) ||
                (super.contactAfter(character) == true)){
            this.setWalking(false);
            this.setLiveOrDie(false);
        }else if(super.contactUnder(character) == true){
            character.setWalking(false);
            character.setLiveOrDie(false);
        }
    }
    
    public Image onDied() {
        String str;
        ImageIcon icon;
        Image img;
        
        str = "/images/boom.png";
        if(this.meterDeath ==0){
            Audio.playSound("/audio/boum.wav");
        }
        if(this.meterDeath ==100){
             Audio.playSound("/audio/partiePerdue.wav");
        }
        this.meterDeath++;
        if (this.meterDeath > 100) {
            str = "/images/marioMeurt.png";
            this.setY(this.getY()-1);
        } else {
            str = "/images/champEcraseGauche.png";
        }

        icon = new ImageIcon(getClass().getResource(str));
        img = icon.getImage();
        return img;
    }
    
}
