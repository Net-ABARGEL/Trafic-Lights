/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maman15b;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * a class that change the side of the traffic lights,
 * can work in parallel to other threads.(and will)
 * @author abargel_ido
 */
public class ChangeSides extends Thread {
        public static final int RIGHTTOLEFT=1,TOPTOBUTTON = 0;
        private TrafficThreads trf;
        
    
    public ChangeSides(TrafficThreads trf)
    {
        this.trf=trf;
    }
    
    
    public void run()
    {
        while (true)
        {
            if (trf.counter%2==RIGHTTOLEFT)   //to know wich direction shoud be filled
                trf.fillShapeRightToLeft(trf.gc);
            else
                trf.fillShapeTopToBottom(trf.gc);
            
            try {
                Thread.sleep(3000); //change the walking side every 3 sec
            } catch (InterruptedException ex) {
                Logger.getLogger(ChangeSides.class.getName()).log(Level.SEVERE, null, ex);
            }
            trf.counter++;//counter for the flicking
        }
    }
}
