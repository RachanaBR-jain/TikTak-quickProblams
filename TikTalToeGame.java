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
			pos= (int) (Math.floor(Math.random() * 9) % 9 + 1);
			while(board[pos] != ' '){
				pos= (int) (Math.floor(Math.random() * 9) % 9 + 1);
			}
			board[pos] = computerLetter;
		} else {
			System.out.println("Enter Position ");
			pos = userInput.nextInt();
			while(board[pos] != ' '){
				System.out.println("position is occupied ,please select any other box");
				System.out.println("Enter Position");
				pos = userInput.nextInt();
			}  
			board[pos] = computerLetter;
		} 
	}


	public static void toss()
	{ 
		System.out.println("lets choose who needs to start the game");
		int coinToss = (int)( Math.floor(Math.random() * 10) % 2);
		System.out.println("Coin toss "+coinToss);
		if(coinToss==1)
		{
			System.out.println("Player plays First");	 
		}
		else
		{
			System.out.println("Computer plays First");	
		}
	} 
	public static boolean isGameOver(char symbol) { 
		if ((board[1] == symbol && board [2] == symbol && board[3] == symbol) ||
				(board[4] == symbol && board [5] == symbol && board [6] == symbol) ||
				(board[7] == symbol && board [8] == symbol && board [9] == symbol) ||

				(board[1] == symbol && board [4] == symbol && board [7] == symbol) ||
				(board[2] == symbol && board [5] == symbol && board [8] == symbol) ||
				(board[3] == symbol && board [6] == symbol && board [9] == symbol) || 

				(board[1] == symbol && board [5] == symbol && board [9]== symbol) || 
				(board[3] == symbol && board [5] == symbol && board [7] == symbol) ) {

			return true;
		}
		return false;
	} 

	public static void winner(char symbol) {
		if (symbol == userLetter) {
			System.out.println("Plar Won!!"); 
		} else if (symbol == computerLetter)
			System.out.println("Computer Won!!");
		else
		{
			for (int i = 1; i < 10; i++) {
				if (board[i]== ' ') 
					System.out.println("The game ended in a tie!"); 
			}
		}
	}


	public void gameOver()
	{
		boolean isOver=false;
		for (int i = 1; i <= 9; i++) {  
			showBoard(board);
			play(playerOrder[0]);
			isOver = isGameOver(computerLetter);
			if (isOver) {
				System.out.println("Game Over"); 
				winner(computerLetter);
				break;
			} 
			showBoard(board); 
			play(playerOrder[1]);
			isOver = isGameOver(userLetter);
			if (isOver) {
				System.out.println("Game Over");
				winner(userLetter);
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



