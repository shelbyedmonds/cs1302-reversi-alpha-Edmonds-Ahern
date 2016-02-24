public abstract class Player{
	//attributes 
	protected int turn;
	protected int numOfTokens;
	
	public Player{
	turn=1;
	numOfTokens=2;
	//we need some way to decide which token the player will get
	}//Player

/** SHOULD WE ADD IN A CONSTRUCTOR?*/
	public abstract boolean moveValidation(){
	}//moveValidation
	
	public int howManyTokens(){
		return numOfTokens;
	}//howManyTokens

	public abstract ReversiBoard playersMove(){
	}//playersMove
	
	public abstract boolean isYourTurn(){
	}//isYourTurn
	
	public abstract ReversiBoard changeBoard(){
	}//changeBoard

	public int getTurnNum(){
	return turn;
	}//getTurnNum

	public void setTurn(int turn){
		this.turn=turn;
	}//setTurn

}//Player
