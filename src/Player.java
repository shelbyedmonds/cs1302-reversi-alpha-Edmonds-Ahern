public abstract class Player{
	//attributes 
	protected int turn;
	protected int numOfTokens;
	protected String token;


/**This is the constructor for the player class.
 * It creates an object with a specific turn number, a num of tokens value, and which token is theirs.
 *
 * @param playerToken a string that denotes which token the player will use. Either X or O.
 */
	
	public Player(String playerToken){
	turn=1;
	numOfTokens=2;
	token=playerToken;
	}//Player

/**An abstract method that will later be used to validate moves.
 * @param none
 * @return boolean value of if the move is valid (true) or not (false).
 */
	public abstract boolean moveValidation(){
	}//moveValidation

/**This method returns the number of tokens a player object has.
 * 
 *@param none
 * @return int value of tokens.
 */	
	public int howManyTokens(){
		return numOfTokens;
	}//howManyTokens

/**This method is used to change the number of tokens a player has.
 * It will be used on each turn when a player makes a move that changes the board.
 *
 * @param tokens an int value that tells the number of tokens a player has on the board.
 * @return void.
 */
	public void changeNumOfTokens(int tokens){
		numOfTokens=tokens;
	}//changeNumOfTokens

/**This method will be used to make a move for the player.
 * @param none
 * @return String [][] (the board)
 */
	public abstract String [][] playersMove(){
	}//playersMove
	
	
/**This method will change the board in children classes.
 * @param none
 * @return String [][] (the board)
 */
	public abstract String [][] changeBoard(){
	}//changeBoard

/**This method will return the number of the turn game play is currently on. 
 * @param none
 * @return int the number of turns so far
 */
	public int getTurnNum(){
		return turn;
	}//getTurnNum

/**This method shows the vertical moves present on the board by changing them to underscores to be displayed.
 * @param reversiBoard a two-dimensional string array that represents the game board
 * @param playerToken a string that identifies which player is needing to see their possible moves in a vertical direction.
 *@return void
 */


	public void showVerticalMoves(String [][] reversiBoard, String playerToken){
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
        } //showVerticalMoves

/**This method shows the possible horizontal moves for a specific player by marking them with an underscore. 
 * @param reversiBoard this is a 2 dimensional string array that represents the game board
 * @param playerToken this represents the player in a string format by their token
 * @return void
 */	
	public void showHorizontalMoves(String [][] reversiBoard, String playerToken ){
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

/**This method shows the possible diagonal moves for a specific player
 * @param reversiBoard a two dimensional String array that represents the board
 * @param playerToken a string that represents the player. 
 * @return void
 */

        public void showDiagonalMoves(String [][] reversiBoard, String playerToken){
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

/** This method removes any underscores marking available moves in the game board.
 * @param reversiBoard a two dimensional string array that represents the game board.
 * @return void.
 */
	public void removeAvailableMoveMarkers(String [][] reversiBoard){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(reversiBoard[i][j].equals("_"))
					reversiBoard[i][j]=".";
			}
		}
	}//removeAvailableMoveMarkers

/**This method allows us to change the turn number the game is on if for example an error was made.
 * @param turn an int that tells the desired turn number
 * @return void
 */
	public void setTurn(int turn){
		this.turn=turn;
	}//setTurn

}//Player
