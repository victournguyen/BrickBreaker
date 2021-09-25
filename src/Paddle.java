import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions: 
 *				In the paint method Choose if you want to draw your paddle or 
 *				if you want to use an image to make a paddle.
 *				
 *				Finish the goLeft & goRight methods
 *
 *				Go to BreakOut and do Step 1.
 *				Then test it out in the runner.
 *				If all of the paddle works move on to Ball
 */
 
 
class Paddle extends Block
{
	private int speed; // a paddle has to have a speed to make it move
	
	public Paddle() {
		this(300, 530, 200, 20, 15);
	}
	public Paddle( int ex, int wy, int wd, int ht, int sp)
	{
		//write the code for the Paddle constructor
		//must have a super constructor call
		super(ex, wy, wd, ht);
		speed = sp;
	}
	
	public void goLeft()
	{
	  setX( getX() - speed ); // because a paddle is a block it has the setX and getX methods
	  
	  // add the code to keep the paddle from going off the screen to the left.
	  if (getX() < 0) {
		  setX(0);
	  }
	  
	}

	public void goRight() 
	{
	  //add code to move to the right
		setX(getX() + speed);
	  
	  // keep the paddle from going off the screen to the right.
		if (getX() > 800 - getW()) {
			setX(800 - getW());
		}
	}	
	
	//overidde paint to draw your Paddle
	public void paint( Graphics window )
	{
		
		// drawing methods for Java: 
		// go to the Graphics Intro Folder
		/*
		window.setColor(Color.RED);
		window.fillRect(getX(), getY(), getW(), getH());
		window.setColor(Color.BLACK);
		window.drawRect(getX(), getY(), getW(), getH());
		*/

		//find and image for your paddle and put it here
    		Graphics2D g2 = (Graphics2D) window;
    		Image img1 = Toolkit.getDefaultToolkit().getImage("paddle.png"); //use .gif or .png, you can choose the image
    		g2.drawImage(img1, getX(), getY(), getW(), getH(), this);
    	
	}	
		
}