public class HumanPlayer extends Player{
	//attributes
	private int row;
	private int column;
	private int numOfPieces;
	private String playerToken;
	
	public HumanPlayer(){
		super(playerToken);
		numOfPieces=2;
	
	}//constructor
	

	
	@override
	public boolean moveValidation(int row, int column){
		if(row>0&&row<9&&column>0&&column<9){
			this.row=row;
			this.column=column;
			return true;
		else 
			return false;
	}//moveValidation
	
	@override
	public ReversiBoard playersMove(Board reversiBoard ,int row, int column, HumanPlayer player1){
		if(moveValidation(row,column)==true&&reversiBoard[row-1][column-1].equals("_")){
			changeBoard(reversiBoard, row, column, player1);
		}	
	return ReversiBoard;
	}//playersMove

	
	@override
	public ReversiBoard changeBoard(Board reversiBoard, int row, int column, Player player1){
		reversiBoard[row-1][column-1]=player1.playerToken;
		//add in the a way to change the other pieces

	return ReversiBoard;
	}//ReversiBoard






}//Human Player

