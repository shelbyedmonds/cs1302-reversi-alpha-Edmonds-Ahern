public class HumanPlayer extends Player{
	//attributes
	private int row;
	private int column;
	private String playersToken;
	
/**This is a constructor for the human player class.
 * It takes in the desired players token so it can call the parent constructor as well.
 * @param playersToken a string that denotes the players token
 */
	public HumanPlayer(String playersToken){
		super(playersToken);
		this.playersToken=playersToken;
	
	}//constructor
	

/**This method validates the move a player wants to make 
 * @param reversiBoard a 2 dimensional array that represents the game board.
 * @return boolean if the move is validated.
 */	
	@override
	public boolean moveValidation(String [][] reversiBoard){
		if(reversiBoard[row-1][column-1].equals("_")&&row<8&&row>0&&column<8&&row>0 )
			return true;
		else
			return false;
	}//moveValidation

/**This method makes a move for the player. This method also calls subsequent methods to 
 * determine if the move can be made or not. 
 * @param playersToken a string value that represents the player
 * @param row an int value that shows which row they want to move a piece to
 * @param column an int value that shows which column they want to move a piece to
 * @param reversiBoard a 2 dimensional string that represents the game board
 * @return String [][] a two dimensional string array that represeents the modified board
 */	
	@override
	public String [][] playersMove(String playersToken, int row, int column, String [][] reversiBoard){
	if(row>0&&row<8&&column>0&&column<8){
		this.row=row;
		this.column=column;
	}
	if(moveValidation(reversiBoard)==true)
		changeBoard(playersToken, row, column, reversiBoard);
		
	return reversiBoard;
	}//playersMove

	
/**This method changes the board for the players move. It takes into account which way the player moved and 
 * changes all the pieces accordingly.
 * @param playersToken a string representing the player's token
 * @param row an int showing which row they moved a piece to
 * @param column an int showing which column they moved a piece to 
 * @param reversiBoard a two dimensional array that represents the game board
 * @return String [][] an array that represents the game board
 */
	@override
	public String [][] changeBoard(String playersToken, int row, int column, String [][] reversiBoard){
		reversiBoard[row][column]=playersToken;
		boolean changeToLeft=false;
		boolean changeToRight=false;
		boolean changeUp=false;
		boolean changeDown=false;
		int lastRightIndexToChange=100;
		int lastLeftIndexToChange=-1;
		int lastUpIndexToChange;
		int lastDownIndexToChange;	
		boolean changeLeftUp=false;
                int lastLeftUpRowIndex=-1;
                int lastLeftUpColumnIndex=-1;
		boolean changeRightDown=false;
                int lastRightDownRowIndex=100;
                int lastRightDownColumnIndex=100;
		boolean changeRightUp=false;
                int lastRightUpRowIndex=-1;
                int lastRightUpColumnIndex=100;
		boolean changeLeftDown=false;
                int lastLeftDownRowIndex=100;
                int lastLeftDownColumnIndex=-1;
		
		//horizontal right loop changer
		for(int j=column; j<8; j++){
			if(reversiBoard[row][j].equals("_"){
				lastRightIndexToChange=j;
				changeToRight=true;
				break;
			}
			if(changeToRight==true){
				for(int q=column; q<=lastRightIndexToChange; q++){
					reversiBoard[row][q]=playersToken;
				}
			}
		lastRightIndexToChange=100;
		changeToRight=false;
		}
		//horizontal left loop changer
		for(int j=column; j>0; j--){
			if(reversiBoard[row][j].equals("_"){
				lastLeftIndexToChange=j;
				changeToLeft=true;
				break;
			}
			if(changeToLeft=true){
				for(int q=column; q>=lastLeftIndexToChange; q--){
					reversiBoard[row][q]=playersToken;
				}
			}
		changeToLeft=false;
		lastLeftIndexToChange=-1;
		}
		//vertical up loop changer
		for(int i=row; i>0; i--){
			if(reversiBoard[i][column].equals("_"){
				lastUpIndexToChange=i;
				changeUp=true;
				break;
			}
			if(changeUp=true){
				for(int t=row; t>=lastUpIndexToChange; t--){
					reversiBoard[t][column]=playersToken;
				}
			}
		changeUp=false;
		lastUpIndexToChange=-1;
		}

		//vertical down checker
		for(int i=row; i<8; i++){
                        if(reversiBoard[i][column].equals("_"){         
                                lastDownIndexToChange=i;
                                changeDown=true;
                                break;
                        }
                        if(changeDown=true){
                                for(int t=row; t<=lastUpIndexToChange; t++){
                                        reversiBoard[t][column]=playersToken;
                                }
                        }
                changeDown=false;
                lastDownIndexToChange=100;
                }
				


		//diagonal left up loop changer
		for(int i=row, j=column; i>0&&j>0; j--, i--){		
			if(reversiBoard[i][j].equals("_"){
				lastLeftUpRowIndex=i;
				lastLeftUpColumnIndex=j;
				changeLeftUp=true;
				break;
			}
			if(changeLeftUp=true){
				for(int q=row, t=column; q>=lastLeftUpRowIndex, t>=lastLeftUpColumnIndex; q--, t--){
						reversiBoard[q][t]=playersToken;
				}
			}
			changeLeftUp=false;
			lastLeftUpRowIndex=-1;
			lastLeftUpColumnIndex=-1;
		}

		//diagonal right down loop changer
		
		   for(int i=row, j=column; i<8&&j<8; j++, i++){
                        if(reversiBoard[i][j].equals("_"){                      
                                lastRightDownRowIndex=i;
                                lastRightDownColumnIndex=j;
                                changeRightDown=true;
                                break;
                        }
                        if(changeRightDown=true){
                                for(int q=row, t=column; q<=lastRightDownRowIndex, t<=lastRightDownColumnIndex; q++, t++){                                                                      
					reversiBoard[q][t]=playersToken;
                                
				}
                        }
                        changeRightDown=false;
                        lastRightDownRowIndex=100;
                        lastRightDownColumnIndex=100;
                }

		//diagonal right up loop checker

		  for(int i=row, j=column; i>0&&j<8; j++, i--){
                        if(reversiBoard[i][j].equals("_"){
                                lastRightUpRowIndex=i;
                                lastRightUpColumnIndex=j;
                                changeRightUp=true;
                                break;
                        }
                        if(changeRightUp=true){
                                for(int q=row, t=column; q>=lastRightDownRowIndex, t<=lastRightDownColumnIndex; q--, t++){                                                                      
					reversiBoard[q][t]=playersToken;
                                }
                        }
                        changeRightUp=false;
                        lastRightUpRowIndex=-1;
                        lastRightUpColumnIndex=100;
                }
		//diagonal left down loop checker
		
		for(int i=row, j=column; i<8&&j>0; j--, i++){
                        if(reversiBoard[i][j].equals("_"){
                                lastLeftDownRowIndex=i;
                                lastLeftDownColumnIndex=j;
                                changeLeftDown=true;
                                break;
                        }
                        if(changeLeftDown=true){
                                for(int q=row, t=column; q<=lastLeftUpRowIndex, t>=lastLeftUpColumnIndex; q++, t--){
                                                reversiBoard[q][t]=playersToken;
                                }
                        }
                        changeLeftDown=false;
                        lastLeftDownRowIndex=100;
                        lastLeftDownColumnIndex=-1;
                }				
				
		
	return reversiBoard;
	}//ReversiBoard



	




}//Human Player

