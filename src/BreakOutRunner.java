import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions: Go to all the other labs and press F9 (build) on each of them in order. 
 *				then come back to this runner and press F10 (run);
 *				Then follow the directions in the other labs starting with Lab01.
 */

class BreakOutRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public BreakOutRunner()
	{
		super("BreakOut");

		setSize(WIDTH,HEIGHT);

		//This line loads the BreakOut game
		getContentPane().add( new BreakOut() );
				
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		BreakOutRunner run = new BreakOutRunner();
	}
}