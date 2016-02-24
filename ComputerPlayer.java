public abstract class ComputerPlayer extends Player{

	//attributes
	protected int randomRow;
	protected int randomColumn;
	protected String playerToken;

	public ComputerPlayer(String playerToken){
		super(playerToken);
		Random randomGen= new Random();
		
	}//constructor


	public int getRandomRow(){
		randomRow=randomGen.nextInt(8);
		return randomRow;
	}//getRandomRow

	public int getRandomColumn(){
		randomColumn=randomGen.nextInt(8);
		return randomColumn;
	}//getRandomColumn

	@override
	public boolean moveValidation(Board reversiBoard){
		boolean moveFinder=false;
		while(moveFinder==false){
			getRandomRow();
			getRandomColumn();
			if(reversiBoard[randomRow][randomColumn].equals("_"))
				moveFinder=true;
		}//while
				
	}//moveValidation

	@override
	public ReversiBoard changeBoard(){
	}//changeBoard


}//ComputerPlayer
