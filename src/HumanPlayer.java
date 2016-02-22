public class HumanPlayer extends Player{
	//attributes
	private int row;
	private int column;
	private int numOfPieces;
	
	public HumanPlayer(){
	
	
	}//constructor
	
	public int getTurnNum(){

	return turn;  //taken from parent class (protected modifier)
	}//getTurnNum

	public boolean moveValidation(){

	return false;
	}//moveValidation

	public ReversiBoard playersMove(){
	return ReversiBoard;
	}//playersMove

	public boolean isYourTurn(){
	return false;
	}//isYourTurn

	public ReversiBoard changeBoard(){

	return ReversiBoard;
	}//ReversiBoard

	public void setTurn(){

	}//setTurn




}//Human Player

