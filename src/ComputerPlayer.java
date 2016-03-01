import java.util.Random;
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
		this.playersToken=playersToken;

		
	}//constructor

/**This method selects a random row for the computer to play at.
 * @param none
 * @return int
 */
	public int getRandomRow(){
		Random randomGenerator= new Random();
		randomRow=randomGenerator.nextInt(8);
		return randomRow;
	}//getRandomRow

/**This method selects a random column for the computer to play at.
 * @param none
 * @return int
 */
	public int getRandomColumn(){
		Random randomGenerator= new Random();
		randomColumn=randomGenerator.nextInt(8);
		return randomColumn;
	}//getRandomColumn

/**This method validates the move of the computer.
 * @param reversiBoard a two dimensional String array that represents the game board.
 * @return boolean
 */
//	@override
//	public boolean moveValidation(String [][] reversiBoard){
		
//		boolean status=false
//		while(status==false){
//		getRandomRow();
//		getRandomColumn();
//		if(reversiBoard[randomRow][randomColumn].equals("_")){
//			status=true;
//		}
//		}
//		return status;
			
//	}//moveValidation

public abstract int howManyTokens(String playersToken, String [][] reversiBoard);

} 
