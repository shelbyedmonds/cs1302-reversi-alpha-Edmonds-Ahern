public abstract class Player{
	//attributes 
	protected int turn;
	protected int numOfTokens;
	protected String token;
	protected turnStatus;
	
	public Player(String playerToken){
	turn=1;
	numOfTokens=2;
	token=playerToken;
	}//Player

/** SHOULD WE ADD IN A CONSTRUCTOR?*/
	public abstract boolean moveValidation(){
	}//moveValidation
	
	public int howManyTokens(){
		return numOfTokens;
	}//howManyTokens

	public abstract ReversiBoard playersMove(){
	}//playersMove
	
	public boolean isYourTurn(){
		return turnStatus;
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
