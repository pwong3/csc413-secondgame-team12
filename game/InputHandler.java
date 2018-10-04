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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class InputHandler extends JPanel implements  KeyListener {
    
    ArrayList <Wall> pad = new ArrayList<Wall>();
    public InputHandler(ArrayList <Wall> pad)
    {
        for (int i = 0; i< 1; i++)
        {
            this.pad.add(pad.get(i));
        }
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public synchronized void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //System.out.println(code);
        
        SwitcherA(code);
       
        
        
       
            
        
            
    }

    /**
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) 
    {
        
    }

    /**
     *
     * @param e
     */
    @Override
    public synchronized void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        //System.out.println(code);
        SwitcherB(code);
        
        
    }
    
    
    public void SwitcherA(int code)
    {
        switch (code) 
        {
            case KeyEvent.VK_LEFT:
                //velY = 0;
                for (Wall a: pad)
                {
                    
                    a.getVelocity()[0] = -3;
                    a.movingHorizontally(true);
                }
                if (!Map.spawned && !Map.stars.isEmpty())
                {
                    Map.stars.get(0).getVelocity()[0] = -3;
                }
                break;
            case KeyEvent.VK_RIGHT:
                //velY = 0;
                for (Wall a: pad)
                {
                    a.getVelocity()[0] = 3;
                    a.movingHorizontally(true);
                }
                if (!Map.spawned && !Map.stars.isEmpty())
                {
                    Map.stars.get(0).getVelocity()[0] = 3;
                }
                break;
            case KeyEvent.VK_SPACE:
                if (!Map.spawned && !Map.stars.isEmpty())
                {
                    Map.stars.get(0).getVelocity()[0] = 1;
                    Map.stars.get(0).getVelocity()[1] = -1;
                    Map.spawned = true;
                    break;
                }
        }
    }
    
    public void SwitcherB(int code)
    {
        switch (code) 
        {
            case KeyEvent.VK_LEFT:
                //velY = 0;
                for (Wall a: pad)
                {
                    a.getVelocity()[0] = 0;
                    a.movingHorizontally(true);
                }
                if (!Map.spawned && !Map.stars.isEmpty())
                {
                    Map.stars.get(0).getVelocity()[0] = 0;
                }
                break;
            case KeyEvent.VK_RIGHT:
                //velY = 0;
                for (Wall a: pad)
                {
                    a.getVelocity()[0] = 0;
                    a.movingHorizontally(true);
                }
                if (!Map.spawned && !Map.stars.isEmpty())
                {
                    Map.stars.get(0).getVelocity()[0] = 0;
                }
                break;
            case KeyEvent.VK_SPACE:
                
                break;
        }
    }


}