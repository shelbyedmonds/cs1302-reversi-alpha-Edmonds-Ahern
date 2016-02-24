public class HumanPlayer extends Player{
	//attributes
	private int row;
	private int column;
	private String playersToken;
	
	public HumanPlayer(String playersToken){
		super(playersToken);
		this.playersToken=playersToken;
	
	}//constructor
	

	
	@override
	public boolean moveValidation(Board ReversiBoard){
		if(ReversiBoard[row-1][column-1].equals("_")&&row<8&&row>0&&column<8&&row>0 )
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

	
	public void changeAvailableMoveSpaces(){
		//adding more here later...
	}//changeAvailableMoveSpaces

	@override
	public ReversiBoard changeBoard(String playersToken, int row, int column, Board ReversiBoard){
		int changeToRow=0;
		int changeToColumn=0;
		boolean vertical=false;
		boolean horizontal=false;
		boolean diagonal=false;
		ReversiBoard[row][column]=" "+ playersToken+ " ";
		
		//horizontal loop checker
		
		//vertical loop checker
		
		//diagonal loop checker
					
				
		
	return ReversiBoard;
	}//ReversiBoard






}//Human Player

