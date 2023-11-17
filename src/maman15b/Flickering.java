/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maman15b;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * a class that flicking the green light to 
 * let the people on the street that that they can cross the street
 * @author abargel_ido
 */
public class Flickering extends Thread{
    public static final int lEFTTTORIGHT=1,TOPTOBUTTON = 0;
    private TrafficThreads trf;

    public Flickering(TrafficThreads trf) {
        this.trf = trf;
    }
    
    public void run()
    {
         while (true)
        {    
            trf.setFill();  //set fill from
            
            if (trf.counter%2==lEFTTTORIGHT)   //to know wich direction should be flicked
                trf.leftToRight();
            else
                trf.topToBottom();
            try {
            Thread.sleep(300);  //flickering every 200 mili seconds
        } catch (InterruptedException ex) {
            Logger.getLogger(TrafficThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}
