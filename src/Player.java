public abstract class Player{
	//attributes 
	protected int turn;
	protected int numOfTokens;
	protected String token;


/**This is the constructor for the player class.
 * It creates an object with a specific turn number, a num of tokens value, and which token is theirs.
 *
 * @param playerToken a string that denotes which token the player will use. Either X or O.
 */
	
	public Player(String playerToken){
	turn=1;
	numOfTokens=2;
	token=playerToken;
	}//Player


/**This method returns the number of tokens a player object has.
 * 
 *
 *@param reversiBoard 
 */	
	public abstract int howManyTokens(String playersToken, String [][] reversiBoard);

/**This method is used to change the number of tokens a player has.
 * It will be used on each turn when a player makes a move that changes the board.
 *
 * @param tokens an int value that tells the number of tokens a player has on the board.
 * @return void.
 */
	public void changeNumOfTokens(int tokens){
		numOfTokens=tokens;
	}//changeNumOfTokens

	
	

}//Player
