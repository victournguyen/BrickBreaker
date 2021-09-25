import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;


/*
 *		Directions: Follow the directions in order. 
 *		(1) Paddle
 *			(1A) Make the paddle show up on the screen
 *			(1B) Make the paddle move
 *		(2) Ball
 *			(2A) Make the ball show up on the screen
 *			(2B) Make the ball bounce after you press the space bar
 *		(3) Make the bricks work
 *			(3A) Initialize the list of bricks
 *			(3B) add bricks to the list
 *			(3C) make the bricks show up on the screen
 *		(4) make the ball bounce off the paddle
 *		(5) make the ball bounce off the bricks
 *		(6) remove the bricks that get hit by the ball
 *		Test after each step.
 *
 *		Add methods, constructors, instance variables anywhere that is needed
 *		to enhance the game.
 *
 *		To get full credit you need to add two more features that are not included.
 */

class BreakOut extends JPanel implements Runnable, KeyListener
{
		private boolean[] keys; // this stores booleans for when a key is pressed or not.
			
		private Paddle pad;	// this is the paddle that moves across the bottom of the screen

		private Ball ball; // this is the ball that bounces around the screen

		private ArrayList< Brick > bricks; // this is the list of bricks that are to be drawn on the screen
		
		private int lives;

	
	public BreakOut() // create all instance in here
	{
		setBackground(Color.WHITE);
		
		lives = 3;

		//make the keys array big enough to store all keys pressed
		keys = new boolean[3];		// scroll down to see the keyPressed method
		
		pad = new Paddle(300, 530, 200, 20, 15); /* (1A) initialize the Paddle, put the paddle close to the bottom of the screen. */
	
		/* (2A) initialize the Ball, put the ball on the paddle. */
		
		ball = new Ball(pad.getX() + pad.getW() / 2 - 13, pad.getY() - 25, 25, 25, 4);
		
		
		/* (3A)initialize the ArrayList<Brick> */
		
		bricks = new ArrayList<Brick>();
		
		/* (3B) make a for loop to add Bricks to your ArrayList< Brick >
		 * 		bricks.add( new Brick( x, y , w, h ) );
		 * 		each brick will need to have different x & y coordinates, but same width and height
		 * 		the x & y coordinates should be based on the width and height you choose
		 */
		
		for (int x = 0; x < 24; x++) {
			//bricks.add(new Brick(x * 50, x * 40, 50, 40));
			int wh = (int) (Math.random() * 75 + 25);
			int xs = 800 - wh;
			int ys = 400 - wh;
			bricks.add(new Brick((int) (Math.random() * xs), (int) (Math.random() * ys), wh, wh));
		}
		
		addKeyListener( this );   	//
		setFocusable( true );		// Do NOT DELETE these three lines
		new Thread(this).start();	//
	}
	
	public void reset() {
		pad.setX(400 - pad.getW() / 2);
		pad.setY(530);
		ball = new Ball(pad.getX() + pad.getW() / 2 - 13, pad.getY() - 25, 25, 25, 4);
		keys[0] = false;
	}

	public void paint( Graphics window )// all other paint methods and game logic goes in here.
	{
		window.drawImage(new ImageIcon("background.png").getImage(), 0, 0, 800, 600, this);
		if (lives <= 0) {
			window.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			window.setColor(Color.RED);
			window.drawString("Game Over", 265, 300);
			return;
		}
		if (bricks.size() == 0) {
			window.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			window.setColor(Color.GREEN);
			window.drawString("You Win!", 295, 300);
			return;
		}
		
		switch (bricks.size()) {
			case 20:
				pad.setW(180); pad.setH(20); break;
			case 16:
				pad.setW(160); pad.setH(18); break;
			case 12:
				pad.setW(140); pad.setH(16); break;
			case 8:
				pad.setW(120); pad.setH(12); break;
			case 4:
				pad.setW(100); pad.setH(10); break;
		}
		
		//window.setColor(Color.WHITE); window.fillRect( 0,0, 800, 600); // makes the background white
		//window.setColor(Color.BLACK); window.drawRect( 0,0, 800, 600); // draws a black box around the outside
		

		window.setColor(Color.ORANGE); // to change fonts, color, etc: go to the Graphics Intro Folder
		window.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + " , " + MouseInfo.getPointerInfo().getLocation().y + ")", 10, 553);
		window.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		window.setColor(Color.BLUE);
		window.drawString("Lives: " + lives, 666, 550);
		
		pad.paint( window );   //(1A) paints the paddle	
		/* (2A)  paint the ball */
		ball.paint(window);
		/* (3C) paint the bricks, must use a loop to paint each brick individually */
		
		for (Brick item : bricks) {
			item.paint(window);
		}
		
		if(keys[0]) // space is pressed
		{
			/* (2B) make the ball bounce, this runs after you press the space bar */
			ball.bounce();
		}
		if(keys[1]) // Left Arrow is pressed
		{
			/* (1B) move paddle left */
			pad.goLeft();
		}
		if(keys[2]) // Right Arrow is pressed
		{	
			/*(1B) move paddle right */
			pad.goRight();
		}
		
		if (ball.getY() > 600 - ball.getH()) {
			reset();
			lives--;
		}
		
		/* (4) test if the ball is hitting the paddle, make the ball bounce off */
		
		if (pad.intersects(ball)) {
			ball.bouncey();
		}
		
		/* (5) test if the ball is hitting a brick, make the ball bounce off */
		/* (6) then remove the brick that got hit */
		
		for (int i = 0; i < bricks.size(); i++) {
			if (ball.intersects(bricks.get(i))) {
				ball.bouncey();
				bricks.remove(i);
			}
		}
		
		
						
	}
	

// only edit if you would like to add more key functions	
	public void keyPressed(KeyEvent e)
	{   
		//Java KeyEvent docs
		//https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html
		
		if( e.getKeyCode()  == KeyEvent.VK_SPACE )
		{
			keys[0] = true;
		}
		
		if( e.getKeyCode()  == KeyEvent.VK_LEFT )
		{
			keys[1] = true;
		}
		
		if( e.getKeyCode()  == KeyEvent.VK_RIGHT )
		{
			keys[2] = true;
		}					
	}
/*****~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*****/	
// do not edit anything from this point on!!!
	public void keyTyped(KeyEvent e)
	{
		keyPressed( e );			
	}		
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[2] = false;
		}
	}	
	
	public void run()
	{
		try
		{
			while( true )
			{	
			   Thread.sleep( 10 );
			   repaint();
			}
		}
		catch( Exception e )
		{			
		}
	}
}