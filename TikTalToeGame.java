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
		
		public static void main(String[] args) {
		TikTalToeGame  game=new TikTalToeGame();
		System.out.println(game.creatingBoard());
		
	 }
	
}


