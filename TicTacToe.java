import java.util.Scanner;
public class TicTacToe {
	
   int[][] board = new int[3][3];
	
   public static void main(String[] args) 
   {
   
   Scanner kb = new Scanner(System.in);
   
   int input = -1;
   
   while (input != 2)
   {
      System.out.println("1. Start New Game");
      System.out.println("2. Quit");
      System.out.println("Please make a choice (1 or 2): ");
      input = kb.nextInt();
      
      
      if (input == 1) 
      {
    	  StartNewGame();
      }
      else if (input != 2) 
      {
    	  System.out.println("Invalid input");
      }
   }
   
   System.out.println("Thank you for playing");
   
   kb.close();
   
   }
   
   public static void StartNewGame() {
	   initGame();
	   
   }
   
}