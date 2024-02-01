import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author Anchal Singh 
 * @since 30 March 2023
 */
class Tick_Tac_Toe 
{
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);

    char[][] block = new char[3][3];
    for (int row = 0; row < block.length; row++) {
      for (int col = 0; col < block[row].length; col++) {
        block[row][col] = ' ';
      }
    }
    char player = 'X';
    boolean gameOver = false;

    
    while (!gameOver) {
      printBoard(block);
      if(endGame(block)) {
          System.out.println("---------Tie!!!-----------");
          System.exit(0);
      }
        System.out.print("Player " + player + " Enter :");
        int row,col;
        row= sc.nextInt();
        col = sc.nextInt();        
        try {
        	if(row<0 || col<0 || row>2 || col>2)	{
        		throw new ArrayIndexOutOfBoundsException();
        	}
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" Player " + player + " Enter Again :");
            row= sc.nextInt();
            col = sc.nextInt(); 
        }

        if (block[row][col] == ' ') 
        {
            block[row][col] = player;
            gameOver = haveWon(block, player);
            if (gameOver) 
            {
            	System.out.println("Player " + player + " has won. ");
            } else {
            	player = (player == 'X') ? 'O' : 'X'; 
            }
        } 
        else {
        System.out.println("Invalid Move. Try Again");
        }
    }

    printBoard(block);

  }
  /**
   * Check if the game ended ;
   * if there is not winner such as tie situation ; the game should end after 9 total moves  
   * @param block
   * @return boolean 
   */
  public static boolean endGame(char[][] block) {
    int count=0;
    for(int row = 0; row <block.length ; row++)	{
        for(int col =0 ; col< block.length ; col++)	{
            if(block[row][col]!= ' ')	{
                count++;
            }
        }
    }
    return count==9? true :false ;
}
  
/**
 * To print the game Board 
 * @param board
 */
public static void printBoard(char[][] board) {
    for (int row = 0; row < board.length; row++) 
    {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(" "+board[row][col] + " |");
        
      }
      System.out.println();
    }
  }

/**
 * Winning Algorithm 
 * if either the row or column is same ; he player has won 
 * or if the right diagonal or the left diagonal is same ; then the player as won 
 * @param board
 * @param player
 * @return boolean
 */
  public static boolean haveWon(char[][] board, char player) {
    // to win
    // check the rows
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
        return true;
      }
    }

    // check the columns
    for (int col = 0; col < board.length; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
        return true;
      }
    }
    // check the diagonals
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }
    if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
      return true;
    }

    return false;
  }

}