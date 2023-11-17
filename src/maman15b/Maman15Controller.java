/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package maman15b;

import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.runLater;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

/**
 * FXML Controller class
 *
 * @author abargel_ido
 */
public class Maman15Controller implements Initializable {

    @FXML
    private Canvas canvas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         GraphicsContext gc = canvas.getGraphicsContext2D(); //our canvas
         makeShapes(gc); //create the strocks
         
         TrafficThreads trf = new TrafficThreads(gc,canvas);
         ChangeSides cng  = new ChangeSides(trf);   //change sides thread
         Flickering flk = new Flickering(trf);      // flickering thread
         
         flk.start();
         cng.start();
         
    }    
    
    public void makeShapes(GraphicsContext gc)  // first time creating the shapes
    {
        //top middle
        gc.strokeOval(canvas.getWidth()/2,canvas.getHeight()/20,30,30);
        gc.strokeOval(canvas.getWidth()/2,canvas.getHeight()/20+32,30,30);
        gc.strokeRect(canvas.getWidth()/2+5, canvas.getHeight()/20+62, 20, 30);
        gc.strokeRect(canvas.getWidth()/2+5, canvas.getHeight()/20+92, 20, 30);
        
        //bottom middle
        gc.strokeOval(canvas.getWidth()/2,canvas.getHeight()-152,30,30);
        gc.strokeOval(canvas.getWidth()/2,canvas.getHeight()-120,30,30);
        gc.strokeRect(canvas.getWidth()/2+5, canvas.getHeight()-89, 20, 30);
        gc.strokeRect(canvas.getWidth()/2+5, canvas.getHeight()-59, 20, 30);
        
        //left
        gc.strokeOval(30,canvas.getHeight()/3,30,30);
        gc.strokeOval(30,canvas.getHeight()/3+32,30,30);
        gc.strokeRect(35, canvas.getHeight()/3+62, 20, 30);
        gc.strokeRect(35, canvas.getHeight()/3+92, 20, 30);
        
        
        //right
        gc.strokeOval(canvas.getWidth()-40,canvas.getHeight()/3,30,30);
        gc.strokeOval(canvas.getWidth()-40,canvas.getHeight()/3+32,30,30);
        gc.strokeRect(canvas.getWidth()-35, canvas.getHeight()/3+62, 20, 30);
        gc.strokeRect(canvas.getWidth()-35, canvas.getHeight()/3+92, 20, 30);
        
    }
}
