import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * The button which we fill the chess board. Extends jbutton.
 * @author tarcan gul
 *
 */
public class SquareButton extends JButton 
{
	//Instance variables.
	private int r;//row
	private int c;//column

	
	/**
	 * 
	 * @param row : which row the button is in
	 * @param column : which column the button is in.
	 */
	public SquareButton(int row, int column)
	{
		
		super();//Getting the default constructor.
		setSize(60,60);//Setting the size of the buttons.
		//Setting up the instance variables.
		r = row;
		c = column;
		
		
	}

	//Because r is private, we need a accessor method.
	public int getRow()
	{
		return r;//Returns row number
	}
	//Because c is private, we need a accessor method.
	public int getColumn()
	{
		return c;//Returns column number.
	}
}
