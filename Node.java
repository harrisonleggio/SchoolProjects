/**
 * Node class contains all methods related to Nodes
 * @author Harrison
 *
 */
public class Node
{	
	/**
	 * Ball
	 */
	Ball ball;
	/**
	 * Next
	 */
	Node next;

	/**
	 * Default constructor
	 */
	public Node(){

	}

	/**
	 * Gets ball
	 * @return
	 */
	public Ball getBall(){
		return ball;
	}

	/**
	 * Gets next node
	 * @return
	 */
	public Node getNext(){
		return next;
	}

	/**
	 * Sets ball
	 * @param someItem
	 */
	public void setBall(Ball someBall){
		ball = someBall;
	}

	/**
	 * Sets node
	 * @param someNode
	 */
	public void setNext(Node someNode){
		next = someNode;
	}



}