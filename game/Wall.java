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


//Reef game*************************************

import java.awt.Image;
import javax.swing.ImageIcon;

public class Wall extends Sprite
{
    private int[][] fixedWall = new int [40][40];
    private int[][] destWall = new int [40][40];
    private int health;
    private int blockColor;
    private boolean destructable;
    private int numberOfWalls;
    
    private int[] velocity = new int[2];
    private int[] position = new int[2];
    private String direction = "";
    String sep = System.getProperty("file.separator");
    Image img = null;
    
    public Wall(boolean destructable, int blockColor , int posX, int posY)
    {
        this.blockColor = blockColor;
        this.destructable = destructable;
        this.position[0] = posX;
        this.position[1] = posY;
    }
    public Wall(boolean destructable, int blockColor, int numberOfWalls, String direction, int posX, int posY)
    {
        this(destructable, blockColor, posX, posY);
        this.numberOfWalls = numberOfWalls;
        this.direction = direction;
        Map.createWalls(this);
       
        
        
    }
    public int getSize()
    {
        return numberOfWalls;
    }
    public int getBlockColor()
    {
        return blockColor;
    }
    public String getDirection()
    {
        return direction;
    }
    public boolean getDestructable()
    {
        return destructable;
    }
    public int[][] getFixedWall() {
        return fixedWall;
    }

    public void setFixedWall(int[][] fixedWall) {
        this.fixedWall = fixedWall;
    }

    public int[][] getDestWall() {
        return destWall;
    }

    public void setDestWall(int[][] destWall) { 
        this.destWall = destWall;
    }
    @Override
    int[] getPosition() 
    {
        
        return position;
    }

    

    @Override
    int[] getVelocity() 
    {
        return velocity;
    }
    
    public void releaseStar()
    {
        /*Star a = new Star(tankID);
        a.getVelocity()[0] = (int)(10* Math.cos(angle));
        a.getVelocity()[1] = (int)(10* Math.sin(angle));
        a.getPosition()[0] = this.position[0] + (this.getImage().getWidth(null)/2) - (a.getImage().getWidth(null)/2);
        a.getPosition()[1] = this.position[1] + (this.getImage().getHeight(null)/2) - (a.getImage().getHeight(null)/2);
        a.getPosition()[0] += (6)*(a.getVelocity()[0]);
        a.getPosition()[1] += (6)*(a.getVelocity()[1]);
        
        Map.buls.add(a);*/
    }
   
    public Image getImage()
    {
        if (destructable == false)
        {
            img = new ImageIcon("images"+ sep +"Block_solid.gif").getImage();
        }
        else
        {
            switch (blockColor)
            {
                case 1:
                    img = new ImageIcon("images"+ sep +"Block1.gif").getImage();
                    break;
                case 2:
                    img = new ImageIcon("images"+ sep +"Block2.gif").getImage();
                    break;
                case 3:
                    img = new ImageIcon("images"+ sep +"Block3.gif").getImage();
                    break;    
                case 4:
                    img = new ImageIcon("images"+ sep +"Block4.gif").getImage();
                    break;
                case 5:
                    img = new ImageIcon("images"+ sep +"Block5.gif").getImage();
                    break; 
                case 6:
                    img = new ImageIcon("images"+ sep +"Block6.gif").getImage();
                    break;
                case 7:
                    img = new ImageIcon("images"+ sep +"Block7.gif").getImage();
                    break;
                case 8:
                    img = new ImageIcon("images"+ sep +"Block_life.gif").getImage();
                    break;
                case 9:
                    img = new ImageIcon("images"+ sep +"Block_split.gif").getImage();
                    break;
                case 10:
                    img = new ImageIcon("images"+ sep +"Block_double.gif").getImage();
                    break;
                case 11:
                    img = new ImageIcon("images"+ sep +"Katch4.gif").getImage();
                    break;
            }
        }
        return img;
    }
}