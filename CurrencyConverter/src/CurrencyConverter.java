import java.util.Scanner;

public class CurrencyConverter {

    public static final double OLD_PENNY_TO_NEW_CURRENCY = 0.67;
    public static final double OLD_SHILLING_TO_NEW_CURRENCY = 8.04;
    public static final double OLD_POUND_TO_NEW_CURRENCY = 160.80;

    public static void main(String[] args) {

        System.out.println("This program will convert your old currency of pennies,"
                + " shillings and pounds to new currency."
                + "\n\nHow many old pennies do you have?");

        Scanner input = new Scanner(System.in);
        double oldPennies = input.nextDouble();
        System.out.println("How many old shillings do you have?");
        double oldShillings = input.nextDouble();
        System.out.println("How many old pounds do you have?");
        double oldPounds = input.nextDouble();
        input.close();

        double modernWorth = (oldPennies * OLD_PENNY_TO_NEW_CURRENCY)
                + (oldShillings * OLD_SHILLING_TO_NEW_CURRENCY)
                + (oldPounds * OLD_POUND_TO_NEW_CURRENCY);

// We convert the amount of coins to Integers so they appear correctly in the console output.

        int oldPenniesInt = (int) oldPennies;
        int oldShillingsInt = (int) oldShillings;
        int oldPoundsInt = (int) oldPounds;

        /* In order to force the modernWorth variable to have two decimal places, we must convert
         * it to a string with the format "%.2f".
         */

        String modernWorthTwoDecimal = String.format ("%.2f", modernWorth);

        System.out.println(oldPoundsInt + " old pound, " + oldShillingsInt
                + " old shilling and " + oldPenniesInt
                + " old pence = £" + modernWorthTwoDecimal);
    }

}