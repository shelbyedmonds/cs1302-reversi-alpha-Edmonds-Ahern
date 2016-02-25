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

	public void showVerticalMoves(Board reversiBoard, String playerToken){
        if(playerToken.equals("X"){

        for(int j=0; j<8;j++){
                for(int i=0; i<8; i++){
                        checkAbove=false;
                        checkBelow=false;
                if(reversiBoard[i][j].equals("X"){
                        if(i-1>0&&reversiBoard[i-1][j].equals("O"))
                                checkAbove=true;
                        if(i+1<8&&reversiBoard[i+1][j].equals("O"))
                                checkBelow=true;
                        if(checkAbove==true){
                                for(int q=i-2;q>0; q--){
                                        if(reversiBoard[q][j].equals(".")){
                                                reversiBoard[q][j]="_";
                                                break;
                                        }
                                 }
                        }
                        if(checkBelow==true){
                                for(int t=i+2; t<8; t++){
                                        if(reversiBoard[t][j].equals(".")){
                                                reversiBoard[t][j]="_";
                                                break;
                                        }
                                }
                        }
                }
        }
        if(playerToken.equals("O"){
        for(int j=0; j<8;j++){
                for(int i=0; i<8; i++){
                        checkAbove=false;
                        checkBelow=false;
                if(reversiBoard[i][j].equals("O"){
                        if(i-1>0&&reversiBoard[i-1][j].equals("X"))
                                checkAbove=true;
                        if(i+1<8&&reversiBoard[i+1][j].equals("X"))
                                checkBelow=true;
                        if(checkAbove==true){
                                for(int q=i-2;q>0; q--){
                                        if(reversiBoard[q][j].equals(".")){
                                                reversiBoard[q][j]="_";
                                                break;
                                        }
                                 }
                        }
                        if(checkBelow==true){
                                for(int t=i+2; t<8; t++){
                                        if(reversiBoard[t][j].equals(".")){
                                                reversiBoard[t][j]="_";
                                                break;
                                        }
                                }
                        }
                }
        }
        }
        }
        }//showVerticalMoves

	

	public void showHorizontalMoves(Board reversiBoard, String playerToken ){
                if(playerToken.equals("X"){

        for(int i=0; i<8; i++){
                for(int j=0; j<8;j++){
                        checkLeft=false;
                        checkRight=false;
                if(reversiBoard[i][j].equals("X"){
                        if(j-1>0&&reversiBoard[i][j-1].equals("O"))
                                checkLeft=true;
                        if(j+1<8&&reversiBoard[i][j+1].equals("O"))
                                checkRight=true;
                        if(checkAbove==true){
                                for(int q=j-2;q>0; q--){
                                        if(reversiBoard[i][q].equals(".")){
                                                reversiBoard[i][q]="_";
                                                break;
                                        }
                                 }
                        }
                        if(checkBelow==true){
                                for(int t=j+2; t<8; t++){
                                        if(reversiBoard[i][t].equals(".")){
                                                reversiBoard[i][t]="_";
                                                break;
                                        }
                                }
                        }
                }
        }
}
}
        if(playerToken.equals("O"){
         for(int i=0; i<8; i++){
                for(int j=0; j<8;j++){
                        checkAbove=false;
                        checkBelow=false;
                if(reversiBoard[i][j].equals("O"){
                        if(j-1>0&&reversiBoard[i][j-1].equals("X"))
                                checkAbove=true;
                        if(i+1<8&&reversiBoard[i][j-1].equals("X"))
                                checkBelow=true;
                        if(checkAbove==true){
                                for(int q=j-2;q>0; q--){
                                        if(reversiBoard[i][q].equals(".")){
                                                reversiBoard[i][q]="_";
                                                break;
                                        }
                                 }
                        }
                        if(checkBelow==true){
                                for(int t=j+2; t<8; t++){
                                        if(reversiBoard[i][t].equals(".")){
                                                reversiBoard[i][t]="_";
                                                break;
                                        }
                                }
                        }
                }
        }
        }
        }

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
