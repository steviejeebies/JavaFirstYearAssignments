import java.util.Scanner;

public class AverageAndVariance {

    public static void main(String[] args) {

        System.out.println("This program computes the average and variance of all numbers entered.");

        double average = 0;
        double previousAverage = 0;
        double variance = 0;
        double previousVariance = 0;
        double currentNumber = 0;
        double numberCount = 0;
        boolean userQuits = false;

        do
        {
            System.out.println("Enter a number (or type 'quit'):");
            Scanner userInput = new Scanner (System.in);
            if(userInput.hasNextDouble())
            {
                numberCount++;
                currentNumber = userInput.nextDouble();
                average = previousAverage
                        + (currentNumber - previousAverage) / numberCount;

                variance = ((previousVariance * (numberCount - 1))
                        + (currentNumber - previousAverage)
                        * (currentNumber - average)) / numberCount;

                previousAverage = average;
                previousVariance = variance;

                System.out.println(
                        "So far the average is " + average + " and the variance is " + variance);


            }
            else if(userInput.hasNext("quit"))
            {
                userQuits = true;
                userInput.close();
            }
            else
            {
                System.out.println("You have inputted an invalid"
                        + " value. Enter a new number, or enter"
                        + " \"quit\" or \"exit\".");
            }

        }while(!userQuits);

        System.out.println("Goodbye.");

    }

}
