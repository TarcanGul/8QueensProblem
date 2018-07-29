import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
/**
 * BoardComponent is a extended JComponent class. This is where math is implemented to GUI.
 * @author tarcan gul
 *
 */
public class BoardComponent extends JComponent
{
   
   JPanel panel = new JPanel();//JPanel object which is needed as a parameter in the constructor.
   int trigger = 0;//This is the integer variable which we will use for navigating inside any solution arraylist.
   TButton forward;//The forward navigation button which has ">>" on it.
   TButton back;//The backward navigation button which has "<<" on it.
   boolean flag = true;//The flag which we use in paintComponent to achieve some operations exactly once no matter how many times the computer repaint() it.
   SquareButton square;//The reference variable for all buttons we add to the chess board.
   private int target_row = 0;//The row number of the selected square. Default set to 0.
   private int target_col = 0;//The column number of the selected square. Default set to 0.
   private ArrayList<Solution> solutions = new ArrayList<Solution>();//The arraylist which stores the solutions of a specific square.
   private final int SIZE = 8;//The size of the n*n board. Can take up values from 4 to 9.

   /**
    * The constructor.
    * @param p JPanel object which we will add our buttons to.
    */
   public BoardComponent(JPanel p)
   {
     panel = p;//Adding value to our instance variable.
     
     forward = new TButton(630,500,50,50,">>");//Creating a new TButton object with location, size and title.
     back = new TButton(580,500,50,50,"<<");//Creating a new TButton object with location, size and title.
     
     //Adding the action listener for the forward button.
     forward.addActionListener(new ActionListener(){
   //Every time we press...
   public void actionPerformed(ActionEvent ae)
   {
    trigger++;//Every time the forward button pressed, we increase the trigger by one, meaning we are going to the next item in the arraylist. 
   }
   
  });
   //Adding the action listener for the forward button.
  back.addActionListener(new ActionListener(){
   //Every time we press...
   public void actionPerformed(ActionEvent ae)
   {
     trigger--;//Every time the back button pressed, we decrease the trigger by one, meaning we are going to the previous item in the arraylist. 
     
   }
    
  });
   }
   
   @Override
   /**
    * The paintcomponent method draws the texts, and update the screen when solution changes. We also draw the chessboard here.
    * @param Graphics g graphics object which is the tool that draws on the frame.
    */
   
   public void paintComponent(Graphics g)
   {
     drawButtonsChessBoard(SIZE);//Drawing the chess board with buttons, taking SIZE as a parameter.
     
    //The flag was set to true at the start of the class, at the end of the execution it will be false and the lines inside will never execute again.
    if(flag)
    {
     panel.add(forward);//Adding the forward button to panel(which was the parameter of the constructor).
     panel.add(back);//Adding the back button to panel(which was the parameter of the constructor).
     flag = false;//We now set the flag as false, now the two last lines will never execute over and over again, meaning the program will be more efficient.
    }
    
     Graphics2D g2 = (Graphics2D) g;//Casting Graphics object to Graphics2D object. We do this because Graphics2D is the updated version, meaning it is easier to use and there are more possibilities. 
      
     //DEPENDENCY!
     EightQueensSolution sa = new EightQueensSolution(SIZE);//Solving the Queens Problem mathematically using SolutionAlgorithm class. Taking size as input.
     
     //For each solution found by solution algorithm...
     for(Solution s: sa.getSolutions())
  {
      //if the solution includes the row and column numbers of the selected(target) square button, add it to solutions arraylist.
   if(s.getSolution()[target_row][target_col])
   {
    solutions.add(s);
   }
  }
     //if trigger is smaller than 0, we can't access to the arraylist so...
     if(trigger < 0)
     {
      trigger = 0;//We only want trigger to stay at 0, no matter how many times we press the back button.
     }
     //if trigger is bigger than n-1, we can't access to the arraylist so...
     else if(trigger > solutions.size()-1)
     {
      trigger = solutions.size()-1;//We only want trigger to stay at n-1, no matter how many times we press the forward button.
     }
     //After setting the trigger so it is not out of bounds, we take the solution from the solutions arraylist using trigger as index, thus we can navigate with buttons.
     Solution s = solutions.get(trigger);
     
     //Setting the solution up on the frame, using the solution and g2 as arguments.
     setSolution(s,g2);
     
     g2.setColor(Color.BLACK);//Setting the g2 brush color as black.
     g2.setFont(new Font("Times New Roman", Font.PLAIN, 20));//Setting the font of g2 object, the magical brush.
     
     //Printing different instructions with g2, using string and location.
     g2.drawString("Solution number: " + String.valueOf(trigger + 1),100,600);//trigger acts like index but when printing we want a counting number so we just add one.
     g2.drawString("Possible "+solutions.size()+" solutions from chosen point.", 230, 630);//Solutions.size() is the possible solutions from that point.
     g2.drawString("There are total "+sa.getSolutionNumber()+" solutions.", 300, 600);//sa.getNumSols() is the total number of all solutions.
     
     g2.setColor(Color.RED);//Setting the g2 brush color as red.
     g2.setFont(new Font("Times New Roman", Font.BOLD, 12));//Setting the font of g2 object, the magical brush.
     
     //Printing an instruction with g2 using string and location.
     g2.drawString("Welcome to 8 Queens solver! Choose any square you want to, for seeing how many solutions are available from that point.",10,20);
     //Whenever the navigation buttons are activated.
     if(forward.isEnabled() || back.isEnabled())
     {
      solutions.clear();//We clear the solutions arraylist so it doen't add up with previous solutions. Solutions arraylist shoud store unique solutions for different squares. So before updating, we clear the solutions.
      repaint();//Updating the component, thus the frame.
     }
   }
   
