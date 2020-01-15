// Full Connect4 game in terminal against the computer

import java.util.Scanner;
public class Connect4Game {
    public static void main(String[] args) {
        Connect4Grid2DArray theBoard = new Connect4Grid2DArray();
        C4RandomAIPlayer theComputer = new C4RandomAIPlayer();
        C4HumanPlayer thePlayer = new C4HumanPlayer();
        boolean finished = false;
        boolean winningMove = false;

        while (!finished) {
            theBoard.emptyGrid();
            if(!winningMove) System.out.println(theBoard.toString());
            while (!winningMove) {
                if (theBoard.isGridFull())
                    break;
                int playersColumn = 0;
                boolean successfulMove = false;
                do{
                    playersColumn = thePlayer.selectColumn() - 1;
                    if(!theBoard.isValidColumn(playersColumn))
                        System.out.println("Column must be between 1 and 7!");
                    else if (!theBoard.isColumnFull(playersColumn))
                        System.out.println("There are no more spaces left in this column!");
                    else
                        successfulMove = true;
                } while (!successfulMove);
                theBoard.dropPiece(thePlayer, playersColumn);
                System.out.println(theBoard.toString());
                if (theBoard.didLastPieceConnect4()) {
                    System.out.println("You win!");
                    winningMove = true;
                    break;
                }
                if (theBoard.isGridFull())
                    break;

                int computersColumn = 0;
                successfulMove = false;

                do {
                    computersColumn = theComputer.selectColumn() - 1;
                    if(!theBoard.isValidColumn(computersColumn)) {
                        //blank if statement to return to start of while loop
                    }
                    else if (!theBoard.isColumnFull(computersColumn)){
                        //blank if statement to return to start of while loop
                    }
                    else
                        successfulMove = true;
                } while (!successfulMove);
                theBoard.dropPiece((Connect4Player) theComputer, computersColumn);
                System.out.println(theBoard.toString());
                if (theBoard.didLastPieceConnect4()) {
                    System.out.println("the computer wins!");
                    winningMove = true;
                    break;
                }

            }
            if(theBoard.isGridFull() && !winningMove)
                System.out.println("It's a draw!");
            System.out.println("Do you want to go again? (y/n)");
            Scanner userInput = new Scanner(System.in);
            String wantToGoAgain = userInput.next();
            if(wantToGoAgain.equalsIgnoreCase("y"))
            {
                theBoard.emptyGrid();
                winningMove = false;
            }
            else if(wantToGoAgain.equalsIgnoreCase("n"))
            {
                finished = true;
            }
            else
            {
                System.out.println("Invalid input.");
            }
        }
    }
}
