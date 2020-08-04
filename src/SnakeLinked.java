/**
 * Class that represents a snake object that occupies the board game
 * 
 * @author Jacob Chun
 *
 */
public class SnakeLinked {

	/**
	 * snakeLength represents the current length of the snake object. snakeBody
	 * position doubly-linked list stores the position of every part of the snake.
	 */
	int snakeLength;
	DoubleList<Position> snakeBody;

	/**
	 * constructs a snake object that occupies the board game and sets instance
	 * variables
	 * 
	 * @param row desired row start position of snake object
	 * @param col desired column start position of snake object
	 */
	public SnakeLinked(int row, int col) {
		snakeLength = 1;
		snakeBody = new DoubleList<Position>();
		Position initial = new Position(row, col);
		snakeBody.addData(0, initial);
	}

	/**
	 * 
	 * @return the current length of the snake
	 */
	public int getLength() {
		return snakeLength;
	}

	/**
	 * Method returns the position of a specified index in the linked list
	 * 
	 * @param index desired index of linked list to find the position of
	 * @return the position information of the linked list index entered
	 */
	public Position getPosition(int index) {
		if (index < 0 || index >= snakeLength)
			return null;
		return snakeBody.getData(index);
	}

	/**
	 * 
	 * @param pos the desired position to check if it is in the snakeBody linked
	 *            list
	 * @return a boolean indicating whether a not the snake lies on a certain
	 *         position
	 */
	public boolean snakePosition(Position pos) {
		for (int i = 0; i < snakeLength; i++) {
			if (snakeBody.getData(i).equals(pos))
				return true;
		}
		return false;
	}

	/**
	 * method returns the updated position of the snake head
	 * 
	 * @param direction desired direction to travel
	 * @return the new position of the snake head
	 */
	public Position newHeadPosition(String direction) {
		int rowPosition = snakeBody.getData(0).getRow();
		int colPosition = snakeBody.getData(0).getCol();

		if (direction == "right") {
			colPosition++;
		} else if (direction == "left") {
			colPosition--;
		} else if (direction == "up") {
			rowPosition--;
		} else if (direction == "down") {
			rowPosition++;
		}
		return new Position(rowPosition, colPosition);
	}

	/**
	 * The method will shift the entire snake body "moving it" on the board
	 * 
	 * @param direction desired direction to move the snake
	 */
	public void moveSnakeLinked(String direction) {
		for (int i = (snakeLength - 1); i > 0; i--) {
			snakeBody.setData(i, snakeBody.getData(i - 1));
		}
		snakeBody.setData(0, newHeadPosition(direction));
	}

	/**
	 * Shrinks the snake's length by 1
	 */
	public void shrink() {
		snakeBody.removeData(snakeLength - 1);
		snakeLength--;
	}

	/**
	 * method adds a position to the snake body and increases the length by 1
	 * representing what happens when the virtual snake eats an apple on the board
	 * 
	 * @param direction desired direction to move
	 */
	public void grow(String direction) {
		Position position = newHeadPosition(direction);
		snakeBody.addData(0, position);
		snakeLength++;
	}

}
