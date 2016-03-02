public class ReversiBoard implements Board {

	private String[][] board;
	private int moveCount = 0;


/**This method is designed to display the board properly.
 *
 * @param reveriBoard: String[][]
 * @return void
 */
	@Override 
	public void displayBoard(String[][] reversiBoard){
		System.out.println("  1 2 3 4 5 6 7 8");
		for (int i = 0; i < 8; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(reversiBoard[i][j] + " ");
			}
			System.out.println();
		}
	}

/**This method clears off any valid moves displayed on the board already.
 *
 * @param none
 * @return String [][]
 */	
	public String[][] clearValidMoves() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].equals("_")) {
					board[i][j] = ".";
				}
			}
		}
		return board;
	}


/**This method initializes the game board with the starting moves.
 *
 * @param none
 * @return String [][]
 */
	@Override
	public String[][] initializeBoard() {
		String[][] tempBoard = new String[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tempBoard[i][j] = ".";
			}
		}
		tempBoard[3][3] = "X";
		tempBoard[3][4] = "O";
		tempBoard[4][3] = "O";
		tempBoard[4][4] = "X";
		return tempBoard;
	}

/**This method changes the board to reflect a move.
 *
 * @param board: String [][]
 * @param row: int
 * @param col: int
 * @param spot: String
 * @return String [][]
 */
	@Override
	public String[][] changeBoard(String[][] board, int row, int col, String spot) {
		board[row - 1][col - 1] = spot;
		return board;
	}

/**This method sets the board.
 * 
 * @param myBoard: String [][]
 * @return void
 */	
	public void setBoard(String[][] myBoard) {
		this.board=new String[myBoard.length][myBoard[0].length];
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				this.board[i][j]=myBoard[i][j];
			}
		}
	}

/**This method retrieves the board.
 * 
 * @param none
 * @return String [][]
 */		
	public String[][] getBoard() {
		return board;
	}

/**This method sets the move count.
 *
 * @param count :int
 * @return void
 */	
	public void setMoveCount(int count) {
		this.moveCount = count;
	}

/**This method gets the move count and returns it.
 *
 * @param none
 * @return int
 */	
	public int getMoveCount() {
		return moveCount;
	}
	

/**This method returns which turn we are on.
 * 	
 * @param none
 * @return String
 */
 

	public String turnIndicator() {
		String turn = "";
		if (getMoveCount() % 2 == 0) {
			turn = "X";
		}
		else {
			turn = "O";
		}
		return turn;
	}	

/**This method marks the legal moves.
 *
 * @param none
 * @return String [][]
 */	
	public String[][] markLegalMoves() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				isLegalMove(i, j);
			}
		}
		return board;	
	}

/**This method determines if a move is legal or not according to game rules.
 *
 * @param row: int 
 * @param col int
 * @return void
 */	
	private void isLegalMove(int row,int col) {
		if (row == 0 && col == 0) {
			setBoard(searchDown(row, col));
			setBoard(searchRight(row, col));
			setBoard(searchDDR(row, col));
		}
		else if (row == 0 && col == 7) {
			setBoard(searchDown(row, col));
			setBoard(searchLeft(row, col));
			setBoard(searchDDL(row, col));
		}
		else if (row == 0 && col != 0 && col != 7) {
			setBoard(searchDown(row, col));
			setBoard(searchRight(row, col));
			setBoard(searchLeft(row, col));
			setBoard(searchDDL(row, col));
			setBoard(searchDDR(row, col));
		}
		else if (row == 7 && col == 0) {
			setBoard(searchUp(row, col));
			setBoard(searchRight(row, col));
			setBoard(searchUDR(row, col));
		}
		else if (row == 7 && col == 7) {
			setBoard(searchUp(row, col));
			setBoard(searchLeft(row, col));
			setBoard(searchUDL(row, col));
		}
		else if (row == 7 && col != 0 && col != 7) {
			setBoard(searchUp(row, col));
			setBoard(searchLeft(row, col));
			setBoard(searchRight(row, col));
			setBoard(searchUDR(row, col));
			setBoard(searchUDL(row, col));
		}
		else if (col == 0 && row != 0 && row != 7) {
			setBoard(searchRight(row, col));
			setBoard(searchUp(row, col));
			setBoard(searchDown(row, col));
			setBoard(searchUDR(row, col));
			setBoard(searchDDR(row, col));
		}
		else if (col == 7 && row != 0 && row != 7) {
			setBoard(searchLeft(row, col));
			setBoard(searchUp(row, col));
			setBoard(searchDown(row, col));
			setBoard(searchUDL(row, col));
			setBoard(searchDDL(row, col));
		}
		else {
			setBoard(searchUp(row, col));
			setBoard(searchDown(row, col));
			setBoard(searchRight(row, col));
			setBoard(searchLeft(row, col));
			setBoard(searchUDL(row, col));
			setBoard(searchUDR(row, col));
			setBoard(searchDDL(row, col));
			setBoard(searchDDR(row, col));
		}
	}



