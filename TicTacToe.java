import java.util.Scanner;
public class TicTacToe {

	public enum Player { PLAYERONE, PLAYERTWO }

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




	}

	// Create the game board and initialize it 
	public static void initGame()
	{
		int boardNum = 1;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				board[i][j] = (char) (boardNum + '0');
				boardNum++;
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

		int spotSelection;
		boolean isPlayerOnesTurn = true;
		boolean hasGameEnded = false;
		while (hasGameEnded == false)
		{
			if (isPlayerOnesTurn == true)
			{
				spotSelection = getPlayerInput(Player.PLAYERONE);  
			}
			else
			{
				spotSelection = getPlayerInput(Player.PLAYERTWO);
			}

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
				continue;
			}
			if (row != -1 && col != -1 && board[row][col] != 'X' && board[row][col] != 'O')
			{

				if (isPlayerOnesTurn)
				{
					board[row][col] = 'X';
				}
				else
				{
					board[row][col] = 'O';
				}

				printBoard();
				hasGameEnded = wasGameWon(row, col);
				if (!hasGameEnded)
				{
					if(checkDraw(row, col))
					{
						System.out.println("Its a draw!");
						hasGameEnded = true;
					}
				
					else
					{
					isPlayerOnesTurn = !isPlayerOnesTurn;
					}
					
				}
				else
				{
					System.out.println("Congrats You Win!");
				}

			}
			else
			{
				System.out.println("Invalid Input");
			}
		}


	}

	public static boolean hasWonHorizontal(int row)
	{
		char temp;
		temp = board[row][0];
		for (int col = 1; col < 3; col++)
		{
			if (temp != board[row][col])
			{
				return false;
			}
		}
		return true;

	}

	public static boolean hasWonVertical(int col)
	{
		char temp;
		temp = board[0][col];
		for (int row = 1; row < 3; row++)
		{
			if (temp != board[row][col])
			{
				return false;
			}
		}
		return true;
	}

	public static boolean hasWonDiagonal(int row, int col)
	{
		boolean hasWon1 = true;
		boolean hasWon2 = true;
		char temp;
		temp = board[row][col];
		for (int i = 0; i < 3; i++)
		{
			if (temp != board[i][i])
			{
				hasWon1 = false;
				continue;
			}
		}

		if (hasWon1 == false)
		{
			for ( int i = 0, j = 2; i < 3; i++, j--)
			{
				if (temp != board[i][j])
				{
					hasWon2 = false;
					continue;
				}
			}
		}
		return hasWon1 || hasWon2;

	}
	public static int getPlayerInput(Player player)
	{
		String prompt = ("Player %d it is your turn, please choose a number 1-9 where you'd like to play.");

		int spotSelection;
		System.out.printf(prompt, player.ordinal() + 1);
		try
		{
			spotSelection = kb.nextInt();
		}
		catch (java.util.InputMismatchException ex)
		{
			spotSelection = - 1;
			kb.next();
		}
		return spotSelection;
	}
	
	public static boolean wasGameWon(int row, int col)
	{
		return hasWonHorizontal(row) || hasWonVertical(col) || hasWonDiagonal (row, col);
	}
	
	public static boolean checkDraw(int row, int col)
	{

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (board[i][j] != 'X' && board[i][j] != 'O')
				{
					return false;
				}
			}
		}
		return true;
	}
	
}