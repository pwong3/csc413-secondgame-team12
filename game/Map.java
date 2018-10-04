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

import java.util.ArrayList;
import javax.swing.*;

public class Map extends JFrame {

    static ArrayList<Sprite> arr = new ArrayList<Sprite>();
    static ArrayList<Star> stars = new ArrayList<Star>();
    static ArrayList<Bonus> bons = new ArrayList<Bonus>();
    static ArrayList<Wall> walls = new ArrayList<Wall>();
    static ArrayList<Biglegs> legs = new ArrayList<Biglegs>();
    private static int actions = 0;
    private static int score;
    private static int life = 3;
    private static int level = 1;
    static boolean spawned = false;

    public static void setLife(int life) {
        Map.life = life;
    }
   

    public static int getScore() {
        return score;
    }

    public static int getLife() {
        return life;
    }

    public Map(String input) {
        super(input);
        Star one = new Star();
        stars.add(one);
        Wall paddle = new Wall(true, 11, 1, "RIGHT", 300, 430);
        
        Level.createMapOne();
              
        InputHandler s = new InputHandler(walls);
        this.add(s);
    }

    public void run() {
        this.addPanel();
        this.setVisible(true);
    }

    public void addPanel() {
        Drawer draw = new Drawer(arr);
        this.add(draw);

    }

    static public void fillArray() {
        arr.clear();

        for (Sprite a : stars) {
            arr.add(a);
        }
        for (Sprite a : walls) {
            arr.add(a);
        }
        for (Sprite a : legs) {
            arr.add(a);
        }
        /* for (Sprite a: tank)
         {
         arr.add(walls.size(),a);
         }
         for (Sprite a: buls)
         {
         arr.add(walls.size() + tank.size(),a);
         }*/
       // for (Sprite a: bons)
        // {
        //     arr.add(walls.size() + tank.size() + buls.size(), a);
        // }
        actions++;

    }

    static public void createWalls(Wall e) {
        int adder[] = {0, 0};
        boolean destructible = e.getDestructable();
        int blockColor = e.getBlockColor();
        int originalX = e.getPosition()[0];
        int originalY = e.getPosition()[1];
        switch (e.getDirection()) {
            case ("UP"):
                adder[1] = -20;
                break;
            case ("DOWN"):
                adder[1] = 20;
                break;
            case ("LEFT"):
                adder[0] = -40;
                break;
            case ("RIGHT"):
                adder[0] = 40;
                break;
        }

        for (int i = 0; i < e.getSize(); i++) {
            Wall dummiWall = new Wall(destructible, blockColor, originalX + (adder[0] * i), originalY + (adder[1] * i));

            walls.add(dummiWall);

        }

    }

    static public void Events() {
        /*if (actions % 2000 == 1000)
         {
         Bonus ran = new Bonus();
         ran.setPowerUp((int)(Math.random() *2));
         ran.getPosition()[0] = (int)(Math.random() * 640) - ran.getImage().getWidth(null)/2;
         ran.getPosition()[1] = (int)(Math.random() * 480) - ran.getImage().getHeight(null)/2;
         bons.add(0, ran);
         arr.add(0, bons.get(0));
         }*/
        
        for (Sprite a: arr)
        {
            
            
            a.updatePos();
            a.avoidLimits();
            
            
            if (!(a instanceof Star))
            {
                break;
            }
            
            
        }
        checkPadLimit(walls);
        int size = arr.size();
        int starsSize = stars.size();
        
        for (int i = 0;i< stars.size(); i++)
        {
            for (int j = starsSize; j < size; j++)
            {
                if (j > starsSize && j < starsSize +64)
                {
                    continue;
                }
                Sprite a = arr.get(i);
                Sprite b = arr.get(j);
                int distanceX = a.distanceX(b);
                int distanceY = a.distanceY(b);
                int Xlimit = (a.getImage().getWidth(null) / 2) + (b.getImage().getWidth(null) / 2);
                int Ylimit = (a.getImage().getHeight(null) / 2) + (b.getImage().getHeight(null) / 2);
                 if (Math.abs(a.distanceX(b)) < Xlimit && Math.abs(a.distanceY(b)) < Ylimit)
                {

                //if ( (Math.abs(distanceX - a.getVelocity()[0]) < (Xlimit + 10)) && ( Math.abs(distanceY - a.getVelocity()[1]) < Ylimit)  )
                //{        
                    if (b instanceof Wall)
                    {
                            a.avoidSuperposition(b);
                            if (((Wall) b).getDestructable()) 
                            {
                                if (((Wall) b).getBlockColor() < 8) 
                                {
                                    walls.remove(b);
                                    score += 20;
                                }
                                else if (((Wall) b).getBlockColor() == 8)
                                {
                                walls.remove(b);
                                life += 1;
                                }
                                else if (((Wall) b).getBlockColor() == 9)
                                {
                                walls.remove(b);
                                Star splitStar = new Star();
                                stars.add(splitStar);
                                }
                            }
                            
                    }
                    else if(b instanceof Biglegs)
                    {
                        
                            a.avoidSuperposition(b);
                            legs.remove(b);
                            score+=50;
                        
                    }
                    break;
                }
                
            }
        }
        if(legs.isEmpty() && level == 1)
        {
            Level.newLevel();
            Level.createMapTwo();
            level++;
            if(legs.isEmpty() && level == 2)
            {
                Level.newLevel();
                Level.createMapThree();
            }
        }
        

    }
    static void checkPadLimit(ArrayList<Wall> pad)
    {
        
        if (pad.get(0).getPosition()[0] < 40) 
        {
            pad.get(0).getPosition()[0] = 40;
                     
        }
        
        if (pad.get(0).getPosition()[0] > 520) 
        {
            pad.get(0).getPosition()[0] = 520;   
        }
        
    }
    static void starDies(Star a)
    {
        if (stars.size() > 1)
        {
            stars.remove(a);
        }
        else
        {
            walls.get(0).getPosition()[0] = 300;
            walls.get(0).getPosition()[1] = 430;
            stars.get(0).getPosition()[0] = 300;
            stars.get(0).getPosition()[1] = 400;
            stars.get(0).getVelocity()[0] = 0;
            stars.get(0).getVelocity()[1] = 0;
            spawned = false;
            life--;
        }
    }
    

}