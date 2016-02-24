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
	public ReversiBoard changeBoard(){
	}//changeBoard

	public abstract void showVerticalMoves(Board reversiBoard, String playerToken){
        }//showVerticalMoves

        public abstract void showHorizontalMoves(Board reversiBoard, String playerToken){
        }//showHorizontalMoves

        public abstract void showDiagonalMoves(Board reversiBoard, String playerToken){
        }//showDiagonalMoves




}//ComputerPlayer