/**This method searches Down from a specific point on the grid.
 *
 * @param row int
 * @param col int
 * @return String [][]
 */
	private String[][] searchDown(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row][col].equals(".")) {
			if (board[row+1][col].equals(opposite)) {
				for (int i = (row + 2); i < 8; i++) {
					if (board[i][col].equals(".")) {
						return board;
					}
					if (board[i][col].equals(player)) {
						board[row][col] = "_";
					}
				}
			}
		}
		return board;
	}

/**This method searches Upwards from a specific point on the grid.
 *
 * @param row int
 * @param col int 
 * @return String [][]
 */	
	private String[][] searchUp(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row][col].equals(".")) {
			if (board[row-1][col].equals(opposite)) {
				for (int i = (row - 2); i >= 0; i--) {
					if (board[i][col].equals(".")) {
						return board;
					}
					if (board[i][col].equals(player)) {
						board[row][col] = "_";
					}
				}
			}
		}
		return board;
	}

/**This method searches to the right of a specific point on the grid.
 *
 * @param row int
 * @param col int
 * @return String [][]
 */
	private String[][] searchRight(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row][col].equals(".")) {
			if (board[row][col+1].equals(opposite)) {
				for (int j = (col + 2); j < 8; j++) {
					if (board[row][j].equals(".")) {
						return board;
					}
					if (board[row][j].equals(player)) {
						board[row][col] = "_";
					}
				}
			}
		}
		return board;
	}

/**This method searches to the left of a specific point on the grid.
 *
 * @param row int
 * @param col int 
 * @return String [][]
 */	
	private String[][] searchLeft(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row][col].equals(".")) {
			if (board[row][col-1].equals(opposite)) {
				for (int j = (col - 2); j >= 0; j--) {
					if (board[row][j].equals(".")) {
						return board;
					}
					if (board[row][j].equals(player)) {
						board[row][col] = "_";
					}
				}
			}
		}
		return board;
	}


/**This method searches Up Diagonal Left.
 *
 * @param row int
 * @param col int
 * @return String [][]
 */	
	private String[][] searchUDL(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row][col].equals(".")) {
			if (board[row-1][col-1].equals(opposite)) {
				for (int i = (row - 2), j = (col - 2); i >= 0 && j >= 0; i--, j--) {
					if (board[i][j].equals(".")) {
						return board;
					}
					if (board[i][j].equals(player)) {
						board[row][col] = "_";
					}
				}
			}
		}
		return board;
	}

/**This method searches Up Diagonal Right.
 *
 * @param row int 
 * @param col int
 * @return String[][]
 */	
	private String[][] searchUDR(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row][col].equals(".")) {
			if (board[row-1][col+1].equals(opposite)) {
				for (int i = (row - 2), j = (col + 2); i >= 0 && j < 8; i--, j++) {
					if (board[i][j].equals(".")) {
						return board;
					}
					if (board[i][j].equals(player)) {
						board[row][col] = "_";
					}
				}
			}
		}
		return board;
	}

