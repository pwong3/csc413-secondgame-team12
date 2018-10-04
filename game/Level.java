/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Map.legs;
import static game.Map.walls;

/**
 *
 * @author patri
 */
public class Level {
   
    
    public Level()
    {
        
    }

    static void gameOver()
    {
        Map.stars.clear();
        //Map.walls.clear();
        //Map.legs.clear();
    }
    static void newLevel()
    {
        for(int i=1; i<Map.walls.size();i++)
        {
            Map.walls.remove(i);
        }
        Map.stars.clear(); 
        Star star = new Star();
        Map.stars.add(star);
    }
   
    static void createMapOne() {
         Biglegs bl1 = new Biglegs(160, 20);
        legs.add(bl1);
        Biglegs bl2 = new Biglegs(440, 20);
        legs.add(bl2);
        Wall wall1 = new Wall(false, 0, 24, "DOWN", 0, 0);    //left wall
        Wall wall2 = new Wall(false, 0, 16, "RIGHT", 40, 0);  //top wall
        Wall wall3 = new Wall(false, 0, 24, "DOWN", 600, 0);  //right wall
        Wall wall4 = new Wall(false, 0, 13, "DOWN", 120, 0);  //fixed column
        Wall wall5 = new Wall(false, 0, 13, "DOWN", 240, 0);  //fixed column
        Wall wall6 = new Wall(false, 0, 13, "DOWN", 360, 0);  //fixed column
        Wall wall7 = new Wall(false, 0, 13, "DOWN", 480, 0);  //fixed column
        Wall wall8 = new Wall(true, 1, 11, "DOWN", 40, 40);   //purple
        Wall wall18 = new Wall(true, 8, 1, "DOWN", 40, 20);   //life
        Wall wall9 = new Wall(true, 2, 11, "DOWN", 80, 40);   //yellow
        Wall wall19 = new Wall(true, 8, 1, "DOWN", 80, 20);   //heart
        Wall wall10 = new Wall(true, 3, 10, "DOWN", 160, 60); //red
        Wall wall11 = new Wall(true, 4, 8, "DOWN", 200, 20);  //green
        Wall wall22 = new Wall(true, 9, 1, "DOWN", 200, 180); //split
        Wall wall23 = new Wall(true, 4, 3, "DOWN", 200, 200); //green
        Wall wall12 = new Wall(true, 4, 8, "DOWN", 400, 20);  //green
        Wall wall24 = new Wall(true, 9, 1, "DOWN", 400, 180); //split
        Wall wall25 = new Wall(true, 4, 3, "DOWN", 400, 200); //green
        Wall wall13 = new Wall(true, 3, 10, "DOWN", 440, 60); //red
        Wall wall14 = new Wall(true, 2, 11, "DOWN", 520, 40); //yellow
        Wall wall20 = new Wall(true, 8, 1, "DOWN", 520, 20);  //heart
        Wall wall15 = new Wall(true, 1, 11, "DOWN", 560, 40); //purple
        Wall wall21 = new Wall(true, 8, 1, "DOWN", 560, 20);  //heart
        Wall wall16 = new Wall(true, 6, 12, "DOWN", 280, 20); //blue
        Wall wall17 = new Wall(true, 7, 12, "DOWN", 320, 20); //white  
        
    }

    static void createMapTwo() {
        Biglegs bl1 = new Biglegs(480, 100);
        legs.add(bl1);
        Biglegs bl2 = new Biglegs(480, 160);
        legs.add(bl2);
        Wall wall1 = new Wall(false, 0, 24, "DOWN", 0, 0);      //left wall
        Wall wall2 = new Wall(false, 0, 16, "RIGHT", 40, 0);    //top wall
        Wall wall3 = new Wall(false, 0, 24, "DOWN", 600, 0);    //right wall
        Wall wall4 = new Wall(false, 0, 4, "DOWN", 80, 80);     //fixed column 4
        Wall wall5 = new Wall(false, 0, 3, "RIGHT", 120, 140);  //fixed column 4
        Wall wall6 = new Wall(false, 0, 7, "DOWN", 160, 80);    //fixed column 4
        Wall wall7 = new Wall(false, 0, 7, "DOWN", 320, 80);    //fixed column 1
        Wall wall8 = new Wall(false, 0, 2, "RIGHT", 440, 80);   //fixed column 3
        Wall wall9 = new Wall(false, 0, 1, "RIGHT", 480, 140);  //fixed column 3
        Wall wall10 = new Wall(false, 0, 2, "RIGHT", 440, 200); //fixed column 3
        Wall wall11 = new Wall(false, 0, 7, "DOWN", 520, 80);   //fixed column 3
        Wall wall12 = new Wall(true, 1, 10, "DOWN", 40, 20);    //purple
        Wall wall13 = new Wall(true, 1, 10, "DOWN", 560, 20);   //purple
        Wall wall14 = new Wall(true, 2, 12, "RIGHT", 80, 20);   //yellow
        Wall wall15 = new Wall(true, 3, 12, "RIGHT", 80, 40);   //red
        Wall wall16 = new Wall(true, 4, 12, "RIGHT", 80, 60);   //green
        Wall wall17 = new Wall(true, 5, 3, "DOWN", 120, 80);    //teal
        Wall wall18 = new Wall(true, 5, 3, "DOWN", 120, 160);   //teal
        Wall wall19 = new Wall(true, 6, 3, "DOWN", 80, 160);    //blue
        Wall wall20 = new Wall(true, 7, 3, "DOWN", 200, 80);    //white
        Wall wall21 = new Wall(true, 7, 3, "DOWN", 200, 160);   //white
        Wall wall22 = new Wall(true, 6, 3, "DOWN", 240, 80);    //blue
        Wall wall23 = new Wall(true, 7, 3, "DOWN", 280, 80);    //white
        Wall wall24 = new Wall(true, 9, 2, "RIGHT", 240, 140);  //split
        Wall wall25 = new Wall(true, 6, 3, "DOWN", 240, 160);   //blue
        Wall wall26 = new Wall(true, 7, 3, "DOWN", 280, 160);   //white
        Wall wall27 = new Wall(true, 6, 3, "DOWN", 360, 80);    //blue
        Wall wall28 = new Wall(true, 7, 3, "DOWN", 400, 80);    //white
        Wall wall29 = new Wall(true, 8, 2, "RIGHT", 360, 140);  //life
        Wall wall30 = new Wall(true, 6, 3, "DOWN", 360, 160);   //blue
        Wall wall31 = new Wall(true, 7, 3, "DOWN", 400, 160);   //white
        Wall wall32 = new Wall(true, 5, 5, "DOWN", 440, 100);   //teal
        
    }

