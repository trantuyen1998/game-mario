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
public class Pipe extends Object{
    

    public Pipe(int x, int y) {
        super(x, y, 43, 65);
        this.iconObject = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
        this.imgObject = this.iconObject.getImage();
    }

    
}
