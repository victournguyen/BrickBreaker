import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

class KeyBoxRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public KeyBoxRunner()
	{
		super("Key Box Runner");

		setSize(WIDTH,HEIGHT);

		//This line loads the KeyBox
		getContentPane().add( new KeyBox() );
				
		setVisible(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		KeyBoxRunner run = new KeyBoxRunner();
	}
}