import java.util.Scanner;

public class WeightConversion {

    public static final int POUNDS_IN_STONE = 14;
    public static final int OUNCES_IN_POUND = 16;
    public static final double OUNCE_TO_KILOGRAM = 0.02834952;

    public static void main(String[] args) {
        boolean finished = false;
        Scanner input = new Scanner(System.in);

        while(!finished)
        {
            System.out.println("Enter the number of Stones, Pounds and Ounces separated"
                    + " by spaces (or enter quit):");
            try
            {
                int stones = input.nextInt();
                int pounds = input.nextInt();
                int ounces = input.nextInt();

                if(stones < 0 || pounds < 0 || ounces < 0)
                {
                    throw new java.util.InputMismatchException();
                }

                double kilograms = convertToKilograms(stones, pounds, ounces);
                String weightString = getFormattedWeightString(stones, pounds, ounces);

                System.out.println(weightString + "is equal to " + kilograms + "kg");
            }
            catch(java.util.InputMismatchException e)
            {
                String userInput = input.next();

                if(userInput.equalsIgnoreCase("Quit"))
                {
                    finished = true;
                }
                else
                {
                    System.out.println("Invalid input. Stones, pounds and ounces must all"
                            + " be positive integers. Please try again");
                }
            }
        }
    }

    public static double convertToKilograms(int stones, int pounds, int ounces)
    {
        int totalOunces = (stones * POUNDS_IN_STONE * OUNCES_IN_POUND)
                +  (pounds * OUNCES_IN_POUND) + ounces;

        double totalKilograms = ((double) totalOunces) * OUNCE_TO_KILOGRAM;

        return totalKilograms;
    }

    public static String getFormattedWeightString(int stones, int pounds, int ounces)
    {
        String weightString = "";
        String stoneString = " stone";
        String poundString = " pound";
        String ounceString = " ounce";

        if(stones != 1)
            stoneString += "s";
        if(pounds != 1)
            poundString += "s";
        if(ounces != 1)
            ounceString += "s";

        if(stones != 0)
        {
            weightString += (stones + stoneString
                    + ((pounds != 0 && ounces != 0) ? ", ": " "));
        }

        if(pounds != 0)
        {
            weightString += (pounds + poundString
                    +((ounces != 0) ? ", " : " "));
        }

        if(ounces == 0)
        {
            weightString += ((stones == 0 && pounds == 0)
                    ? ounces + ounceString + " " : " ");
        }
        else
            weightString += ounces + ounceString + " ";

        return weightString;
    }

}
