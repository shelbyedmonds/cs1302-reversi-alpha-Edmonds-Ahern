public abstract class Player{
	//attributes 
	protected int turn;
	protected String playerToken;


	public Player(String playerToken){
		this.playerToken=playerToken;
		this.turn=1;
	}
	
	public boolean moveValidation(){
	}//moveValidation
	
	public abstract ReversiBoard playersMove(){
	}//playersMove
	
	public abstract ReversiBoard changeBoard(){
	}//changeBoard

	public int getTurnNum(){
	return turn;
	}//getTurnNum

	public void setTurn(int turn){
		this.turn=turn;
	}//setTurn

}//Player
