/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom1.mario;

import javax.swing.JFrame;

/**
 *
 * @author trant
 */
public class Main {
    public static Scene scene;
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame fr =  new JFrame("Mario game");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(700,360);
        fr.setLocationRelativeTo(null);
        fr.setResizable(false);
        fr.setAlwaysOnTop(true);
        
        scene = new Scene();
        fr.setContentPane(scene);
        fr.setVisible(true);
    }
}