    static void createMapThree() {
        Biglegs bl1 = new Biglegs(160, 100);
        legs.add(bl1);
        Biglegs bl2 = new Biglegs(440, 100);
        legs.add(bl2);
        Wall wall1 = new Wall(false, 0, 24, "DOWN", 0, 0);      //left wall
        Wall wall2 = new Wall(false, 0, 16, "RIGHT", 40, 0);    //top wall
        Wall wall3 = new Wall(false, 0, 24, "DOWN", 600, 0);    //right wall
        Wall wall4 = new Wall(false, 0, 6, "DOWN", 80, 120);    //fixed column
        Wall wall5 = new Wall(false, 0, 6, "DOWN", 240, 120);   //fixed column
        Wall wall6 = new Wall(false, 0, 6, "DOWN", 360, 120);   //fixed column
        Wall wall7 = new Wall(false, 0, 6, "DOWN", 520, 120);   //fixed column
        //Wall wall8 = new Wall(false, 0, 1, "RIGHT", 120, 220);  //fixed left u bottom
        //Wall wall24 = new Wall(false, 0, 1, "RIGHT", 200, 220); //fixed left u bottom
        Wall wall25 = new Wall(true, 9, 1, "RIGHT", 160, 180);  //split
        //Wall wall9 = new Wall(false, 0, 1, "RIGHT", 400, 220);  //fixed right u bottom
        //Wall wall26 = new Wall(false, 0, 1, "RIGHT", 480, 220); //fixed right u bottom
        Wall wall27 = new Wall(true, 9, 1, "RIGHT", 440, 180);  //split
        Wall wall10 = new Wall(true, 1, 11, "DOWN", 40, 20);    //purple
        Wall wall11 = new Wall(true, 2, 5, "DOWN", 80, 20);     //yellow
        Wall wall12 = new Wall(true, 3, 11, "DOWN", 120, 20);   //red
        Wall wall13 = new Wall(true, 4, 4, "DOWN", 160, 20);    //green
        Wall wall28 = new Wall(true, 4, 2, "DOWN", 160, 140);   //green
        Wall wall29 = new Wall(true, 4, 2, "DOWN", 160, 200);   //green
        Wall wall14 = new Wall(true, 5, 11, "DOWN", 200, 20);   //teal
        Wall wall15 = new Wall(true, 6, 5, "DOWN", 240, 20);    //blue
        Wall wall16 = new Wall(true, 7, 6, "DOWN", 280, 20);    //white
        Wall wall33 = new Wall(true, 7, 4, "DOWN", 280, 160);   //white
        Wall wall32 = new Wall(true, 8, 2, "RIGHT", 280, 140);  //life
        Wall wall17 = new Wall(true, 6, 6, "DOWN", 320, 20);    //blue
        Wall wall34 = new Wall(true, 6, 4, "DOWN", 320, 160);   //blue
        Wall wall18 = new Wall(true, 7, 5, "DOWN", 360, 20);    //white
        Wall wall19 = new Wall(true, 5, 11, "DOWN", 400, 20);   //teal
        Wall wall20 = new Wall(true, 4, 4, "DOWN", 440, 20);    //green
        Wall wall30 = new Wall(true, 4, 2, "DOWN", 440, 140);   //green
        Wall wall31 = new Wall(true, 4, 2, "DOWN", 440, 200);   //green
        Wall wall21 = new Wall(true, 3, 11, "DOWN", 480, 20);   //red
        Wall wall22 = new Wall(true, 2, 5, "DOWN", 520, 20);    //yellow
        Wall wall23 = new Wall(true, 1, 11, "DOWN", 560, 20);   //purple
       
    }

}