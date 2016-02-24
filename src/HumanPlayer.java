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
	public ReversiBoard playersMove(String playersToken, int row, int column, Board ReversiBoard){
	if(row>0&&row<8&&column>0&&column<8){
		this.row=row;
		this.column=column;
	}
	if(moveValidation(ReversiBoard)==true)
		changeBoard(playersToken, row, column, ReversiBoard);
		
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
		
		//horizontal loop changer
		
		//vertical loop changer
		
		//diagonal loop changer
					
				
		
	return ReversiBoard;
	}//ReversiBoard

	public void showVerticalMoves(Board reversiBoard, String playerToken ){
	

	}//showVerticalMoves

	public void showHorizontalMoves(Board reversiBoard, String playerToken){

	}//showHorizontalMoves

	public void showDiagonalMoves(Board reversiBoard, String playerToken){

	}//showDiagonalMoves


	public void removeAvailableMoveMarkers(){
	
	}




}//Human Player

