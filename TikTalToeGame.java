
import java.util.*;

public class TikTalToeGame 
{
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
		private static char choose(Scanner userInput)
		{ 
			System.out.println("enter the user choice letter X or O");
			return userInput.next().toUpperCase().charAt(0);
		}   
		public static void main(String[] args) {
		TikTalToeGame  game=new TikTalToeGame();
		System.out.println(game.creatingBoard());
		Scanner userInput=new Scanner(System.in);
		char userLetter=choose(userInput);
		char computerLetter;
		//computerLatter=(userLetter =='X') ? 'O' : 'Y';
		if(userLetter=='X')
		{
			computerLetter='O';
		}
		else if(userLetter=='Y')
		{
			computerLetter='Y';
		}
		else 
		{
			computerLetter='!';
		}
		System.out.println(computerLetter);
		if(computerLetter=='!')
		{
			System.out.println("Invalid input plaese give input either O or X");
		}
	}
}

