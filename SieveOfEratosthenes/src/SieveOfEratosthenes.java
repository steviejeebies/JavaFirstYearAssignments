// This program will find all prime numbers below the user's entered number, by using the Sieve of Eratosthenes

import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args) {

        boolean finished = false;

        while(!finished)
        {
            System.out.println("Enter int >= 2: ");
            Scanner userInput = new Scanner(System.in);

            try
            {
                int userNValue = userInput.nextInt();

                if(userNValue > 2)
                {
                    boolean[] startArray = createSequence(userNValue);
                    sequenceToString(startArray);
                    boolean[] crossOutArray = sieve(startArray);
                    nonCrossedOutSubseqToString(crossOutArray);
                }
                else
                {
                    System.out.println("Input must be a positive integer "
                            + "equal or greater than 2.\n");
                }

            }
            catch(java.util.InputMismatchException e)
            {
                String quitCheck = userInput.next();

                if(quitCheck.equalsIgnoreCase("quit"))
                {
                    finished = true;
                    System.out.println("Goodbye");
                }
                else
                    System.out.println("Input must be a positive integer "
                            + "equal or greater than 2.");
            }
        }
    }

    public static boolean[] createSequence(int userNValue)
    {
        boolean[] startSieve = new boolean[userNValue + 1];

        for(int initialiseIndex = 2;
            initialiseIndex < startSieve.length; initialiseIndex++)
        {
            startSieve[initialiseIndex] = true;
        }

        return startSieve;
    }

    public static boolean[] sieve(boolean[] initialArray)
    {
        for(int sieveheader = 2; sieveheader < initialArray.length; sieveheader++)
        {
            if(initialArray[sieveheader])
                crossOutHigherMultiples(sieveheader, initialArray);
        }

        return initialArray;
    }

    public static boolean[] crossOutHigherMultiples(int currentPrime, boolean[] crossOutArray)
    {
        boolean changeOccured = false;

        for(int crossIndex = currentPrime*2; crossIndex < crossOutArray.length;
            crossIndex = crossIndex + currentPrime)
        {
            if(crossOutArray[crossIndex])
                changeOccured = true;

            crossOutArray[crossIndex] = false;
        }

        if(changeOccured)
            sequenceToString(crossOutArray);

        return crossOutArray;
    }

    public static void sequenceToString(boolean[] crossOutArray)
    {
        String output = "";

        for(int sieveIndex = 2; sieveIndex < crossOutArray.length; sieveIndex++)
        {
            if(crossOutArray[sieveIndex])
                output += sieveIndex
                        + ((sieveIndex == crossOutArray.length - 1) ? "" : ", ");
            else
                output += "[" + sieveIndex
                        + ((sieveIndex == crossOutArray.length - 1) ? "]" : "], ");
        }

        System.out.println(output);
    }

    public static void nonCrossedOutSubseqToString(boolean[] crossOutArray)
    {
        String finalLineOutput = "";
        int lastPrime = 0;

        for(int lastPrimeIndex = crossOutArray.length - 1; lastPrime == 0; lastPrimeIndex--)
        {
            if(crossOutArray[lastPrimeIndex])
                lastPrime = lastPrimeIndex;
        }

        for(int sieveIndex = 2; sieveIndex < crossOutArray.length; sieveIndex++)
        {
            if(crossOutArray[sieveIndex])
                finalLineOutput += sieveIndex
                        + ((sieveIndex == lastPrime) ? "\n" : ", ");
        }

        System.out.println(finalLineOutput);
    }
}