/**
 * Class that represents a doubly-linked list
 * 
 * @author Jacob Chun
 *
 * @param <T> Represents any data type that the DoubleList an accept
 */
public class DoubleList<T> {

	/**
	 * Instance variables head and rear represent the nodes that the start and end.
	 * numDataItems is the current amount of nodes in the linkedlist.
	 */
	private DoubleNode<T> head;
	private DoubleNode<T> rear;
	private int numDataItems;

	/**
	 * Constructor of the class initializes an "empty" linkedlist that the user can
	 * manipulate
	 */
	public DoubleList() {
		head = null;
		rear = null;
		numDataItems = 0;
	}

	/**
	 * Method adds a data item at a specified
	 * 
	 * @param index   desired index to use
	 * @param newData data that you want to store in a node
	 * @throws InvalidPositionException thrown if a specified index doesn't exist in
	 *                                  the list
	 */
	public void addData(int index, T newData) throws InvalidPositionException {
		if (index < 0 || index > numDataItems)
			throw new InvalidPositionException("Error: Invalid index");
		else {
			DoubleNode<T> curr = head;
			DoubleNode<T> next = null;
			DoubleNode<T> prev = null;
			DoubleNode<T> target = new DoubleNode(newData);

			for (int i = 0; i < index; i++) {
				prev = curr;
				curr = curr.getNext();
			}
			
			// if-else if represents different cases that can occur
			if (numDataItems == 0 && index == 0) {
				head = target;
				rear = target;
				target.setNext(null);
				target.setPrev(null);
			} else if (index == numDataItems) {
				target.setNext(null);
				prev.setNext(target);
				target.setPrev(prev);
				rear = target;
			} else if (index == 0) {
				target.setPrev(null);
				target.setNext(curr);
				curr.setPrev(target);
				head = target;
			} else {
				prev.setNext(target);
				target.setPrev(prev);
				target.setNext(curr);
				curr.setPrev(target);
			}
			numDataItems++;
		}
	}

	/**
	 * method returns node at the specified index
	 * 
	 * @param index desired index to inspect
	 * @return the node that is desired
	 * @throws InvalidPositionException if the indexes given do not exist
	 */
	public DoubleNode<T> getNode(int index) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Error: Invalid Index");
		else {
			DoubleNode<T> curr = head;
			DoubleNode<T> prev = null;
			if (index == 0)
				return head;
			else {
				for (int i = 0; i < index; i++) {
					prev = curr;
					curr = curr.getNext();
				}
			}
			return curr;
		}
	}

	/**
	 * Removes node at specified index
	 * 
	 * @param index desired index
	 */
	public void removeData(int index) {
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Error: Invalid Index");
		else {
			DoubleNode<T> curr = head;
			DoubleNode<T> prev = null;
			for (int i = 0; i < index; i++) {
				prev = curr;
				curr = curr.getNext();
			}
			
			// if-else if cases represent different scenarios of removing nodes
			if (index == 0 && numDataItems == 1) {
				head = null;
				rear = null;
			} else if (index == 0) {
				head = curr.getNext();
				head.setPrev(null);
				curr.setNext(null);
			} else if (index == (numDataItems - 1)) {
				rear = prev;
				prev.setNext(null);
				curr.setPrev(null);
			} else {
				prev.setNext(curr.getNext());
				curr.getNext().setPrev(prev);
				curr.setNext(null);
				curr.setPrev(null);
			}
			numDataItems--;
		}

	}

	/**
	 * getData returns the data specified index
	 * 
	 * @param index desired index
	 * @return the data at the index
	 * @throws InvalidPositionException if the index does not exist in the list
	 */
	public T getData(int index) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Error: Invalid index");
		if (index == 0)
			return head.getData();
		else {
			DoubleNode<T> curr = head;
			DoubleNode<T> prev = null;
			for (int i = 0; i < index; i++) {
				prev = curr;
				curr = curr.getNext();
			}
			return curr.getData();
		}
	}

	/**
	 * setData sets the data at a specified index
	 * 
	 * @param index desired index
	 * @param newData desired data to set
	 * @throws InvalidPositionException if the index does not exist in the list
	 */
	public void setData(int index, T newData) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Error: Invalid index");
		if (index == 0)
			head.setData(newData);
		else {
			DoubleNode<T> curr = head;
			DoubleNode<T> prev = null;
			for (int i = 0; i < index; i++) {
				prev = curr;
				curr = curr.getNext();
			}
			curr.setData(newData);
		}
	}
}
