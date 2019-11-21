/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom1.objects;

import javax.swing.ImageIcon;

/**
 *
 * @author trant
 */
public class Block extends Object{
    

    public Block(int x, int y) {
        super(x, y, 30, 30);
        super.iconObject = new ImageIcon(getClass().getResource("/images/bloc.png"));
        this.imgObject = this.iconObject.getImage();
    }

    
}
