public abstract class Player{
	//attributes 
	protected int turn;



/** SHOULD WE ADD IN A CONSTRUCTOR?*/
	public boolean moveValidation(){
	}//moveValidation
	
	public ReversiBoard playersMove(){
	}//playersMove
	
	public boolean isYourTurn(){
	}//isYourTurn
	
	public ReversiBoard changeBoard(){
	}//changeBoard

	public int getTurnNum(){
	return turn;
	}//getTurnNum

	public void setTurn(int turn){
		this.turn=turn;
	}//setTurn

}//Player
