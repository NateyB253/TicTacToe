import java.util.Scanner;
public class TicTacToe {

   static char[][] board = new char[3][3];
   
   static Scanner kb = new Scanner(System.in);
   
   public static void main(String[] args) 
   {
   
   Scanner kb = new Scanner(System.in);
   
   int input = -1;
   
   
   //Prints the options for the users to either start a new game or quit. 
   while (input != 2)
   {
	  System.out.println("Please make a choice (1 or 2): ");
      System.out.println("1. Start New Game");
      System.out.println("2. Quit");
      
      input = kb.nextInt();
      
      
      if (input == 1) 
      {
    	  startNewGame();
      }
      else if (input != 2) 
      {
    	  System.out.println("Invalid input");
      }
   }
   
   System.out.println("Thank you for playing");
   
   kb.close();
   
   }
   
   public static void startNewGame() 
   {
	 initGame();
	 printBoard();
	 playGame();
	 hasWonHorizontal();
	 hasWonVertical();
	 hasWonDiagonal();
	 
	   
   }
   
   // Create the game board and initialize it 
   public static void initGame()
   {
	   for (int i = 0; i < 3; i++)
	   {
		for (int j = 0; j < 3; j++)
		{
			board[i][j] = '-';
		}
	   }
	   
	  
   }
   
   //Lets us see the board when we run it 
   public static void printBoard()
   {
	   for (int i = 0; i < 3; i++)
	   {
		   for (int j = 0; j < 3; j++)
		   {
			 if (j != 2)
			 {
				 System.out.print(board[i][j] + " | ");
			 }
			 else 
			 {
				 System.out.println(board[i][j]);
			 }
		   }
	   }
	   
   }
   
   //Prompts the user to make their first move, Player 1 gets the character x and Player 2 gets the character O.
   public static void playGame()
   {
	   
	   System.out.println("Player 1 it is your turn, please choose a number 1-9 where you'd like to place an X.");
	   int spotSelection = kb.nextInt();
	   int row = -1;
	   int col = -1;
	   
	   
	   switch(spotSelection)
	   {
	   case 1 :
	   case 2 :
	   case 3 :
		   row = 0;
		   col = spotSelection - 1;
		   break;
		   
	   case 4 :
	   case 5 :
	   case 6 :
		   row = 1;
		   col = spotSelection - 4;
		   break;
		   
	   case 7 :
	   case 8 :
	   case 9 :
		   row = 2;
		   col = spotSelection - 7;
		   break;
		   
	   default :
		   System.out.println(("Invalid input"));
		   
		   
	   
		   
	   }
	   
	   if (row != -1 || col != -1) 
	   {
		   board[row][col] = 'X';
	   }
	   
	   printBoard();
   }
   
   public static void hasWonHorizontal()
   {
	   
   }
   
   public static void hasWonVertical()
   {
	   
   }
   
   public static void hasWonDiagonal()
   {
	   
   }
}