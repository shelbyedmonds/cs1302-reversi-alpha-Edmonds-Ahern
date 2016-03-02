public interface Board{

/**This method will display the board.
 * 
 * @param board- a String [][] that represents the board
 */
	public void displayBoard(String[][] board);

/**This method will initialize the board.
 *
 * @param none
 * @return String [][]
 */
	public abstract String[][] initializeBoard();

/**This method will change the board.
 *
 * @param board - a String [][] that represents the board
 * @param row- an int that represents the row
 * @param col- an int that represents the col
 * @param spot- a String that represents the spot
 * @return String [][]
 */
	public abstract String[][] changeBoard(String[][] board, int row, int col, String spot);

}//Board




