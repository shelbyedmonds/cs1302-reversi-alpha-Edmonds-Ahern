public class ReversiBoard implements Board {

	private String[][] board;
	private int moveCount = 0;

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

	@Override
	public String[][] changeBoard(String[][] board, int row, int col, String spot) {
		board[row - 1][col - 1] = spot;
		return board;
	}
	
	public void setBoard(String[][] board) {
		this.board = board;
	}
		
	public String[][] getBoard() {
		return board;
	}
	
	public void setMoveCount(int count) {
		this.moveCount = count;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public String turnIndicator() {
		String turn = "":
		if (getMoveCount() % 2 == 0) {
			turn = "X";
		}
		else {
			turn = "O";
		}
		return turn;
	}	
	
	public boolean legalMove(int row, int col) {
		if (getBoard()[row - 1][col - 1].equals("X") && turnIndicator().equals("X")) {
			if (searchUp()) {
				return true;
			}
			else if (searchDown()) {
				return true;
			}
			else if (searchRight()) {
				return true;
			}
			else if (searchLeft()) {
				return true;
			}
			else if (searchDiagUL()) {
				return true;
			}
			else if (searchDiagUR()) {
				return true;
			}
			else if (searchDiagDL()) {
				return true;	
			}
			else if (searchDiagDR()) {
				return true;
			}
		}

		}
	}
	
	public boolean isInBounds(int row, int col) {
		if (row > 0 && row <= 8 && col > 0 && col <= 8) {
			return true;
		}
		else {
			return false;
		}
	}
					

	//add in how to display the board
	

	


}//ReversiBoard
