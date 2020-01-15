// Simple high score program that asks the user how many high-scores they want to maintain,
// then accepts new high scores and correctly places them on the scoreboard as the user enters them.

import java.util.Scanner;

public class HighScores {

    public static void main(String[] args) {

        boolean finished = false;

        while(!finished)
        {
            System.out.println("How many scores would you like to maintain?");
            Scanner input = new Scanner (System.in);

            try
            {
                int scoresMaintained = input.nextInt();
                double[] scoreBoard;

                if(scoresMaintained > 0)
                    scoreBoard = new double[scoresMaintained];
                else
                    throw new ArrayIndexOutOfBoundsException();

                scoreBoard = initialiseHighScores(scoreBoard);

                while(!finished)
                {
                    System.out.println("Enter a new High Score:");
                    input = new Scanner (System.in);

                    if(input.hasNextDouble())
                    {
                        double currentValue = input.nextDouble();

                        boolean higherThan =
                                higherThan(scoreBoard, currentValue);

                        scoreBoard = (higherThan) ?
                                insertScore(scoreBoard, currentValue)
                                : scoreBoard;

                        printScore(scoreBoard);
                    }
                    else
                    {
                        String userInput = input.next();
                        finished =
                                (userInput.equalsIgnoreCase("Quit") ? true : false);

                        System.out.println((finished) ? "Goodbye." :
                                "Invalid input, please try again.");
                    }

                }

                input.close();

            }
            catch(java.util.InputMismatchException e)
            {
                String userInput = input.next();
                finished =
                        (userInput.equalsIgnoreCase("Quit") ? true : false);

                System.out.println((finished) ? "Goodbye." :
                        "Invalid input, scores maintained must "
                                + "be in integer. Try Again.");

            }
            catch(java.lang.ArrayIndexOutOfBoundsException |
                    java.lang.NegativeArraySizeException e)
            {
                System.out.println("You cannot maintain a negative or zero"
                        + " number of scores.");
            }
        }
    }


    public static double[] initialiseHighScores (double[] scoreBoard)
    {
        for(int index = 0; index < scoreBoard.length ; index++)
        {
            scoreBoard[index] = 0;
        }

        return scoreBoard;
    }

    public static void printScore (double[] scoreBoard)
    {
        System.out.println("The High Scores are ");

        for(int index = 0; index < scoreBoard.length; index++)
        {
            System.out.print(scoreBoard[index]
                    + ((index == scoreBoard.length - 1) ? ".\n" : ", "));
        }
    }

    public static boolean higherThan(double[] currentScoreBoard, double currentValue)
    {
        return (currentValue >=
                (currentScoreBoard[currentScoreBoard.length - 1]));

        // We only need to check if the current user's number is
        // eligible for the score board. As a result, since this
        // function will return a boolean, we only need to check
        // if the users current input is greater than the lowest
        // high score in the array.
    }

    public static double[] insertScore(double[] currentScoreBoard, double currentValue)
    {
        boolean finished = false;
        int index = 0;

        while(!finished)
        {
            if(currentValue >= currentScoreBoard[index])
            {
                for(int updateIndex = (currentScoreBoard.length - 1);
                    updateIndex > index; updateIndex--)
                {
                    currentScoreBoard[updateIndex] =
                            currentScoreBoard[updateIndex - 1];

                    //all numbers below user's current input score,
                    //starting from the lowest number, are shifted
                    //down one place in the score board array.
                }

                currentScoreBoard[index] = currentValue;

                //after shifting all numbers less than the current value,
                //the current value can now go into the current index location
                //of the score board array.

                finished = true;
            }

            index++;
        }

        return currentScoreBoard;
    }

}
