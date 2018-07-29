import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
/**
 * The panel class which extends JPanel.
 * 
 * @author tarcan gül
 *
 */
public class BoardPanel extends JPanel
{
 /**
  * BoardPanel constructor. No arguments needed. Only sets the panel up.
  */
 public BoardPanel()
   {
     setLayout(new GridLayout(1,2));//Setting the layout of the panel. We will add component here, so it is important to set the layout before adding things to panel.
     
     BoardComponent component = new BoardComponent(this);//Setting up a new component object which takes the panel as a parameter.
     add(component);//Adding the component to panel.
     
   }
}
