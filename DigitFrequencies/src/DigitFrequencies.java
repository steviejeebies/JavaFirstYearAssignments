// Input a number, and this program will tell you how many times each digit appears in that number.
// For example, if you input 456445, your result will be 4(3) 5(2) 6(1)

import java.util.Scanner;
public class DigitFrequencies {

    public static final int NUMBER_OF_DIGITS = 10;

    public static void main(String[] args) {

        boolean finished = false;

        while(!finished)
        {
            System.out.println("\nEnter a number:");
            Scanner input = new Scanner(System.in);

            try
            {
                long usersNumber = input.nextLong();
                countDigitFrequencies(usersNumber);

            }
            catch(java.util.InputMismatchException e)
            {
                String nonLongInput = input.next();

                if(nonLongInput.equalsIgnoreCase("Quit"))
                {
                    System.out.println("GoodBye.");
                    finished = true;
                }
                else
                    System.out.println("Invalid input, please input an long integer.");

            }
        }

    }

    public static void countDigitFrequencies(long usersNumber)
    {
        int [] frequencies = new int[NUMBER_OF_DIGITS];
        while(usersNumber != 0)
        {
            int currentDigit = (int) Math.abs(usersNumber % 10);
            frequencies[currentDigit]++;
            usersNumber /= 10;
        }

        printDigitFrequencies(frequencies);
    }

    public static void printDigitFrequencies(int[] frequencies)
    {
        System.out.println("Digit frequencies: ");
        for(int increment = 0; increment<frequencies.length; increment++)
        {
            int frequencyOfIncrement = frequencies[increment];

            if(frequencyOfIncrement != 0)
                System.out.print(increment + "(" + frequencyOfIncrement + ") ");
        }
    }
}
