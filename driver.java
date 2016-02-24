public class driver{
	public static void main(String [] args){
		ReversiBoard reversiBoard = new ReversiBoard();
		reversiBoard.setBoard(reversiBoard.initializeBoard());
		reversiBoard.displayBoard(reversiBoard.getBoard());
		reversiBoard.changeBoard(reversiBoard.getBoard(),1,1,"X");
		reversiBoard.displayBoard(reversiBoard.getBoard());	
	}
}
