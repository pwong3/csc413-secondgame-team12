/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luisf
 */
package game;

//Reef Game************************************
//Katch class**********************************

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class Tanks extends Sprite {
    private int score;
    private int health;
    private int shield;
    private int tankID;
    private double angle;
    private int lives = 3;
    private int[] position = new int [2];
    private int[] velocity = {0 , 0};
    String sep = System.getProperty("file.separator");
    Image img = null;
    
    
    public Tanks(int id)
    {
        health = 100;
        shield = 0;
        score = 0;
        tankID = id;
        if (tankID == 1)
        {
           position[0] = 0;
           position[1] = 0; 
        }
        else
        {
            position[0] = 1280-70;
            position[1] = 720-70;
        }
        
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getTankID() {
        return tankID;
    }

    public void setTankID(int tankID) {
        this.tankID = tankID;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int[] getVelocity() {
        return velocity;
    }

    public void setVelocity(int[] velocity) {
        this.velocity = velocity;
    }
    
    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
    public void hit()
    {
        if (shield >= 0)
        {
            health -= 20;
        }
        else
        {
            shield -= 20;
            health -= 5;
        }
    }
    public void releaseBullet()
    {
        Bullets a = new Bullets(tankID);
        a.getVelocity()[0] = (int)(10* Math.cos(angle));
        a.getVelocity()[1] = (int)(10* Math.sin(angle));
        a.getPosition()[0] = this.position[0] + (this.getImage().getWidth(null)/2) - (a.getImage().getWidth(null)/2);
        a.getPosition()[1] = this.position[1] + (this.getImage().getHeight(null)/2) - (a.getImage().getHeight(null)/2);
        a.getPosition()[0] += (6)*(a.getVelocity()[0]);
        a.getPosition()[1] += (6)*(a.getVelocity()[1]);
        
        //Map.buls.add(a);
    }
  
    public void respawn(int tankID)
    {
        if (tankID == 1)
        {
            position[0] = 0;
            position[1] = 0; 
        }
        else
        {
            position[0] = 1280-70;
            position[1] = 720-70;
        }
        this.setHealth(100);
       
        
    }

    public Image getImage(){
            
            img = new ImageIcon("images"+ sep +"Katch.gif").getImage();
            
            return img;
    }    
    
    
}