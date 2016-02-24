public abstract class ComputerPlayer extends Player{

	//attributes
	protected int randomRow;
	protected int randomColumn;
	protected String playersToken;
	Random randomGenerator=new Random();


	public ComputerPlayer(String playersToken){
		super(playersToken);
		this.playersToken=playersToken;

		
	}//constructor


	public int getRandomRow(){
		randomRow=randomGenerator.nextInt(8);
	
	}//getRandomRow

	public int getRandomColumn(){
		randomColumn=randomGenerator.nextInt(8);

	}//getRandomColumn

	@override
	public boolean moveValidation(int row, int column, Board ReversiBoard){
		boolean status=false
		while(status==false){
		if(!(ReversiBoard[row-1][column-1].equals("."))){
			getRandomRow();
			getRandomColumn();
			status=false;
		}
		else 
			status=true;
		}
		return status;
			
	}//moveValidation

	@override
	public ReversiBoard changeBoard(){
	}//changeBoard


}//ComputerPlayer
