public class RandomComputerPlayer extends Player{
	//attributes 
	Random random= new Random();

	/**DO WE NEED A CONSTRUCTOR HERE AS WELL?*/

	

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
