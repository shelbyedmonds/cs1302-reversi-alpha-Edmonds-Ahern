public class ReversiBoard implements Board {

	private String[][] board;

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
		board[row][col] = spot;
		return board;
	}
	
	public void setBoard(String[][] board) {
		this.board = board;
	}
		
	public String[][] getBoard() {
		return board;
	}	

	//add in how to display the board
	

	


}//ReversiBoard
