public class HumanPlayer extends Player{
	//attributes
	private int row;
	private int column;
	private int playersToken;
	
	public HumanPlayer(String playersToken){
		super(playersToken);
		this.playersToken=playersToken;
	
	}//constructor
	

	
	@override
	public boolean moveValidation(Board ReversiBoard){
		if(ReversiBoard[row][column]="_"&&row<8&&row>0&&column<8&&row>0 )
			return true;
		else
			return false;
	}//moveValidation
	
	@override
	public ReversiBoard playersMove(int row, int column, Board ReversiBoard){
	if(row>0&&row<8&&column>0&&column<8){
		this.row=row;
		this.column=column;
	}
	if(moveValidation(ReversiBoard)==true)
		changeBoard(row, column);
	return ReversiBoard;
	}//playersMove

	
	@override
	public ReversiBoard changeBoard(int row, int column, Board ReversiBoard){
		ReversiBoard[row][column]=playersToken;
		//somehow add in stuff to change the tokens in between this players token and the newly picked one
		
	return ReversiBoard;
	}//ReversiBoard






}//Human Player