   /**
    * Draws a chessboard using black and white square buttons, which is another class I wrote.
    * @param size the number n in n*n chessboard.
    */
   public void drawButtonsChessBoard(int size)
   {
    //Setting initial coordinates of the board, we will start adding from here.
    int x = 40;
    int y = 40;
      
      //Enhanced for loop is used because we need to iterate through a 2D mechanism.
      for(int r = 0; r < size ;r++)
      {
        for(int c = 0; c < size; c++)
        {
          //Adding a new square button. Parameters are row and column numbers.
          square = new SquareButton(r,c);
          //Setting the location of the buttons using row and column numbers since all the buttons will have their unique r and c numbers.
          square.setLocation(x+60*r,y+60*c);
          
          
          if(r % 2 == 1)
          {
            if(c%2 == 1)
            {
           //The left top corner of a chessboard is white. So I started from here.
              square.setBackground(Color.WHITE);
            }
            else
            {
             //Setting the color black the square next to the white square in the same column.
             square.setBackground(Color.BLACK);
            }
            
          }
          //Setting the colors of the button one by one.
          else
          {
            if(c%2 == 0)
            {
             square.setBackground(Color.WHITE);//Setting the button color white.
            }
            else
            {
             square.setBackground(Color.BLACK);//Settşng the button color black.
            }
          }
          //Adding the same actionlisteners for added n*n buttons.
          square.addActionListener(new ActionListener(){
     //After a square is pressed...
     public void actionPerformed(ActionEvent ae)
     {
      Object button = ae.getSource();//We first reach to the button inside a actionlistener object. getSource() does that.
      if(button instanceof SquareButton)//if the source is instance of square button(which it should be.)
      {
       target_row = ((SquareButton) button).getRow();//Getting the row number of selected square.
       target_col = ((SquareButton) button).getColumn();//Getting the column number of selected square.
      }
      
      trigger = 0;//Because the solutions will refresh, I also start the trigger right at the beginning. Also this will handle some errors, for example from a 12. solution if you jump to a square with 4 solutions, it will give error normally. By setting trigger to zero every time we press a square prevents that.
      
      
     }
     
    });
          panel.add(square);//Adding the square button to panel.
       
            
        }
      }
   }
   /**
    * Putting a queen to a specified row and column number.
    * @param a row number
    * @param b column number
    * @param g2 Graphics2D object which helps to draw.
    */
   public void putQueen(int a, int b, Graphics2D g2)
   {
     
     File file = new File("queen.png");//Getting the image file from eclipse project folder.
     String location = file.getAbsolutePath();//Finding the absolute path of the file, so we can reach it.
     //There can be a case where the file cannot be found, thus we need a try catch block.
     try
     {
       BufferedImage queen = ImageIO.read(new File(location));//If the file is found, we read it.
       g2.drawImage(queen,40 + 60*(a),40 + 60*(b),60,60,null);//We draw the image using g2.
     }
     catch(Exception e)
     {
       e.printStackTrace();//If the file is not found, print the error.
     }
     
     
     
   }
   /**
    * Setting the solution on to the frame.
    * @param s The solution object which has queen's coordinates.
    * @param g2 Graphics2D object which will draw. 
    */
   public void setSolution(Solution s,Graphics2D g2)
   {
    //Using enhance for loop because we are iterating through every row and column position.
    for(int i = 0; i < s.getSize(); i++)//s.getSize() is size of the board.
    {
     for(int j = 0; j < s.getSize();j++)
     {
      //If a spesific position is true, since s is a boolean array, it means this position have a queen. We draw the queen here.
      if(s.getSolution()[i][j])
      {
       putQueen(i,j,g2);//Putting the Queen in this spesific coordinate.
      }
     }
    }
   }
}
