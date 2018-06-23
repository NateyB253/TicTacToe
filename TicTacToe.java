import java.util.Scanner;
public class TicTacToe {

   static char[][] board = new char[3][3];
   
   public static void main(String[] args) 
   {
   
   Scanner kb = new Scanner(System.in);
   
   int input = -1;
   
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
	 
	 
	   
   }
   
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
}