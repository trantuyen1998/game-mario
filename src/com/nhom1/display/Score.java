/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom1.display;

/**
 *
 * @author trant
 */
public class Score {
    private final int TOTAL_GOLDEN =10;
    private int numGolden;
    
    public Score(){
        this.numGolden = 0;
    }

    public int getNumGolden() {
        return numGolden;
    }

    public void setNumGolden(int numGolden) {
        this.numGolden = numGolden;
    }

    
    
    public int getTOTAL_GOLDEN(){
        return TOTAL_GOLDEN;
    }
}
