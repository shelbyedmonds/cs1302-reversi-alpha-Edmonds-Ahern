public class RandomComputerPlayer extends Player{
	//attributes 
	Random random= new Random();

	/**DO WE NEED A CONSTRUCTOR HERE AS WELL?*/

	@override
	public int getRandomRow(){
	
	return randomRow;
	}//getRandomRow

	@override
	public int getRandomColumn(){
	
	return randomColumn;
	}//getRandomColumn

	@override
	public int getTurn(){
	return turn;
	}//getTurn

	@override
	public boolean moveValidation(){
	return false;
	}//moveValidation

	@override
	public ReversiBoard playersMove(){
	return ReversiBoard;
	}//playersMove

	@override 
	public boolean isYourTurn(){
	return false;
	}//isYourTurn

	@override 
	public ReversiBoard changeBoard(){
	return ReversiBoard;
	}//changeBoard
	
	@override 
	public void setTurn(){
	
	/** SHOULD WE ADD A PARAMETER TO SET THE TURN TO?*/
	}//setTurn
	

}//RandomComputerPlayer
