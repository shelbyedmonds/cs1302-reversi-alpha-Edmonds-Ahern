public class RandomComputerPlayer extends Player{

/**This is the constructor for this class.
 * This constructors main purpose is to call the 
 * constructors of its parent classes. 
 * 
 * @param playersToken - String
 * @return nothing
 */
	public RandomComputerPlayer(String playersToken){
		super(playersToken);
	}//RandomComputerPlayer
	


/**This method returns the number of Tokens a particular player has on the board.
 *
 * @param playersToken - String 
 * @param reversiBoard- String [][]
 * @return int 
 */
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
	
	
	

}//RandomComputerPlayer
