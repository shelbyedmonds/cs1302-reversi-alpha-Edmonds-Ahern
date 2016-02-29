public class driver{
	public static void main(String [] args){
		ReversiBoard reversiBoard = new ReversiBoard();
		reversiBoard.setBoard(reversiBoard.initializeBoard());
		reversiBoard.markLegalMoves();
		reversiBoard.displayBoard(reversiBoard.getBoard());
		reversiBoard.setBoard(reversiBoard.clearValidMoves());
		reversiBoard.makeMove(5,3);
		reversiBoard.setMoveCount(1);
		reversiBoard.markLegalMoves();
		reversiBoard.displayBoard(reversiBoard.getBoard());	
		reversiBoard.makeMove(5,2);
		reversiBoard.setMoveCount(2);
		reversiBoard.setBoard(reversiBoard.clearValidMoves());
		reversiBoard.markLegalMoves();

		reversiBoard.displayBoard(reversiBoard.getBoard());
		reversiBoard.makeMove(4,2);
		reversiBoard.setMoveCount(3);
		reversiBoard.setBoard(reversiBoard.clearValidMoves());
		reversiBoard.markLegalMoves();	
		reversiBoard.displayBoard(reversiBoard.getBoard());
	}
}
