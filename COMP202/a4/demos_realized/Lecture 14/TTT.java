//this is a demo in class
import java.util.Random;
public class TTT{
  public static void main(String[] args){
    playGame();
  }
  public static void playGame(){
    char[][] board = createBoard();
    boolean playing = true;
    while(playing){
      displayBoard(board);
      getPlayerMove(board);
      displayBoard(board);
      getAIMove(board);
      char c = checkWinner(board);
      if(c == 'X'){
        System.out.println("WIN!");
        playing = false;
      }else if(c == 'O'){
      System.out.println("LOSE!");
        playing = false;
      }
    }
  }
  public static void getAIMove(char[][] board){
    //initialize the random num generator
    //don't forget the import statement
    Random rand = new Random();
    //assume we don't have a valid move
    boolean hasValidMove = false;
    while(!hasValidMove){
      //generate a move
      int row = rand.nextInt(3);
      int col = rand.nextInt(3);
      //see if we can write this move to the board
      hasValidMove = writeOnBoard(board,row, col, 'O');
    }
  }
  public static char checkWinner(char[][] board){
    //check horizontal
    for(int row = 0; row < board.length; row++){
      if(board[row][0] != ' ' &&
         board[row][0] == board[row][1] &&
         board[row][1] == board[row][2]){
        return board[row][0];
      }
    }
    //check vertical
    for(int col = 0; col < board.length; col++){
      if(board[0][col] != ' ' &&
         board[0][col] == board[1][col] &&
         board[1][col] == board[2][col]){
        return board[0][col];
      }
    }
    //check diagonal
    if(board[0][0] != ' ' &&
       board[0][0] == board[1][1] &&
       board[1][1] == board[2][2]){
      return board[0][0];
    }
    if(board[2][0] != ' ' &&
       board[2][0] == board[1][1] &&
       board[1][1] == board[0][2]){
      return board[2][0];
    }
    return ' '; //no winner
  }
  //get the row and col from the player
  public static void getPlayerMove(char[][] board){
    java.util.Scanner scan = new java.util.Scanner(System.in);
    boolean validMove = false;
    while(!validMove){
      System.out.println("Enter a move: (Example: 1 1)");
      //get row and col
      int row = scan.nextInt();
      int col = scan.nextInt();
      //write on the board
      validMove = writeOnBoard(board, row, col, 'X');
      if(!validMove){
        System.out.println("Invalid move!");
      }
    }
  }
  //write a symbol on the board
  //check to make sure that the row and col
  //are within the board
  //check to see if row and col are unoccupied
  //return true if symbol written, and false if not
  public static boolean writeOnBoard(char[][] board, int row, 
                                     int col, char symbol){
    if(row < 0 || row >= board.length || col < 0 || col >= board.length){
      return false;
    }
    if(board[row][col] != ' '){
      return false;
    }
    board[row][col] = symbol;
    return true;
  }
  public static void displayBoard(char[][] board){
    System.out.println("+---+---+---+"); //top row
    for(int row = 0; row < board.length; row++){
      System.out.print("|"); //left edge
      for(int col = 0; col < board[row].length; col++){
        //the entries and edges
        System.out.print(" " + board[row][col] + " |");
      }
      System.out.println();
      //the line under each row
      System.out.println("+---+---+---+");
    }
  }
  //create the board
  //the board will be a 3*3 array of char arrays
  public static char[][] createBoard(){
    //create board of 3 by 3
    char[][] board = new char[3][3];
    //initialize all entries to be a space
    for(int row = 0; row < board.length; row++){
      for(int col = 0; col < board[row].length; col++){
        board[row][col] = ' ';
      }
    }
    return board;
  }
}