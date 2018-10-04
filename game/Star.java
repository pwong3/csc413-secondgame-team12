/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author luisf
 */
public class Star extends Sprite
{
    int [] position = new int[2];
    int [] velocity = new int[2];
    double angle;
    String sep = System.getProperty("file.separator");
    Image img = null;
    
    
    public Star()
    {
        position[0] = 300;
        position[1] = 400;
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

    @Override
    Image getImage()
    {
        img = new ImageIcon("images"+ sep +"reef.png").getImage();
        angle = Math.atan2(velocity[1], velocity[0]);
        return img;
    }
    
}