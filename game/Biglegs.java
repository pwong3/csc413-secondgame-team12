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
 * @author patri
 */
public class Biglegs extends Sprite{
    private int id;
    int [] position = new int[2];
    int [] velocity = new int[2];
    String sep = System.getProperty("file.separator");
    Image img = null;
    
    public Biglegs(int x, int y)
    {
        this.position[0] = x;
        this.position[1] = y;
    }
    public Image getImage()
    {
         img = new ImageIcon("images"+ sep +"Bigleg_small1.gif").getImage();
         return img;
    }

    @Override
    int[] getPosition() {
        return position;
    }

    @Override
    int[] getVelocity() {
        return velocity;
    }
    
}
