public class HumanPlayer extends Player{
	//attributes
	private int row;
	private int column;
	private String playersToken;
	
	public HumanPlayer(String playersToken){
		super(playersToken);
		this.playersToken=playersToken;
	
	}//constructor
	

	
	@override
	public boolean moveValidation(Board ReversiBoard){
		if(ReversiBoard[row-1][column-1].equals("_")&&row<8&&row>0&&column<8&&row>0 )
			return true;
		else
			return false;
	}//moveValidation
	
	@override
	public ReversiBoard playersMove(String playersToken, int row, int column, Board ReversiBoard){
	if(row>0&&row<8&&column>0&&column<8){
		this.row=row;
		this.column=column;
	}
	if(moveValidation(ReversiBoard)==true)
		changeBoard(playersToken, row, column, ReversiBoard);
		
	return ReversiBoard;
	}//playersMove

	

	@override
	public ReversiBoard changeBoard(String playersToken, int row, int column, Board ReversiBoard){
		ReversiBoard[row][column]=playersToken;
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
			if(ReversiBoard[row][j].equals("_"){
				lastRightIndexToChange=j;
				changeToRight=true;
				break;
			}
			if(changeToRight==true){
				for(int q=column; q<=lastRightIndexToChange; q++){
					ReversiBoard[row][q]=playersToken;
				}
			}
		lastRightIndexToChange=100;
		changeToRight=false;
		}
		//horizontal left loop changer
		for(int j=column; j>0; j--){
			if(ReversiBoard[row][j].equals("_"){
				lastLeftIndexToChange=j;
				changeToLeft=true;
				break;
			}
			if(changeToLeft=true){
				for(int q=column; q>=lastLeftIndexToChange; q--){
					ReversiBoard[row][q]=playersToken;
				}
			}
		changeToLeft=false;
		lastLeftIndexToChange=-1;
		}
		//vertical up loop changer
		for(int i=row; i>0; i--){
			if(ReversiBoard[i][column].equals("_"){
				lastUpIndexToChange=i;
				changeUp=true;
				break;
			}
			if(changeUp=true){
				for(int t=row; t>=lastUpIndexToChange; t--){
					ReversiBoard[t][column]=playersToken;
				}
			}
		changeUp=false;
		lastUpIndexToChange=-1;
		}

		//vertical down checker
		for(int i=row; i<8; i++){
                        if(ReversiBoard[i][column].equals("_"){         
                                lastDownIndexToChange=i;
                                changeDown=true;
                                break;
                        }
                        if(changeDown=true){
                                for(int t=row; t<=lastUpIndexToChange; t++){
                                        ReversiBoard[t][column]=playersToken;
                                }
                        }
                changeDown=false;
                lastDownIndexToChange=100;
                }
				


		//diagonal left up loop changer
		for(int i=row, j=column; i>0&&j>0; j--, i--){		
			if(ReversiBoard[i][j].equals("_"){
				lastLeftUpRowIndex=i;
				lastLeftUpColumnIndex=j;
				changeLeftUp=true;
				break;
			}
			if(changeLeftUp=true){
				for(int q=row, t=column; q>=lastLeftUpRowIndex, t>=lastLeftUpColumnIndex; q--, t--){
						ReversiBoard[q][t]=playersToken;
				}
			}
			changeLeftUp=false;
			lastLeftUpRowIndex=-1;
			lastLeftUpColumnIndex=-1;
		}

		//diagonal right down loop changer
		
		   for(int i=row, j=column; i<8&&j<8; j++, i++){
                        if(ReversiBoard[i][j].equals("_"){                      
                                lastRightDownRowIndex=i;
                                lastRightDownColumnIndex=j;
                                changeRightDown=true;
                                break;
                        }
                        if(changeRightDown=true){
                                for(int q=row, t=column; q<=lastRightDownRowIndex, t<=lastRightDownColumnIndex; q++, t++){                                                                      
					ReversiBoard[q][t]=playersToken;
                                
				}
                        }
                        changeRightDown=false;
                        lastRightDownRowIndex=100;
                        lastRightDownColumnIndex=100;
                }

		//diagonal right up loop checker

		  for(int i=row, j=column; i>0&&j<8; j++, i--){
                        if(ReversiBoard[i][j].equals("_"){
                                lastRightUpRowIndex=i;
                                lastRightUpColumnIndex=j;
                                changeRightUp=true;
                                break;
                        }
                        if(changeRightUp=true){
                                for(int q=row, t=column; q>=lastRightDownRowIndex, t<=lastRightDownColumnIndex; q--, t++){                                                                      
					ReversiBoard[q][t]=playersToken;
                                }
                        }
                        changeRightUp=false;
                        lastRightUpRowIndex=-1;
                        lastRightUpColumnIndex=100;
                }
		//diagonal left down loop checker
		
		for(int i=row, j=column; i<8&&j>0; j--, i++){
                        if(ReversiBoard[i][j].equals("_"){
                                lastLeftDownRowIndex=i;
                                lastLeftDownColumnIndex=j;
                                changeLeftDown=true;
                                break;
                        }
                        if(changeLeftDown=true){
                                for(int q=row, t=column; q<=lastLeftUpRowIndex, t>=lastLeftUpColumnIndex; q++, t--){
                                                ReversiBoard[q][t]=playersToken;
                                }
                        }
                        changeLeftDown=false;
                        lastLeftDownRowIndex=100;
                        lastLeftDownColumnIndex=-1;
                }				
				
		
	return ReversiBoard;
	}//ReversiBoard



	




}//Human Player

