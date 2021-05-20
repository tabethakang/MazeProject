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


public class MazeProjectCanvas extends Canvas
{
   //make array for maze
   int [][] mazeArray = new int [21][21];
   //graphics context
   GraphicsContext gc = getGraphicsContext2D();
   
   //variables for positions, x and y should start at 0
   int posX = 0;
   int posY = 0;
   //variable for key code
   KeyCode code;
   
   //constructor
   public MazeProjectCanvas()
   {  
      //try and catch so that it catches if file not found    
      try
      {
         //scanner to read in the text
         Scanner scan = new Scanner(new File("mazeGame.txt"));
         
         //set width and height to 525
         setWidth(525);
         setHeight(525);
         
         //for loop to go through the rows and columns               
         for (int j=0; j<21; j++)
         {
            for (int i=0; i<21; i++)
            {
               //scan array(txt file) for numbers
               int num = scan.nextInt();
               mazeArray[i][j] = num;
            }
         }
       }
       
       //catch if fnfe
       catch(FileNotFoundException fnfe)
       {
         System.out.println("File does not exist!");
       }
      //draw 
      draw(gc);

   }
   
   //draw method
   public void draw(GraphicsContext gc)
   {
      //for loop for the rows and columns
      for (int i = 0; i < mazeArray.length; i++)
      {
         for(int j = 0; j<mazeArray.length; j++)
         {
            //if txt file has 0, make squares white
            if (mazeArray[i][j] == 0)
            {
               gc.setFill(Color.WHITE);
               gc.fillRect(i*25, j*25, 25 ,25);   
            }
            //if txt file has 1, make squares black
            if (mazeArray[i][j] == 1)
            {
               gc.setFill(Color.BLACK);
               gc.fillRect(i*25, j*25, 25 ,25);
            }        
         }
      }
      
      //for loop for the cyan square
      for (int i = 0; i<21; i++)
      {
         if (mazeArray[i][0] == 0)
         {
            posX = i*25;
         }         
      }
         //graphics for the cyan square
         gc.setFill(Color.CYAN);
         gc.fillRect(posX, 0, 25, 25);

   }
      
   //if up, down, left, right is pressed
   public void buttonKeys(KeyCode code)
   {        
         this.code = code;
           
         gc.clearRect(posX, posY, 25, 25);
         //if for if up key is pressed
         if (code == KeyCode.UP) 
         {
            if (posY > 0)
            {
             if(mazeArray[posX/25][(posY/25) -1] == 0)
             {
               // - 25 to Y
               posY = posY - 25;
             }  
             }
         }
          //if for if down key is pressed
          if (code == KeyCode.DOWN)
          {
            if (posY < 500)
            {
            if (mazeArray[posX/25][(posY/25) + 1] == 0)
            {
               // + 25 to Y
               posY = posY + 25;
            }
            }
          }
          //if for if left key is pressed
          if (code == KeyCode.LEFT) 
          {
            if (posX > 0)
            {
            if (mazeArray[(posX/25) -1][posY/25] == 0)
            {
               // -25 to X
               posX = posX -25;
            }
            }
          }
          //if for if right key is pressed
          if (code == KeyCode.RIGHT) 
          {
            if (posX < 500)
            {
            if(mazeArray[(posX/25) +1][posY/25] == 0)
            {
               // +25 to X
               posX = posX +25;
            }
            }
          }
          //cyan box that moves if key pressed
          gc.setFill(Color.CYAN);
          gc.fillRect(posX, posY, 25, 25);
          
          //when it reaches past posY of 20, the maze is finished and user wins
          if (posY/25 == 20)
          {
            if (mazeArray[posX/25][posY/25] == 0) 
            {
               System.out.println("You Win!!");
            }
          }        

      }
}
  