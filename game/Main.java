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
import java.awt.Dimension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.swing.*;
public class Main
{
    
    public static void main(String[] args) throws MidiUnavailableException, FileNotFoundException, IOException, InvalidMidiDataException
    {
        
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        InputStream music = new BufferedInputStream(new FileInputStream(new File("images/Music.mid")));
        sequencer.setSequence(music);
        sequencer.start();
        
        Map map = new Map("Reef Game: Score ");
       
        map.setPreferredSize(new Dimension(640, 500));
        map.setMaximumSize(new Dimension(640, 500));
        map.setMinimumSize(new Dimension(640, 500));
        //map.pack();
        
        map.setResizable(false);
        
        map.run();
        
        map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
           
        
    }
    
}