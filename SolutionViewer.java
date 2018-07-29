import javax.swing.*;
/**
 * The main class. Sets the frame and puts the panel in it.
 * 
 * @author tarcan gül
 *
 */
public class SolutionViewer 
{
	public static void main(String[] args)
	{
		
		
		JFrame frame = new JFrame("Queens");//Creating a new frame object.
	    frame.setSize(700,700);//Setting the frame's size 700*700.
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Make it close when we press the x on the top right corner.
	    
	    BoardPanel panel = new BoardPanel();//Creating a new JPanel objects.
	    frame.add(panel);//Adding the panel to frame.
	    frame.setVisible(true);//Setting the frame visible.
	    
	}
}
