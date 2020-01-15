import java.util.Scanner;
public class FactorsandPrimeNumbers {

    public static void main(String[] args) {

        int usersNumber = 0;
        int usersNumberDivision = 0;
        boolean isFinished = false;

        do
        {
            System.out.println("Please enter a positive whole number:");
            int numberOfFactors = 0;
            Scanner userInput = new Scanner (System.in);

            if(userInput.hasNextInt())
            {
                usersNumber = userInput.nextInt();
                String result = "The factors of " + usersNumber + " are ";

                for(int factor = 1; factor < usersNumber + 1; factor++)
                {
                    if(usersNumber % factor == 0)
                    {
                        usersNumberDivision = usersNumber / factor;
                        result += factor + "x" + usersNumberDivision + ((usersNumberDivision == 1) ? " " : ", ");
                        numberOfFactors++;
                    }

                }

                if(numberOfFactors > 1)
                {
                    System.out.println(result);
                    System.out.println(usersNumber + " is not a prime number.");
                }
                else if(numberOfFactors == 1)
                {
                    System.out.println(result);
                    System.out.println(usersNumber + " is a prime number.");
                }
                else if(usersNumber == 1)
                {
                    System.out.println("The factor of " + usersNumber + " is " + usersNumber + ".");
                    System.out.println(usersNumber + " is not a prime number.");
                }
                else
                {
                    System.out.println("This is an invalid input.");
                }
            }
            else if(userInput.hasNext("quit"))
            {
                isFinished = true;
                userInput.close();
            }

        }while(!isFinished);

        System.out.println("Goodbye.");

    }

}