public class HumanPlayer extends Player{
	//attributes
	private String playersToken;

	
/**This is a constructor for the human player class.
 * It takes in the desired players token so it can call the parent constructor as well.
 * @param playersToken a string that denotes the players token
 */
	public HumanPlayer(String playersToken){
		super(playersToken);
		this.playersToken=playersToken;
	
	}//constructor
	
public int howManyTokens(String playersToken, String [][] reversiBoard){
	int tokens=0;
	for(int i=0; i<8; i++){
		for(int j=0; j<8; j++){
			if(reversiBoard[i][j].equals(playersToken))
				tokens++;
		}
	}
	return tokens;
	
}//howManyTokens
}//Human Player

