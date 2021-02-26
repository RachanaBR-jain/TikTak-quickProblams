
public class TikTalToeGame 
{
		public char[] creatingBoard()
		{
			char[] board= new char[10];
			for (int  i=1;i<=9;i++)
			{
				{
					board[i]=' ';
				}	
			}
			return board;
		}
		
	public static void main(String[] args) {
	TikTalToeGame  game=new TikTalToeGame();
	game.creatingBoard();
			
}
}