/**This method searches down diagonal left.
 *
 * @param row int
 * @param col int
 * @return String [][]
 */	
	private String[][] searchDDL(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row][col].equals(".")) {
			if (board[row+1][col-1].equals(opposite)) {
				for (int i = (row + 2), j = (col - 2); i < 8 && j >= 0; i++, j--) {
					if (board[i][j].equals(".")) {
						return board;
					}
					if (board[i][j].equals(player)) {
						board[row][col] = "_";
					}
				}
			}
		}
		return board;
	}


/**This method searches Diagonal Down Right.
 *
 * @param row int
 * @param col int
 * @return String[][]
 */		
	private String[][] searchDDR(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row][col].equals(".")) {
			if (board[row+1][col+1].equals(opposite)) {
				for (int i = (row + 2), j = (col + 2); i < 8 && j < 8; i++, j++) {
					if (board[i][j].equals(".")) {
						return board;
					}
					if (board[i][j].equals(player)) {
						board[row][col] = "_";
					}
				}
			}
		}
		return board;
	}

/**This method makes a move to a specific spot.
 *
 * @param row int
 * @param col int 
 * @return void
 */
	public void makeMove(int row, int col) {
		if (row == 0 && col == 0) {
			setBoard(moveDown(row, col));
			setBoard(moveRight(row, col));
			setBoard(moveDDR(row, col));
		}
		else if (row == 0 && col == 7) {
			setBoard(moveDown(row, col));
			setBoard(moveLeft(row, col));
			setBoard(moveDDL(row, col));
		}
		else if (row == 0 && col != 0 && col != 7) {
			setBoard(moveDown(row, col));
			setBoard(moveRight(row, col));
			setBoard(moveLeft(row, col));
			setBoard(moveDDL(row, col));
			setBoard(moveDDR(row, col));
		}
		else if (row == 7 && col == 0) {
			setBoard(moveUp(row, col));
			setBoard(moveRight(row, col));
			setBoard(searchUDR(row, col));
		}
		else if (row == 7 && col == 7) {
			setBoard(moveUp(row, col));
			setBoard(moveLeft(row, col));
			setBoard(moveUDL(row, col));
		}
		else if (row == 7 && col != 0 && col != 7) {
			setBoard(moveUp(row, col));
			setBoard(moveLeft(row, col));
			setBoard(moveRight(row, col));
			setBoard(moveUDR(row, col));
			setBoard(moveUDL(row, col));
		}
		else if (col == 0 && row != 0 && row != 7) {
			setBoard(moveRight(row, col));
			setBoard(moveUp(row, col));
			setBoard(moveDown(row, col));
			setBoard(moveUDR(row, col));
			setBoard(moveDDR(row, col));
		}
		else if (col == 7 && row != 0 && row != 7) {
			setBoard(moveLeft(row, col));
			setBoard(moveUp(row, col));
			setBoard(moveDown(row, col));
			setBoard(moveUDL(row, col));
			setBoard(moveDDL(row, col));
		}
		else {
			setBoard(moveUp(row, col));
			setBoard(moveDown(row, col));
			setBoard(moveRight(row, col));
			setBoard(moveLeft(row, col));
			setBoard(moveUDL(row, col));
			setBoard(moveUDR(row, col));
			setBoard(moveDDL(row, col));
			setBoard(moveDDR(row, col));
		}
	}


/**This method changes the board based on a down move.
 *
 * @param row int
 * @param col int
 * @return String [][]
 */
	private String[][] moveDown(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row+1][col].equals(opposite)) {
			for (int i = (row + 2); i < 8; i++) {
				if (board[i][col].equals(player)) {
					for (int j = i; j >= row; j--) {
						board[j][col] = player;
					}
					return board;
				}
				else if (board[i][col].equals(".") || board[i][col].equals("_")) {
					return board;
				}
			}
		}
		return board;
	}

/**This method changes the board based on an up move.
 *
 * @param row int
 * @param col int
 * @return String [][]
 */	
	private String[][] moveUp(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row-1][col].equals(opposite)) {
			for (int i = (row - 2); i >= 0; i--) {
				if (board[i][col].equals(player)) {
					for (int j = i; j <= row; j++) {
						board[j][col] = player;
					}
					return board;
				}
				else if (board[i][col].equals(".") || board[i][col].equals("_")) {
					return board;
				}
			}
		}
		return board;
	}

