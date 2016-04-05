/**
 * @author Harrison Leggio
 * Program 02 - Bing Bong
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball{

	private final int RADIUS = 20;			// radius of ball
	private double bounce = 0.9;			// bounce factor
	private final double GRAVITY = 0.5;		// gravity
	private double sX = 10;					// speed (x direction)
	private double sY = 10;					// spped (y direction)
	private int x;							// x coordinate of ball
	private int y;							// y coordinate of ball
	private Color color;					// color of ball
	


	/**
	 * Constructor of the ball class calls the methods that set the
	 * x and y coordinates as well as the color
	 */
	public Ball(){
		setX();
		setY();
		setColor();

	}

	/**
	 * setX method sets the x coordinate of the ball
	 */
	private void setX(){
		x = (int) (Math.random() * 500);
	}

	/**
	 * setY method sets the y coordinate of the ball
	 */
	private void setY(){
		y = (int) (Math.random() * 500);
	}

	/**
	 * setColor method sets the color of the ball to a random color
	 */
	public void setColor(){
		int R = (int)(Math.random()*256);
		int G = (int)(Math.random()*256);
		int B= (int)(Math.random()*256);
		color = new Color(R, G, B);
	}

	/**
	 * paint method paints the ball
	 * @param pane
	 */
	public void paint(Graphics pane){
		pane.setColor(color);
		pane.drawOval(x, y, RADIUS, RADIUS);
		pane.fillOval(x, y, RADIUS, RADIUS);
	}

	/**
	 * move method handles the physics behind the balls movement
	 * i.e the change of direction, the gravity, and the change
	 * of speed
	 */
	public void move(){
		x = (int) (x + sX);
		y = (int) (y + sY);
		sY += GRAVITY;
		if(y + RADIUS > 605){
			sY = -sY * bounce;
			y = 550;
			bounce = bounce/1.2;
		}	
		if(x - RADIUS < 0 && sX < 0){
			sX = -sX;
		}
		if(x - RADIUS > 470 && sX > 0){
			sX = -sX;
		}



	}



	/**
	 * check collision method takes in 2 balls
	 * and compares to see if they collide. if they collide,
	 * the speed in both the x and y direction are negated
	 * @param ball1
	 * @param ball2
	 */
	public static void checkCollision(Ball ball1, Ball ball2){
		
		ball1 = Collection.head.getBall();
		ball2 = Collection.head.getNext().getBall();
		if(ball1.x < ball2.x && ball1.x > ball2.x-20 && ball1.y+20 > ball2.y && ball1.y < ball2.y+20){
			ball1.sX = -ball1.sX;
			ball2.sX = -ball2.sX;

			ball1.sY = -ball1.sY;
			ball2.sY = -ball2.sY;

		}

	}


}
