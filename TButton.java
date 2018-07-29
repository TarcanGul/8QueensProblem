import javax.swing.*;
import java.awt.event.*;
/**
 * TButton is the navigation buttons on the frame. Extends JButton.
 * @author tarcan gul
 *
 */
public class TButton extends JButton 
{
	
	/**
	 * Constructs a new button.
	 * @param x : x coordinate
	 * @param y : y coordinate
	 * @param w : width
	 * @param h : height
	 * @param text : title
	 */
	public TButton(int x, int y,int w,int h,String text)
	{
		super(text);//Using a default JButton constructor which has a String parameter.
		setLocation(x,y);//Setting the location using x and y coordinates.
		setSize(w,h);//Setting size using the width and height.
		
	}

}
