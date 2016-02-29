public interface Board{

	public void displayBoard(String[][] board);

	public String[][] initializeBoard();

	public String[][] changeBoard(String[][] board, int row, int col, String spot);

}//Board
