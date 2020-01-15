import java.util.Scanner;

public class AverageAndStandardDeviation {

    public static void main(String[] args) {
        boolean acceptedInput = false;
        int numberOfValues = 0;
        System.out.println("This program will calculate the Average and Standard Deviation of your inputted numbers.");
        Scanner input = new Scanner(System.in);

        while(!acceptedInput) {
            System.out.println("First, how many numbers do you want to input?");
            numberOfValues = input.nextInt();
            if(numberOfValues <= 0)
                System.out.println("Error, must enter positive integer");
            else
                acceptedInput = true;
        }

        double [] ourValues = new double[numberOfValues];
        double totalSum = 0;

        for(int i =  0; i < numberOfValues; i++)
        {
            System.out.println("Input next value (" + (i + 1) + " of " + numberOfValues + ") :");
            double nextValue = input.nextDouble();
            totalSum += nextValue;
            ourValues[i] = nextValue;
        }

        double finalAverage = totalSum/numberOfValues;
        double standardDeviationSum = 0;

        for(int i = 0; i < numberOfValues; i++) {
            double iterationValue = (ourValues[i] - finalAverage) * (ourValues[i] - finalAverage);
            standardDeviationSum += iterationValue;
        }

        double standardDeviationFinalResult = Math.sqrt((standardDeviationSum)/numberOfValues);

        System.out.println("The Average is " + finalAverage +" and the Standard Deviation is " + standardDeviationFinalResult + ".");

        input.close();
    }

}
