import java.util.Scanner;
import java.util.Random;
public class Reversi{
	
			
//		static HumanPlayer player1;
//		static HumanPlayer player2;
//		static RandomComputerPlayer computer1;
//		static RandomComputerPlayer computer2;
		static String playerAToken="";
		static Player player1;
		static Player player2;
                static String playerBToken="";
		static boolean gameStatus=false;
		static ReversiBoard board = new ReversiBoard();
		static int numPiecesX = 2;
		static int numPiecesO = 2;
		static int totalNumPieces = 4;
		

/**This is the main method for the game.
 * It starts game play by calling other methods. Another
 * important role this method plays is deciding which type of players 
 * the game will be played by.
 *
 * @param args -String []
 * @return none
 */
	public static void main(String [] args){

		Player [] players= new Player [2];		

		if(args.length!=2){
			System.out.println("Error! To play Reversi you need exactly 2 players.");
			System.exit(0);
		}
		else{
			for(int i=0; i<2; i++){
				if(args[i].equalsIgnoreCase("Human")&&i==0){
					player1=new HumanPlayer("X");
					playerAToken="X";
				//	players[0]=player1;
				}
				else if(args[i].equalsIgnoreCase("RandomComputerPlayer")&&i==0){
					player1=new RandomComputerPlayer("X");
					playerAToken="X";
				//	players[0]=computer1;
				}	
				else if(args[i].equalsIgnoreCase("Human")&&i==1){
					player2=new HumanPlayer("O");
					playerAToken="O";
				//	players[1]=player2;
				}
				else if(args[i].equalsIgnoreCase("RandomComputerPlayer")&&i==1){
					player2=new RandomComputerPlayer("O");
					playerAToken="O";
				//	players[1]=computer2;
				}
				else{
				System.out.println("Invalid Input");
				System.exit(0);
				}

			}
		}	
		

	//	ReversiBoard board=new ReversiBoard();
		board.setBoard(board.initializeBoard());
		board.setBoard(board.markLegalMoves());	
		welcome();
		board.displayBoard(board.getBoard());
		System.out.println();


	while(totalNumPieces<64 && numPiecesX>0 && numPiecesO>0){
		if(underscoreChecker()>0 && countPieces("X")>0){
		int[] player1move = getInput(player1);
		System.out.println();
	//	player1move = getInput(player1);
		board.makeMove(player1move[0], player1move[1]);
		board.setBoard(board.clearValidMoves());
		board.setMoveCount(board.getMoveCount()+1);
		board.setBoard(board.markLegalMoves());
		board.displayBoard(board.getBoard());
		System.out.println();
		}
		else{
			System.out.println("No available moves for " + board.turnIndicator() + ".");
			board.setMoveCount(board.getMoveCount()+1);
			board.setBoard(board.clearValidMoves());
			board.setBoard(board.markLegalMoves());
			board.displayBoard(board.getBoard());
		}
         	if(underscoreChecker()>0 && countPieces("O")>0){       
		int[] player2move = getInput(player2);
		System.out.println();
	//	player2move = getInput(player2);
		board.makeMove(player2move[0], player2move[1]);
                board.setBoard(board.clearValidMoves());
                board.setMoveCount(board.getMoveCount()+1);
                board.setBoard(board.markLegalMoves());
                board.displayBoard(board.getBoard());		
		System.out.println();
		}
		else{
			System.out.println("No available moves for " + board.turnIndicator() + ".");
                        board.setMoveCount(board.getMoveCount()+1);
			board.setBoard(board.clearValidMoves());
                        board.setBoard(board.markLegalMoves());
                        board.displayBoard(board.getBoard());

		}
		numPiecesX=countPieces("X");
		numPiecesO=countPieces("O");
		totalNumPieces=numPiecesX+numPiecesO;
	}
	winner();
	}
		

	


/**This method welcomes the player to the game.
 *
 * @param none
 * @return none
 */	
	public static  void welcome(){
		System.out.println("Welcome to Reversi! Moves should be entered in \"[Row][Column]\" format.");
	}//welcome

/**This method checks to see if there are any underscores on the board.
 * 
 * @param none
 * @return int 
 */	
	public static int underscoreChecker(){
		int underscores=0;
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board.getBoard()[i][j].equals("_"))
					underscores++;
			}
		}
		return underscores;
	}//underscoreChecker;

