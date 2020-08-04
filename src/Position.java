/**
 * Class that represents a position object that stores row and column
 * information
 * 
 * @author Jacob Chun
 *
 */
public class Position {

	/**
	 * The different positions a Position object can occupy
	 */
	private int positionRow;
	private int positionColumn;

	/**
	 * Initializes a Position object with two different attributes
	 * 
	 * @param row a position's row number
	 * @param col a column's row number
	 */
	public Position(int row, int col) {
		positionRow = row;
		positionColumn = col;
	}

	/**
	 * getRow method returns a position's row number
	 * 
	 * @return a position's row number
	 */
	public int getRow() {
		return positionRow;
	}

	/**
	 * getCol method returns a position's column number
	 * 
	 * @return a position's column number
	 */
	public int getCol() {
		return positionColumn;
	}

	/**
	 * setRow method sets a new row number to the instance
	 * 
	 * @param newRow a number you want to set the row to
	 */
	public void setRow(int newRow) {
		positionRow = newRow;
	}

	/**
	 * newCol method sets a new column number to the instance
	 * 
	 * @param newCol a number you want to set the column to
	 */
	public void setCol(int newCol) {
		positionColumn = newCol;
	}

	/**
	 * equals method compares two position object instances and determines if
	 * they're the same
	 * 
	 * @param otherPosition another position being compared to
	 * @return a boolean indicating whether of not the positions are the same
	 */
	public boolean equals(Position otherPosition) {
		if (this.getCol() == otherPosition.getCol() && this.getRow() == otherPosition.getRow()) {
			return true;
		}
		return false;
	}
}
