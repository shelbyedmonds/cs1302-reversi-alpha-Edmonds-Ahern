public abstract class ComputerPlayer extends Player{

	//attributes
	protected int randomRow;
	protected int randomColumn;
	protected String playersToken;


	public ComputerPlayer(String playersToken){
		super(playersToken);
		Random randomGenerator=new Random();
		this.playersToken=playersToken;

		
	}//constructor


	public int getRandomRow(){
		randomRow=randomGenerator.nextInt(8);
	
	}//getRandomRow

	public int getRandomColumn(){
		randomColumn=randomGenerator.nextInt(8);

	}//getRandomColumn

	@override
	public boolean moveValidation(Board ReversiBoard){
		
		boolean status=false
		while(status==false){
		getRandomRow();
		getRandomColumn();
		if(ReversiBoard[randomRow][randomColumn].equals("_")){
			status=true;
		}
		}
		return status;
			
	}//moveValidation

	@override
	public ReversiBoard changeBoard(String playersToken, Board ReversiBoard){
		moveValidation(ReversiBoard);
		ReversiBoard[randomRow][randomColumn]=playersToken;
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
		for(int j=randomColumn; j<8; j++){
                        if(ReversiBoard[randomRow][j].equals("_"){
                                lastRightIndexToChange=j;
                                changeToRight=true;
                                break;
                        }
                        if(changeToRight==true){
                                for(int q=randomColumn; q<=lastRightIndexToChange; q++){
                                        ReversiBoard[randomRow][q]=playersToken;
                                }
                        }
                lastRightIndexToChange=100;
                changeToRight=false;
                }

		//horizontal left loop changer
		for(int j=randomColumn; j>0; j--){
                        if(ReversiBoard[randomRow][j].equals("_"){
                                lastLeftIndexToChange=j;
                                changeToLeft=true;
                                break;
                        }
                        if(changeToLeft=true){
                                for(int q=randomColumn; q>=lastLeftIndexToChange; q--){
                                        ReversiBoard[randomRow][q]=playersToken;
                                }
                        }
                changeToLeft=false;
                lastLeftIndexToChange=-1;
                }
		
		//vertical up loop changer
		for(int i=randomRow; i>0; i--){
                        if(ReversiBoard[i][randomColumn].equals("_"){
                                lastUpIndexToChange=i;
                                changeUp=true;
                                break;
                        }
                        if(changeUp=true){
                                for(int t=randomRow; t>=lastUpIndexToChange; t--){
                                        ReversiBoard[t][randomColumn]=playersToken;
                                }
                        }
                changeUp=false;
                lastUpIndexToChange=-1;
                }

		//vertical down loop changer
		for(int i=randomRow; i<8; i++){
                        if(ReversiBoard[i][randomColumn].equals("_"){
                                lastDownIndexToChange=i;
                                changeDown=true;
                                break;
                        }
                        if(changeDown=true){
                                for(int t=randomRow; t<=lastUpIndexToChange; t++){
                                        ReversiBoard[t][randomColumn]=playersToken;
                                }
                        }
                changeDown=false;
                lastDownIndexToChange=100;
                }

		//diagonal left up loop changer
		for(int i=randomRow, j=randomColumn; i>0&&j>0; j--, i--){
                        if(ReversiBoard[i][j].equals("_"){
                                lastLeftUpRowIndex=i;
                                lastLeftUpColumnIndex=j;
                                changeLeftUp=true;
                                break;
                        }
                        if(changeLeftUp=true){
                                for(int q=randomRow, t=randomColumn; q>=lastLeftUpRowIndex, t>=lastLeftUpColumnIndex; q--, t--){
                                                ReversiBoard[q][t]=playersToken;
                                }
                        }
                        changeLeftUp=false;
                        lastLeftUpRowIndex=-1;
                        lastLeftUpColumnIndex=-1;
                }
		//diagonal right down loop changer
		for(int i=randomRow, j=randomColumn; i>0&&j<8; j++, i--){
                        if(ReversiBoard[i][j].equals("_"){
                                lastRightUpRowIndex=i;
                                lastRightUpColumnIndex=j;
                                changeRightUp=true;
                                break;
                        }
                        if(changeRightUp=true){
                                for(int q=randomRow, t=randomColumn; q>=lastRightDownRowIndex, t<=lastRightDownColumnIndex; q--, t++){                                     
                                        ReversiBoard[q][t]=playersToken;
                                }
                        }
                        changeRightUp=false;
                        lastRightUpRowIndex=-1;
                        lastRightUpColumnIndex=100;
                }

		//diagonal right up loop changer
		for(int i=randomRow, j=randomColumn; i>0&&j<8; j++, i--){
                        if(ReversiBoard[i][j].equals("_"){
                                lastRightUpRowIndex=i;
                                lastRightUpColumnIndex=j;
                                changeRightUp=true;
                                break;
                        }
                        if(changeRightUp=true){
                                for(int q=randomRow, t=randomColumn; q>=lastRightDownRowIndex, t<=lastRightDownColumnIndex; q--, t++){                                     
                                        ReversiBoard[q][t]=playersToken;
                                }
                        }
                        changeRightUp=false;
                        lastRightUpRowIndex=-1;
                        lastRightUpColumnIndex=100;
                }

		//diagonal left down loop changer
		for(int i=randomRow, j=randomColumn; i<8&&j>0; j--, i++){
                        if(ReversiBoard[i][j].equals("_"){
                                lastLeftDownRowIndex=i;
                                lastLeftDownColumnIndex=j;
                                changeLeftDown=true;
                                break;
                        }
                        if(changeLeftDown=true){
                                for(int q=randomRow, t=randomColumn; q<=lastLeftUpRowIndex, t>=lastLeftUpColumnIndex; q++, t--){
                                                ReversiBoard[q][t]=playersToken;
                                }
                        }
                        changeLeftDown=false;
                        lastLeftDownRowIndex=100;
                        lastLeftDownColumnIndex=-1;
                }


		return ReversiBoard;
	}//changeBoard





}//ComputerPlayer
