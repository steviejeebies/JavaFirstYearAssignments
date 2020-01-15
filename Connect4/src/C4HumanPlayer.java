import java.util.InputMismatchException;
import java.util.Scanner;

public class C4HumanPlayer extends Connect4Player {
    C4HumanPlayer() {
        super('Y');
    }

    @Override
    public int selectColumn() {
        Scanner playerInput = new Scanner(System.in);

        try {
            System.out.println("What column would you like to place your piece?");
            int playerColumn = playerInput.nextInt();
            return playerColumn;
        } catch (InputMismatchException e) {
            System.out.println("Invalid move, must be an integer between 1 and 7");
        }

        return 0;
    }

}
