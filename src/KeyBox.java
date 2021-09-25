import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

// this is only to test if the keys are pressed.
class KeyBox extends Canvas implements KeyListener
{
	private String key;
	private boolean space;
	
		//this is the constructor
	public KeyBox( )
	{	
		key = "NO VALUE YET";
		space = false;
		addKeyListener( this );
		setFocusable( true );
	}

	public void paint( Graphics window )
	{									
		window.setColor(new Color(212,175,55)); // try changing the color, look up RGB color codes
		window.fillRect(0,0,800,600);
		
		
		
		window.setColor(Color.BLACK);	// try changing the color, look up the Color class in Java	
		window.drawString( key, 250, 250 );
		
		if(space){
			window.setColor(new Color( 190, 30, 50));	
			window.drawString( "Now go to Ex02_KeyBox.java and change/add stuff!!", 200, 200 );
		}
		else{
			window.setColor(new Color( 190, 30, 50));	
			window.drawString( "Try Pressing the Spacebar!", 200, 200 );
		}
		
			
	}
	
	public void keyTyped(KeyEvent e)
	{
		keyPressed( e );			
	}
		
	public void keyPressed(KeyEvent e)
	{
		if( e.getKeyCode()  == KeyEvent.VK_SPACE ) 
		{
			key = "Key pressed " + e.getKeyCode();
			repaint();
		}
		// copy/paste the code & change the key, then test the code.
					
	}
				
	public void keyReleased(KeyEvent e)
	{
		if( e.getKeyCode()  == KeyEvent.VK_SPACE )
		{
			space = true;
		}
	}
}