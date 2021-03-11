
import java.util.*;
public class TikTalToeGame 
{
	static Scanner userInput=new Scanner(System.in);
	static char userLetter,computerLetter;
	static char[] playerOrder=new char[2];
	static char[] board;

	public char[] creatingBoard()
	{
		char[] board= new char[10];
		for (int  i=1;i<10;i++) 
		{ 
			{ 
				board[i]=' '; 
			}	
		}
		return board; 
	}


	public static void chooseLetter() {
		System.out.println("enter the user choice letter X or O");
		userLetter=userInput.next().toUpperCase().charAt(0); 
		if(userLetter=='X') {
			computerLetter='O';
			System.out.println("User Choice is "+userLetter);
			System.out.println("Computer Choice is "+computerLetter);
		}
		else if(userLetter=='O') {
			computerLetter='X';  
			System.out.println("User Choice is "+userLetter);
			System.out.println("Computer Choice is "+computerLetter);
		}
		else
		{
			System.out.println("invalid input");
			chooseLetter(); 	
		}
	}   


	public static void showBoard(char[] board)
	{ 
		System.out.println("-+-+-");  
		System.out.println(board[1] + "|" +  board[2] + "|" +  board[3]  );
		System.out.println("-+-+-");
		System.out.println(board[4] + "|" +  board[5] + "|" +  board[6]  );
		System.out.println("-+-+-");
		System.out.println(board[7] + "|" +  board[8] + "|" +  board[9]  );
		System.out.println("-+-+-");

	}

	public static void play(char symbol){
		int pos;
		if(symbol == computerLetter){
			pos=smartMove();
			board[pos]=computerLetter;
		} else {
			System.out.println("Enter Position ");
			pos = userInput.nextInt();
			while(board[pos] != ' '){
				System.out.println("position is occupied ,please select any other box");
				System.out.println("Enter Position");
				pos = userInput.nextInt();
			}  
			board[pos] = userLetter;
		} 
	}


	public static boolean isGameOver() { 
		if ((board[1] ==  board [2] && board[1] == board[3] && board[1] != ' ') ||
				(board[1] == board[4] && board[1] == board [7] && board[1] != ' ') ||  
				(board[1] == board[5] && board[1] == board [9] && board[1] != ' ') ||

				(board[2] == board[5] &&  board[2]== board [8] && board[2] != ' ' ) ||
				(board[2] == board[1] &&  board[2]== board [3] && board[2] != ' ') ||

				(board[3] == board[1] &&  board[3]== board [2] && board[3] != ' ' ) ||
				(board[3] == board[6] &&  board[3]== board [9] && board[3] != ' ' ) ||
				(board[3] == board[6] &&  board[3]== board [9] && board[3] != ' ') ||

				(board[4] == board[1] &&  board[4]== board [7] && board[4] != ' ') ||
				(board[4] == board[5] &&  board[4]== board [6] && board[4] != ' ' ) ||

				(board[5] == board[2] &&  board[5]== board [8] && board[5] != ' ' ) ||
				(board[5] == board[4] &&  board[5]== board [6] && board[5] != ' ' ) ||

				(board[6] == board[4] &&  board[6]== board [5] && board[6] != ' ' ) ||
				(board[6] == board[3] &&  board[6]== board [9] && board[6] != ' ' ) ||

				(board[7] == board[1] &&  board[7]== board [4] && board[7] != ' ' ) ||
				(board[7] == board[3] &&  board[7]== board [5] && board[7] != ' ' ) ||
				(board[7] == board[8] &&  board[7]== board [9] && board[7] != ' ' ) ||

				(board[6] == board[3] &&  board[6]== board [9] && board[6] != ' ' ) ||
				(board[6] == board[3] &&  board[6]== board [9] && board[6] != ' ' ) ||

				(board[8] == board[7] &&  board[8]== board [9] && board[8] != ' ' ) ||
				(board[8] == board[2] &&  board[8]== board [5] && board[8] != ' ' ) ||

				(board[9] == board[3] &&  board[9]== board [6] && board[9] != ' ' ) ||
				(board[9] == board[1] &&  board[9]== board [5] && board[9] != ' ' ) ||
				(board[9] == board[7] &&  board[9]== board [8] && board[9] != ' ' ))

		{

			return true;
		}
		return false;
	} 

	public static void winner(char symbol) { 
		if (symbol == userLetter) {
			System.out.println("Player Won!!"); 
		} else if (symbol == computerLetter) 
		{
			System.out.println("Computer Won!!");
		}
		else

		{
			for (int i = 0; i < board.length; i++) {
				if (board[i] == ' ')
				{
					System.out.println("The game ended in a tie!"); 
					showBoard(board);
					break;
				}

			}

		}
	}
	public static int smartMove(){
		boolean hasWon = false;
		for(int i=1; i<10; i++){
			if(board[i] == ' '){
				board[i] = computerLetter;
				hasWon = isGameOver();
				board[i] = ' ';
				if(hasWon) 
					return i;
			}
		} 
		for(int i=1; i<10; i++){
			if(board[i] == ' '){
				board[i] = userLetter;
				hasWon = isGameOver();
				board[i] = ' ';
				if(hasWon)
					return i;
			}
		}
		if(board[1] == ' '){
			return 1;
		}
		if(board[3] == ' '){
			return 3;
		}
		if(board[7] == ' '){
			return 7;
		}
		if(board[9] == ' '){
			return 9;
		}

		int index = (int) (Math.floor(Math.random() * 9) % 9 + 1);
		while (board[index] != ' ') {
			index = (int) (Math.floor(Math.random() * 9) % 9 + 1);
		}
		return index;
	}


	public static void toss()
	{ 
		System.out.println("lets choose who needs to start the game");
		int coinToss = (int)( Math.floor(Math.random() * 10) % 2);
		System.out.println("Coin toss "+coinToss);
		if(coinToss==1)
		{
			System.out.println("Player plays First");
			playerOrder[0] = userLetter;
			playerOrder[1] = computerLetter;
		}
		else
		{
			System.out.println("Computer plays First"); 
			playerOrder[0] = computerLetter;
			playerOrder[1] = userLetter;

		}
	} 
	public void gameOver()
	{
		boolean play=false;
		for (int i = 1; i <= 9; i++) {  
			play(playerOrder[0]);
			showBoard(board);
			play = isGameOver();
			if (play) {
				System.out.println("Game Over"); 
				winner(playerOrder[0]);
				break;
			} 

			play(playerOrder[1]);
			showBoard(board);
			play = isGameOver();
			if (play) {
				System.out.println("Game Over");
				winner(playerOrder[1]);
				break; 
			}
		}

	}

	public static void main(String[] args) {  
		TikTalToeGame tictacto = new TikTalToeGame();
		board = tictacto.creatingBoard();
		showBoard(board);
		chooseLetter(); 
		toss(); 
		tictacto.gameOver();
	}
}



