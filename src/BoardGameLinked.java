/**
 * Class represents a board game that the snake game is played on made up of
 * doubly-linked lists
 *
 * @author Jacob Chun
 *
 */
public class BoardGameLinked {

	/**
	 * Instance variables for the length and width of the board, the snake on the
	 * board, and the board itself
	 */
	int boardLength;
	int boardWidth;
	SnakeLinked theSnake;
	DoubleList<String>[] board;

	/**
	 * Constructor will create the virtual board and its information and also the
	 * snake on the board
	 * 
	 * @param boardFile the text file that you wish to use to create the board
	 */
	public BoardGameLinked(String boardFile) {
		// declares two different variable types used
		MyFileReader inputFile;
		int value;

		// reads the file using the MyFileReader class
		inputFile = new MyFileReader(boardFile);

		// reads and ignores the first two integer values
		value = inputFile.readInt();
		value = inputFile.readInt();

		// uses the next two integers for information about the board
		value = inputFile.readInt();
		boardLength = value;
		value = inputFile.readInt();
		boardWidth = value;

		// uses the next two integers for information about the snake
		int initialSnakeRow = inputFile.readInt();
		int initialSnakeCol = inputFile.readInt();

		// initializes a Snake object
		theSnake = new SnakeLinked(initialSnakeRow, initialSnakeCol);

		board = (DoubleList<String>[]) (new DoubleList[boardLength]);

		// initializes all entries to empty at first
		for (int i = 0; i < boardWidth; i++) {
			DoubleList<String> list = new DoubleList<String>();
			board[i] = list;
			for (int j = 0; j < boardLength; j++) {
				board[i].addData(j, "empty");
			}
		}
		
		// initializes the values based on the board file
		while (inputFile.endOfFile() == false) {
			int inputRow = inputFile.readInt();
			int inputCol = inputFile.readInt();
			String line = inputFile.readString();
			board[inputRow].setData(inputCol, line);
		}

	}

	/**
	 * Gives the user the object occupying an index
	 * 
	 * @param row desired row
	 * @param col desired column
	 * @return the object that occupies the specific position
	 * @throws InvalidPositionException if the indexes given do not exist
	 */
	public String getObject(int row, int col) throws InvalidPositionException {
		if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength) {
			throw new InvalidPositionException("Error: Invalid Index");
		}
		return board[row].getData(col);
	}

	/**
	 * Sets an object at the specific index
	 * 
	 * @param row desired row
	 * @param col desired column
	 * @param newObject the object that user wants to be set in position
	 * @throws InvalidPositionException if the indexes given do not exist
	 * 
	 */
	public void setObject(int row, int col, String newObject) throws InvalidPositionException {
		if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength) {
			throw new InvalidPositionException("Error: Invalid Index");
		}
		board[row].setData(col, newObject);
	}

	/**
	 * 
	 * @return the snake object
	 */
	public SnakeLinked getSnakeLinked() {
		return theSnake;
	}

	/**
	 * Sets a new snake object
	 * 
	 * @param newSnake the desired snake to be set
	 */
	public void setSnakeLinked(SnakeLinked newSnake) {
		theSnake = newSnake;
	}

	/**
	 * 
	 * @return the board length
	 */
	public int getLength() {
		return boardLength;
	}

	/**
	 * 
	 * @return the board width
	 */
	public int getWidth() {
		return boardWidth;
	}

}
