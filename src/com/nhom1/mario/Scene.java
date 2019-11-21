/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom1.mario;

import com.nhom1.audio.Audio;
import com.nhom1.character.Mario;
import com.nhom1.character.Monster;
import com.nhom1.character.Turtle;
import com.nhom1.display.CountDown;
import com.nhom1.display.Score;
import com.nhom1.objects.Block;
import com.nhom1.objects.Golden;
import com.nhom1.objects.Pipe;
import com.nhom1.objects.Object;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author trant
 */
@SuppressWarnings("serial")
public class Scene extends JPanel {

    private ImageIcon iconFond;
    private Image imgFond1;
    private Image imgFond2;

    private ImageIcon iconCastle1;
    private Image imgCastle1;
    private ImageIcon iconDepart;
    private Image imgDepart;

    private int xFond1;
    private int xFond2;

    private int dx;//set chuyen dong
    private int xPos;//set vi tri
    private int ySo1;//set nhay
    private int heightCeil;
    private boolean ok;

    public Mario mario;
    public Monster monster;
    public Turtle turtle;

    public Pipe pipe1;
    public Pipe pipe2;
    public Pipe pipe3;
    public Pipe pipe4;
    public Pipe pipe5;
    public Pipe pipe6;
    public Pipe pipe7;
    public Pipe pipe8;

    public Block block1;
    public Block block2;
    public Block block3;
    public Block block4;
    public Block block5;
    public Block block6;
    public Block block7;
    public Block block8;
    public Block block9;
    public Block block10;
    public Block block11;
    public Block block12;

    public Golden golden1;
    public Golden golden2;
    public Golden golden3;
    public Golden golden4;
    public Golden golden5;
    public Golden golden6;
    public Golden golden7;
    public Golden golden8;
    public Golden golden9;
    public Golden golden10;

    public Monster monster1;
    public Monster monster2;
    public Monster monster3;
    public Monster monster4;
    public Monster monster5;
    public Monster monster6;
    public Monster monster7;
    public Monster monster8;

    public Turtle turtle1;
    public Turtle turtle2;
    public Turtle turtle3;
    public Turtle turtle4;
    public Turtle turtle5;
    public Turtle turtle6;
    public Turtle turtle7;
    public Turtle turtle8;
    public Turtle turtle9;

    private ImageIcon iconFlag;
    private Image imgFlag;
    private ImageIcon iconCastleFin;
    private Image imgCastleFin;

    private ArrayList<Object> tabObjects;
    private ArrayList<Golden> tabGoldens;
    private ArrayList<Turtle> tabTurtle;
    private ArrayList<Monster> tabMonster;

    private Score score;
    private Font police;
    private CountDown countDown;

