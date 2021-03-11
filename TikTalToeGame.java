package com.JavaPractiveProgram;

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
			
		}
		else if(userLetter=='O') {
			computerLetter='X';  
		 }
		else
			System.out.println("invalid input");
		System.out.println("User Choice is "+userLetter);
		System.out.println("Computer Choice is "+computerLetter);
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
        int index;
        if(symbol == computerLetter){
            index= (int) (Math.floor(Math.random() * 9) % 9 + 1);
            while(board[index] != ' '){
                index= (int) (Math.floor(Math.random() * 9) % 9 + 1);
            }
            board[index] = computerLetter;
        } else {
            System.out.println("Enter Position to place your mark");
            index = userInput.nextInt();
            while(board[index] != ' '){
                System.out.println("position is already occupied");
                System.out.println("Enter Position to place your mark");
                index = userInput.nextInt();
            }
            board[index] = computerLetter;
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

	public static void main(String[] args) { 
		TikTalToeGame tictacto = new TikTalToeGame();
		board = tictacto.creatingBoard();
		showBoard(board);
		chooseLetter(); 
		toss(); 
		play(computerLetter);
	}
}


