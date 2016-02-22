public abstract class ComputerPlayer extends Player{

	//attributes
	protected int randomRow;
	protected int randomColumn;

	public ComputerPlayer(){
	}//constructor

	@override
	public int getTurnNum(){
	} //getTurnNum

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

	@override
	public void setTurn(){
	}//setTurn

}//ComputerPlayer
