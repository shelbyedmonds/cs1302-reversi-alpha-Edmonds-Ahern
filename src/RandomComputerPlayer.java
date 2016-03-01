public class RandomComputerPlayer extends Player{


	public RandomComputerPlayer(String playersToken){
		super(playersToken);
	}//RandomComputerPlayer
	

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
