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
	public boolean moveValidation(){
	return false;
	}//moveValidation

	@override
	public ReversiBoard playersMove(){
	return ReversiBoard;
	}//playersMove


	@override 
	public ReversiBoard changeBoard(){
	return ReversiBoard;
	}//changeBoard
	
	
	

}//RandomComputerPlayer