/**This method gets input from the player. 
 * 
 * @param p - Player that tells which type of player is calling the method.
 * @return int []
 */
	public static int[]  getInput(Player p){
		int [] move=new int[2];
		Random randGen= new Random();
		int uncheckedRow;
		int uncheckedCol;
		int row;
		int col;
		boolean moveIsGood=false;
		String input = "";
		if(p instanceof HumanPlayer){
			System.out.print("Enter your move player " + board.turnIndicator() + ": ");
			Scanner keyboard = new Scanner(System.in);
			while (moveIsGood == false) {	
				input = keyboard.nextLine();
			//	Scanner reader = new Scanner(input);
				if (input.trim().length() != 3 || input.trim().charAt(1) != ' ') {
					System.out.print("Invalid input. Enter your move player " + board.turnIndicator() + ": ");
				//	keyboard.nextLine();
				}
				else {
					uncheckedRow = Integer.parseInt("" + input.charAt(0));
					uncheckedCol = Integer.parseInt("" + input.charAt(2));
					if (uncheckedRow > 0 && uncheckedRow < 9 && uncheckedCol > 0 && uncheckedCol < 9) {
						if (board.getBoard()[uncheckedRow-1][uncheckedCol-1].equals("_")) {
							move[0] = uncheckedRow-1;
							move[1] = uncheckedCol-1;
							moveIsGood = true;
							return move;
						}
						else {
							System.out.print("Invalid move. Enter your move player " + board.turnIndicator() + ": ");
						}
					}
					else {
						System.out.print("Invalid move. Enter your move player " + board.turnIndicator() + ": ");
				//		keyboard.nextLine();
					}
				
				}
			}
		}
		/*		if (reader.hasNextInt()) {
					uncheckedRow = reader.nextInt();
					if (reader.hasNextInt()) {
						uncheckedCol = reader.nextInt();
		//				reader.nextLine();
						if (reader.hasNext()) {
							System.out.println("Invalid move. Enter your move player " + board.turnIndicator() + " ");
						//	keyboard.nextLine();
						}
						else {
						//	uncheckedRow = reader.nextInt();
						//	uncheckedCol = reader.nextInt();
							if (uncheckedRow > 0 && uncheckedRow < 9 && uncheckedCol > 0 && uncheckedCol < 9) {
								if (board.getBoard()[uncheckedRow-1][uncheckedCol-1].equals("_")) {
									move[0] = uncheckedRow-1;
									move[1] = uncheckedCol-1;
									moveIsGood = true;
									return move;
								}
							}
							else {
								System.out.println("Invalid move entry. Enter your move player " + board.turnIndicator() + " ");
								keyboard.nextLine();
							}
						}
					}
					else {
						System.out.println("Invalid move entry. Enter your move player " + board.turnIndicator() + " ");
						//reader.next();
					}
				}
				else {
					System.out.println("Invalid move entry. Enter your move player " + board.turnIndicator() + " ");
				//	reader.next();
				} */
			
		
		else if (p instanceof RandomComputerPlayer) {
			System.out.print("Enter your move player " + board.turnIndicator() + " ");
			uncheckedRow=randGen.nextInt(8);
			uncheckedCol=randGen.nextInt(8);
			if(board.getBoard()[uncheckedRow][uncheckedCol].equals("_")){
				row=uncheckedRow;
				col=uncheckedCol;
				move[0]=row;
				move[1]=col;
				try {
					Thread.sleep(2000);
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				System.out.print((row+1) + " " + (col+1));
				return move;
			}
			else {
				do {
					uncheckedRow=randGen.nextInt(8);
					uncheckedCol=randGen.nextInt(8);
					if(board.getBoard()[uncheckedRow][uncheckedCol].equals("_")){
						row=uncheckedRow;
						col=uncheckedCol;
						move[0]=row;
						move[1]=col;
						System.out.print((row+1) + " " + (col+1) + "\n");
						moveIsGood=true;
					}
				}while(moveIsGood==false);
			}
			return move;
		}
		return move;
	}

		public static int countPieces(String token){
			int tokenCounter = 0;
			for(int i=0; i<8; i++){
				for(int j=0; j<8; j++){
					if(board.getBoard()[i][j].equals(token)){
						tokenCounter++;
					}
				}
			}
			return tokenCounter;
		}

		public static void winner() {
			if (countPieces("X") > countPieces("O")) {
				System.out.println("Congratulations player X. You defeated\nplayer O " + countPieces("X") + " to " + countPieces("O"));
			}
			else if (countPieces("X") < countPieces("O")) {
				System.out.println("Congratulations player O. You defeated\nplayer X " + countPieces("O") + " to " + countPieces("X"));
			}
			else {
				System.out.println("The game ended in a tie.");
			}
			System.out.println("Thanks for playing!\n");
			System.exit(0);
		}
			

	
}	


