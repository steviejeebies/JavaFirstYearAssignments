import java.util.Scanner;
public class RationalTest {

    public static void main(String[] args) {
        String []fraction;
        Rational rationalA;
        Rational rationalB;

        try
        {
            System.out.println("What is your first rational number?"
                    + "\n(Use '/' to separate the numerator and denominator)");
            Scanner userInput = new Scanner(System.in);
            String input = userInput.next();
            if(input.contains("/"))
            {
                fraction = input.split("/");
                int aNumerator = Integer.parseInt(fraction[0]);
                int aDenominator = Integer.parseInt(fraction[1]);
                rationalA = new Rational(aNumerator, aDenominator);
            }
            else
            {
                int aNumerator = Integer.parseInt(input);
                rationalA = new Rational(aNumerator);
            }

            System.out.println("What is your second rational number?"
                    + "\n(Use '/' to separate the numerator and denominator)");
            input = userInput.next();

            if(input.contains("/"))
            {
                fraction = input.split("/");
                int bNumerator = Integer.parseInt(fraction[0]);
                int bDenominator = Integer.parseInt(fraction[1]);
                rationalB = new Rational(bNumerator, bDenominator);
            }
            else
            {
                int bNumerator = Integer.parseInt(input);
                rationalB = new Rational(bNumerator);
            }


            //output

            System.out.println(rationalA + " + "
                    + rationalB + " = " + rationalA.add(rationalB));
            System.out.println(rationalA + " - "
                    + rationalB + " = " + rationalA.subtract(rationalB));
            System.out.println(rationalA + " * "
                    + rationalB + " = " + rationalA.multiply(rationalB));
            System.out.println(rationalA + " / "
                    + rationalB + " = " + rationalA.divide(rationalB));
            System.out.println(rationalA + " is "
                    + (rationalA.equals(rationalB)?"equals ":"not equals ") + rationalB);
            System.out.println(rationalA + " is "
                    + (rationalA.isLessThan(rationalB)?"less than ":"not less than ") + rationalB);
            System.out.println(rationalA + " simplifies as " + rationalA.simplify() + ".");
            System.out.println(rationalB + " simplifies as " + rationalB.simplify() + ".");

            userInput.close();
        }
        catch(java.lang.NumberFormatException e)
        {
            System.out.println("Invalid input, must be integers.");
        }
        catch(java.lang.IllegalArgumentException e)
        {
            System.out.println("Denominator cannot be zero.");
        }
    }
}
