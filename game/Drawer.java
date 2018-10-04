/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luisf
 */

//Reef Game************************************

package game;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;

public class Drawer extends JPanel
{
    private int delay;
    Image img = null;
    BufferedImage bg = null;
    Timer timer;
    int velx = 2;
    int posx = 200;
    ArrayList<Sprite> list;
  
    
    public Drawer(ArrayList<Sprite> list)
    {
        super();
       
        this.list = list;
        this.setSize(new Dimension(640, 500));
        
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        delay = 1;
        timer = new Timer(delay, gameTimer);
        
        timer.start();
        try{
            bg = ImageIO.read(getClass().getResource("/images/Background1.bmp"));            
        }catch (IOException ex){
            System.out.println("background not loaded");
        }
        //System.out.println("Here");
        
        
            
       
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //g.setColor(Color.yellow);
        g.drawImage(bg, 0, 0,this);
        Map.Events();
        Map.fillArray();
        for (Sprite a: list)
        {
            g.drawImage(a.getImage(), a.getPosition()[0],a.getPosition()[1], this );
            //System.out.println("HEre");
            
        }
        g.setColor(Color.CYAN);
        g.setFont(new Font("Arial", Font.BOLD,20) );
        g.drawString("Life: " + Map.getLife(), 50, 400);
        g.drawString("Score: " + Map.getScore(), 50, 420);
        g.drawString("Biglegs: " + Map.legs.size(), 50, 440);
        
        if(Map.getLife()==0)
        {
            Level.gameOver();
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("GAME OVER", 240, 250);
            g.drawString("High Score", 246, 280);
            g.drawString(Integer.toString(Map.getScore()), 300, 310);
        }
        /*g.setFont(new Font("Arial", Font.BOLD,30) );
        g.drawString("Tank 1", 10, 610);
        g.drawString("Score: " + Map.tank.get(0).getScore(), 10, 640);
        g.drawString("Health: " + Map.tank.get(0).getHealth(), 10, 670);
        g.drawString("Lives: " + Map.tank.get(0).getLives(), 10, 700);
        g.drawString("Tank 2", 950, 610);
        g.drawString("Score: " + Map.tank.get(1).getScore(), 950, 640);
        g.drawString("Health: " + Map.tank.get(1).getHealth(), 950, 670);
        g.drawString("Lives: " + Map.tank.get(1).getLives(), 950, 700);
        
        if((Map.tank.get(0).getLives()==0||Map.tank.get(1).getLives()==0))
        {
            int highScore = 0;
            int tankID = 3;
            if(Map.tank.get(0).getScore()>Map.tank.get(1).getScore())
            {
                highScore = Map.tank.get(0).getScore();
                tankID = Map.tank.get(0).getTankID();
            }
            else
            {
                highScore = Map.tank.get(1).getScore();
                tankID = Map.tank.get(1).getTankID();
            }
            g.setFont(new Font("Arial", Font.BOLD,80) );
            g.drawString("GAME OVER", 400, 200);
            g.drawString("Tank "+ tankID + " wins", 400, 300);
        }
        */
        
        //g.drawRect(50, 50, 50, 50);
        //g.drawImage(img, posx, 200,this);
        
    }
    public void redraw()
    {
        this.repaint();
        
    }

    ActionListener gameTimer = new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            
            redraw();
        }
    };
    
    
    

    
}