public class HumanPlayer extends Player{
	//attributes
	private int row;
	private int column;
	private int numOfPieces;
	
	public HumanPlayer(){
		
	
	}//constructor
	
	@override
	public int getTurnNum(){

	return turn;  //taken from parent class (protected modifier)
	}//getTurnNum
	
	@override
	public boolean moveValidation(){

	return false;
	}//moveValidation
	
	@override
	public ReversiBoard playersMove(){
	return ReversiBoard;
	}//playersMove

	@override
	public boolean isYourTurn(){
	return false;
	}//isYourTurn
	
	@override
	public ReversiBoard changeBoard(){

	return ReversiBoard;
	}//ReversiBoard

	@override
	public void setTurn(){

	}//setTurn




}//Human Player

