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
		boolean checkAbove=false;
		boolean checkBelow=false; 

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
	boolean checkLeft=false;
	boolean checkRight=false;        

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


        public void showDiagonalMoves(Board reversiBoard, String playerToken){
	int q=2;
	int l=2;
	int r=2;
	int s=2;
	for(int i=0, j=0; i<8, j<8; i++, j++){
		if(playerToken.equals("X"){
			//checkLeftUpDiagonal
			for(int row=i, column=j; row>=0, column>=0; row--, column--){
					if(reversiBoard[row][column].equals("X"){
						if(row-1>0&&column-1>0&&reversiBoard[row-1][column-1].equals("O")){
							if(row-q>0&&column-q>0&&reversiBoard[row-q][column-q].equals(".")){
								reversiBoard[row-q][column-q]="_";
								break;
							else
								q++;
							}
						}
					}
					q=2;
			}
			

			//checkRightDownDiagonal
			for(int row=i, column=j; row<8, column<8; row++, column++){
					if(reversiBoard[row][column].equals("X"){
						if(row+1<8&&column+1<8&&reversiBoard[row+1][column+1].equals("O")){
							if(row+l<8&&column+l<8&&reversiBoard[row+l][column+l].equals(".")){
								reversiBoard[row+l][column+l]="_";
								break;
							}
							else
								l++;
						}
					}
					l=2;
			}
			
			
			//checkLeftDownDiagonal
			for(int row=i, column=j; row<8, column<0; row++, column--){
				if(reversiBoard[row][column].equals("X"){
					if(row+1<8&&column-1>0&& reversiBoard[row+1][column-1].equals("O")){
						if(row+r<8&&column-r>0&&reversiBoard[row+r][column-r].equals(".")){
							reversiBoard[row+r][column-r]="_";
							break;
						}
						else
							r++;
					}
				}
				r=2;
			}
	
			//checkRightUpDiagonal		
		 	for(int row=i, column=j; row>0, column<8; row--, column++){
                                if(reversiBoard[row][column].equals("X"){
                                        if(row-1>0&&column+1<8&& reversiBoard[row-1][column+1].equals("O")){
                                                if(row-s>0&&column+s<8&&reversiBoard[row-s][column+s].equals(".")){
                                                        reversiBoard[row-s][column+s]="_";
                                                        break;
                                                }
                                                else
                                                        s++;
                                        }       
                                }
                                s=2;
                        }
		}
		if(playerToken.equals("O"){
		          //checkLeftUpDiagonal
		          for(int row=i, column=j; row>=0, column>=0; row--, column--){
		          	if(reversiBoard[row][column].equals("O"){
                                	if(row-1>0&&column-1>0&&reversiBoard[row-1][column-1].equals("X")){
						if(row-q>0&&column-q>0&&reversiBoard[row-q][column-q].equals(".")){
                                                                reversiBoard[row-q][column-q]="_";
                                                                break;
                                                        else
                                                                q++;
                                                        }
                                                }
                                        }
                                        q=2;
                        }
			//checkRightDownDiagonal
			for(int row=i, column=j; row<8, column<8; row++, column++){
                                        if(reversiBoard[row][column].equals("O"){
                                                if(row+1<8&&column+1<8&&reversiBoard[row+1][column+1].equals("X")){
                                                        if(row+l<8&&column+l<8&&reversiBoard[row+l][column+l].equals(".")){
                                                                reversiBoard[row+l][column+l]="_";
                                                                break;
                                                        }
                                                        else
                                                                l++;
                                                }
                                        }
                                        l=2;
                        }
			
			//checkLeftDownDiagonal
			for(int row=i, column=j; row<8, column<0; row++, column--){
                                if(reversiBoard[row][column].equals("O"){
                                        if(row+1<8&&column-1>0&& reversiBoard[row+1][column-1].equals("X")){
                                                if(row+r<8&&column-r>0&&reversiBoard[row+r][column-r].equals(".")){
                                                        reversiBoard[row+r][column-r]="_";
                                                        break;
                                                }
                                                else
                                                        r++;
                                        }
                                }
                                r=2;
                        }

			//checkRightUpDiagonal
			           for(int row=i, column=j; row>0, column<8; row--, column++){
                                if(reversiBoard[row][column].equals("O"){
                                        if(row-1>0&&column+1<8&& reversiBoard[row-1][column+1].equals("X")){
                                                if(row-s>0&&column+s<8&&reversiBoard[row-s][column+s].equals(".")){
                                                        reversiBoard[row-s][column+s]="_";
                                                        break;
                                                }
                                                else
                                                        s++;
                                        }
                                }
                                s=2;
                        }
                }
}
			









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
