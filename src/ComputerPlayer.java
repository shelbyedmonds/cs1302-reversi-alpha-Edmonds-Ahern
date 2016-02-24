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
		randomGenerator.nextInt(8);

	}//getRandomRow

	public int getRandomColumn(){
		randomGenerator.nextInt(8);
	}//getRandomColumn

	@override
	public boolean moveValidation(){
	}//moveValidation

	@override
	public ReversiBoard changeBoard(){
	}//changeBoard


}//ComputerPlayer
