public class HumanPlayer extends Player{
	//attributes
	private int row;
	private int column;
	private String playersToken;
	
	public HumanPlayer(String playersToken){
		super(playersToken);
		this.playersToken=playersToken;
	
	}//constructor
	

	
	@override
	public boolean moveValidation(Board ReversiBoard){
		if(ReversiBoard[row-1][column-1].equals("_")&&row<8&&row>0&&column<8&&row>0 )
			return true;
		else
			return false;
	}//moveValidation
	
	@override
	public ReversiBoard playersMove(String playersToken, int row, int column, Board ReversiBoard){
	if(row>0&&row<8&&column>0&&column<8){
		this.row=row;
		this.column=column;
	}
	if(moveValidation(ReversiBoard)==true)
		changeBoard(playersToken, row, column, ReversiBoard);
		
	return ReversiBoard;
	}//playersMove

	

	@override
	public ReversiBoard changeBoard(String playersToken, int row, int column, Board ReversiBoard){
		int changeToRow=0;
		int changeToColumn=0;
		boolean vertical=false;
		boolean horizontal=false;
		boolean diagonal=false;
		ReversiBoard[row][column]=" "+ playersToken+ " ";
		
		//horizontal loop changer
		
		//vertical loop changer
		
		//diagonal loop changer
					
				
		
	return ReversiBoard;
	}//ReversiBoard

	public void showHorizontalMoves(Board reversiBoard, String playerToken ){
	        if(playerToken.equals("X"){

        for(int i=0; i<8; i++){
                for(int j=0; j<8;j++){
                        checkLeft=false;
                        checkRight=false;
                if(reversiBoard[i][j].equals("X"){
                        if(j-1>0&&reversiBoard[i][j-1].equals("O"))
                                checkLeft=true;
                        if(j+1<8&&reversiBoard[i][j+1].equals("O"))
                                checkRight=true;
                        if(checkAbove==true){
                                for(int q=j-2;q>0; q--){
                                        if(reversiBoard[i][q].equals(".")){
                                                reversiBoard[i][q]="_";
                                                break;
                                        }
                                 }
                        }
                        if(checkBelow==true){
                                for(int t=j+2; t<8; t++){
                                        if(reversiBoard[i][t].equals(".")){
                                                reversiBoard[i][t]="_";
                                                break;
                                        }
                                }
                        }
                }
        }
}
}
        if(playerToken.equals("O"){
         for(int i=0; i<8; i++){
                for(int j=0; j<8;j++){
                        checkAbove=false;
                        checkBelow=false;
                if(reversiBoard[i][j].equals("O"){
                        if(j-1>0&&reversiBoard[i][j-1].equals("X"))
                                checkAbove=true;
                        if(i+1<8&&reversiBoard[i][j-1].equals("X"))
                                checkBelow=true;
                        if(checkAbove==true){
                                for(int q=j-2;q>0; q--){
                                        if(reversiBoard[i][q].equals(".")){
                                                reversiBoard[i][q]="_";
                                                break;
                                        }
                                 }
                        }
                        if(checkBelow==true){
                                for(int t=j+2; t<8; t++){
                                        if(reversiBoard[i][t].equals(".")){
                                                reversiBoard[i][t]="_";
                                                break;
                                        }
                                }
                        }
                }
        }
        }
        }		

	}//showHorizontalMoves

	public void showVerticalMoves(Board reversiBoard, String playerToken){
	if(playerToken.equals("X"){
	
	for(int j=0; j<8;j++){
		for(int i=0; i<8; i++){
			checkAbove=false;
                        checkBelow=false;
		if(reversiBoard[i][j].equals("X"){
			if(i-1>0&&reversiBoard[i-1][j].equals("O"))
				checkAbove=true;
			if(i+1<8&&reversiBoard[i+1][j].equals("O"))
				checkBelow=true;
			if(checkAbove==true){
				for(int q=i-2;q>0; q--){
					if(reversiBoard[q][j].equals(".")){
						reversiBoard[q][j]="_";
						break;
					}
				 }
			}
			if(checkBelow==true){
				for(int t=i+2; t<8; t++){
					if(reversiBoard[t][j].equals(".")){
						reversiBoard[t][j]="_";
						break;
					}
				}
			}
		}
	}
	if(playerToken.equals("O"){
	for(int j=0; j<8;j++){
                for(int i=0; i<8; i++){
			checkAbove=false;
			checkBelow=false;
		if(reversiBoard[i][j].equals("O"){
                        if(i-1>0&&reversiBoard[i-1][j].equals("X"))
                                checkAbove=true;
                        if(i+1<8&&reversiBoard[i+1][j].equals("X"))
                                checkBelow=true;
                        if(checkAbove==true){
                                for(int q=i-2;q>0; q--){
                                        if(reversiBoard[q][j].equals(".")){
                                                reversiBoard[q][j]="_";
                                                break;
                                        }
                                 }
                        }
                        if(checkBelow==true){
                                for(int t=i+2; t<8; t++){
                                        if(reversiBoard[t][j].equals(".")){
                                                reversiBoard[t][j]="_";
                                                break;
                                        }
                                }
                        }
                }
	}
	}
	}
	}//showVerticalMoves

	public void showDiagonalMoves(Board reversiBoard, String playerToken){

	}//showDiagonalMoves


	




}//Human Player

