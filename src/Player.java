public abstract class Player{
	//attributes 
	protected int turn;
	protected int numOfTokens;
	protected String token;
	
	public Player(String playerToken){
	turn=1;
	numOfTokens=2;
	token=playerToken;
	}//Player

	public abstract boolean moveValidation(){
	}//moveValidation
	
	public int howManyTokens(){
		return numOfTokens;
	}//howManyTokens

	public void changeNumOfTokens(int tokens){
		numOfTokens=tokens;
	}//changeNumOfTokens

	public abstract ReversiBoard playersMove(){
	}//playersMove
	
	
	public abstract ReversiBoard changeBoard(){
	}//changeBoard

	public int getTurnNum(){
		return turn;
	}//getTurnNum

	public abstract void showVerticalMoves(Board reversiBoard, String playerToken){
	}//showVerticalMoves
	
	public abstract void showHorizontalMoves(Board reversiBoard, String playerToken){
        }//showHorizontalMoves

        public abstract void showDiagonalMoves(Board reversiBoard, String playerToken){
        }//showDiagonalMoves

	public void removeAvailableMoveMarkers(Board reversiBoard){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(reversiBoard[i][j].equals("_"))
					reversiBoard[i][j]=".";
			}
		}
	}//removeAvailableMoveMarkers

	public void setTurn(int turn){
		this.turn=turn;
	}//setTurn

}//Player
