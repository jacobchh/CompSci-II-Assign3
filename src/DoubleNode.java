/**
 * The class represents a node that is part of a doubly-linked list
 * 
 * @author Jacob Chun
 *
 * @param <T> Represents any data type that the ArrayStack an accept
 */
public class DoubleNode<T> {

	/**
	 * Instance variables next and prev represent the coming and previous nodes from
	 * a current node. Data is the data stored in a node.
	 */
	private DoubleNode<T> next;
	private DoubleNode<T> prev;
	private T data;

	/**
	 * Constructor initializes a node with no next, previous, or data
	 */
	public DoubleNode() {
		next = null;
		prev = null;
		data = null;
	}

	/**
	 * Constructor initializes a node with no next or previous node. Stores data newData.
	 * 
	 * @param newData desired data to be stored
	 */
	public DoubleNode(T newData) {
		next = null;
		prev = null;
		data = newData;
	}

	/**
	 * 
	 * @return the next node that it points to
	 */
	public DoubleNode<T> getNext() {
		return next;
	}

	/**
	 * 
	 * @return the previous node that it points to
	 */
	public DoubleNode<T> getPrev() {
		return prev;
	}

	/**
	 * 
	 * @return the data stored in the node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Method sets a next node to point to
	 * 
	 * @param nextNode desired node to point to
	 */
	public void setNext(DoubleNode<T> nextNode) {
		next = nextNode;
	}

	/**
	 * Method sets a previous node to point to
	 * 
	 * @param prevNode desired node to point to
	 */
	public void setPrev(DoubleNode<T> prevNode) {
		prev = prevNode;
	}

	/**
	 * Method sets data in a node
	 * 
	 * @param newData desired data to store
	 */
	public void setData(T newData) {
		data = newData;
	}

}
