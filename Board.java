public interface Board{

//	public String[][] board;

	public void displayBoard(String[][] board);

	public String[][] initializeBoard();

	public String[][] changeBoard(String[][] board, int row, int col, String spot);

}//Board
