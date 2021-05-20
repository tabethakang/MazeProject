//maze project by tabetha kang

//all imports
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import java.net.*;
import javafx.geometry.*;

public class MazeProject extends Application
{
   //make flow pane
   FlowPane root = new FlowPane();
   //canvas
   MazeProjectCanvas mazeCanvas = new MazeProjectCanvas();
   //add gc graphics context
   GraphicsContext gc = mazeCanvas.getGraphicsContext2D();
   
   //start method
   public void start (Stage stage)
   {
      //set size to 525x525
      root.setPrefSize(525,525);
      //add canvas to flowpane
      root.getChildren().add(mazeCanvas);
      
      //set scene and title
      Scene scene = new Scene(root, 525, 525);      
      stage.setScene(scene); 
      //title
      stage.setTitle("A very cool and fancy maze game!");           
      stage.show();
      
      root.requestFocus();
      //set on key press for key listener 
      root.setOnKeyPressed(new KeyListenerDown());
      
      //draw from canvas
      mazeCanvas.draw(gc);
   }
   
   //main method
   public static void main (String[] args)
   {
      launch(args);
   }
   
   //key listener 
   public class KeyListenerDown implements EventHandler<KeyEvent>
   {
      public void handle(KeyEvent event) 
      {
         //initialize key code 
         KeyCode pressed = event.getCode();
         mazeCanvas.buttonKeys(pressed);
      }
   }
}

//check if 0, if 0 then change variable