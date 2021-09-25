import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions: extend the Block class to use the Block methods
 *
 *				Override the paint method to draw a Ball
 *				
 *				Make an xspeed and a yspeed instance variable in order to make the ball bounce
 *				
 *				Create a Ball constructor, using the Paddle constructor as an example, it can still take
 *				in just one speed, then set both instance variables to that one speed.
 *				
 *				Create a bounce method that keeps the ball on the screen but bounces around the screen.
 *				Do NOT test if the ball is touching the bricks or the paddle in this method, you will do that
 *				in the game logic in BreakOut.java.
 *
 *				Go to BreakOut and do Step 2 and test it in the runner.
 *
 *				If all works then move on to Brick
 *				
 */

class Ball extends Block
{
	private int xspeed, yspeed;
	
	public Ball() {
		super();
		xspeed = 7;
		yspeed = 7;
	}
	public Ball(int x, int y, int w, int h, int speed) {
		super(x, y, w, h);
		xspeed = speed;
		yspeed = speed;
	}
	
	public void paint(Graphics window) {
		//window.setColor(new Color(59, 212, 255));
		/*window.setColor(new Color(252, 124, 212));
		window.fillOval(getX(), getY(), getW(), getH());*/
		Graphics2D g2 = (Graphics2D) window;
		Image img1 = Toolkit.getDefaultToolkit().getImage("fireball.png");
		g2.drawImage(img1, getX(), getY(), getW(), getH(), this);
	}
	
	public void bounce() {
		if (getX() > 800 - getW() - 10 || getX() < 0) {
			xspeed *= -1;
		}
		if (getY() > 600 - getH() || getY() < 0) {
			yspeed *= -1;
		}
		setX(getX() + xspeed);
		setY(getY() + yspeed);
	}
	public void bouncey() {
		yspeed *= -1;
	}
	public void bouncex() {
		xspeed *= -1;
	}
}