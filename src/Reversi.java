import java.util.Scanner;
import java.util.Random;
public class Reversi{
	
			
		static HumanPlayer player1;
		static HumanPlayer player2;
		static RandomComputerPlayer computer1;
		static RandomComputerPlayer computer2;
		static String playerAToken="";
		static Player player1;
		static Player player2;
                static String playerBToken="";
		static boolean gameStatus=false;
		static ReversiBoard board = new ReversiBoard();


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
					computer1=new RandomComputerPlayer("X");
					playerAToken="X";
				//	players[0]=computer1;
				}	
				else if(args[i].equalsIgnoreCase("Human")&&i==1){
					player2=new HumanPlayer("O");
					playerAToken="O";
				//	players[1]=player2;
				}
				else if(args[i].equalsIgnoreCase("RandomComputerPlayer")&&i==1){
					computer2=new RandomComputerPlayer("O");
					playerAToken="O";
				//	players[1]=computer2;
				}
				else{
				System.out.println("Invalid Input");
				System.exit(0);
				}


			}
		}	
		

		//ReversiBoard board=new ReversiBoard();
		board.setBoard(board.initializeBoard());
		
		welcome();
	
	while(true){	
		board.setBoard(board.markLegalMoves());
			
		board.displayBoard(board.getBoard());
		
		
			boolean moveValid=false;
			while(moveValid==false){
			board.setBoard(board.markLegalMoves());
			if(underscoreChecker()==0){
				System.out.println("No valid moves available for Player X.");
				board.setMoveCount(board.getMoveCount()+1);
				moveValid=true;
			}
			else{

			System.out.println("Enter move Player X");
			int row=getInput(player1)[0]-1;
			int column=getInput(player1)[1]-1;
	
			if (board.getBoard()[row][column].equals("_")){
				board.makeMove(row, column);
				board.setBoard(board.clearValidMoves());
				moveValid=true;
				board.setMoveCount(board.getMoveCount()+1);
			}
			else
				System.out.println("Invalid Move!");
			}
			}
			moveValid=false;
			
			while(moveValid==false){
			board.setBoard(board.markLegalMoves());
			if(underscoreChecker()==0){
				System.out.println("No valid moves available for Player O.");
                                board.setMoveCount(board.getMoveCount()+1);
                        	moveValid=true;
			}
			else{
                	board.displayBoard(board.getBoard());
                        System.out.println("Enter move Player O");
                        int row=getInput(player2)[0];
                        int column=getInput(player2)[1];
                        if (board.getBoard()[row][column].equals("_")){
                                board.makeMove(row, column);
                                moveValid=true;
                        }
                        else
                                System.out.println("Invalid Move!");
                        }			
			}
	}
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
	public static int[] getInput(Player p){
		Scanner keyboard=new Scanner(System.in);
		int readRows;
		int[] move = new int[2];
		int readCols;
		boolean moveIsGood=false;
		do{
		String input= keyboard.nextLine();
		Scanner inputReader= new Scanner(input);
		if(inputReader.hasNextInt()) {
			if(inputReader.hasNextInt()) {
				if(!(inputReader.hasNext())) {
					readRows = inputReader.nextInt();
					readCols = inputReader.nextInt();
					if (readRows > 0 && readRows < 9 && readCols > 0 && readCols < 9) {
						move[0] = readRows;
						move[1] = readCols;
						moveIsGood=true;
					}
					else {
						System.out.println("Nope");
					}
				}
				else {
					System.out.println("Nope");
				}
			}
			else {
				System.out.println("nope");
			}
		}
	
		
					
		
	
		
		else {
			System.out.print("Invalid move entry");
		}
		}while (moveIsGood==false);
			

		return move;
	}//getInput (Human)

/**This method pulls in input from the computer so that the computer can randomly play.
 *
 * @param c RandomComputerPlayer
 * @return int [] 
 */
	public static int[] getInput(RandomComputerPlayer c){
		Random randomGen= new Random();
		int [] move = new int[2];
		boolean moveIsGood=false;		
		do{
		int randomRow=randomGen.nextInt(8);
                int randomCol=randomGen.nextInt(8);
		if(board.getBoard()[randomRow][randomCol].equals("_")){
			move[0]=randomRow+1;
			move[1]=randomCol+1;
			moveIsGood=true;
		}
		}while(moveIsGood==false);
		return move;
	}//getInput (Computer)

	
}



