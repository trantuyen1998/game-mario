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
public class CountDown implements Runnable{
     private final int PAUSE = 1000;
    private int countDown;
    private String str;
    
    public CountDown(){
        this.countDown = 100;
        this.str = "Thoi gian con lai";
        Thread count = new Thread(this);
        count.start();
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    
    @Override
    public void run(){
        while (true) {            
            try {
                Thread.sleep(PAUSE);
            } catch (Exception e) {
            }
            this.countDown--;
            this.str = "Thoi gian con lai: " + this.countDown;
        }
    }
}
