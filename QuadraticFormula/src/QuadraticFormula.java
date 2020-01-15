import java.util.Scanner;

public class QuadraticFormula {

    public static void main(String[] args) {

        double firstCoefficient = 0;
        double secondCoefficient = 0;
        double thirdCoefficient = 0;
        double quadraticFormulaPositive = 0;
        double quadraticFormulaNegative = 0;
        boolean isFinished = false;

        do
        {
            System.out.println("Enter the coefficients of your second "
                    + "order polynommial separated by spaces (or enter quit):");

            try
            {
                Scanner userInput = new Scanner (System.in);
                firstCoefficient = userInput.nextDouble();
                secondCoefficient = userInput.nextDouble();
                thirdCoefficient = userInput.nextDouble();

                quadraticFormulaPositive = (- secondCoefficient
                        + (Math.sqrt((secondCoefficient * secondCoefficient)
                        - 4*(firstCoefficient * thirdCoefficient))))
                        / 2*firstCoefficient;

                quadraticFormulaNegative = (- secondCoefficient
                        - (Math.sqrt((secondCoefficient * secondCoefficient)
                        - 4*(firstCoefficient * thirdCoefficient))))
                        / 2*firstCoefficient;

                System.out.println("The roots to this equations are x="
                        + quadraticFormulaPositive + " and x="
                        + quadraticFormulaNegative);

                isFinished = true;


            }
            catch(Exception e)
            {
                System.out.println("You have inputted an invalid value, "
                        + "please try again.");
            }

        }while(isFinished);

    }

}