    public Scene() {
        super();
        this.xFond1 = -50;
        this.xFond2 = 750;
        this.dx = 0;
        this.xPos = -1;
        this.ySo1 = 293;
        this.heightCeil = 0;
        this.ok = true;

        iconFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
        this.imgFond1 = this.iconFond.getImage();
        this.imgFond2 = this.iconFond.getImage();

        this.iconCastle1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));
        this.imgCastle1 = this.iconCastle1.getImage();
        this.iconDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
        this.imgDepart = this.iconDepart.getImage();

        mario = new Mario(300, 245);

        pipe1 = new Pipe(600, 230);
        pipe2 = new Pipe(1000, 230);
        pipe3 = new Pipe(1600, 230);
        pipe4 = new Pipe(1900, 230);
        pipe5 = new Pipe(2500, 230);
        pipe6 = new Pipe(3000, 230);
        pipe7 = new Pipe(3800, 230);
        pipe8 = new Pipe(4500, 230);

        block1 = new Block(400, 180);//set vi tri
        block2 = new Block(1200, 180);//set vi tri
        block3 = new Block(1270, 170);//set vi tri
        block4 = new Block(1340, 160);//set vi tri
        block5 = new Block(2000, 180);//set vi tri
        block6 = new Block(2600, 160);//set vi tri
        block7 = new Block(2650, 180);//set vi tri
        block8 = new Block(3500, 160);//set vi tri
        block9 = new Block(3550, 140);//set vi tri
        block10 = new Block(4000, 170);//set vi tri
        block11 = new Block(4200, 200);//set vi tri
        block12 = new Block(4300, 210);//set vi tri

        golden1 = new Golden(402, 145);
        golden2 = new Golden(1202, 140);
        golden3 = new Golden(1272, 95);
        golden4 = new Golden(1342, 40);
        golden5 = new Golden(1650, 145);
        golden6 = new Golden(2650, 145);
        golden7 = new Golden(3000, 135);
        golden8 = new Golden(3400, 125);
        golden9 = new Golden(4200, 145);
        golden10 = new Golden(4600, 40);

        monster1 = new Monster(800, 263);
        monster2 = new Monster(1100, 263);
        monster3 = new Monster(2100, 263);
        monster4 = new Monster(2400, 263);
        monster5 = new Monster(3200, 263);
        monster6 = new Monster(3500, 263);
        monster7 = new Monster(3700, 263);
        monster8 = new Monster(4500, 263);

        turtle1 = new Turtle(950, 243);
        turtle2 = new Turtle(1500, 243);
        turtle3 = new Turtle(1800, 243);
        turtle4 = new Turtle(2400, 243);
        turtle5 = new Turtle(3100, 243);
        turtle6 = new Turtle(3600, 243);
        turtle7 = new Turtle(3900, 243);
        turtle8 = new Turtle(4200, 243);
        turtle9 = new Turtle(4400, 243);

        this.iconCastleFin = new ImageIcon(getClass().getResource("/images/chateauFin.png"));
        this.imgCastleFin = this.iconCastleFin.getImage();

        this.iconFlag = new ImageIcon(getClass().getResource("/images/drapeau.png"));
        this.imgFlag = this.iconFlag.getImage();

        tabObjects = new ArrayList<>();

        this.tabObjects.add(this.pipe1);
        this.tabObjects.add(this.pipe2);
        this.tabObjects.add(this.pipe3);
        this.tabObjects.add(this.pipe4);
        this.tabObjects.add(this.pipe5);
        this.tabObjects.add(this.pipe6);
        this.tabObjects.add(this.pipe7);
        this.tabObjects.add(this.pipe8);

        this.tabObjects.add(this.block1);
        this.tabObjects.add(this.block2);
        this.tabObjects.add(this.block3);
        this.tabObjects.add(this.block4);
        this.tabObjects.add(this.block5);
        this.tabObjects.add(this.block6);
        this.tabObjects.add(this.block7);
        this.tabObjects.add(this.block8);
        this.tabObjects.add(this.block9);
        this.tabObjects.add(this.block10);
        this.tabObjects.add(this.block11);
        this.tabObjects.add(this.block12);

        tabGoldens = new ArrayList<Golden>();
        this.tabGoldens.add(this.golden1);
        this.tabGoldens.add(this.golden2);
        this.tabGoldens.add(this.golden3);
        this.tabGoldens.add(this.golden4);
        this.tabGoldens.add(this.golden5);
        this.tabGoldens.add(this.golden6);
        this.tabGoldens.add(this.golden7);
        this.tabGoldens.add(this.golden8);
        this.tabGoldens.add(this.golden9);
        this.tabGoldens.add(this.golden10);

        tabMonster = new ArrayList<>();
        this.tabMonster.add(this.monster1);
        this.tabMonster.add(this.monster2);
        this.tabMonster.add(this.monster3);
        this.tabMonster.add(this.monster4);
        this.tabMonster.add(this.monster5);
        this.tabMonster.add(this.monster6);
        this.tabMonster.add(this.monster7);
        this.tabMonster.add(this.monster8);

        tabTurtle = new ArrayList<>();
        this.tabTurtle.add(this.turtle1);
        this.tabTurtle.add(this.turtle2);
        this.tabTurtle.add(this.turtle3);
        this.tabTurtle.add(this.turtle4);
        this.tabTurtle.add(this.turtle5);
        this.tabTurtle.add(this.turtle6);
        this.tabTurtle.add(this.turtle7);
        this.tabTurtle.add(this.turtle8);
        this.tabTurtle.add(this.turtle9);

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new KeyBoardHandle());

        score = new Score();
        police = new Font("Arial", Font.PLAIN, 18);
        countDown = new CountDown();

        Thread threadMJ = new Thread(new ThreadMajor());
        threadMJ.start();
    }

    public int getxFond1() {
        return xFond1;
    }

    public void setxFond1(int xFond1) {
        this.xFond1 = xFond1;
    }

    public int getxFond2() {
        return xFond2;
    }

    public void setxFond2(int xFond2) {
        this.xFond2 = xFond2;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getySo1() {
        return ySo1;
    }

    public void setySo1(int ySo1) {
        this.ySo1 = ySo1;
    }

    public int getHeightCeil() {
        return heightCeil;
    }

    public void setHeightCeil(int heightCeil) {
        this.heightCeil = heightCeil;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void deplacementFond() {
        if (this.xPos >= 0 && this.xPos <= 4430) {
            this.xPos = this.xPos + this.dx;
            this.xFond1 = this.xFond1 - this.dx;
            this.xFond2 = this.xFond2 - this.dx;
        }

        if (this.xFond1 == -800) {
            this.xFond1 = 800;
        } else if (this.xFond2 == -800) {
            this.xFond2 = 800;
        } else if (this.xFond1 == 800) {
            this.xFond1 = -800;
        } else if (this.xFond2 == 800) {
            this.xFond1 = -800;
        }
    }

    private boolean passWin() {
        if (this.countDown.getCountDown() > 0
                && this.mario.isLiveOrDie() == true
                && this.score.getNumGolden() == 10
                && this.xPos > 4400) {
            if (this.ok == true) {
                Audio.playSound("/audio/partieGagnee.wav");
                this.ok = false;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean partFail() {
        if (this.mario.isLiveOrDie() == false
                || this.countDown.getCountDown() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean partFinish() {
        if (this.passWin() == true || this.partFail() == true) {
            return true;
        } else {
            return false;
        }
    }

   @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        //contact pipe and block
        for (int i = 0; i < this.tabObjects.size(); i++) {
            if (this.mario.nearObject(this.tabObjects.get(i))) {
                this.mario.contact(this.tabObjects.get(i));
            }
            for (int j = 0; j < this.tabMonster.size(); j++) {
                if (this.tabMonster.get(j).nearObject(this.tabObjects.get(i))) {
                    this.tabMonster.get(j).contact(this.tabObjects.get(i));
                }
            }
            for (int j = 0; j < this.tabTurtle.size(); j++) {
                if (this.tabTurtle.get(j).nearObject(this.tabObjects.get(i))) {
                    this.tabTurtle.get(j).contact(this.tabObjects.get(i));
                }
            }

        }

        for (int i = 0; i < this.tabGoldens.size(); i++) {
            if (this.mario.nearObject(this.tabGoldens.get(i))) {
                if (this.mario.contactGolden(this.tabGoldens.get(i))) {
                    Audio.playSound("/audio/piece.wav");
                    this.tabGoldens.remove(i);
                    this.score.setNumGolden(this.score.getNumGolden() + 1);
                }
            }
        }
        //detect contact
        //create contact object

        for (int i = 0; i < this.tabMonster.size(); i++) {
//            tabMonster
            for (int j = 0; j < this.tabMonster.size(); j++) {
                if (j != i) {
                    if (this.tabMonster.get(j).nearObject(this.tabMonster.get(i))) {
                        this.tabMonster.get(j).contact(this.tabMonster.get(i));
                    }
                }
            }
            //turtle
            for (int j = 0; j < this.tabTurtle.size(); j++) {
                if (this.tabTurtle.get(j).nearObject(this.tabMonster.get(i))) {
                    this.tabTurtle.get(j).contact(this.tabMonster.get(i));
                }
            }
        }
        for (int i = 0; i < this.tabTurtle.size(); i++) {
            for (int j = 0; j < this.tabMonster.size(); j++) {
                if (this.tabMonster.get(j).nearObject(this.tabTurtle.get(i))) {
                    this.tabMonster.get(j).contact(this.tabTurtle.get(i));
                }
            }
            for (int j = 1; j < this.tabTurtle.size(); j++) {
                if (j != i) {
                    if (this.tabTurtle.get(j).nearObject(this.tabTurtle.get(i))) {
                        this.tabTurtle.get(j).contact(this.tabTurtle.get(i));
                    }
                }
            }
        }

        for (int i = 0; i < this.tabMonster.size(); i++) {
            if (this.mario.nearObject(this.tabMonster.get(i)) && this.tabMonster.get(i).isLiveOrDie() == true) {
                this.mario.contact(this.tabMonster.get(i));
                if(this.tabMonster.get(i).isLiveOrDie() == false){
                    Audio.playSound("/audio/ecrasePersonnage.wav");
                }
            }
        }
        for (int i = 0; i < this.tabTurtle.size(); i++) {
            if (this.mario.nearObject(this.tabTurtle.get(i)) && this.tabTurtle.get(i).isLiveOrDie() == true) {
                this.mario.contact(this.tabTurtle.get(i));
                 if(this.tabTurtle.get(i).isLiveOrDie() == false){
                    Audio.playSound("/audio/ecrasePersonnage.wav");
                }
            }
        }
        this.deplacementFond();


        if (this.xPos >= 0 && this.xPos <= 4430) {
            for (int i = 0; i < this.tabObjects.size(); i++) {
                this.tabObjects.get(i).deplacement();
            }
            for (int i = 0; i < this.tabGoldens.size(); i++) {
                this.tabGoldens.get(i).deplacement();
            }
            for (int i = 0; i < this.tabMonster.size(); i++) {
                this.tabMonster.get(i).deplacement();
            }
            for (int i = 0; i < this.tabTurtle.size(); i++) {
                this.tabTurtle.get(i).deplacement();
            }

        }

        g2.drawImage(this.imgFond1, this.xFond1, 0, null);
        g2.drawImage(this.imgFond2, this.xFond2, 0, null);

        g2.drawImage(imgCastle1, 10 - this.xPos, 95, null);
        g2.drawImage(imgDepart, 220 - this.xPos, 234, null);//(x,y)


        //load pipe and block
        for (int i = 0; i < this.tabObjects.size(); i++) {
            g2.drawImage(this.tabObjects.get(i).getImgObject(), this.tabObjects.get(i).getX(),
                    this.tabObjects.get(i).getY(), null);
        }

//        load tabGolden
        for (int i = 0; i < this.tabGoldens.size(); i++) {
            g2.drawImage(this.tabGoldens.get(i).move(), this.tabGoldens.get(i).getX(),
                    this.tabGoldens.get(i).getY(), null);
        }

        g2.drawImage(imgFlag, 4650 - this.xPos, 115, null);
        g2.drawImage(imgCastleFin, 5000 - this.xPos, 145, null);

        if (this.mario.isLiveOrDie() == true) {
            if (this.mario.isLeap()) {
                g2.drawImage(this.mario.onLeap(), this.mario.getX(), this.mario.getY(), null);
            } else {
                g2.drawImage(this.mario.onWalking("mario", 25), this.mario.getX(), this.mario.getY(), null);//(x,y)
            }
        }else{
            g2.drawImage(this.mario.onDied(), this.mario.getX(),this.mario.getY(), null);
        }

        for (int i = 0; i < this.tabMonster.size(); i++) {
            if (this.tabMonster.get(i).isLiveOrDie() == true) {
                g2.drawImage(this.tabMonster.get(i).onWalking("champ", 45), this.tabMonster.get(i).getX(), this.tabMonster.get(i).getY(), null);
            } else {
                g2.drawImage(this.tabMonster.get(i).onDied(), this.tabMonster.get(i).getX(), this.tabMonster.get(i).getY() + 20, null);
            }
        }
        for (int i = 0; i < this.tabTurtle.size(); i++) {
            if (this.tabTurtle.get(i).isLiveOrDie() == true) {
                g2.drawImage(this.tabTurtle.get(i).onWalking("tortue", 50), this.tabTurtle.get(i).getX(), this.tabTurtle.get(i).getY(), null);
            } else {
                g2.drawImage(this.tabTurtle.get(i).onDied(), this.tabTurtle.get(i).getX(), this.tabTurtle.get(i).getY() + 20, null);
            }
        }

        g2.setFont(police);
        g2.drawString(this.score.getNumGolden() + " / " + this.score.getTOTAL_GOLDEN(), 460, 25);
        g2.drawString(this.countDown.getStr(), 5, 25);

        if (this.partFinish() == true) {
            Font policeFin = new Font("Arial", Font.BOLD, 50);
            g2.setFont(policeFin);
            if (this.passWin() == true) {
                g2.drawString("WIN GAME!", 120, 180);
            } else {
                g2.drawString("GAME OVER", 120, 180);
            }

        }

    }

}
