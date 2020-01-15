import java.util.Scanner;
public class NoughtsAndCrosses{

    public static final char PLAYER_1 = 'X';
    public static final char PLAYER_2 = 'O';
    public static final char BLANK_SPACE = ' ';
    public static final int BOARD_SIZE = 3;

    public static void main(String[] args) {
        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
        boolean player1XTurn = true;
        boolean canMakeMove = false;
        boolean finished = false;
        int moveX = 0;
        int moveY = 0;
        char winner = 'a';	//'a' will be a default value if no winner declared yet.
        clearBoard(board);
        printBoard(board);

        while(!finished)
        {
            while(!canMakeMove)
            {
                System.out.println("\nPlayer "+((player1XTurn==true)?"1 (X)":"2 (O)")
                        + ", what row and column do you want to make your "
                        + "move? Separate ROW and COLUMN with a space"
                        + "\n(e.g \"1 1\" makes a move in the top left box):");
                Scanner userInput = new Scanner(System.in);

                try
                {
                    moveX = userInput.nextInt()-1;
                    moveY = userInput.nextInt()-1;
                    // currently, the game detects which box the player wants to make
                    // a move in with a row then column order. If you want the game to
                    // be played in cartesian form, i.e horizontal then vertical, switch
                    // the above two variables around.

                    canMakeMove = canMakeMove(board, moveX, moveY);

                    if(!canMakeMove)
                        System.out.println("Invalid Input!");
                }
                catch(java.util.InputMismatchException e)
                {
                    System.out.println("Invalid input!");
                }
            }

            if(canMakeMove)
            {
                makeMove(board, (player1XTurn)?PLAYER_1:PLAYER_2, moveX, moveY);
                player1XTurn = !player1XTurn;
                canMakeMove=false;
                printBoard(board);
                winner = winner(board);
            }

            if(isBoardFull(board) || winner != 'a')
                finished = true;
        }

        System.out.println("\n" + ((isBoardFull(board))?"It's a draw!":winner + " wins!"));
    }

    public static void clearBoard(char[][]board)
    {
        for(int rowIndex = 0;rowIndex < board.length; rowIndex++)
        {
            for(int columnIndex = 0;columnIndex<board[0].length; columnIndex++)
            {
                board[rowIndex][columnIndex] = BLANK_SPACE;
            }
        }
    }

    public static void printBoard(char[][]board)
    {
        for(int rowIndex = 0;rowIndex < board.length; rowIndex++)
        {
            for(int columnIndex = 0;columnIndex<board[0].length; columnIndex++)
            {
                System.out.print(" " + board[rowIndex][columnIndex] + " |");
            }
            System.out.println("\n___ ___ ___");
        }
    }

    public static boolean canMakeMove(char[][] board, int row, int column)
    {
        if(row<board.length && row >= 0 && column<board[0].length && column >= 0)
        {
            if(board[row][column] == BLANK_SPACE)
                return true;
        }

        return false;
    }

    public static void makeMove(char[][] board, char currentPlayerPiece , int row, int column)
    {
        board[row][column] = currentPlayerPiece;
    }

    public static boolean isBoardFull(char[][] board)
    {
        for(int rowIndex = 0;rowIndex < board.length; rowIndex++)
        {
            for(int columnIndex = 0;columnIndex<board[0].length; columnIndex++)
            {
                if(board[rowIndex][columnIndex] == BLANK_SPACE)
                    return false;
            }
        }

        return true;
    }

    public static char winner(char[][] board)
    {
        for(int rowIndex = 0; rowIndex<board.length; rowIndex++)
        {
            if(board[rowIndex][0] != BLANK_SPACE && board[rowIndex][0] == board[rowIndex][1]
                    && board[rowIndex][0] == board[rowIndex][2])
            {
                return board[rowIndex][0];
            }
        }

        for(int columnIndex = 0; columnIndex<board.length; columnIndex++)
        {
            if(board[0][columnIndex] != BLANK_SPACE && board[0][columnIndex] == board[1][columnIndex]
                    && board[0][columnIndex] == board[2][columnIndex])
            {
                return board[0][columnIndex];
            }
        }

        if(board[0][0] != BLANK_SPACE && board[0][0] == board[1][1] && board[0][0] == board[2][2])
        {
            return board[0][0];
        }

        if(board[0][2] != BLANK_SPACE & board[0][2] == board[1][1] && board[0][2] == board[2][0])
        {
            return board[0][2];
        }

        return 'a';
    }
}
