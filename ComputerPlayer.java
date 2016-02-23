public abstract class ComputerPlayer extends Player{

	//attributes
	protected int randomRow;
	protected int randomColumn;

	public ComputerPlayer(){
	}//constructor


	public int getRandomRow(){
	}//getRandomRow

	public int getRandomColumn(){
	}//getRandomColumn

	@override
	public boolean moveValidation(){
	}//moveValidation

	@override
	public ReversiBoard changeBoard(){
	}//changeBoard


}//ComputerPlayer
