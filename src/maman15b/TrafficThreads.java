/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maman15b;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *a class that include all the fills that needs to be done
 * for traffic threads
 * @author abargel_ido
 */
public class TrafficThreads extends Thread {

    public GraphicsContext gc;
    private Canvas canvas;
    public int counter;
    private int i;
    
    
    public TrafficThreads(GraphicsContext gc,Canvas canvas) {   //builder
        
       this.gc = gc;
       this.canvas = canvas;
       counter=0;
    }
    
    public void setFill()   //setting the fill according to the index for flickering
    {
        if (i%2==1)
            gc.setFill(new Color(0,0,0,1));
        else
            gc.setFill(new Color(0,1,0,1));
    }
    
    public void leftToRight()   //fill the shapes for flickering
    {
        gc.fillOval(30,canvas.getHeight()/3+32,30,30);
        gc.fillOval(canvas.getWidth()-40,canvas.getHeight()/3+32,30,30);
        gc.fillRect(canvas.getWidth()/2+5, canvas.getHeight()/20+92, 20, 30);
        gc.fillRect(canvas.getWidth()/2+5, canvas.getHeight()-59, 20, 30);
        i++;
        if (i==1000)//eliminate stack over flow
            i=0;
        
    }
    
    public void topToBottom()   //fill the shapes for flickering
    {
        gc.fillOval(canvas.getWidth()/2,canvas.getHeight()/20+32,30,30);
        gc.fillOval(canvas.getWidth()/2,canvas.getHeight()-120,30,30);
        gc.fillRect(35, canvas.getHeight()/3+92, 20, 30);
        gc.fillRect(canvas.getWidth()-35, canvas.getHeight()/3+92, 20, 30);
        i++;
        if (i==1000)//eliminate stack over flow
            i=0;
    }
    
    public void fillShapeRightToLeft(GraphicsContext gc)    //fill the shape for side change
    {
        //green fill
         gc.setFill(new Color(0,1,0,1));
         gc.fillOval(30,canvas.getHeight()/3+32,30,30);
         gc.fillOval(canvas.getWidth()-40,canvas.getHeight()/3+32,30,30);
         gc.fillRect(canvas.getWidth()/2+5, canvas.getHeight()/20+92, 20, 30);
         gc.fillRect(canvas.getWidth()/2+5, canvas.getHeight()-59, 20, 30);
         
         //red fill
         gc.setFill(new Color(1,0,0,1));   //red
         gc.fillOval(canvas.getWidth()/2,canvas.getHeight()/20,30,30);
         gc.fillOval(canvas.getWidth()/2,canvas.getHeight()-152,30,30);
         gc.fillRect(35, canvas.getHeight()/3+62, 20, 30);
         gc.fillRect(canvas.getWidth()-35, canvas.getHeight()/3+62, 20, 30);
         
         //clear fill
         gc.setFill(Color.LIGHTGRAY);
         gc.fillOval(canvas.getWidth()/2,canvas.getHeight()/20+32,30,30);
         gc.fillOval(canvas.getWidth()/2,canvas.getHeight()-120,30,30);
         gc.fillRect(35, canvas.getHeight()/3+92, 20, 30);
         gc.fillRect(canvas.getWidth()-35, canvas.getHeight()/3+92, 20, 30);
         
         gc.fillOval(30,canvas.getHeight()/3,30,30);
         gc.fillOval(canvas.getWidth()-40,canvas.getHeight()/3,30,30);
         gc.fillRect(canvas.getWidth()/2+5, canvas.getHeight()/20+62, 20, 30);
         gc.fillRect(canvas.getWidth()/2+5, canvas.getHeight()-89, 20, 30);
         
    }
    
    public void fillShapeTopToBottom(GraphicsContext gc)    //fill the shape for side change
    {
        //green fill
         gc.setFill(new Color(0,1,0,1));
         gc.fillOval(canvas.getWidth()/2,canvas.getHeight()/20+32,30,30);
         gc.fillOval(canvas.getWidth()/2,canvas.getHeight()-120,30,30);
         gc.fillRect(35, canvas.getHeight()/3+92, 20, 30);
         gc.fillRect(canvas.getWidth()-35, canvas.getHeight()/3+92, 20, 30);
         
         //red fill
         gc.setFill(new Color(1,0,0,1));   //red
         gc.fillOval(30,canvas.getHeight()/3,30,30);
         gc.fillOval(canvas.getWidth()-40,canvas.getHeight()/3,30,30);
         gc.fillRect(canvas.getWidth()/2+5, canvas.getHeight()/20+62, 20, 30);
         gc.fillRect(canvas.getWidth()/2+5, canvas.getHeight()-89, 20, 30);
         
         //clear fill
         gc.setFill(Color.LIGHTGRAY);
         gc.fillOval(30,canvas.getHeight()/3+32,30,30);
         gc.fillOval(canvas.getWidth()-40,canvas.getHeight()/3+32,30,30);
         gc.fillRect(canvas.getWidth()/2+5, canvas.getHeight()/20+92, 20, 30);
         gc.fillRect(canvas.getWidth()/2+5, canvas.getHeight()-59, 20, 30);
         
         gc.fillOval(canvas.getWidth()/2,canvas.getHeight()/20,30,30);
         gc.fillOval(canvas.getWidth()/2,canvas.getHeight()-152,30,30);
         gc.fillRect(35, canvas.getHeight()/3+62, 20, 30);
         gc.fillRect(canvas.getWidth()-35, canvas.getHeight()/3+62, 20, 30);
         
         
    }
     
}
