public abstract class ComputerPlayer extends Player{

	//attributes
	protected int randomRow;
	protected int randomColumn;
	protected String playersToken;


/**This is the constructor for the ComputerPlayer abstract class.
 * It creates an object based on the playersToken which is used to call the parent classes
 * constructor.
 * It also creates a randomGenerator which will be utilized for the computer to play.
 *@param playersToken a string that represents the players token
 */
	public ComputerPlayer(String playersToken){
		super(playersToken);
		Random randomGenerator=new Random();
		this.playersToken=playersToken;

		
	}//constructor

/**This method selects a random row for the computer to play at.
 * @param none
 * @return int
 */
	public int getRandomRow(){
		randomRow=randomGenerator.nextInt(8);
	
	}//getRandomRow

/**This method selects a random column for the computer to play at.
 * @param none
 * @return int
 */
	public int getRandomColumn(){
		randomColumn=randomGenerator.nextInt(8);

	}//getRandomColumn

/**This method validates the move of the computer.
 * @param reversiBoard a two dimensional String array that represents the game board.
 * @return boolean
 */
	@override
	public boolean moveValidation(String [][] reversiBoard){
		
		boolean status=false
		while(status==false){
		getRandomRow();
		getRandomColumn();
		if(reversiBoard[randomRow][randomColumn].equals("_")){
			status=true;
		}
		}
		return status;
			
	}//moveValidation

/** This method changes the board based on the random computer move.
 * @param playersToken a string that represents the players token.
 * @param reversiBoard a 2d string array that represents the game board.
 *@return String [][] a 2d string array that represents the game board
*/

	@override	
	public String [][] changeBoard(String playersToken, String [][] reversiBoard){
		moveValidation(reversiBoard);
		reversiBoard[randomRow][randomColumn]=playersToken;
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
		for(int j=randomColumn; j<8; j++){
                        if(reversiBoard[randomRow][j].equals("_"){
                                lastRightIndexToChange=j;
                                changeToRight=true;
                                break;
                        }
                        if(changeToRight==true){
                                for(int q=randomColumn; q<=lastRightIndexToChange; q++){
                                        reversiBoard[randomRow][q]=playersToken;
                                }
                        }
                lastRightIndexToChange=100;
                changeToRight=false;
                }

		//horizontal left loop changer
		for(int j=randomColumn; j>0; j--){
                        if(reversiBoard[randomRow][j].equals("_"){
                                lastLeftIndexToChange=j;
                                changeToLeft=true;
                                break;
                        }
                        if(changeToLeft=true){
                                for(int q=randomColumn; q>=lastLeftIndexToChange; q--){
                                        reversiBoard[randomRow][q]=playersToken;
                                }
                        }
                changeToLeft=false;
                lastLeftIndexToChange=-1;
                }
		
		//vertical up loop changer
		for(int i=randomRow; i>0; i--){
                        if(reversiBoard[i][randomColumn].equals("_"){
                                lastUpIndexToChange=i;
                                changeUp=true;
                                break;
                        }
                        if(changeUp=true){
                                for(int t=randomRow; t>=lastUpIndexToChange; t--){
                                        reversiBoard[t][randomColumn]=playersToken;
                                }
                        }
                changeUp=false;
                lastUpIndexToChange=-1;
                }

		//vertical down loop changer
		for(int i=randomRow; i<8; i++){
                        if(reversiBoard[i][randomColumn].equals("_"){
                                lastDownIndexToChange=i;
                                changeDown=true;
                                break;
                        }
                        if(changeDown=true){
                                for(int t=randomRow; t<=lastUpIndexToChange; t++){
                                        reversiBoard[t][randomColumn]=playersToken;
                                }
                        }
                changeDown=false;
                lastDownIndexToChange=100;
                }

		//diagonal left up loop changer
		for(int i=randomRow, j=randomColumn; i>0&&j>0; j--, i--){
                        if(reversiBoard[i][j].equals("_"){
                                lastLeftUpRowIndex=i;
                                lastLeftUpColumnIndex=j;
                                changeLeftUp=true;
                                break;
                        }
                        if(changeLeftUp=true){
                                for(int q=randomRow, t=randomColumn; q>=lastLeftUpRowIndex, t>=lastLeftUpColumnIndex; q--, t--){
                                                reversiBoard[q][t]=playersToken;
                                }
                        }
                        changeLeftUp=false;
                        lastLeftUpRowIndex=-1;
                        lastLeftUpColumnIndex=-1;
                }
		//diagonal right down loop changer
		for(int i=randomRow, j=randomColumn; i>0&&j<8; j++, i--){
                        if(reversiBoard[i][j].equals("_"){
                                lastRightUpRowIndex=i;
                                lastRightUpColumnIndex=j;
                                changeRightUp=true;
                                break;
                        }
                        if(changeRightUp=true){
                                for(int q=randomRow, t=randomColumn; q>=lastRightDownRowIndex, t<=lastRightDownColumnIndex; q--, t++){                                     
                                        reversiBoard[q][t]=playersToken;
                                }
                        }
                        changeRightUp=false;
                        lastRightUpRowIndex=-1;
                        lastRightUpColumnIndex=100;
                }

		//diagonal right up loop changer
		for(int i=randomRow, j=randomColumn; i>0&&j<8; j++, i--){
                        if(reversiBoard[i][j].equals("_"){
                                lastRightUpRowIndex=i;
                                lastRightUpColumnIndex=j;
                                changeRightUp=true;
                                break;
                        }
                        if(changeRightUp=true){
                                for(int q=randomRow, t=randomColumn; q>=lastRightDownRowIndex, t<=lastRightDownColumnIndex; q--, t++){                                     
                                        reversiBoard[q][t]=playersToken;
                                }
                        }
                        changeRightUp=false;
                        lastRightUpRowIndex=-1;
                        lastRightUpColumnIndex=100;
                }

		//diagonal left down loop changer
		for(int i=randomRow, j=randomColumn; i<8&&j>0; j--, i++){
                        if(reversiBoard[i][j].equals("_"){
                                lastLeftDownRowIndex=i;
                                lastLeftDownColumnIndex=j;
                                changeLeftDown=true;
                                break;
                        }
                        if(changeLeftDown=true){
                                for(int q=randomRow, t=randomColumn; q<=lastLeftUpRowIndex, t>=lastLeftUpColumnIndex; q++, t--){
                                                reversiBoard[q][t]=playersToken;
                                }
                        }
                        changeLeftDown=false;
                        lastLeftDownRowIndex=100;
                        lastLeftDownColumnIndex=-1;
                }


		return reversiBoard;
	}//changeBoard





}//ComputerPlayer
