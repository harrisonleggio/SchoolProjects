/**
 * @author Harrison Leggio
 * Program 02 - Bing Bong
 */
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BingBong extends Frame implements MouseListener, AlarmListener {

	private Abutton throwButton;					// throw button
	private Abutton removeButton;					//  remove button
	private Abutton fasterButton;					// faster button
	private Abutton slowerButton;					// slower button
	private Abutton resetButton;					// reset button
	private Alarm alarm;							// alarm
	private int lastX;								// x coordinate of mouse click
	private int lastY;								// y coordinate of mouse click
	private int period = 50;						// time of alarm
	protected Collection myCollection;				// collection

	/**
	 * BingBong constructor sets up the window, the buttons,
	 * the alarm, and the collection
	 */
	public BingBong(){
		setTitle("Bing Bong");
		setLocation(50, 50);
		setSize(520,630);
		Color background = new Color(224, 224, 224);
		setBackground(background);
		setVisible(true);
		addMouseListener(this);
		Color color1 = new Color(255, 204, 204);
		Color color2 = new Color(255, 255, 204);
		Color color3 = new Color(204, 255, 204);
		Color color4 = new Color(204, 255, 255);
		Color color5 = new Color(255, 178, 102);
		throwButton = new Abutton("Throw", color1, 25, 50);
		removeButton = new Abutton("Remove", color2, 125, 50);
		fasterButton = new Abutton("Faster", color3, 225, 50);
		slowerButton = new Abutton("Slower", color4, 325, 50);
		resetButton = new Abutton("Reset", color5, 425, 50);
		alarm = new Alarm("Timer", this);
		alarm.setPeriod(period);
		alarm.start();
		myCollection = new Collection();


	}
	
	/**
	 * paint method paints the box frame, the buttons, and the 
	 * collection
	 */
	public void paint(Graphics pane){
		pane.drawLine(10,50, 10, 600);
		pane.drawLine(10, 600, 510, 600);
		pane.drawLine(510, 600, 510, 50);
		if(throwButton != null)
			throwButton.paint(pane);
		if(removeButton != null)
			removeButton.paint(pane);
		if(slowerButton != null)
			slowerButton.paint(pane);
		if(fasterButton != null)
			fasterButton.paint(pane);
		if(resetButton != null)
			resetButton.paint(pane);
		if(myCollection != null)
			myCollection.paint(pane);


	}
	
	/**
	 * check method handles what is done when each button is clicked
	 */
	private void check(){
		if(throwButton.isInside(lastX, lastY)){
			Ball ball = new Ball();
			myCollection.add(ball);
		}
		if(removeButton.isInside(lastX, lastY)){
			remove();
		}
		if(fasterButton.isInside(lastX, lastY)){
			if(period > 10){
				period = period - 10;
				alarm.setPeriod(period);
			}
		}
		if(slowerButton.isInside(lastX, lastY)){
			period = period + 10;
			alarm.setPeriod(period);
		}
		if(resetButton.isInside(lastX, lastY)){
			myCollection = new Collection();
			
		}



	}
	
	/**
	 * remove method calls remove from the collection class
	 */
	public void remove(){
		myCollection.remove();
	}

	
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * mousePressed method find the x and y coordinates
	 * of where the mouse was clicked and also calls the 
	 * check method
	 */
	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		lastX = event.getX();
		lastY = event.getY();
		check();
		//System.out.println(lastX + lastY);

	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * takeNotice method works with the alarm and 
	 * has the ball move every time the alarm ticks. it also
	 * repaints the window every time the alarm ticks
	 */
	@Override
	public void takeNotice() {
		myCollection.move();


		repaint();
		// TODO Auto-generated method stub

	}

}