/**This method changes the board based on a move to the left.
 *
 * @param row int
 * @param col int
 * @return String [][]
 */
	private String[][] moveLeft(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row][col-1].equals(opposite)) {
			for (int i = (col - 2); i >= 0; i--) {
				if (board[row][i].equals(player)) {
					for (int j = i; j <= col; j++) {
						board[row][j] = player;
					}
					return board;
				}
				else if (board[row][i].equals(".") || board[row][i].equals("_")) {
					return board;
				}
			}
		}
		return board;
	}

/**This method changes the board based on a move to the right. 
 *
 * @param row: int
 * @param col int
 * @return String [][]
 */
	private String[][] moveRight(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row][col+1].equals(opposite)) {
			for (int i = (col + 2); i < 8; i++) {
				if (board[row][i].equals(player)) {
					for (int j = i; j >= col; j--) {
						board[row][j] = player;
					}
					return board;
				}
				else if (board[row][i].equals(".") || board[row][i].equals("_")) {
					return board;
				}
			}
		}
		return board;
	}

/**This changes the board based on an Up diagonal move to the left.
 *
 * @param row int
 * @param col int
 * @return String [][]
 */
	private String[][] moveUDL(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row-1][col-1].equals(opposite)) {
			for (int i = (row - 2), j = (col - 2); i >= 0 && j >= 0; i--, j--) {
				if (board[i][j].equals(player)) {
					for (int k = i, l = j; k <= row && l <= col; k++, l++) {
						board[k][l] = player;
					}
					return board;
				}
				else if (board[i][j].equals(".") || board[i][j].equals("_")) {
					return board;	
				}
			}
		}
		return board;
	}

/**This method changes the board based on a move up diagonally to the right
 * 
 * @param row int
 * @param col int
 * @return String [][]
 */
	private String[][] moveUDR(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row-1][col+1].equals(opposite)) {
			for (int i = (row - 2), j = (col + 2); i >= 0 && j < 8; i--, j++) {
				if (board[i][j].equals(player)) {
					for (int k = i, l = j; k <= row && l >= col; k++, l--) {
						board[k][l] = player;
					}
					return board;
				}
				else if (board[i][j].equals(".") || board[i][j].equals("_")) {
					return board;
				}
			}
		}
		return board;
	}

/**This method changes the board based on a diagonal move down to the left.
 *
 * @param row int 
 * @param col int
 * @return String [][]
 */	
	private String[][] moveDDL(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row+1][col-1].equals(opposite)) {
			for (int i = (row + 2), j = (col - 2); i < 8 && j >= 0; i++, j--) {
				if (board[i][j].equals(player)) {
					for (int k = i, l = j; k >= row && l <= col; k--, l++) {
						board[k][j] = player;
					}
					return board;
				}
				else if (board[i][j].equals(".") || board[i][j].equals("_")) {
					return board;
				}
			}
		}
		return board;
	}

/**This method changes the board based on a diagonal down to the right move. 
 *
 * @param row int
 * @param col
 * @return String [][]
 */
	private String[][] moveDDR(int row, int col) {
		String player = turnIndicator();
		String opposite = "";
		if (player.equals("X")) {
			opposite = "O";
		}	
		else if (player.equals("O")) {
			opposite = "X";
		}
		if (board[row+1][col+1].equals(opposite)) {
			for (int i = (row + 2), j = (col + 2); i < 8 && j < 8; i++, j++) {
				if (board[i][j].equals(player)) {
					for (int k = i, l = k; k >= row && l >= col; k--, l--) {
						board[k][j] = player;
					}
					return board;
				}
			}
		}
		return board;
	}

/**This method determines if a row/col combo is in bounds.
 *
 * @param row int
 * @param col int
 * @return boolean
 */								
	private boolean isInBounds(int row, int col) {
		if (row >= 0 && row < 8 && col >= 0 && col < 8) {
			return true;
		}
		else {
			return false;
		}
	}	
}//ReversiBoard
