import java.util.*;
public class TikTalToeGame 
{
	static Scanner userInput=new Scanner(System.in);
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

	private static void playerTurn(char[] board, Scanner scanner) {
		String userInput1; 
		while (true) {
			System.out.println("its your turn where do you like to move(1-9)");
			userInput1 = scanner.nextLine();
			if (isValidMove(board, userInput1)){ 
				break;
			} else {
				System.out.println(userInput1 + " is not a valid move."); 
			}
		} 
		char userLetter='X';
		freeSpace(board, userInput1, userLetter); 
	}

	private static void freeSpace(char[] board, String position, char userLetter) {
		switch(position) {
		case "1":
			board[1]= userLetter;
			break;
		case "2":
			board[2] = userLetter;
			break;
		case "3":
			board[3] = userLetter;
			break;
		case "4":
			board[4] = userLetter;
			break;
		case "5":
			board[5] = userLetter;
			break;
		case "6":
			board[6] = userLetter;
			break;
		case "7":
			board[7] = userLetter;
			break;
		case "8":
			board[8] = userLetter;
			break;
		case "9":
			board[9] = userLetter;
			break;
		default:
			System.out.println("no space");
		}
	}


	private static boolean isValidMove (char[] board, String position) {
		switch(position) {
		case "1":
			return (board[1] == ' ');
		case "2":
			return (board[2] == ' ');
		case "3":
			return (board[3] == ' ');
		case "4":
			return (board[4]== ' ');
		case "5":
			return (board[5] == ' ');
		case "6":
			return (board[6] == ' ');
		case "7":
			return (board[7] == ' ');
		case "8":
			return (board[8] == ' ');
		case "9":
			return (board[9] == ' ');
		default:
			return false;
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
	private static char choose(Scanner userInput) 
	{ 
		System.out.println("enter the user choice letter X or O");
		return userInput.next().toUpperCase().charAt(0); 
	}   


	public static void main(String[] args) {
		TikTalToeGame  game=new TikTalToeGame(); 
		System.out.println(game.creatingBoard());
		game.showBoard(game.creatingBoard());
		char userLetter=choose(userInput);
		char computerLetter;
		//computerLatter=(userLetter =='X') ? 'O' : 'X';
		if(userLetter=='X')
		{
			computerLetter='O';
		} 
		else if(userLetter=='O')
		{
			computerLetter='X';  
		}
		else 
		{
			computerLetter='!';
		}
		System.out.println(computerLetter);
		if(computerLetter=='!')
		{
			System.out.println("Invalid input plaese give input either O or X");
			choose(userInput);
		}
		Scanner input1=new Scanner(System.in);
		game.playerTurn(game.creatingBoard(),input1);



	}

}


