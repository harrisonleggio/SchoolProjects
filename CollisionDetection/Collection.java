/**
 * @author Harrison Leggio
 * Program 02 - Bing Bong
 */
import java.awt.Graphics;


public class Collection implements CollectionInterface{



	public int current = 0;					// holds position of current ball
	protected static Node head;				// head


	/**
	 * default constructor does nothing
	 */
	public Collection(){

	}

	/**
	 * the add method adds a new ball to the linked list by creating
	 * a new node, setting the ball, then setting the next to head
	 * 
	 */
	public void add(Ball someBall) {

		Node node = new Node();
		node.setBall(someBall);
		node.setNext(head);
		head = node;
	}




	/**
	 * remove method removes the last ball from the linked list
	 */
	@Override
	public void remove() {
		Node current, previous;
		current = head.getNext();
		previous = head;

		while(current.getNext() != null){
			previous = current;
			current = current.getNext();

		}
		previous.setNext(null);




	}
	/**
	 * Checks whether each ball collides with all of the other balls
	 * that are active in the window
	 * @param node
	 */
	public void BallCollision(Node node){
		Node current = head;
		Node next = current.getNext();
		while(current != null){
			while(current != null && current.getNext() != null){
				Ball.checkCollision(current.getBall(), next.getBall());
				next = next.getNext();
			}
			current = current.getNext();
			Ball.checkCollision(current.getBall(), next.getBall());

		}
	}


	@Override
	public void isEmpty() {
		// TODO Auto-generated method stub

	}

	/**
	 * paint method loops through and paints the linked list
	 * @param pane
	 */
	public void paint(Graphics pane){
		Node temp = head;
		if(temp != null){
			while(temp != null){
				temp.getBall().paint(pane);
				temp = temp.getNext();
			}
		}
	}

	/**
	 * move method moves each ball as it is thrown
	 */
	public void move(){
		Node temp = head;
		if(temp != null){
			while(temp != null){
				temp.getBall().move();
				temp = temp.getNext();
			}

		}

	}

}
